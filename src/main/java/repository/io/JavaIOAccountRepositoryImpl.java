package main.java.repository.io;

import main.java.model.Account;
import main.java.model.AccountStatus;
import main.java.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private static final String ACCOUNT = "main\\java\\files\\accounts.txt";

    private List<Account> splitString(List<String> s) {
        List<Account> content = new ArrayList<>();
        for (String str : s) {
            Account account = new Account();
            String strIdAndScillName = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ':')
                    strIdAndScillName += str.charAt(i);
                else if (str.charAt(i) == ':') {
                    account.setId(Long.parseLong(strIdAndScillName));
                    strIdAndScillName = "";
                }
            }
            account.setAccountStatus(AccountStatus.valueOf(strIdAndScillName));
            content.add(account);
        }
        return content;
    }

    private List<String> accountToString(List<Account> content) {
        List<String> stringList = new ArrayList<>();
        for (Account account : content)
            stringList.add("" + account.getId() + ":" + account.getAccountStatus());

        return stringList;
    }

    @Override
    public void add(Account account) {
        List<Account> content = splitString(ReadStringsFromFile.readObjectFromFile(ACCOUNT));
        for (Account a : content)
            if (a.getId().equals(account.getId())) {
                return;
            }
        content.add(account);
        WriteStringsInFile.writeStringsToFile(ACCOUNT, accountToString(content));
    }

    @Override
    public void update(Account account) {
        List<Account> content = splitString(ReadStringsFromFile.readObjectFromFile(ACCOUNT));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(account.getId())) {
                content.remove(i);
                content.add(account);
                break;
            }
        }
        WriteStringsInFile.writeStringsToFile(ACCOUNT, accountToString(content));
    }

    @Override
    public void remove(Long ID) {
        List<Account> content = splitString(ReadStringsFromFile.readObjectFromFile(ACCOUNT));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(ID)) {
                content.remove(i);
                WriteStringsInFile.writeStringsToFile(ACCOUNT, accountToString(content));
                return;
            }
        }
    }

    @Override
    public Account getById(Long ID) {
        List<Account> content = splitString(ReadStringsFromFile.readObjectFromFile(ACCOUNT));
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).getId().equals(ID)) {
                return content.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Account> list() {
        return splitString(ReadStringsFromFile.readObjectFromFile(ACCOUNT));
    }
}