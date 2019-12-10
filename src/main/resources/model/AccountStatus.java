package main.resources.model;

import java.util.Objects;

public class AccountStatus {

    long ID;
    String accountStatus;

    public AccountStatus(long ID, String accountStatus) {
        this.ID = ID;
        this.accountStatus = accountStatus;
    }

    public AccountStatus (){};

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountStatus that = (AccountStatus) o;
        return ID == that.ID &&
                Objects.equals(accountStatus, that.accountStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, accountStatus);
    }

    @Override
    public String toString() {
        return "AccountStatus{" +
                "ID=" + ID +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
