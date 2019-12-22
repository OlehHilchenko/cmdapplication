package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    private Long id;
    private AccountStatus accountStatus;

    private static final long serialVersionUID = 1l;
    public Account(){};

    public Account(long ID, AccountStatus accountStatus) {
        this.id = ID;
        this.accountStatus = accountStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return id == account.id &&
                accountStatus == account.accountStatus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountStatus);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
