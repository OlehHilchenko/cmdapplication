package main.java.repository;

import main.java.model.Account;
import main.java.model.AccountStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountRepositoryImpl implements AccountRepository {

    private static final String ACCOUNT = "main\\java\\files\\account.txt";

    private List<Account> readObjectFromFile(String filepath) {
        ArrayList<String> temp = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new FileInputStream(filepath));
            while (scan.hasNextLine())
                temp.add(scan.nextLine());
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return splitString(temp);
    }

    private List<Account> splitString(ArrayList<String> s) {
        List<Account> content = new ArrayList<>();
        for (String str : s) {
            Account account  = new Account();
            String strIdAndScillName = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ':')
                    strIdAndScillName += str.charAt(i);
                else if (str.charAt(i) == ':') {
                    account.setID(Long.parseLong(strIdAndScillName));
                    strIdAndScillName = "";
                }
            }
            account.setAccountStatus(AccountStatus.valueOf(strIdAndScillName));
            content.add(account);
        }
        return content;
    }

    private void writeObjectToFile(String filepath, List<Account> accounts) {
        try {
            boolean firstWrite = false;
            for (Account account : accounts) {
                FileWriter fw = new FileWriter(filepath, firstWrite);
                fw.write("" + account.getID() + ":" + account.getAccountStatus());
                fw.write(System.getProperty("line.separator"));
                fw.close();
                firstWrite = true;
            }
        } catch (IOException e) {
            System.out.println(e);
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