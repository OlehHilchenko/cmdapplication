package main.java.com.OlehHilchenko.OGCRUDApplication.Action;

public interface MainMenu {

    String viewByID(int ID);

    String viewAll();

    boolean delete(int ID);

    boolean create();

    boolean update(int ID);

}
