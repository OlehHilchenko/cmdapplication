package main.java.com.OlehHilchenko.OGCRUDApplication.Entities;

import java.util.LinkedHashSet;

public class SkillSet {

    public LinkedHashSet<String> skills = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "SkillSet{" +
                "skills=" + skills +
                '}';
    }
}
