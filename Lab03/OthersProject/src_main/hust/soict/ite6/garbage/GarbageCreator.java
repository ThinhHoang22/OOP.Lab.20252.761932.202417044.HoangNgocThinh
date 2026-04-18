package hust.soict.ite6.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "testfile.exe"; 

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();

            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }

            long endTime = System.currentTimeMillis();

            System.out.println("Time using String (+): " + (endTime - startTime) + " ms");
            System.out.println("Output length: " + outputString.length());

        } catch (IOException e) {
            System.out.println("Cannot read file: " + filename);
            e.printStackTrace();
        }
    }
}