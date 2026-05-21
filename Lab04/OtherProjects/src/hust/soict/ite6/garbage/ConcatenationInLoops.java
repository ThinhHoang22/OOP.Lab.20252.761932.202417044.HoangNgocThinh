package hust.soict.ite6.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // 1) Using String
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time using String: " + (end - start) + " ms");

        // 2) Using StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        
        s = sb.toString();
        System.out.println("Length: " + s.length());
        
        // 3) Using StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sf.append(r.nextInt(2));
        }
        s = sf.toString();
        end = System.currentTimeMillis();
        System.out.println("Time using StringBuffer: " + (end - start) + " ms");
    }
}