package br.com.karanalpe.crud.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.crud.model.Tarefa;
import br.com.karanalpe.crud.service.TarefaService;
import br.com.karanalpe.crud.util.FacesUtil;

@Named
@ViewScoped
public class ListaTarefaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaService tarefaService;
	
	private List<Tarefa> tarefas = new ArrayList<>();
	
	private List<Tarefa> tarefaSelecionadas = new ArrayList<>();
	
	
	@PostConstruct
	public void inicializar() {
		tarefas = tarefaService.listAll();
	}
	
	public void excluirSelecionados() {
		for (Tarefa tarefa : tarefaSelecionadas) {
			tarefaService.excluir(tarefa);
			tarefas.remove(tarefa);
		}
		
		FacesUtil.addInfoMessage("Tarefa(s) excluída(s) com sucesso!");
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefaSelecionadas() {
		return tarefaSelecionadas;
	}

	public void setTarefaSelecionadas(List<Tarefa> tarefaSelecionadas) {
		this.tarefaSelecionadas = tarefaSelecionadas;
	}	

}
