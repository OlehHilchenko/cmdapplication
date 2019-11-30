package main.java.com.OlehHilchenko.OGCRUDApplication.Action;

import java.util.Scanner;

public class MyScanner {

    public synchronized String scannerMeth() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        //scanner.close();
        return s;
    }
}