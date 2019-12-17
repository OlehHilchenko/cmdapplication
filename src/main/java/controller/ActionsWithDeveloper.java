package main.java.controller;

import main.java.model.Account;
import main.java.model.AccountStatus;
import main.java.model.Developer;
import main.java.model.Skill;
import main.java.repository.DeveloperRepository;
import main.java.repository.DeveloperRepositoryImpl;
import main.java.view.ViewAllActions;
import main.java.view.uniqueid.RandomLongID;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ActionsWithDeveloper {

    private String scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private void actionAddNewDeveloper(){
        Developer developer = new Developer();
        RandomLongID randomLongID = new RandomLongID();
        developer.setID(randomLongID.checkedID());
        System.out.println(ViewAllActions.ENTRY_DEVELOPER_NAME);
        developer.setDeveloperName((String) scan());

        ViewAllActions.choiceAccountStatus();
        switch ((String) scan()) {
            case "A":
                developer.setAccount(new Account(randomLongID.checkedID(), AccountStatus.ACTIVE));
                break;
            case "B":
                developer.setAccount(new Account(randomLongID.checkedID(), AccountStatus.BANNED));
                break;
            case "D":
                developer.setAccount(new Account(randomLongID.checkedID(), AccountStatus.DELETED));
                break;
            default:
                break;
        }

        Set<Skill> skillSet = new HashSet<>();
        boolean exit = true;
        while (exit){
            System.out.println(ViewAllActions.ENTRY_SKILL_NAME);
            String s = scan();
            if (s.equals("-1")){
                exit = false;
            }else {skillSet.add(new Skill(randomLongID.checkedID(), s));}
        }
        developer.setSkill(skillSet);

        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        developerRepository.add(developer);
    }

    public void mainMenu() {

        while (true) {
            ViewAllActions.viewMainMenu();
            String scan = scan();
            switch (scan) {
                case "1":
                    //new
                    actionAddNewDeveloper();
                    break;
                case "2":
                    //update
                    updateDeveloper();
                    break;
                case "3":
                    //delete
                    deleteByID();
                    break;
                case "4":
                    //view by id
                    viewByID();
                    break;
                case "5":
                    //view all
                    viewAll();
                    break;
                case "6":
                    return;
                default:
                    break;
            }
        }
    }

    private void updateDeveloper(){
        System.out.println(ViewAllActions.ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_CHANGE);
        Long id = Long.parseLong(scan());

        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        Developer developer = ((DeveloperRepositoryImpl) developerRepository).getById(id);
        developerRepository.remove(id);

        System.out.println(ViewAllActions.ENTRY_DEVELOPER_NAME);
        developer.setDeveloperName((String) scan());

        ViewAllActions.choiceAccountStatus();
        switch ((String) scan()) {
            case "A":
                developer.setAccount(new Account((developer.getAccount().getID()),(AccountStatus.ACTIVE)));
                break;
            case "B":
                developer.setAccount(new Account((developer.getAccount().getID()),(AccountStatus.BANNED)));
                break;
            case "D":
                developer.setAccount(new Account((developer.getAccount().getID()),(AccountStatus.DELETED)));
                break;
            default:
                break;
        }

        RandomLongID randomLongID = new RandomLongID();
        Set<Skill> skillSet = new HashSet<>();
        boolean exit = true;
        while (exit){
            System.out.println(ViewAllActions.ENTRY_SKILL_NAME);
            String s = scan();
            if (s.equals("-1")){
                exit = false;
            }else {skillSet.add(new Skill(randomLongID.checkedID(), s));}
        }
        developer.setSkill(skillSet);
        developerRepository.add(developer);
    }

    private void viewByID(){
        System.out.println(ViewAllActions.ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_SEE);
        Long id = Long.parseLong(scan());
        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        Developer developer = developerRepository.getById(id);
        System.out.println(developer.toString());
    }

    private void deleteByID (){
        System.out.println(ViewAllActions.ENTRY_ID_REMOVABLE_DEVELOPER);
        Long id = Long.parseLong(scan());
        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        developerRepository.remove(id);
    }

    private void viewAll(){
        DeveloperRepository developerRepository = new DeveloperRepositoryImpl();
        List<Developer> l = developerRepository.list();
        for (Developer d : l)
            System.out.println(d.toString());
    }
}
