package main.resources.view;

import main.resources.model.Account;
import main.resources.model.AccountStatus;
import main.resources.model.Skill;
import main.resources.repository.*;
import java.util.List;

import java.util.ArrayList;

public class Main implements StoragePath{


    public static void main(String[] args) {
        Skill skill = new Skill();
        SkillRepository skillSkillRepository = new SkillRepositoryImpl();
        Account account = new Account();
        AccountRepository accountRepository = new AccountRepositoryImpl();

        // List<Account> accountList = new ArrayList<>();
        //accountList.add(new Account(324567800l, AccountStatus.ACTIVE));
        //((AccountRepositoryImpl) accountRepository).writeObjectToFile(AccountRepositoryImpl.ACCOUNT, accountList);
        accountRepository.add(new Account(324567800l, AccountStatus.ACTIVE));
        List<Account> a = accountRepository.list();
            for(Account ac : a)
                System.out.println(ac.toString());
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
