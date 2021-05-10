package org.cfuentes.scrumapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.service.api.HistoriaUsuarioService;
import org.cfuentes.scrumapp.service.api.SprintService;
import org.primefaces.PrimeFaces;
import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("boardController")
@ViewScoped
public class BoardController {

	Miembro miembroAuth;
	Proyecto proyecto;
	List<HistoriaUsuario> historiasUsuarioNuevas;
	List<HistoriaUsuario> historiasUsuarioAprobadas;
	List<HistoriaUsuario> historiasUsuarioEntregadas;
	List<HistoriaUsuario> historiasUsuarioCompletadas;
	Sprint sprintActual;
	HistoriaUsuario historiaSelec;
	
	
	@Autowired
	HistoriaUsuarioService historiaUsuarioService;
	
	@Autowired
	GlobalController globalController;
	
	@Autowired
	SprintService sprintService;
	
	
	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyecto = (Proyecto) globalController.getEntidad();
		sprintActual = sprintService.findLastByProyecto(proyecto.getIdProyecto());
			historiasUsuarioNuevas = historiaUsuarioService.findByProyectoAndEstado(proyecto.getIdProyecto(), "new");
			historiasUsuarioAprobadas = historiaUsuarioService.findByProyectoAndEstado(proyecto.getIdProyecto(), "approved");
			historiasUsuarioEntregadas = historiaUsuarioService.findByProyectoAndEstado(proyecto.getIdProyecto(), "commited");
			historiasUsuarioCompletadas = historiaUsuarioService.findByProyectoAndEstado(proyecto.getIdProyecto(), "completed");
			historiaSelec = new HistoriaUsuario();
			
	}
	
	public void historiaToNew(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();
		if (historia.getEstado().equals("approved")) {
			historia.setEstado("new");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioNuevas.add(historia);
			historiasUsuarioAprobadas.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}		
	}
	
	public void historiaToApproved(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();
		if (historia.getEstado().equals("new")) {
			historia.setEstado("approved");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioAprobadas.add(historia);
			historiasUsuarioNuevas.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}		
	}
	
	public void historiaToCommited(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();
		if (historia.getEstado().equals("approved")) {
			historia.setEstado("commited");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioEntregadas.add(historia);
			historiasUsuarioAprobadas.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}		
	}
	
	public void historiaToCompleted(DragDropEvent<HistoriaUsuario> ddEvent) {
		HistoriaUsuario historia = ddEvent.getData();
		if (historia.getEstado().equals("commited")) {
			historia.setEstado("completed");
			historiaUsuarioService.saveOrUpdate(historia);
			historiasUsuarioCompletadas.add(historia);
			historiasUsuarioEntregadas.remove(historia);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No permitido", "Ese movimiento no está permitido"));
		}		
	}

	public void guardarHistoria() {
		Boolean nueva = false;
		HistoriaUsuario old = new HistoriaUsuario();
		if (historiaSelec.getProyecto()==null) {
			nueva = true;
			historiaSelec.setProyecto(proyecto);
			historiaSelec.setPrioridad(historiaUsuarioService.siguientePrioridad(proyecto.getIdProyecto()) + 1);
		}
		
		
		
		if (!nueva) { 
			
			old = historiaUsuarioService.findById(historiaSelec.getIdHistoriaUsuario());
			//si ha cambiado el estado se elimina de la lista anterior y se añade a la actual
			if (!historiaSelec.getEstado().equals(old.getEstado())) {
				if (historiasUsuarioNuevas.contains(historiaSelec)) {
					historiasUsuarioNuevas.remove(historiaSelec);
				}
				else if (historiasUsuarioAprobadas.contains(historiaSelec)) {
					historiasUsuarioAprobadas.remove(historiaSelec);
				}
				else if (historiasUsuarioEntregadas.contains(historiaSelec)) {
					historiasUsuarioEntregadas.remove(historiaSelec);
				}
				else if (historiasUsuarioCompletadas.contains(historiaSelec)) {
					historiasUsuarioCompletadas.remove(historiaSelec);
				}
				
				//se inserta en la lista del estado correspondiente
				if (historiaSelec.getEstado().equals("new")) {
					 historiasUsuarioNuevas.add(historiaSelec);
				 }
				 else if (historiaSelec.getEstado().equals("approved")) {
					 historiasUsuarioAprobadas.add(historiaSelec);
				 }
				 else if (historiaSelec.getEstado().equals("commited")) {
					 historiasUsuarioEntregadas.add(historiaSelec);
				 }
				 else if (historiaSelec.getEstado().equals("completed")) {
					 historiasUsuarioCompletadas.add(historiaSelec);
				 }
			}
		}
		
		historiaSelec = historiaUsuarioService.saveOrUpdate(historiaSelec);
		proyecto.getHistorias().add(historiaSelec);
		
		if (nueva) { 
			if (historiaSelec.getEstado().equals("new")) {
				 historiasUsuarioNuevas.add(historiaSelec);
			 }
			 else if (historiaSelec.getEstado().equals("approved")) {
				 historiasUsuarioAprobadas.add(historiaSelec);
			 }
			 else if (historiaSelec.getEstado().equals("commited")) {
				 historiasUsuarioEntregadas.add(historiaSelec);
			 }
			 else if (historiaSelec.getEstado().equals("completed")) {
				 historiasUsuarioCompletadas.add(historiaSelec);
			 }	
		}
		
		
	}
	
	public void nuevaHistoria() {
		historiaSelec = new HistoriaUsuario();
		Integer n = proyecto.getHistorias().size()+1;
		historiaSelec.setCodigo(new String(proyecto.getCodigo()+"-"+ n));
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

	public List<HistoriaUsuario> getHistoriasUsuarioNuevas() {
		return historiasUsuarioNuevas;
	}

	public void setHistoriasUsuarioNuevas(List<HistoriaUsuario> historiasUsuarioNuevas) {
		this.historiasUsuarioNuevas = historiasUsuarioNuevas;
	}

	public List<HistoriaUsuario> getHistoriasUsuarioAprobadas() {
		return historiasUsuarioAprobadas;
	}

	public void setHistoriasUsuarioAprobadas(List<HistoriaUsuario> historiasUsuarioAprobadas) {
		this.historiasUsuarioAprobadas = historiasUsuarioAprobadas;
	}

	public List<HistoriaUsuario> getHistoriasUsuarioEntregadas() {
		return historiasUsuarioEntregadas;
	}

	public void setHistoriasUsuarioEntregadas(List<HistoriaUsuario> historiasUsuarioEntregadas) {
		this.historiasUsuarioEntregadas = historiasUsuarioEntregadas;
	}

	public List<HistoriaUsuario> getHistoriasUsuarioCompletadas() {
		return historiasUsuarioCompletadas;
	}

	public void setHistoriasUsuarioCompletadas(List<HistoriaUsuario> historiasUsuarioCompletadas) {
		this.historiasUsuarioCompletadas = historiasUsuarioCompletadas;
	}

	public Sprint getSprintActual() {
		return sprintActual;
	}

	public void setSprintActual(Sprint sprintActual) {
		this.sprintActual = sprintActual;
	}

	public HistoriaUsuario getHistoriaSelec() {
		return historiaSelec;
	}

	public void setHistoriaSelec(HistoriaUsuario historiaSelec) {
		this.historiaSelec = historiaSelec;
	}
	
}
