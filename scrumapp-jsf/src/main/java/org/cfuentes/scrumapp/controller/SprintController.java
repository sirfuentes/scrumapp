package org.cfuentes.scrumapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.entity.Tarea;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.service.api.EstadoTareaService;
import org.cfuentes.scrumapp.service.api.HistoriaUsuarioService;
import org.cfuentes.scrumapp.service.api.SprintService;
import org.cfuentes.scrumapp.service.api.TareaService;
import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("sprintController")
@ViewScoped
public class SprintController {

	Miembro miembroAuth;
	Proyecto proyecto;
	Sprint sprintActual;
	List<Tarea> tareasToDo;
	List<Tarea> tareasInProgress;
	List<Tarea> tareasTesting;
	List<Tarea> tareasCompletadas;
	Tarea tareaSelec;
	
	@Autowired
	TareaService tareaService;
	
	@Autowired
	EstadoTareaService estadoTareaService;
	
	@Autowired
	SprintService sprintService;
	
	@Autowired
	GlobalController globalController;

	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyecto = (Proyecto) globalController.getEntidad();
		sprintActual = sprintService.findByProyecto(proyecto.getIdProyecto());
		tareasToDo = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "todo");
		tareasInProgress = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "doing");
		tareasTesting = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "testing");
		tareasCompletadas = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "completed");
		tareaSelec = new Tarea();
	}
	
	public void tareaToDo(DragDropEvent<Tarea> ddEvent) {
		Tarea tarea = ddEvent.getData();
		if (tarea.getEstadoTarea().getCodigo().equals("doing")) {
			tarea.setEstadoTarea(estadoTareaService.findEstadoTareaByCodigo("todo"));
			tareaService.saveOrUpdate(tarea);
			tareasToDo.add(tarea);
			tareasInProgress.remove(tarea);
		}
	}
	
	public void tareaToDoing(DragDropEvent<Tarea> ddEvent) {
		Tarea tarea = ddEvent.getData();
		if (tarea.getEstadoTarea().getCodigo().equals("todo")) {
			tarea.setEstadoTarea(estadoTareaService.findEstadoTareaByCodigo("doing"));
			tareaService.saveOrUpdate(tarea);
			tareasInProgress.add(tarea);
			tareasToDo.remove(tarea);
		}
	}
	
	public void tareaToTesting(DragDropEvent<Tarea> ddEvent) {
		Tarea tarea = ddEvent.getData();
		if (tarea.getEstadoTarea().getCodigo().equals("doing")) {
			tarea.setEstadoTarea(estadoTareaService.findEstadoTareaByCodigo("testing"));
			tareaService.saveOrUpdate(tarea);
			tareasTesting.add(tarea);
			tareasInProgress.remove(tarea);
		}
	}
	
	public void tareaToCompleted(DragDropEvent<Tarea> ddEvent) {
		Tarea tarea = ddEvent.getData();
		if (tarea.getEstadoTarea().getCodigo().equals("testing")) {
			tarea.setEstadoTarea(estadoTareaService.findEstadoTareaByCodigo("completed"));
			tareaService.saveOrUpdate(tarea);
			tareasCompletadas.add(tarea);
			tareasTesting.remove(tarea);
		}
	}
	
	public void guardarHistoria() {
		
	}

	public Miembro getMiembroAuth() {
		return miembroAuth;
	}

	public void setMiembroAuth(Miembro miembroAuth) {
		this.miembroAuth = miembroAuth;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Sprint getSprintActual() {
		return sprintActual;
	}

	public void setSprintActual(Sprint sprintActual) {
		this.sprintActual = sprintActual;
	}

	public List<Tarea> getTareasToDo() {
		return tareasToDo;
	}

	public void setTareasToDo(List<Tarea> tareasToDo) {
		this.tareasToDo = tareasToDo;
	}

	public List<Tarea> getTareasInProgress() {
		return tareasInProgress;
	}

	public void setTareasInProgress(List<Tarea> tareasInProgress) {
		this.tareasInProgress = tareasInProgress;
	}

	public List<Tarea> getTareasTesting() {
		return tareasTesting;
	}

	public void setTareasTesting(List<Tarea> tareasTesting) {
		this.tareasTesting = tareasTesting;
	}

	public List<Tarea> getTareasCompletadas() {
		return tareasCompletadas;
	}

	public void setTareasCompletadas(List<Tarea> tareasCompletadas) {
		this.tareasCompletadas = tareasCompletadas;
	}

	public Tarea getTareaSelec() {
		return tareaSelec;
	}

	public void setTareaSelec(Tarea tareaSelec) {
		this.tareaSelec = tareaSelec;
	}

	public TareaService getTareaService() {
		return tareaService;
	}

	public void setTareaService(TareaService tareaService) {
		this.tareaService = tareaService;
	}
	
	

}
