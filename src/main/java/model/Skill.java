package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class Skill implements Serializable {


    private Long id;
    private String name;

    private static final long serialVersionUID = 1l;
    public Skill() {
    }

    public Skill(Long ID, String skillName) {
        this.id = ID;
        this.name = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id) &&
                Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
