package br.com.home.jsf.domain;

import br.com.home.jsf.infra.JPAUtil;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class AutomovelBean {

  private Automovel automovel = new Automovel();
  private List<Automovel> automoveis;

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public void salva(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(automovel);
        entityManager.getTransaction().commit();
    }

    public List<Automovel> getAutomoveis(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query q = entityManager.createQuery("select a from Automovel a", Automovel.class);
        this.automoveis = converteParaListaAutomoveis(q.getResultList());
        return this.automoveis;
    }

    private List<Automovel> converteParaListaAutomoveis(List resultList) {
        List<Automovel> autos = new ArrayList<>();
        for (Object auto : resultList){
            autos.add((Automovel) auto);
        }
        return autos;
    }
}
