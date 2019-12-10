package main.resources.repository;

import main.resources.model.Account;
import main.resources.model.AccountStatus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    public static final String ACCOUNT = "main\\resources\\files\\account.txt";

    public List<Account> readObjectFromFile(String filepath) {
        try {
            List<Account> accounts = new ArrayList<>();
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
            accounts = (List<Account>) objectIn.readObject();
            objectIn.close();
            return accounts;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void writeObjectToFile(String filepath, List<Account> accounts) {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
            objectOut.writeObject(accounts);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void add(Account account) {
        List<Account> content = readObjectFromFile(ACCOUNT);
        for (Account a : content)
            if (a.getID().equals(account.getID())) {
                return;
            }
        content.add(account);
        writeObjectToFile(ACCOUNT, content);
    }

    @Override
    public void update(Account account) {
        List<Account> content = readObjectFromFile(ACCOUNT);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(account.getID())) {
                content.remove(i);
                content.add(account);
                break;
            }
        }
        writeObjectToFile(ACCOUNT, content);
    }

    @Override
    public void remove(Long ID) {
        List<Account> content = readObjectFromFile(ACCOUNT);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                content.remove(i);
                writeObjectToFile(ACCOUNT, content);
                return;
            }
        }
    }

    @Override
    public Account getById(Long ID) {
        List<Account> content = readObjectFromFile(ACCOUNT);
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getID().equals(ID)) {
                return content.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Account> list() {
        return readObjectFromFile(ACCOUNT);
    }
}