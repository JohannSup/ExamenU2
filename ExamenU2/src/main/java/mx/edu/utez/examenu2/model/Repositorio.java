package mx.edu.utez.examenu2.model;

import mx.edu.utez.examenu2.utils.Response;

import java.util.List;

public interface Repositorio<T> {

    List<T> findAll();
    Response<T> findById(long id);
    Response<T> save(T object);
    Response<T> update(T Object);
    Response<T> delete(long id);


}
