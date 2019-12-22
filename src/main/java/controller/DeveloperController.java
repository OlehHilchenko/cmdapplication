package main.java.controller;

import main.java.model.Developer;
import main.java.model.Skill;
import main.java.repository.io.JavaIODeveloperRepositoryImpl;
import main.java.repository.io.NewLongID;
import main.java.view.ViewAllActions;

import java.util.HashSet;
import java.util.Set;

public class DeveloperController {

    public Developer getNewDeveloper() {

        NewLongID newLongID = new NewLongID();

        Developer developer = new Developer();
        developer.setId(newLongID.newLongID());

        System.out.println(ViewAllActions.ENTRY_DEVELOPER_NAME);
        developer.setName((String) ViewAllActions.scan());

        AccountController accountController = new AccountController();
        developer.setAccount(accountController.getNewAccount(newLongID.newLongID()));

        Set<Skill> skillSet = new HashSet<>();
        boolean exit = true;
        while (exit) {
            System.out.println(ViewAllActions.ENTRY_SKILL_NAME);
            SkillController skillController = new SkillController();
            String s = ViewAllActions.scan();
            if (s.equals("-1")) {
                exit = false;
            } else {
                skillSet.add(skillController.getNewSkill(newLongID.newLongID(), s));
            }
        }
        developer.setSkills(skillSet);


        return developer;
    }

    public Developer getUpdateDeveloper(Developer developer) {

        System.out.println(ViewAllActions.ENTRY_DEVELOPER_NAME);
        developer.setName((String) ViewAllActions.scan());

        AccountController accountController = new AccountController();
        developer.setAccount(accountController.getUpdateAccount(developer.getAccount().getId()));

        Set<Skill> skillSet = developer.getSkills();
        Set<Skill> updateSkillSet = new HashSet<>();
        for (Skill skill : skillSet) {
            SkillController skillController = new SkillController();
            System.out.println(skill.toString());
            ViewAllActions.updateSkillMenu();
            String s = ViewAllActions.scan();
            if (s.equals("D"))
                continue;
            if (s.equals("S"))
                updateSkillSet.add(skill);
            else
                updateSkillSet.add(skillController.getUpdateSkill(skill.getId(), s));
        }
        developer.setSkills(updateSkillSet);

        return developer;

    }
}
