package main.resources.repository;

import main.resources.model.Skill;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SkillRepositoryImpl implements SkillRepository, StoragePath {

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

    public long randomId (){
        ArrayList<String> content = readSkillTxt(SKILLS);
        Random rnd = new Random();
            long id = (long) rnd.nextLong();
        while (checkId(id, content))
            id = (long) rnd.nextLong();


        return id;
    }

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

    @Override
    public void addSkill(Skill skill) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (!checkId(skill.getID(), content)) {
            content.add("" + skill.getID() + ":" + skill.getName());
            writeSkills(content, SKILLS);
        } else
            System.out.println("this skill is exist");

    }

    @Override
    public void updateSkill(Skill skill) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (checkId(skill.getID(), content)) {
            content = deleteSkill(skill.getID(), content);
            content.add("" + skill.getID() + ":" + skill.getName());
            writeSkills(content, SKILLS);
        } else
            System.out.println("id this skill is no exist");
    }

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

    @Override
    public void removeSkill(long id) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (checkId(id, content)) {
            deleteSkill(id, content);
            writeSkills(content, SKILLS);
        } else
            System.out.println("tis id is no exist");

    }


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

    @Override
    public Skill getSkillById(long id) {
        ArrayList<String> content = readSkillTxt(SKILLS);
        if (checkId(id, content)) {
            String splitResult[] = split(returnStringById(id, content));
            return new Skill(Long.parseLong(splitResult[0]), splitResult[1]);
        }

        return new Skill(-1l, "skill with this id is no exist");
    }

    @Override
    public List<Skill> listSkill() {
        return null;
    }

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
}
