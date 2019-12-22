package main.java.controller;

import main.java.model.Account;
import main.java.model.AccountStatus;
import main.java.repository.io.JavaIODeveloperRepositoryImpl;
import main.java.view.ViewAllActions;

public class AccountController {

    public Account getNewAccount(Long id) {

        Account account = new Account();


        account.setId(id);


        ViewAllActions.choiceAccountStatus();
        switch ((String) ViewAllActions.scan()) {
            case "A":
                account.setAccountStatus(AccountStatus.ACTIVE);
                break;
            case "B":
                account.setAccountStatus(AccountStatus.BANNED);
                break;
            case "D":
                account.setAccountStatus(AccountStatus.DELETED);
                break;
            default:
                break;
        }

        return account;
    }

    public Account getUpdateAccount(Long id) {

        Account account = new Account();

        account.setId(id);

        ViewAllActions.choiceAccountStatus();
        switch ((String) ViewAllActions.scan()) {
            case "A":
                account.setAccountStatus(AccountStatus.ACTIVE);
                break;
            case "B":
                account.setAccountStatus(AccountStatus.BANNED);
                break;
            case "D":
                account.setAccountStatus(AccountStatus.DELETED);
                break;
            default:
                break;
        }

        return account;
    }
}
