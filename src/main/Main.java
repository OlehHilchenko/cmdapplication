package main;


import main.java.com.OlehHilchenko.OGCRUDApplication.Action.*;
import main.java.com.OlehHilchenko.OGCRUDApplication.DeveloperRepository.*;
import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.*;

import java.util.Random;


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
        DevelopersHashMap devHashMap = new DevelopersHashMap();

        // Test Entities classes....
        /*
        DeveloperSet developerSet = new DeveloperSet();
        LinkedHashSet<String> skil = new LinkedHashSet<>();
        skil.add("mandatory");
        skil.add("sociable");
        AccountStatus stat = new AccountStatusC();
        ((AccountStatusC) stat).accountStatus = ACTIVE;
        Developer og = new Developer(111, "Oleg", "Gil", skil, BANNED);
        LinkedHashSet<String> secSkil = new LinkedHashSet<>(skil);
        secSkil.add("bro");
        Developer pg = new Developer(22234, "Petro", "Gol", secSkil, ACTIVE);
        devHashMap.value.put((long) 111, og);
        devHashMap.value.put((long) 22234, pg);
        //developerSet.developers.add(og);
        //System.out.println(developerSet.developers.size());
        //System.out.println(developerSet.developers.toString());
        System.out.println(devHashMap.value.size());
        System.out.println(devHashMap.value.get((long)111).accountStatusC);
        System.out.println(devHashMap.value.get((long)111).toString());


        //Test Write class
        Write write = new Write();
        write.write(devHashMap.value);    */

        //Test Read class...
        Read raed = new Read();
        devHashMap.value = raed.parse();
        /*
        System.out.println(devHashMap.value.size());
        for (Long l : devHashMap.value.keySet())
            System.out.println(devHashMap.value.get(l).toString());
            */
        ViewAll viewAll = new ViewAll();
        viewAll.viewAll(devHashMap.value);
        //Test RandomID class...
        RandomID randomID = new RandomID();
        //System.out.println(randomID.randomID(devHashMap.value));

        ViewByID viewByID = new ViewByID();
        viewByID.viewByID(devHashMap.value.get((long) 22234));

        //Create create = new Create();
        //Long l = randomID.randomID(devHashMap.value);
        //devHashMap.value.put(l, create.createNewDev(l));

        Write write = new Write();
        //write.write(devHashMap.value);

        Update update = new Update();
        update.update(devHashMap.value);

        write.write(devHashMap.value);

    }
}
