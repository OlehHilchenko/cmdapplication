package main.java.com.OlehHilchenko.OGCRUDApplication.Entities;

import java.util.LinkedHashSet;

public class SkillSet {

    public LinkedHashSet<String> skillsValues = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "SkillSet{" +
                "skillsValues=" + skillsValues +
                '}';
    }
}
