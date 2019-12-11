package main.resources.controller;

import main.resources.view.ViewAllActions;

import java.util.Scanner;

public class ActionsWithDeveloper {

    String scaner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    void MainMenu (){
        ViewAllActions viewAllActions = new ViewAllActions();

        while (true){
            viewAllActions.viewMainMenu();
            String scan = scaner();
            switch (scan){
                case "1":
                    //new
                    break;
                case "2":
                    //update
                    break;
                case "3":
                    //delete
                    break;
                case "4":
                    //view by id
                    break;
                case "5":
                    //view all
                    break;
                case "6":
                    return;
                    default:
                        break;
            }
        }
    }

}
