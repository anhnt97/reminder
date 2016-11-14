package com.uet.reminder.Manager;

import java.io.*;

/**
 * Class quan li input va output
 */
public class FileManager {
    NoteManager manager;
    // Luồng ký tự, đọc một file.
    // FileReader đọc ký tự theo mã hóa mặc định của Java trên máy chạy code này.
    public FileManager(NoteManager manager) {
        this.manager = manager;
    }

    private File file = new File("Data.txt");;

    /**
     * Doc file
     * @throws IOException
     */
    public void readFile() throws IOException {
        try {
            // if file doesnt exists, then create it
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            String line;
            manager.getUserListNote().clear();
            ListNote newList = new ListNote();
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
                newList.setId(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_' && newNote.getName() == null) {
                    s += line.charAt(i);
                    i++;
                }
                newList.setName(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                newList.setRepeat(s);
                s = new String();
                i++;
                while (line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                newList.setDone(Boolean.parseBoolean(s));
                s = new String();
                i++;
                while (line.charAt(i) != '_') {
                    s += line.charAt(i);
                    i++;
                }
                i++;
                int num = Integer.parseInt(s);
                for (int t = 0; t < num; t++) {
                //manager.add(newNote);
                    newNote = new Note();
                    s = new String();
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
                            String st = String.valueOf('"' + line.charAt(i+1) + line.charAt(i+2));
                            String kt = String.valueOf('"' + '_' + '"');
                            if (st.equalsIgnoreCase(kt)) {
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
                    i++;
                    newNote.setDone(Boolean.parseBoolean(s));
                    //manager.add(newNote);
                    newList.addNote(newNote);
                }
                manager.add(newList);
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
     */
    public void writeFile() {
        try {
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            /**
             * Khoi tao file co ten Data.txt
             */
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            for (ListNote list : manager.getUserListNote()) {
                //In tung phan tu cua List
                String s = list.getId();
                //In ID List
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append('_');
                //In Ten List
                s = list.getName();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append('_');
                //In phan repeat cua List
                s = list.getRepeat();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append('_');
                //In phan done cua List
                s = list.getDone().toString();
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                bw.append('_');
                //In so Note co trong List
                s = String.valueOf(list.count());
                for (int i = 0; i < s.length(); i++) {
                    bw.append(s.charAt(i));
                }
                for (Note note : list.getListNote()) {
                //Liet ke cac Note trong List
                    bw.append('_');
                    //In ID tung Note
                    s = note.getId();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In ten tung Note
                    s = note.getName();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In place cua tung Note
                    s = note.getPlace();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In Noi cung
                    s = note.getContent();
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '_') {
                            bw.write('"');
                            bw.write('_');
                            bw.write('"');
                            continue;
                        }
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In thoi gian Start
                    s = note.getTimeStart();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In thoi gian Finish
                    s = note.getTimeFinish();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In Repeat
                    s = "" + note.isRepeat();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                    bw.append("_");
                    //In Done cua Note
                    s = "" + note.isDone();
                    for (int i = 0; i < s.length(); i++) {
                        bw.append(s.charAt(i));
                    }
                }
                bw.append("\n");
                //Xuong dong khi doi Note
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
     * @throws IOException
     */
    public void update(){
        writeFile();
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}