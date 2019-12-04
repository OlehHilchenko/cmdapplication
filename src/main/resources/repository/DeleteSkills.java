package main.resources.repository;

import java.util.ArrayList;

public class DeleteSkills extends UpdateSkills implements StoragePath {

    public boolean deleteSkills(Long ID){
        ArrayList<String> content = read(SKILLS);

        if (!checkID("" + ID, content))
            return false;

        content = delete(ID, content);

        writeSkills(content, "", "");
        return true;
    }
}
