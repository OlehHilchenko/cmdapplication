package main.java.view;

import main.java.controller.DeveloperController;
import main.java.model.Developer;
import main.java.repository.DeveloperRepository;
import main.java.repository.io.JavaIODeveloperRepositoryImpl;

import java.util.List;

public class Actions {

    private void actionAddNewDeveloper() {
        DeveloperController developerController = new DeveloperController();
        Developer developer = developerController.getNewDeveloper();
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        developerRepository.add(developer);
    }

    public void mainMenu() {

        while (true) {
            ViewAllActions.viewMainMenu();
            String scan = ViewAllActions.scan();
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

    private void updateDeveloper() {
        System.out.println(ViewAllActions.ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_CHANGE);
        Long id = Long.parseLong(ViewAllActions.scan());
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        Developer developer = ((JavaIODeveloperRepositoryImpl) developerRepository).getById(id);
        developerRepository.remove(id);
        DeveloperController developerController = new DeveloperController();
        developerRepository.add(developerController.getUpdateDeveloper(developer));
    }

    private void viewByID() {
        System.out.println(ViewAllActions.ENTRY_ID_DEVELOPER_WHICH_YOU_WANT_TO_SEE);
        Long id = Long.parseLong(ViewAllActions.scan());
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        Developer developer = developerRepository.getById(id);
        System.out.println(developer.toString());
    }

    private void deleteByID() {
        System.out.println(ViewAllActions.ENTRY_ID_REMOVABLE_DEVELOPER);
        Long id = Long.parseLong(ViewAllActions.scan());
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        developerRepository.remove(id);
    }

    private void viewAll() {
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        List<Developer> l = developerRepository.list();
        for (Developer d : l)
            System.out.println(d.toString());
    }
}
