package br.edu.ifpb.domain;

import br.edu.ifpb.aop.LogDeEntidades;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/08/2019, 07:31:51
 */
@Entity
@EntityListeners(LogDeEntidades.class)
public class Aluno implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

//    @PrePersist
//    public void antesDeSalvar() {
//        System.out.println("executando método antes de salvar!!!");
//    }
//
//    @PostPersist
//    public void aposSerSalvar() {
//        System.out.println("executando método depois de salvar!!!");
//    }
//
//    @PostLoad
//    public void aposSerCarregado() {
//        System.out.println("executando método depois de ser carregado!!! " + this.nome);
//    }
    public Aluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
