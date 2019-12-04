package main.resources.view;

import main.resources.model.Skill;
import main.resources.repository.DeleteSkills;
import main.resources.repository.NewSkills;
import main.resources.repository.UpdateSkills;
import main.resources.repository.ViewSkills;

public class Main {


    public static void main(String[] args) {
        Skill skill = new Skill();
        ViewSkills viewSkills = new ViewSkills();
        String str [] = viewSkills.viewSkill(222333444666l);
        skill.setID(Long.parseLong(str[0]));
        skill.setName(str[1]);

        System.out.println("ID " + skill.getID() + " " + "Name "+ skill.getName());

    }
}
