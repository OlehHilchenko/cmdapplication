package main.java.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Developer implements Serializable {

    private Long id;
    private String name;
    private Account account;
    private Set<Skill> skills;


    private static final long serialVersionUID = 1l;

    public Developer(){};

    public Developer(long ID, String developerName, Account account, Set<Skill> skill) {
        this.id = ID;
        this.name = developerName;
        this.account = account;
        this.skills = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id &&
                Objects.equals(name, developer.name) &&
                Objects.equals(account, developer.account) &&
                Objects.equals(skills, developer.skills);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, account, skills);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", skills=" + skills +
                '}';
    }
}
