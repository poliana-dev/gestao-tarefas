package com.gestao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

// com ajuda do beans.xml, o named é facilmente encontrado pelo tomcat
@Named("tarefaBean")
@ViewScoped
public class TarefaBean implements Serializable {

    private Tarefa tarefa = new Tarefa(); // objeto do modelo

    /* EntityManagerFactory é uma classe que possui o EntityManager. Ela serve para criar as tabelas do banco que configurei em "persistence.xml"*/
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("db_tarefas");


    public Tarefa getTarefa() {
        return tarefa;
    }

    public List<Tarefa> getTarefas() {
        EntityManager consulta = emf.createEntityManager();
        try {
            // tenta fazer uma consulta das tarefas que estao em andamento, e as retorna
            return consulta.createQuery("SELECT t FROM Tarefa t WHERE t.situacao = :sit", Tarefa.class)
                    .setParameter("sit", Situacao.EM_ANDAMENTO)
                    .getResultList();
        } finally {
            consulta.close();
        }
    }

    public List<Tarefa> getConcluidas() {
        EntityManager consulta = emf.createEntityManager();
        try {
            return consulta.createQuery("SELECT t FROM Tarefa t WHERE t.situacao = :sit", Tarefa.class)
                    .setParameter("sit", Situacao.CONCLUIDA)
                    .getResultList();
        } finally {
            consulta.close();
        }
    }


    public String salvar() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); //operação de escrita no banco precisa estar dentro de uma transação.
        try {
            tx.begin();
            em.persist(tarefa);
            tx.commit(); // o texto é salvo no banco e a transação termina
        } finally {
            if (tx.isActive()) tx.rollback(); // se algo der errado a ação é revertida
            em.close();
        }
        return "listar.xhtml";

    }

    public String concluir(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Tarefa t = em.find(Tarefa.class, id);
            if (t != null) {
                t.setSituacao(Situacao.CONCLUIDA);
                em.merge(t);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Tarefa concluída com sucesso!", null));
            }
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
        return "listar.xhtml?faces-redirect=true";
    }


    public String remover(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Tarefa t = em.find(Tarefa.class, id);
            if (t != null) {
                em.remove(t);
            }
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
        return "listar.xhtml?faces-redirect=true";
    }



}
