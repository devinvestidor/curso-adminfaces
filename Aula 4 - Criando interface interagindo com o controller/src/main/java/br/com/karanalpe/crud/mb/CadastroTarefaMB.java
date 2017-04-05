package br.com.karanalpe.crud.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.crud.model.Tarefa;
import br.com.karanalpe.crud.service.TarefaService;

@Named
@ViewScoped
public class CadastroTarefaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tarefa tarefa = new Tarefa();
	
	private Long idTarefa;
	
	@Inject
	private TarefaService tarefaService;
	
	
	public void inicializar() {
		if (idTarefa != null) {
			tarefa = tarefaService.porId(idTarefa);
		}
	}
	
	
	public String salvar() {
		tarefaService.salvar(tarefa);
		return "lista-tarefa.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		tarefaService.excluir(tarefa);
		return "lista-tarefa.xhtml?faces-redirect=true";
	}


	public Tarefa getTarefa() {
		return tarefa;
	}


	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}


	public Long getIdTarefa() {
		return idTarefa;
	}


	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}

}
