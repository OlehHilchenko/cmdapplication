package main.resources.view;

import main.resources.model.Skill;
import main.resources.repository.*;
import java.util.List;

import java.util.ArrayList;

public class Main implements StoragePath{


    public static void main(String[] args) {
        Skill skill = new Skill();
        SkillRepository skillSkillRepository = new SkillRepositoryImpl();

        //skillSkillRepository.add(new Skill(324567800l, "Fast"));
        //skillSkillRepository.remove(324567800l);
        //skill = skillSkillRepository.getById(125l);
        //System.out.println(skill.getID() + " " + skill.getSkillName());
        //skillSkillRepository.update(new Skill(324567800l, "Fast and smart"));

        List<Skill> l = skillSkillRepository.list();
        for (Skill s : l)
            System.out.println(s.toString());


    }
}
