package main;


import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.*;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class Main implements AccountStatus {
    public static void main(String[] args) {
        /*
        //create data store
     try {
         File file1 = new File("D:\\OG_CRUD\\src\\main\\java\\com\\OlehHilchenko\\OGCRUDApplication\\DataStore\\developers.txt");
         File file2 = new File("D:\\OG_CRUD\\src\\main\\java\\com\\OlehHilchenko\\OGCRUDApplication\\DataStore\\skills.txt");
         File file3 = new File("D:\\OG_CRUD\\src\\main\\java\\com\\OlehHilchenko\\OGCRUDApplication\\DataStore\\accounts.txt");

         boolean resProc1 = file1.createNewFile();
            if (resProc1)
                 System.out.println("File has been created successfully");
            else
                 System.out.println("File already present at the specified location");
         boolean resProc2 = file2.createNewFile();
            if (resProc2)
                 System.out.println("File has been created successfully");
            else
                 System.out.println("File already present at the specified location");
         boolean resProc3 = file3.createNewFile();
            if (resProc3)
                 System.out.println("File has been created successfully");
            else
                 System.out.println("File already present at the specified location");
     }catch (IOException e){
         System.out.println("Exception Occurred:");
         e.printStackTrace();
     }
*/
        DeveloperSet developerSet = new DeveloperSet();
        LinkedHashSet<String> skil = new LinkedHashSet<>();
        skil.add("mandatory");
        skil.add("sociable");
        AccountStatus stat = new AccountStat();
        ((AccountStat) stat).accountStatus = ACTIVE;
        Developer og = new Developer(111, "Oleg", "Gil", skil, ACTIVE);
                developerSet.developers.add(og);
        System.out.println(developerSet.developers.size());
        System.out.println(developerSet.developers.toString());

    }
}
