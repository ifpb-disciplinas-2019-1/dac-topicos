package br.edu.ifpb.aop;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/08/2019, 08:08:38
 */
public class LogDeEntidades {

    
//    @anotacao
//    public void <> (Object object){}
    
    @PrePersist
    public void antesDeSalvar(Object object) {
        System.out.println(
            "externo - executando método antes de salvar!!!"
            + object.toString()
        );
    }

    @PostPersist
    public void aposSerSalvar(Object object) {
        System.out.println("externo - executando método depois de salvar!!!");
    }

    @PostLoad
    public void aposSerCarregado(Object object) {
        System.out.println("externo - executando método depois de ser carregado!!! ");
    }
}
