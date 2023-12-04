package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String filePathName;
    private File file;
    private Scanner sc;
    public ReadFile(String filePathName) {
        try {
            this.filePathName = filePathName;
            file = new File(this.filePathName);
            sc = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
    }

    public List<String> getScannerIterable() {
        List<String> list = new ArrayList<>();
        while(sc.hasNext()) {
            list.add(sc.nextLine());
        }
        return list;
    }
}
