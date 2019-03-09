package br.com.home.jsf.teste;

import br.com.home.jsf.domain.Automovel;
import br.com.home.jsf.infra.AutomovelDAO;
import br.com.home.jsf.infra.JPAUtil;

import java.util.List;

public class Teste {
    public static void main(String[] args){
        System.out.println("Criando automovel");
        Automovel automovel = new Automovel();
        automovel.setModelo("Fiat");
        automovel.setMarca("Mobi Like");
        automovel.setObservacoes("Nunca foi batido");
        automovel.setQuilometragem(0);

        System.out.println("Salvando automovel");
        AutomovelDAO dao = new AutomovelDAO(JPAUtil.getEntityManager());
        dao.salve(automovel);
        System.out.println("Automovel salvo!");

        System.out.println("Listando automoveis salvos");
        List automoveis = dao.listeTodos();
        for (Object automovelAtual : automoveis){
            System.out.println(automovelAtual);
        }
        System.out.println("Finalizando");
    }
}
