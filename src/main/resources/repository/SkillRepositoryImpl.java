package main.resources.repository;

import main.resources.model.Skill;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SkillRepositoryImpl implements SkillRepository, StoragePath {
    /*
    ArrayList<String> readSkillTxt(String file) {
        ArrayList<String> skillTxtList = new ArrayList<>();
        // id:name ...
        try {
            Scanner scan = new Scanner(new FileInputStream(file));
            while (scan.hasNextLine())
                skillTxtList.add(scan.nextLine());

            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return skillTxtList;
    }
*/
    //read object ...
    public List<Skill> ReadObjectFromFile(String filepath) {

        try {
            List<Skill> skills = new ArrayList<>();
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
            skills = (List<Skill>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return skills;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(Skill skill) {
        List<Skill> content = ReadObjectFromFile(SKILLS);
        for (Skill s : content)
            if (s.getID().equals(skill.getID())) {
                System.out.println("this skill is exist");
                return;
            }
        content.add(skill);
        System.out.println("this skill is add");
        WriteObjectToFile(SKILLS, content);
    }

    @Override
    public void update(Skill skill) {
        List<Skill> content = ReadObjectFromFile(SKILLS);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(skill.getID())) {
                content.remove(i);
                content.add(skill);
                System.out.println("this skill is update");
                break;
            }
        }
        WriteObjectToFile(SKILLS, content);
    }

    @Override
    public void remove(Long ID) {
        List<Skill> content = ReadObjectFromFile(SKILLS);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                content.remove(i);
                System.out.println("this skill is deleted");
                WriteObjectToFile(SKILLS, content);
                return;
            }
        }
        System.out.println("this skill is no exist");
    }

    @Override
    public Skill getById(Long ID) {
        List<Skill> content = ReadObjectFromFile(SKILLS);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                return content.get(i);
            }
        }
        System.out.println("this skill is no exist");
        return null;
    }

    @Override
    public List<Skill> list() {
        return ReadObjectFromFile(SKILLS);
    }

    public long randomId() {
        Random rnd = new Random();
        long id = (long) rnd.nextLong();

        return id;
    }
/*
    boolean checkId(long id, ArrayList<String> content) {
        String sid = "" + id;
        for (String s : content) {
            String checkedId = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ':')
                    checkedId += s.charAt(i);
                else if (s.charAt(i) == ':') {
                    if (sid.equals(checkedId))
                        return true;
                    else
                        break;
                }
            }
        }
        return false;
    }
*/
    /*
    public void addSkill(Skill skill) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (!checkId(skill.getID(), content)) {
            content.add("" + skill.getID() + ":" + skill.getSkillName());
            writeSkills(content, SKILLS);
        } else
            System.out.println("this skill is exist");

    }
*/
    /*
    public void updateSkill(Skill skill) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (checkId(skill.getID(), content)) {
            content = deleteSkill(skill.getID(), content);
            content.add("" + skill.getID() + ":" + skill.getSkillName());
            writeSkills(content, SKILLS);
        } else
            System.out.println("id this skill is no exist");
    }
*/
    /*
    ArrayList<String> deleteSkill(long id, ArrayList<String> content) {
        for (int i = 0; i < content.size(); i++) {
            String checkedID = "";
            for (int j = 0; j < content.get(i).length(); j++) {
                if (content.get(i).charAt(j) != ':')
                    checkedID += content.get(i).charAt(j);
                else if (content.get(i).charAt(j) == ':') {
                    if (("" + id).equals(checkedID)) {
                        content.remove(i);
                        break;
                    } else break;
                }
            }
        }
        return content;
    }
*/
    /*
    public void removeSkill(long id) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (checkId(id, content)) {
            deleteSkill(id, content);
            writeSkills(content, SKILLS);
        } else
            System.out.println("tis id is no exist");

    }
*/
/*
    String returnStringById(long id, ArrayList<String> content) {
        String sid = "" + id;
        for (String s : content) {
            String checkedID = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ':')
                    checkedID += s.charAt(i);
                else if (s.charAt(i) == ':') {
                    if (sid.equals(checkedID))
                        return s;
                    else
                        break;
                }
            }
        }
        return "this string no exist";
    }
*/
/*
    String[] split(String con) {
        String result[] = new String[2];
        result[0] = result[1] = "";
        if (con.equals("this string no exist")) {
            return result;
        }
        int counter = 0;
        for (int i = 0; i < con.length(); i++) {
            if (con.charAt(i) != ':')
                result[counter] += con.charAt(i);
            else if (con.charAt(i) == ':')
                counter++;
        }
        return result;
    }
*/
/*
    public Skill getSkillById(long id) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (checkId(id, content)) {
            String splitResult[] = split(returnStringById(id, content));
            return new Skill(Long.parseLong(splitResult[0]), splitResult[1]);
        }

        return new Skill(-1l, "skill with this id is no exist");
    }
*//*
    public List<Skill> listSkill() {
        return null;
    }
*//*
    void writeSkills(ArrayList<String> content, String file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            // in:name...
            for (String s : content) {
                fileWriter.write(s);
                fileWriter.write(System.getProperty("line.separator"));
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
*/
    //write object ...
    public void WriteObjectToFile(String filepath, List<Skill> skills) {

        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
            objectOut.writeObject(skills);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
