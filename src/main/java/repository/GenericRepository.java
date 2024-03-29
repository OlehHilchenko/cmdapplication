package main.java.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    void add (T t);

    void update (T t);

    void remove (ID id);

    T getById (ID id);

    List<T> list();

}
