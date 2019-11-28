package main.java.com.OlehHilchenko.OGCRUDApplication.Action;

import main.java.com.OlehHilchenko.OGCRUDApplication.Entities.Developer;

import java.util.HashMap;
import java.util.Random;

public class RandomID {

    public Long randomID(HashMap<Long, Developer> dev) {
        Random rnd = new Random();
        long id = (long) rnd.nextLong();

        while ((dev.keySet().contains(id)))
            id = (long) rnd.nextLong();
        return id;

    }
}
