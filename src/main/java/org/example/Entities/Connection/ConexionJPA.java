package org.example.Entities.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class ConexionJPA {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuenSabor");
    public static EntityManager getEmf(){ return emf.createEntityManager();}
};

