package main.resources.repository;

import main.resources.model.Skill;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkillRepositoryImpl implements SkillRepository {

    public static final String SKILLS = "main\\resources\\files\\skills.txt";

    //read object ...
    public List<Skill> readObjectFromFile(String filepath) {
        try {
            List<Skill> skills = new ArrayList<>();
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
            skills = (List<Skill>) objectIn.readObject();
            objectIn.close();
            return skills;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
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

    public long randomId() {
        Random rnd = new Random();
        long id = (long) rnd.nextLong();

        return id;
    }

    //write object ...
    public void writeObjectToFile(String filepath, List<Skill> skills) {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
            objectOut.writeObject(skills);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
