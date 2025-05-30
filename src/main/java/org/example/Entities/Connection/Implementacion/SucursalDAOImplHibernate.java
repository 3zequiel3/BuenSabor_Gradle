package org.example.Entities.Connection.Implementacion;

import jakarta.persistence.EntityManager;
import org.example.Entities.Connection.ConexionJPA;
import org.example.Entities.Connection.DAOs.SucursalDAO;
import org.example.Entities.Geography.Sucursal;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public abstract class SucursalDAOImplHibernate implements SucursalDAO {
    private EntityManager em = ConexionJPA.getEmf();

    @Override
    public Sucursal buscarSucursalPorNombre(String nombre) {
        return null;
    }

    @Override
    public void guardar(Sucursal entidad) {

    }

    @Override
    public Sucursal buscarPorId(Sucursal entidad) {
        return null;
    }

    @Override
    public List<Sucursal> buscarTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Sucursal entidad) {

    }

    @Override
    public void eliminar(Sucursal entidad) {

    }
}
