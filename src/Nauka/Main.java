package Nauka;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {


        String path = "C:/Users/przem/Documents/egnyte";
        File newFolder = new File(path);
        newFolder.mkdir();
        System.out.println(newFolder.exists());
        System.out.println(newFolder.getAbsolutePath());

        Random rd = new Random();
        String randomString = rd.ints(97, 123)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        File newFile = new File(path,randomString);
        newFile.createNewFile();

        RandomAccessFile newTestFile = new RandomAccessFile(newFile, "rw");
        newTestFile.setLength(1048576);
        newTestFile.close();
        System.out.println(newFile.exists());

        File folderWithUpperCaseName = new File(path.toUpperCase(Locale.ROOT));

        if(newFolder.renameTo(folderWithUpperCaseName)) {
            System.out.println("Folder name has been changed");
        }
        else {
            System.out.println("error");
        }


        Desktop.getDesktop().moveToTrash(newFile);

        String pliki[] = newFolder.list();


        if(pliki.length == 0) {
            System.out.println("plik poprawnie przeniesiony do kosza");
        }
        else {
            for(int i =0 ; i < pliki.length; i++)
            {
                System.out.println(pliki[i]);
            }

        }

    }
}
