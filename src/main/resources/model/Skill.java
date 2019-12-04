package main.resources.model;

public class Skill {


    private Long ID;
    private String name;

    public Skill() {
    }

    public Skill(Long ID, String name) {
        this.ID = ID;
        this.name = name;
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
}
