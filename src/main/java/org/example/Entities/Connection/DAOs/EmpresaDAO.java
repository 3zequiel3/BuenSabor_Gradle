package org.example.Entities.Connection.DAOs;

import org.example.Entities.Geography.Empresa;

import java.util.List;

public interface EmpresaDAO extends DAOGenerico<Empresa> {
    List<Empresa> buscarPorNombre(String nombre);
}
