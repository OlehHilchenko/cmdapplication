package main.java.repository.io;

public class NewLongID {

    public NewLongID (){
        id = 0l;
    }

    private static Long id;

    public Long newLongID() {
        if (id == 0) {
            JavaIODeveloperRepositoryImpl javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();
            id = JavaIODeveloperRepositoryImpl.nextLongId(javaIODeveloperRepository.list());
        }
        if (id > 0)
            id++;

        return id;
    }
}
