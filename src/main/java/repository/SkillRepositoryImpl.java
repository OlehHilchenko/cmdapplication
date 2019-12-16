package main.java.repository;

import main.java.model.Skill;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class SkillRepositoryImpl implements SkillRepository {

    public static final String SKILLS = "main\\java\\files\\skills.txt";

    public List<Skill> readObjectFromFile(String filepath) {
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

    List<Skill> splitString(ArrayList<String> s) {
        List<Skill> content = new ArrayList<>();
        for (String str : s) {
            Skill skill = new Skill();
            String strIdAndScillName = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ':')
                    strIdAndScillName += str.charAt(i);
                else if (str.charAt(i) == ':') {
                    skill.setID(Long.parseLong(strIdAndScillName));
                    strIdAndScillName = "";
                }
            }
            skill.setSkillName(strIdAndScillName);
            content.add(skill);
        }
        return content;
    }

    @Override
    public void add(Skill skill) {
        List<Skill> content = readObjectFromFile(SKILLS);
        for (Skill s : content)
            if (s.getID().equals(skill.getID())) {
                return;
            }
        content.add(skill);
        writeObjectToFile(SKILLS, content);
    }

    @Override
    public void update(Skill skill) {
        List<Skill> content = readObjectFromFile(SKILLS);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(skill.getID())) {
                content.remove(i);
                content.add(skill);
                break;
            }
        }
        writeObjectToFile(SKILLS, content);
    }

    @Override
    public void remove(Long ID) {
        List<Skill> content = readObjectFromFile(SKILLS);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                content.remove(i);
                writeObjectToFile(SKILLS, content);
                return;
            }
        }
    }

    @Override
    public Skill getById(Long ID) {
        List<Skill> content = readObjectFromFile(SKILLS);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                return content.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Skill> list() {
        return readObjectFromFile(SKILLS);
    }

    public void writeObjectToFile(String filepath, List<Skill> skills) {
        try {
            boolean firstWrite = false;
            for (Skill skill : skills) {
                FileWriter fw = new FileWriter(filepath, firstWrite);
                fw.write("" + skill.getID() + ":" + skill.getSkillName());
                fw.write(System.getProperty("line.separator"));
                fw.close();
                firstWrite = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
