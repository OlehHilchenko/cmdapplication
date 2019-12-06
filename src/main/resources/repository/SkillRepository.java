package main.resources.repository;

import main.resources.model.Skill;

import java.util.List;

public interface SkillRepository {

    void addSkill (Skill skill);

    void updateSkill (Skill skill);

    void removeSkill (long id);

    Skill getSkillById (long id);

    List<Skill> listSkill();

}
