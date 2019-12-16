package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    Long ID;
    public AccountStatus accountStatus;

    private static final long serialVersionUID = 1l;
    public Account(){};

    public Account(long ID, AccountStatus accountStatus) {
        this.ID = ID;
        this.accountStatus = accountStatus;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ID == account.ID &&
                accountStatus == account.accountStatus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, accountStatus);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
