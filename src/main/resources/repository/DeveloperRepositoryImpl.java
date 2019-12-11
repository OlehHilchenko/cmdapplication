package main.resources.repository;

import main.resources.model.Developer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {

    public static final String DEVELOPER = "main\\resources\\files\\developer.txt";

    public List<Developer> readObjectFromFile(String filepath) {
        try {
            List<Developer> developers = new ArrayList<>();
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
            developers = (List<Developer>) objectIn.readObject();
            objectIn.close();
            return developers;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void writeObjectToFile(String filepath, List<Developer> developers) {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
            objectOut.writeObject(developers);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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
                content.remove(i);
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
        return null;    }

    @Override
    public List<Developer> list() {
        return readObjectFromFile(DEVELOPER);
    }
}
