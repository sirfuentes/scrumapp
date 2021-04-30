package org.cfuentes.scrumapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.service.api.HistoriaUsuarioService;
import org.cfuentes.scrumapp.service.api.SprintService;
import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sprintController")
@ViewScoped
public class SprintController {

	List<HistoriaUsuario> historiasUsuarioToDo;
	List<HistoriaUsuario> historiasUsuarioDoing;
	List<HistoriaUsuario> historiasUsuarioCompleted;
	List<HistoriaUsuario> historiasUsuarioTesting;
	HistoriaUsuario historiaSelec;
	Sprint sprintActual;
	@Autowired
	HistoriaUsuarioService historiaUsuarioService;
	
	@Autowired
	SprintService sprintService;

	@PostConstruct
	public void init() {
		sprintActual = sprintService.findById(new Long(1));
		historiasUsuarioToDo = historiaUsuarioService.findBySprintAndEstado(sprintActual.getIdSprint(), "todo");
		historiasUsuarioDoing = historiaUsuarioService.findBySprintAndEstado(sprintActual.getIdSprint(), "doing");
		historiasUsuarioCompleted = historiaUsuarioService.findBySprintAndEstado(sprintActual.getIdSprint(), "completed");
		historiasUsuarioTesting = historiaUsuarioService.findBySprintAndEstado(sprintActual.getIdSprint(), "testing");
	}
	
	public void historiaToDo(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();
		if (historia.getEstado().equals("doing")) {
			historia.setEstado("todo");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioToDo.add(historia);
			historiasUsuarioDoing.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}		
	}

	public void historiaToDoing(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();

		if (historia.getEstado().equals("todo")) {
			historia.setEstado("doing");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioDoing.add(historia);
			historiasUsuarioToDo.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}
		
	}
	
	public void historiaToTesting(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();

		if (historia.getEstado().equals("doing")) {
			historia.setEstado("testing");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioTesting.add(historia);
			historiasUsuarioDoing.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}
	}
	
	public void historiaToCompleted(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();
		
		if (historia.getEstado().equals("testing")) {
			historia.setEstado("completed");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioCompleted.add(historia);
			historiasUsuarioTesting.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}
	}

	public List<HistoriaUsuario> getHistoriasUsuarioToDo() {
		return historiasUsuarioToDo;
	}

	public void setHistoriasUsuarioToDo(List<HistoriaUsuario> historiasUsuarioToDo) {
		this.historiasUsuarioToDo = historiasUsuarioToDo;
	}

	public List<HistoriaUsuario> getHistoriasUsuarioDoing() {
		return historiasUsuarioDoing;
	}

	public void setHistoriasUsuarioDoing(List<HistoriaUsuario> historiasUsuarioDoing) {
		this.historiasUsuarioDoing = historiasUsuarioDoing;
	}

	public List<HistoriaUsuario> getHistoriasUsuarioCompleted() {
		return historiasUsuarioCompleted;
	}

	public void setHistoriasUsuarioCompleted(List<HistoriaUsuario> historiasUsuarioCompleted) {
		this.historiasUsuarioCompleted = historiasUsuarioCompleted;
	}

	public List<HistoriaUsuario> getHistoriasUsuarioTesting() {
		return historiasUsuarioTesting;
	}

	public void setHistoriasUsuarioTesting(List<HistoriaUsuario> historiasUsuarioTesting) {
		this.historiasUsuarioTesting = historiasUsuarioTesting;
	}

	public HistoriaUsuario getHistoriaSelec() {
		return historiaSelec;
	}

	public void setHistoriaSelec(HistoriaUsuario historiaSelec) {
		this.historiaSelec = historiaSelec;
	}

}
