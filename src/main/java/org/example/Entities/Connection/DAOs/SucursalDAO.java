package org.example.Entities.Connection.DAOs;

import org.example.Entities.Geography.Sucursal;

public interface SucursalDAO  extends DAOGenerico<Sucursal>{
    Sucursal buscarSucursalPorNombre(String nombre);
}
