package main.java.repository;

import main.java.model.Developer;
import main.java.model.Skill;

import java.io.*;
import java.util.*;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    public static final String DEVELOPER = "main\\java\\files\\developer.txt";

    public List<Developer> readObjectFromFile(String filepath) {
        ArrayList<String> temp = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(filepath));
            while (scan.hasNextLine())
                temp.add(scan.nextLine());
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return splitString(temp);
    }

    List<Developer> splitString(ArrayList<String> s) {
        AccountRepository accountRepository = new AccountRepositoryImpl();
        SkillRepository skillRepository = new SkillRepositoryImpl();
        List<Developer> content = new ArrayList<>();
        for (String str : s) {
            Developer developer = new Developer();
            String strIdAndOtherAttributes = "";
            Set<Skill> skillSet = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case ':':
                        developer.setID(Long.parseLong(strIdAndOtherAttributes));
                        strIdAndOtherAttributes = "";
                        break;
                    case ';':
                        developer.setDeveloperName(strIdAndOtherAttributes);
                        strIdAndOtherAttributes = "";
                        break;
                    case ',':
                        developer.setAccount(((AccountRepositoryImpl) accountRepository).getById(Long.parseLong(strIdAndOtherAttributes)));
                        strIdAndOtherAttributes = "";
                        break;
                    case '.':
                        skillSet.add(((SkillRepositoryImpl) skillRepository).getById(Long.parseLong(strIdAndOtherAttributes)));
                        strIdAndOtherAttributes = "";
                        break;
                    default:
                        strIdAndOtherAttributes += str.charAt(i);
                        break;
                }

            }
            skillSet.add(((SkillRepositoryImpl) skillRepository).getById(Long.parseLong(strIdAndOtherAttributes)));
            developer.setSkill(skillSet);
            content.add(developer);
        }
        return content;
    }

    public void writeObjectToFile(String filepath, List<Developer> developers) {
        try {
            boolean firstWrite = false;
            SkillRepository skillRepository = new SkillRepositoryImpl();
            AccountRepository accountRepository = new AccountRepositoryImpl();
            for (Developer developer : developers) {
                accountRepository.add(developer.getAccount());
                for (Skill skill : developer.getSkill()) {
                    skillRepository.add(skill);
                }
                FileWriter fw = new FileWriter(filepath, firstWrite);
                String str = "" + developer.getID() + ":" + developer.getDeveloperName() + ";" + developer.getAccount().getID() + ",";
                boolean count = true;
                for (Skill skill : developer.getSkill()) {
                    if (count) {
                        str += skill.getID();
                    }
                    if (!count)
                        str = str + "." + skill.getID();


                    count = false;
                }
                fw.write(str);
                fw.write(System.getProperty("line.separator"));
                fw.close();
                firstWrite = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void add(Developer developer) {
        List<Developer> content = readObjectFromFile(DEVELOPER);
        for (Developer d : content)
            if (d.getID().equals(developer.getID())) {
                return;
            }
        content.add(developer);
        writeObjectToFile(DEVELOPER, content);
    }

    @Override
    public void update(Developer developer) {
        List<Developer> content = readObjectFromFile(DEVELOPER);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(developer.getID())) {
                //content.remove(i);
                remove(content.get(i).getID());
                content.add(developer);
                break;
            }
        }
        writeObjectToFile(DEVELOPER, content);
    }

    @Override
    public void remove(Long ID) {
        List<Developer> content = readObjectFromFile(DEVELOPER);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                AccountRepository accountRepository = new AccountRepositoryImpl();
                SkillRepository skillRepository = new SkillRepositoryImpl();
                accountRepository.remove(content.get(i).getAccount().getID());
                for (Skill skill: content.get(i).getSkill())
                    skillRepository.remove(skill.getID());
                content.remove(i);
                writeObjectToFile(DEVELOPER, content);
                return;
            }
        }
    }

    @Override
    public Developer getById(Long ID) {
        List<Developer> content = readObjectFromFile(DEVELOPER);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                return content.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Developer> list() {
        return readObjectFromFile(DEVELOPER);
    }
}
