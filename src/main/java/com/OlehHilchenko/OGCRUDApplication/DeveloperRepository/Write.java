package main.java.com.OlehHilchenko.OGCRUDApplication.DeveloperRepository;

import main.java.com.OlehHilchenko.OGCRUDApplication.DataStore.DataWarehousePath;
import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.*;

import java.io.FileWriter;
import java.util.HashMap;

//
public class Write implements DataWarehousePath {

    String ID;
    String firstName;
    String lastName;
    String skillSet;
    String accountStat;

    public boolean write(HashMap<Long, Developer> val){
        boolean firstWrite = false;
        Long keys [] = val.keySet().toArray(Long[]::new);
        for (int i = 0; i < keys.length; i++) {
           Developer developer = val.get(keys[i]);
           ID = keys[i].toString();
           firstName = developer.firstName;
           lastName = developer.lastName;
           skillSet = SkillSetToString(developer.skillSet);
           accountStat = developer.accountStat.accountStatus;
            try {
                FileWriter fwD = new FileWriter(DEVELOPERS, firstWrite);
                fwD.write(ID);
                fwD.write(" ");
                fwD.write(firstName);
                fwD.write(" ");
                fwD.write(lastName);
                fwD.write(System.getProperty( "line.separator" ));
                fwD.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                FileWriter fwA = new FileWriter(ACCOUNTS, firstWrite);
                fwA.write(ID);
                fwA.write(" ");
                fwA.write(accountStat);
                fwA.write(System.getProperty( "line.separator" ));
                fwA.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                FileWriter fwS = new FileWriter(SKILLS, firstWrite);
                fwS.write(ID);
                fwS.write(" ");
                fwS.write(skillSet);
                fwS.write(System.getProperty( "line.separator" ));
                fwS.close();
            } catch (Exception e) {
                System.out.println(e);
            }
                firstWrite = true;
        }

        return true;
    }

    String SkillSetToString(SkillSet skillSet){
        String skillSetResult = "";
        String temp [] = skillSet.skills.toArray(String[]::new);
        for (String s : temp)
            skillSetResult = skillSetResult + s + " ";
        return skillSetResult;
    }
}
