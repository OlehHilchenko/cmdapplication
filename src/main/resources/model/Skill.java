package main.resources.model;

import java.io.Serializable;
import java.util.Objects;

public class Skill implements Serializable {


    private Long ID;
    private String name;

    private static final long serialVersionUID = 1l;
    public Skill() {
    }

    public Skill(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(ID, skill.ID) &&
                Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, name);
    }
}
