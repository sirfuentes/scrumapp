package org.cfuentes.scrumapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.service.api.HistoriaUsuarioService;
import org.primefaces.event.ReorderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("backlogController")
@ViewScoped
public class BacklogController {

	List<HistoriaUsuario> historias;
	HistoriaUsuario historiaSelec;
	Miembro miembroAuth;
	Proyecto proyecto;
	Boolean editando;
	
	@Autowired
	GlobalController globalController;
	
	@Autowired
	HistoriaUsuarioService historiaUsuarioService;
	
	
	
	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyecto = (Proyecto) globalController.getEntidad();
		//historias = historiaUsuarioService.findByIdProyecto(proyecto.getIdProyecto());
		historias = historiaUsuarioService.findHistoriaByProyecto(proyecto.getIdProyecto());
		editando = false;
	}
	
	@PreDestroy
	public void guardarPrioridades() {
		if (editando) {
			for (HistoriaUsuario h : historias) {
				historiaUsuarioService.saveOrUpdate(h);
			}	
		}
	}
	
	public void guardarHistoria() {
		
		guardarPrioridades();
		
		//Si es una historia nueva
		if (historiaSelec.getProyecto() == null) {
			historiaSelec.setProyecto(proyecto);
			historiaSelec.setEstado("new");
			historiaSelec.setPrioridad(historiaUsuarioService.siguientePrioridad(proyecto.getIdProyecto()) + 1);
			historiaSelec = historiaUsuarioService.saveOrUpdate(historiaSelec);
			historias.add(historiaSelec);
		} 
		else {
			historiaSelec = historiaUsuarioService.saveOrUpdate(historiaSelec);
		}
		proyecto.getHistorias().add(historiaSelec);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Nueva historia de usuario creada", historiaSelec.getCodigo() + " se ha añadido correctamente."));
	}
	
	public void nuevaHistoria() {
		historiaSelec = new HistoriaUsuario();
		Integer n = proyecto.getHistorias().size()+1;
		historiaSelec.setCodigo(new String(proyecto.getCodigo()+"-"+ n));
	}
	
	public void onRowReorder(ReorderEvent event) {
		editando = true;
		int i = 1;
		for (HistoriaUsuario h : historias) {
			h.setPrioridad(i);
			i++;
		}		
	}
	
	public void eliminarHistoria() {
		historias.remove(historiaSelec);
		historiaUsuarioService.delete(historiaSelec);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Historia de usuario eliminada", historiaSelec.getCodigo() + " se ha borrado correctamente."));
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<HistoriaUsuario> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaUsuario> historias) {
		this.historias = historias;
	}

	public HistoriaUsuario getHistoriaSelec() {
		return historiaSelec;
	}

	public void setHistoriaSelec(HistoriaUsuario historiaSelec) {
		this.historiaSelec = historiaSelec;
	}

	public Miembro getMiembroAuth() {
		return miembroAuth;
	}

	public void setMiembroAuth(Miembro miembroAuth) {
		this.miembroAuth = miembroAuth;
	}
	
}
