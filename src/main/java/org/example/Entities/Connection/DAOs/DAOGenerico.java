package org.example.Entities.Connection.DAOs;


import java.util.List;

public interface DAOGenerico<T> {
    //Metodo CRUD
    //Create
    void guardar(T entidad);

    //Read
    T buscarPorId(T entidad);

    List<T> buscarTodos();

    //Update
    void actualizar(T entidad);

    //Delete
    void eliminar(T entidad);
}
