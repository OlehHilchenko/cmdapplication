package main.resources.repository;

import java.util.ArrayList;

public class ViewSkills extends NewSkills implements StoragePath {

    String returnStringById(String ID, ArrayList<String> content) {
        boolean exists = false;
        for (String s : content) {
            String checkedID = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ':')
                    checkedID += s.charAt(i);
                else if (s.charAt(i) == ':') {
                    if (ID.equals(checkedID))
                        return s;
                    else
                        break;
                }
            }
        }
        return "this string no exist";
    }

    String[] split(String con) {
        String result[] = new String[2];
        result[0] = result[1] = "";
        if (con.equals("this string no exist")) {
            return result;
        }
        int counter = 0;
        for (int i = 0; i < con.length(); i++) {
            if (con.charAt(i) != ':')
                result[counter] += con.charAt(i);
            else if (con.charAt(i) == ':')
                counter++;
        }
        return result;
    }

    public String[] viewSkill(Long ID) {
        return split(returnStringById("" + ID, read(SKILLS)));
    }
}
