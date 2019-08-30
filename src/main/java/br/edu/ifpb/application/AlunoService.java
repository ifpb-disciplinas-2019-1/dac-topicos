package br.edu.ifpb.application;

import br.edu.ifpb.aop.Auditoria;
import br.edu.ifpb.domain.Aluno;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/08/2019, 07:36:13
 */
@Stateless
@Interceptors(Auditoria.class)
public class AlunoService {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Aluno aluno) {
        em.persist(aluno);
    }

//    @Interceptors(Auditoria.class)
    public List<Aluno> todosOsAlunos() {
        return em.createQuery("FROM Aluno a",Aluno.class)
            .getResultList();
    }

    @AroundInvoke
    public Object interceptodorInterno(InvocationContext context) throws Exception {
        System.out.println("------interno---");
        long inicio = System.currentTimeMillis();
        String nome = context.getMethod().getName();
        Object proceed = context.proceed();
        long fim = System.currentTimeMillis();
        System.out.println("interno - " + nome + " demorou: " + (fim - inicio) + "ms");
        return proceed;
    }

}
