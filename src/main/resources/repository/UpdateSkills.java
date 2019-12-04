package main.resources.repository;

import java.util.ArrayList;

public class UpdateSkills extends ViewSkills implements StoragePath {

    public ArrayList<String> delete(Long ID, ArrayList<String> con) {
        for (int i = 0; i < con.size(); i++) {
            String checkedID = "";
            for (int j = 0; j < con.get(i).length(); j++) {
                if (con.get(i).charAt(j) != ':')
                    checkedID += con.get(i).charAt(j);
                else if (con.get(i).charAt(j) == ':') {
                    if (("" + ID).equals(checkedID)) {
                        con.remove(i);
                        break;
                    } else break;
                }
            }
        }
        return con;
    }

    public boolean updateSkills(Long ID, String newName) {
        ArrayList<String> content = read(SKILLS);

        if (!checkID("" + ID, content))
            return false;

        content = delete(ID, content);


        writeSkills(content, "" + ID, newName);
        return true;
    }
}
