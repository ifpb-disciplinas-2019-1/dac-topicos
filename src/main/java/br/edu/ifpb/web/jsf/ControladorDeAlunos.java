package br.edu.ifpb.web.jsf;

import br.edu.ifpb.application.AlunoService;
import br.edu.ifpb.domain.Aluno;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/08/2019, 07:41:31
 */
@Named
@RequestScoped
public class ControladorDeAlunos {

    @Inject
    private AlunoService service;

    private Aluno aluno = new Aluno();
    private List<Aluno> lista;

    public String salvar() {
        this.service.salvar(aluno);
        this.aluno = new Aluno();
        return null;
    }

    @PostConstruct
    public void init() {
        this.lista = this.service.todosOsAlunos();
    }

    public List<Aluno> todosOsAlunos() {
        return lista;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
