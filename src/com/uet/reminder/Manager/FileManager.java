package com.uet.reminder.Manager;

import java.io.*;

/**
 * Class quan li input va output
 */
public class FileManager {
    // Luồng ký tự, đọc một file.
    // FileReader đọc ký tự theo mã hóa mặc định của Java trên máy chạy code này.

    private File file = new File("Data.txt");;

    /**
     * Doc file
     * @param manager
     * @throws IOException
     */
    public void readFile(NoteManager manager) throws IOException {
        try {
            // if file doesnt exists, then create it
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            String line;
            manager.getUserNote().clear();
            Note newNote = new Note();
            String s = new String();
            line = br.readLine();
            while(line != null) {
                s = new String();
                int i = 0;
                while (line.charAt(i) != '_' && newNote.getName() == null) {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setId(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_' && newNote.getName() == null) {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setName(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_' && newNote.getPlace() == null) {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setPlace(s);
                s = new String();
                i++;
                while(line.charAt(i) != '_' && newNote.getContent() == null) {
                    if (line.charAt(i) == '"') {
                        String t = String.valueOf('"' + line.charAt(i+1) + line.charAt(i+2));
                        String kt = String.valueOf('"' + '_' + '"');
                        if (t.equalsIgnoreCase(kt)) {
                            s += '_';
                            i += 3;
                        }
                    } else {
                        s += line.charAt(i);
                        i++;
                    }
                    if (i == line.length()) {
                        line = br.readLine();
                        i = 0;
                        s += '\n';
                    }
                }
                newNote.setContent(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setTimeStart(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setTimeFinish(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setRepeat(s);
                s = new String();
                i++;
                while ( i != line.length() && line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                newNote.setDone(Boolean.parseBoolean(s));
                manager.add(newNote);
                newNote = new Note();
                line = br.readLine();
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ghi file
     * @param manager
     */
    public void writeFile(NoteManager manager) {
        try {
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            for (Note note : manager.getUserNote()) {
                String s = note.getId();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = note.getName();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = note.getPlace();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = note.getContent();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '_'){
                        bw.write('"');
                        bw.write('_');
                        bw.write('"');
                        continue;
                    }
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = note.getTimeStart();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = note.getTimeFinish();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = "" + note.isRepeat();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("_");
                s = "" + note.isDone();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append("\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Xoa file
     * Ghi lai vao file
     * Doc lai vao manager
     * @param manager
     * @throws IOException
     */
    public void update(NoteManager manager) throws IOException {
        writeFile(manager);
        readFile(manager);
    }
}