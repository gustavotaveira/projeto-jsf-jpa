package br.com.home.jsf.domain;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutomovelBean {

  private Automovel automovel = new Automovel();

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public void salva(){
        System.out.println("Salvando automovel: "+automovel);
    }
}
