package main.java.repository.io;

import main.java.model.Developer;
import main.java.model.Skill;
import main.java.repository.AccountRepository;
import main.java.repository.DeveloperRepository;
import main.java.repository.SkillRepository;

import java.io.*;
import java.util.*;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private static final String DEVELOPER = "main\\java\\files\\developers.txt";

    private List<Developer> splitString(List<String> s) {
        AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();
        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();
        List<Developer> content = new ArrayList<>();
        for (String str : s) {
            Developer developer = new Developer();
            String strIdAndOtherAttributes = "";
            Set<Skill> skillSet = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case ':':
                        developer.setId(Long.parseLong(strIdAndOtherAttributes));
                        strIdAndOtherAttributes = "";
                        break;
                    case ';':
                        developer.setName(strIdAndOtherAttributes);
                        strIdAndOtherAttributes = "";
                        break;
                    case ',':
                        developer.setAccount(((JavaIOAccountRepositoryImpl) accountRepository).getById(Long.parseLong(strIdAndOtherAttributes)));
                        strIdAndOtherAttributes = "";
                        break;
                    case '.':
                        skillSet.add(((JavaIOSkillRepositoryImpl) skillRepository).getById(Long.parseLong(strIdAndOtherAttributes)));
                        strIdAndOtherAttributes = "";
                        break;
                    default:
                        strIdAndOtherAttributes += str.charAt(i);
                        break;
                }

            }
            skillSet.add(((JavaIOSkillRepositoryImpl) skillRepository).getById(Long.parseLong(strIdAndOtherAttributes)));
            developer.setSkills(skillSet);
            content.add(developer);
        }
        return content;
    }

    private List<String> developerToString(List<Developer> content) {
        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();
        AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();
        List<String> stringList = new ArrayList<>();
        for (Developer developer : content) {
            accountRepository.add(developer.getAccount());
            for (Skill skill : developer.getSkills()) {
                skillRepository.add(skill);
            }
            String str = "" + developer.getId() + ":" + developer.getName() + ";" + developer.getAccount().getId() + ",";
            boolean count = true;
            for (Skill skill : developer.getSkills()) {
                if (count) {
                    str += skill.getId();
                }
                if (!count)
                    str = str + "." + skill.getId();

                count = false;
            }
            stringList.add(str);
        }
        return stringList;
    }

    @Override
    public void add(Developer developer) {
        List<Developer> content = splitString(ReadStringsFromFile.readObjectFromFile(DEVELOPER));
        for (Developer d : content)
            if (d.getId().equals(developer.getId())) {
                return;
            }
        content.add(developer);
        WriteStringsInFile.writeStringsToFile(DEVELOPER, developerToString(content));
    }

    @Override
    public void update(Developer developer) {
        List<Developer> content = splitString(ReadStringsFromFile.readObjectFromFile(DEVELOPER));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(developer.getId())) {
                remove(content.get(i).getId());
                content.add(developer);
                break;
            }
        }
        WriteStringsInFile.writeStringsToFile(DEVELOPER, developerToString(content));
    }

    @Override
    public void remove(Long ID) {
        List<Developer> content = splitString(ReadStringsFromFile.readObjectFromFile(DEVELOPER));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(ID)) {
                AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();
                SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();
                accountRepository.remove(content.get(i).getAccount().getId());
                for (Skill skill : content.get(i).getSkills())
                    skillRepository.remove(skill.getId());
                content.remove(i);
                WriteStringsInFile.writeStringsToFile(DEVELOPER, developerToString(content));
                return;
            }
        }
    }

    @Override
    public Developer getById(Long ID) {
        List<Developer> content = splitString(ReadStringsFromFile.readObjectFromFile(DEVELOPER));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(ID)) {
                return content.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Developer> list() {
        return splitString(ReadStringsFromFile.readObjectFromFile(DEVELOPER));
    }

    public static Long nextLongId(List<Developer> content) {
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
}
