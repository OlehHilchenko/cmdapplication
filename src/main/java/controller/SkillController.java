package main.java.controller;

import main.java.model.Skill;
import main.java.repository.io.JavaIODeveloperRepositoryImpl;
import main.java.view.ViewAllActions;

public class SkillController {

    public Skill getNewSkill(Long id, String name) {

        Skill skill = new Skill();

        skill.setId(id);

        skill.setName(name);

        return skill;
    }

    public Skill getUpdateSkill(Long id, String name) {

        Skill skill = new Skill();

        skill.setId(id);

        System.out.println(ViewAllActions.ENTRY_SKILL_NAME);
        skill.setName(name);

        return skill;
    }
}
