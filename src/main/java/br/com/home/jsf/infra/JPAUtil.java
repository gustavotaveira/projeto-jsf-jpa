package br.com.home.jsf.infra;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManager entityManager = Persistence
            .createEntityManagerFactory("default")
            .createEntityManager();
    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
