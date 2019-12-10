package main.resources.model;

import java.util.Objects;

public class Developer {

    long ID;
    String developerName;

    Developer(){};

    public Developer(long ID, String developerName) {
        this.ID = ID;
        this.developerName = developerName;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return ID == developer.ID &&
                Objects.equals(developerName, developer.developerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, developerName);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "ID=" + ID +
                ", developerName='" + developerName + '\'' +
                '}';
    }
}
