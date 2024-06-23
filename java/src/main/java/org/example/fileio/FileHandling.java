package org.example.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileHandling {
    public static void main(String[] args) throws FileNotFoundException {

        try(InputStream stream = FileHandling.class.getClassLoader().getResourceAsStream("file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(stream))
        ) {
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
