package main;

import main.resources.model.Account;
import main.resources.model.AccountStatus;
import main.resources.model.Developer;
import main.resources.model.Skill;
import main.resources.repository.*;
import main.resources.view.uniqueid.RandomLongID;

import java.util.HashSet;
import java.util.List;

import java.util.ArrayList;
import java.util.Set;

public class Main implements StoragePath{


    public static void main(String[] args) {
        Skill skill = new Skill();
        SkillRepository skillSkillRepository = new SkillRepositoryImpl();
        Account account = new Account();
        AccountRepository accountRepository = new AccountRepositoryImpl();
        RandomLongID randomLongID = new RandomLongID();
        Developer developer = new Developer();
        AccountStatus accountStatus;
        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        /*
        developer.setID(randomLongID.checkedID());
        developer.setDeveloperName("Oleg Gil");
        developer.setAccount(new Account(randomLongID.checkedID(), AccountStatus.DELETED));
        Set<Skill> skillSet = new HashSet<>();
        skillSet.add(new Skill(randomLongID.checkedID(), "Smart"));
        skillSet.add(new Skill(randomLongID.checkedID(), "Fast"));
        developer.setSkill(skillSet);
        List<Developer> developerList = new ArrayList<>();
        developerList.add(developer);
        ((DeveloperRepositoryImpl) developerRepository).writeObjectToFile(DEVELOPER, developerList);
        */

        List<Developer> d = developerRepository.list();
        for(Developer dv : d)
            System.out.println(dv.toString());
    }
}
