package org.cfuentes.scrumapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
	}
	
	@PreDestroy
	public void guardarPrioridades() {
		for (HistoriaUsuario h : historias) {
			historiaUsuarioService.saveOrUpdate(h);
		}	
	}
	
	public void guardarHistoria() {
		if (historiaSelec.getProyecto() == null) {
			historiaSelec.setProyecto(proyecto);
			historiaSelec.setPrioridad(historiaUsuarioService.siguientePrioridad(proyecto.getIdProyecto()) + 1);
			//historiaSelec.setPrioridad(Integer.valueOf(1));
		}
		historiaUsuarioService.saveOrUpdate(historiaSelec);
		historias.add(historiaSelec);
	}
	
	public void nuevaHistoria() {
		historiaSelec = new HistoriaUsuario();
	}
	
	public void onRowReorder(ReorderEvent event) {
		int i = 1;
		for (HistoriaUsuario h : historias) {
			h.setPrioridad(i);
			i++;
		}		
	}
	
	public void eliminarHistoria() {
		historias.remove(historiaSelec);
		historiaUsuarioService.delete(historiaSelec);
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
