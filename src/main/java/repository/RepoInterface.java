package repository;

import domain.IdIs;

import java.util.Collection;

public interface RepoInterface<T extends IdIs> {

    void add(T entity);

    Collection<T> getAll();

}
