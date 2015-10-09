package com.swapnil.adsa1.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by swapn on 28-09-2015.
 */
public class FileUtil {

    private FileUtil() {

    }


    public static void writeToFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }

    public static boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static void backupFile(String filePath) throws IOException {
        File oldFile = new File(filePath);
        String backupFileName = oldFile.getPath() + "." + new Date().getTime() + ".bkp";
        File backupFile = new File(backupFileName);
        if (oldFile.renameTo(backupFile)) {
            System.out.println("Backed up earlier report file at " + backupFileName);
        } else {
            System.out.println("Error while taking backup of Old Report File. Deleting without taking backup");
            if (oldFile.delete()) {
                System.out.println("File Deleted...");
            }
        }
    }
}
