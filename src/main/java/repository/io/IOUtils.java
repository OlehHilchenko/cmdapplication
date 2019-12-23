package main.java.repository.io;

import main.java.model.Developer;
import main.java.model.Skill;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IOUtils {

    public IOUtils (){
        id = 0l;
    }

    private static Long id;

    public Long newLongID() {
        //Iterates through the developer entities, because the developer contains both skill entities and account entities.
        //Thus, the largest ID is selected from the sheet.
        if (id == 0) {
            JavaIODeveloperRepositoryImpl javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();
            id = nextLongId(javaIODeveloperRepository.list());
        }
        if (id > 0)
            id++;

        return id;
    }

    private static Long nextLongId(List<Developer> content) {
        Long nextID = 0l;

        for (Developer developer : content) {
            long id = developer.getId();
            long accountID = developer.getAccount().getId();
            Set<Skill> skillSet = developer.getSkills();

            if (nextID < id)
                nextID = id;
            if (nextID < accountID)
                nextID = accountID;
            for (Skill skill : skillSet) {
                if (nextID < skill.getId())
                    nextID = skill.getId();
            }
        }
        return nextID++;
    }

    public static List<String> readObjectFromFile(String filepath) {
        ArrayList<String> stringsFromFile = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(filepath));
            while (scan.hasNextLine())
                stringsFromFile.add(scan.nextLine());
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return stringsFromFile;
    }

    public static void writeStringsToFile(String filepath, List<String> stringsInFile) {
        try {
            boolean firstWrite = false;
            for (String str : stringsInFile) {
                FileWriter fw = new FileWriter(filepath, firstWrite);
                fw.write(str);
                fw.write(System.getProperty("line.separator"));
                fw.close();
                firstWrite = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
