package main.java.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Developer implements Serializable {

    private Long ID;
    private String developerName;
    private Account account;
    private Set<Skill> skill;


    private static final long serialVersionUID = 1l;

    public Developer(){};

    public Developer(long ID, String developerName, Account account, Set<Skill> skill) {
        this.ID = ID;
        this.developerName = developerName;
        this.account = account;
        this.skill = skill;
    }

    public Long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Skill> getSkill() {
        return skill;
    }

    public void setSkill(Set<Skill> skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return ID == developer.ID &&
                Objects.equals(developerName, developer.developerName) &&
                Objects.equals(account, developer.account) &&
                Objects.equals(skill, developer.skill);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, developerName, account, skill);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "ID=" + ID +
                ", developerName='" + developerName + '\'' +
                ", account=" + account +
                ", skill=" + skill +
                '}';
    }
}
