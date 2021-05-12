package org.cfuentes.scrumapp.controller;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.cfuentes.scrumapp.service.api.ProyectoService;
import org.cfuentes.scrumapp.service.api.SprintService;
import org.cfuentes.scrumapp.service.api.TareaService;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("sprintController")
@ViewScoped
public class SprintController {

	Miembro miembroAuth;
	Proyecto proyecto;
	Sprint sprintActual;
	Sprint sprintSelec;
	List<Tarea> tareasToDo;
	List<Tarea> tareasInProgress;
	List<Tarea> tareasTesting;
	List<Tarea> tareasCompletadas;
	List<Miembro> developers;
	List<HistoriaUsuario> historias;
	List<Sprint> sprints;
	Tarea tareaSelec;
	String estadoSprint;
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	TareaService tareaService;
	
	@Autowired
	EstadoTareaService estadoTareaService;
	
	@Autowired
	SprintService sprintService;
	
	@Autowired
	GlobalController globalController;
	
	@Autowired
	MiembroService miembroService;

	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyecto = proyectoService.findById(((Proyecto)globalController.getEntidad()).getIdProyecto());
//		sprintActual = sprintService.findLastByProyecto(proyecto.getIdProyecto());
		sprintActual = sprintService.findActualByProyecto(proyecto.getIdProyecto());
		tareasToDo = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "todo");
		tareasInProgress = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "doing");
		tareasTesting = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "testing");
		tareasCompletadas = tareaService.findBySprintAndEstado(sprintActual.getIdSprint(), "completed");
		tareaSelec = new Tarea();
		developers = proyecto.getDevelopers();
		historias = proyecto.getHistorias();
		sprints = sprintService.findByProyecto(proyecto.getIdProyecto());
		sprintSelec = sprintActual;
		for (Sprint s : sprints) {
			insertarEstadoSprint(s);
		}
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
	
	public void cambiarSprint() {
		
		tareasToDo = tareaService.findBySprintAndEstado(sprintSelec.getIdSprint(), "todo");
		tareasInProgress = tareaService.findBySprintAndEstado(sprintSelec.getIdSprint(), "doing");
		tareasTesting = tareaService.findBySprintAndEstado(sprintSelec.getIdSprint(), "testing");
		tareasCompletadas = tareaService.findBySprintAndEstado(sprintSelec.getIdSprint(), "completed");
		
		//insertarEstadoSprint(sprintSelec);
	}
	
	public void insertarEstadoSprint(Sprint s) {
		if (s.getFechaInicio().before(new Date()) && 
				s.getFechaFin().after(new Date())) {
			s.setEstado("Actual");		
		}
		else if (s.getFechaInicio().after(new Date())) {
			s.setEstado("Futuro");
		}
		else if (s.getFechaFin().before(new Date())) {
			s.setEstado("Pasado");
		}
	}
	
	public void nuevoSprint() {
		Sprint nuevo = new Sprint();
		nuevo.setNombre(new String("Sprint " + (sprints.size() + 1)));
		nuevo.setProyecto(proyecto);
		nuevo.setEstado("future");
		
		Calendar fecIni = Calendar.getInstance();
		fecIni.setTime(sprints.get(sprints.size()-1).getFechaFin());
		fecIni.add(Calendar.DAY_OF_YEAR, 1);
		nuevo.setFechaInicio(fecIni.getTime());
		fecIni.add(Calendar.DAY_OF_YEAR, 30);
		nuevo.setFechaFin(fecIni.getTime());
		//nuevo.setFechaFin(nuevo.getFechaInicio().after());
		nuevo = sprintService.saveOrUpdate(nuevo);
		insertarEstadoSprint(nuevo);
		sprints.add(nuevo);
	}
	
	 public void actualizarSprint(RowEditEvent<Sprint> event) {
		 sprintSelec = event.getObject();
		 sprintSelec = sprintService.saveOrUpdate(sprintSelec);
	 }
	
	public void nuevaTarea() {
		tareaSelec = new Tarea();
		
	}
	
	public void guardarTarea() {
		Boolean nueva = false;
		Tarea old;
		if (tareaSelec.getSprint()==null) {
			tareaSelec.setSprint(sprintSelec);
			tareaSelec.setEstadoTarea(estadoTareaService.findEstadoTareaByCodigo("todo"));
			nueva = true;
		}
		
		if (!nueva) {
			old = tareaService.findById(tareaSelec.getIdTarea());
			
			if (!tareaSelec.getEstadoTarea().equals(tareaSelec.getEstadoTarea())) {
				if (tareasToDo.contains(tareaSelec)) {
					tareasToDo.remove(tareaSelec);
				}
				else if (tareasInProgress.contains(tareaSelec)) {
					tareasInProgress.remove(tareaSelec);
				}
				else if (tareasTesting.contains(tareaSelec)) {
					tareasTesting.remove(tareaSelec);
				}
				else if (tareasCompletadas.contains(tareaSelec)) {
					tareasCompletadas.remove(tareaSelec);
				}
				
				insertarTareaPorEstado();
				
			}
		}
		
		tareaSelec = tareaService.saveOrUpdate(tareaSelec);
		
		if (nueva) {			
			insertarTareaPorEstado();
		}
	}
	
	public void insertarTareaPorEstado() {
		if (tareaSelec.getEstadoTarea().getCodigo().equals("todo")) {
			tareasToDo.add(tareaSelec);
		}
		else if (tareaSelec.getEstadoTarea().getCodigo().equals("doing")) {
			tareasInProgress.add(tareaSelec);
		}
		else if (tareaSelec.getEstadoTarea().getCodigo().equals("testing")) {
			tareasTesting.add(tareaSelec);
		}
		else if (tareaSelec.getEstadoTarea().getCodigo().equals("completed")) {
			tareasCompletadas.add(tareaSelec);
		}
	}
	
	public void vacio() {
		
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

	public List<Miembro> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Miembro> developers) {
		this.developers = developers;
	}

	public List<HistoriaUsuario> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaUsuario> historias) {
		this.historias = historias;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public Sprint getSprintSelec() {
		return sprintSelec;
	}

	public void setSprintSelec(Sprint sprintSelec) {
		this.sprintSelec = sprintSelec;
	}

	public String getEstadoSprint() {
		return estadoSprint;
	}

	public void setEstadoSprint(String estadoSprint) {
		this.estadoSprint = estadoSprint;
	}
	
	

}
