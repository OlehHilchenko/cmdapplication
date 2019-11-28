package main.java.com.OlehHilchenko.OGCRUDApplication.Entities;

import java.util.LinkedHashSet;

public class Developer {

    public long ID;
    public String firstName;
    public String lastName;
    public SkillSet skillSet = new SkillSet();
    public AccountStatusC accountStatusC = new AccountStatusC();

    public Developer(long ID, String firstName, String lastName, LinkedHashSet<String> skillSet, String accountStat) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillSet.skills = skillSet;
        this.accountStatusC.accountStatus = accountStat;
    }

    public Developer(long ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skillSet=" + skillSet.toString() +
                ", accountStatusC=" + accountStatusC.toString() +
                '}';
    }
}
