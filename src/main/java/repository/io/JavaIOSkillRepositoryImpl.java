package main.java.repository.io;

import main.java.model.Skill;
import main.java.repository.SkillRepository;

import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private static final String SKILLS = "main\\java\\resources\\files\\skills.txt";

    private List<Skill> splitString(List<String> s) {
        List<Skill> content = new ArrayList<>();
        for (String str : s) {
            Skill skill = new Skill();
            String strIdAndScillName = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ':')
                    strIdAndScillName += str.charAt(i);
                else if (str.charAt(i) == ':') {
                    skill.setId(Long.parseLong(strIdAndScillName));
                    strIdAndScillName = "";
                }
            }
            skill.setName(strIdAndScillName);
            content.add(skill);
        }
        return content;
    }

    private List<String> skillToString(List<Skill> content) {
        List<String> stringList = new ArrayList<>();
        for (Skill skill : content)
            stringList.add("" + skill.getId() + ":" + skill.getName());

        return stringList;
    }

    @Override
    public void add(Skill skill) {
        List<Skill> content = splitString(ReadStringsFromFile.readObjectFromFile(SKILLS));
        for (Skill s : content)
            if (s.getId().equals(skill.getId())) {
                return;
            }
        content.add(skill);
        WriteStringsInFile.writeStringsToFile(SKILLS, skillToString(content));
    }

    @Override
    public void update(Skill skill) {
        List<Skill> content = splitString(ReadStringsFromFile.readObjectFromFile(SKILLS));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(skill.getId())) {
                content.remove(i);
                content.add(skill);
                break;
            }
        }
        WriteStringsInFile.writeStringsToFile(SKILLS, skillToString(content));
    }

    @Override
    public void remove(Long ID) {
        List<Skill> content = splitString(ReadStringsFromFile.readObjectFromFile(SKILLS));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(ID)) {
                content.remove(i);
                WriteStringsInFile.writeStringsToFile(SKILLS, skillToString(content));
                return;
            }
        }
    }

    @Override
    public Skill getById(Long ID) {
        List<Skill> content = splitString(ReadStringsFromFile.readObjectFromFile(SKILLS));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(ID)) {
                return content.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Skill> list() {
        return splitString(ReadStringsFromFile.readObjectFromFile(SKILLS));
    }

}
