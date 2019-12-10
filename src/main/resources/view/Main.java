package main.resources.view;

import main.resources.model.Skill;
import main.resources.repository.*;

public class Main {


    public static void main(String[] args) {
        Skill skill = new Skill(2233l, "Jora");
        SkillRepository skillRepository = new SkillRepositoryImpl();

        //skillRepository.addSkill(new Skill(727483327371672773l, "Evgen"));

        //System.out.println(skillRepository.getSkillById(222333444555l).toString());

        /*
        System.out.println(skillRepository.getSkillById(-8972800732400858902l).toString());
        skillRepository.updateSkill(new Skill(-8972800732400858902l, "Petro"));
        System.out.println();
        System.out.println(skillRepository.getSkillById(-8972800732400858902l).toString());
        */

        /*
        System.out.println(skillRepository.getSkillById(222333444666l).toString());
        skillRepository.removeSkill(222333444666l);
        System.out.println(skillRepository.getSkillById(222333444666l).toString());
        */
        //((SkillRepositoryImpl) skillRepository).WriteObjectToFile("D:\\OG_CRUD\\src\\main\\resources\\files\\developer.txt", skill);

        Object obg = ((SkillRepositoryImpl) skillRepository).ReadObjectFromFile("D:\\OG_CRUD\\src\\main\\resources\\files\\developer.txt");
        System.out.println(obg.toString());
    }
}
