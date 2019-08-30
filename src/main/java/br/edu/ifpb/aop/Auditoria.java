package br.edu.ifpb.aop;

import java.util.ArrayList;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/08/2019, 08:24:27
 */
public class Auditoria {

//    @anotacao
//    public Object <nome> () throws Exception;
    @AroundInvoke
    public Object interceptodor(InvocationContext context) throws Exception {
        System.out.println("------externo---");
        long inicio = System.currentTimeMillis();
        String nome = context.getMethod().getName();
        Object proceed = context.proceed(); // retorno ao método salvar
        long fim = System.currentTimeMillis();
        System.out.println("externo - " + nome + " demorou: " + (fim - inicio) + "ms");
        return proceed;
//        return new ArrayList();
        // cliente -> servidor
        //  doFilter()
        // servidor -> cliente    

    }
}
