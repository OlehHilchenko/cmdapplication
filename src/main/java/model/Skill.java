package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class Skill implements Serializable {


    private Long ID;
    private String skillName;

    private static final long serialVersionUID = 1l;
    public Skill() {
    }

    public Skill(Long ID, String skillName) {
        this.ID = ID;
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "ID=" + ID +
                ", skillName='" + skillName + '\'' +
                '}';
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getID() {
        return ID;
    }

    public String getSkillName() {
        return skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(ID, skill.ID) &&
                Objects.equals(skillName, skill.skillName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, skillName);
    }
}
