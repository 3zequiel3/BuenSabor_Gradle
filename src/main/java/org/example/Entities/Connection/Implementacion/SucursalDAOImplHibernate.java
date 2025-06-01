package org.example.Entities.Connection.Implementacion;

import jakarta.persistence.EntityManager;
import org.example.Entities.Connection.ConexionJPA;
import org.example.Entities.Connection.DAOs.SucursalDAO;
import org.example.Entities.Geography.Sucursal;

import java.util.List;

public class SucursalDAOImplHibernate implements SucursalDAO {
    private EntityManager em = ConexionJPA.getEmf();

    @Override
    public Sucursal buscarSucursalPorNombre(String nombre) {
        Sucursal sucursal;
        try {
            em.getTransaction().begin();
            sucursal  = em.find(Sucursal.class,nombre);
            System.out.println("Se busco la sucursal con nombre: " + nombre + " con exito: " + sucursal);
            em.getTransaction().commit();
            if(sucursal != null){
                return sucursal;
            }else{
                System.out.println("No se encontro la sucursal con nombre: " + nombre);
            }
        } catch (RuntimeException e) {
            System.out.println("Se produjo un error al buscar la sucursal con nombre: " + nombre + " " + e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void guardar(Sucursal entidad) {
        try{
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println("Se produjo un error al guardar la sucursal: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Sucursal buscarPorId(Sucursal entidad) {
        Sucursal sucursal;
        try {
            sucursal = em.find(Sucursal.class,entidad.getId() );
            System.out.println("Se busco la sucursal con id: " + entidad.getId() + " con exito: " + sucursal);
            if(sucursal == null){
                System.out.println("No se encontro la sucursal con id: " + entidad.getId());
            }else{
                System.out.println("Se encontro la sucursal con id: " + entidad.getId());
            }
        } catch (RuntimeException e) {
            System.out.println("Se produjo un error al buscar la sucursal con id: " + entidad.getId() + " " + e.getMessage());
            throw new RuntimeException(e);
        }

        return sucursal;
    }

    @Override
    public List<Sucursal> buscarTodos() {
        List<Sucursal> sucursales;
        try {
            sucursales = em.createQuery("SELECT s FROM Sucursal s", Sucursal.class).getResultList();
            System.out.println("Se buscaron todas las sucursales con exito: " + sucursales.size() + " sucursales encontradas");
            if(sucursales.isEmpty()){
                System.out.println("No hay sucursales registradas");
            }else{
                sucursales.forEach(sucursal -> System.out.println("Sucursal encontrada: " + sucursal.getNombre()));
            }
        } catch (RuntimeException e) {
            System.out.println("Se produjo un error al buscar todas las sucursales: " + e.getMessage());
            throw new RuntimeException(e);

        }
        return sucursales;
    }

    @Override
    public void actualizar(Sucursal entidad) {
        try {
            em.getTransaction().begin();
            em.merge(entidad);
            em.getTransaction().commit();
            System.out.println("Se actualizo la sucursal con id: " + entidad.getId());
        } catch (RuntimeException e) {
            System.out.println("Se produjo un error al actualizar la sucursal: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Sucursal entidad) {
        try {
            em.getTransaction().begin();
            Sucursal sucursal = em.merge(entidad);
            em.remove(sucursal);
            em.getTransaction().commit();
            System.out.println("Se elimino la sucursal con id: " + entidad.getId());
        } catch (RuntimeException e) {
            System.out.println("Se produjo un error al eliminar la sucursal: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
