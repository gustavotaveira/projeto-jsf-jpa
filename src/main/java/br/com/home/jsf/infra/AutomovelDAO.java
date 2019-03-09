package br.com.home.jsf.infra;

import br.com.home.jsf.domain.Automovel;

import javax.persistence.EntityManager;
import java.util.List;

public class AutomovelDAO {

    private EntityManager entityManager;


    public AutomovelDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salve(Automovel automovel){
        entityManager.getTransaction().begin();
        entityManager.persist(automovel);
        entityManager.getTransaction().commit();
    }

    public void remova(Automovel automovel){
        entityManager.getTransaction().begin();
        entityManager.remove(automovel);
        entityManager.getTransaction().commit();
    }

    public List listeTodos(){
        return entityManager.createQuery("select a from Automovel a").getResultList();
    }
}
