package main;


import main.java.com.OlehHilchenko.OGCRUDApplication.Action.*;
import main.java.com.OlehHilchenko.OGCRUDApplication.DeveloperRepository.*;
import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.*;

import java.io.IOException;
import java.util.Scanner;

public class CrudMain implements AccountStatus {

    public static void main(String[] args) {

        DevelopersHashMap developersHashMap = new DevelopersHashMap();
        Read read = new Read();
        Write write = new Write();
        Create create = new Create();
        Update update = new Update();
        ViewAll viewAll = new ViewAll();
        ViewByID viewByID = new ViewByID();
        RandomID randomID = new RandomID();
        MyScanner myScanner = new MyScanner();

        developersHashMap.developerHashMapValue = read.parse();
        boolean exit = true;

        while (exit) {
            System.out.println("Select an action.");
            System.out.println("To create developer pres 1.");
            System.out.println("To update developer pres 2.");
            System.out.println("To delete developer pres 3.");
            System.out.println("To view all developer pres 4.");
            System.out.println("To view developer by ID, pres 5.");
            System.out.println("To exit program, pres 6.");
            System.out.println();
            String action = myScanner.scannerMeth();
            switch (action) {
                case "6":
                    write.write(developersHashMap.developerHashMapValue);
                    exit = false;
                    break;
                case "1":
                    Long l = randomID.randomID(developersHashMap.developerHashMapValue);
                    developersHashMap.developerHashMapValue.put(l, create.createNewDev(l));
                    write.write(developersHashMap.developerHashMapValue);
                    break;
                case "2":
                    Developer developerTemp = update.update(developersHashMap.developerHashMapValue);
                    developersHashMap.developerHashMapValue.put(developerTemp.ID, developerTemp);
                    write.write(developersHashMap.developerHashMapValue);
                    break;
                case "3":
                    System.out.println("Entry ID removable developer");
                    String s = myScanner.scannerMeth();
                    developersHashMap.developerHashMapValue.remove(Long.parseLong(s));
                    write.write(developersHashMap.developerHashMapValue);
                    break;
                case "4":
                    viewAll.viewAll(developersHashMap.developerHashMapValue);
                    break;
                case "5":
                    System.out.println("Enter the developer ID whose data you want to view.");
                    String i = myScanner.scannerMeth();
                    viewByID.viewByID(developersHashMap.developerHashMapValue.get(Long.parseLong(i)));
                    break;
                default:
                    break;
            }
        }
        /*
        //create data store
     try {
         File file1 = new File("D:\\OG_CRUD\\src\\main\\java\\com\\OlehHilchenko\\OGCRUDApplication\\DataStore\\developers.txt");
         File file2 = new File("D:\\OG_CRUD\\src\\main\\java\\com\\OlehHilchenko\\OGCRUDApplication\\DataStore\\skillsValues.txt");
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

        // Test Entities classes....
        /*
        DeveloperSet developerSet = new DeveloperSet();
        LinkedHashSet<String> skil = new LinkedHashSet<>();
        skil.add("mandatory");
        skil.add("sociable");
        AccountStatus stat = new AccountStatusC();
        ((AccountStatusC) stat).accountStatusValue = ACTIVE;
        Developer og = new Developer(111, "Oleg", "Gil", skil, BANNED);
        LinkedHashSet<String> secSkil = new LinkedHashSet<>(skil);
        secSkil.add("bro");
        Developer pg = new Developer(22234, "Petro", "Gol", secSkil, ACTIVE);
        devHashMap.developerHashMapValue.put((long) 111, og);
        devHashMap.developerHashMapValue.put((long) 22234, pg);
        //developerSet.developers.add(og);
        //System.out.println(developerSet.developers.size());
        //System.out.println(developerSet.developers.toString());
        System.out.println(devHashMap.developerHashMapValue.size());
        System.out.println(devHashMap.developerHashMapValue.get((long)111).accountStatusC);
        System.out.println(devHashMap.developerHashMapValue.get((long)111).toString());


        //Test Write class
        Write write = new Write();
        write.write(devHashMap.developerHashMapValue);    */

        //Test Read class...
        //developersHashMap.developerHashMapValue = raed.parse();
        /*
        System.out.println(devHashMap.developerHashMapValue.size());
        for (Long l : devHashMap.developerHashMapValue.keySet())
            System.out.println(devHashMap.developerHashMapValue.get(l).toString());
            */
        //viewAll.viewAll(developersHashMap.developerHashMapValue);
        //Test RandomID class...
        //System.out.println(randomID.randomID(devHashMap.developerHashMapValue));

        //viewByID.viewByID(developersHashMap.developerHashMapValue.get((long) 22234));

        //Long l = randomID.randomID(devHashMap.developerHashMapValue);
        //devHashMap.developerHashMapValue.put(l, create.createNewDev(l));

        //write.write(devHashMap.developerHashMapValue);

        //Developer developerTemp = update.update(developersHashMap.developerHashMapValue);
        //developersHashMap.developerHashMapValue.put(developerTemp.ID, developerTemp);

        //write.write(developersHashMap.developerHashMapValue);

    }
}
