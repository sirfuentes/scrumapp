package org.cfuentes.scrumapp.controller;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.cfuentes.scrumapp.service.api.ProyectoService;
import org.cfuentes.scrumapp.service.api.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("proyectoController")
@ViewScoped
public class ProyectoController {

	List<Proyecto> proyectos;
	List<Proyecto> proyectosSeleccionados;
	List<Miembro> productOwnerDisponibles;
	List<Miembro> scrumMasterDisponibles;
	List<Miembro> developersDisponibles;
	Proyecto proyectoSelec;
	Miembro miembroAuth;
	Boolean editando;
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	MiembroService miembroService;
	
	@Autowired
	SprintService sprintService;
	
	@Autowired
	GlobalController globalController;
	
	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyectos = proyectoService.findAll();
		productOwnerDisponibles = miembroService.findAll();
		scrumMasterDisponibles = miembroService.findAll();
		developersDisponibles = miembroService.findAll();
		
	}

	public void guardarProyecto() {
//		boolean editando = false;
//		
//		if (proyectoSelec.getIdProyecto() != null) {
//			editando = true;
//		}
		
		if (!editando) {
			if (proyectoService.existsByCodigo(proyectoSelec.getCodigo())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Código repetido", "Ya existe un proyecto con ese código."));
				return;
			}
		}
		
		proyectoSelec = proyectoService.saveOrUpdate(proyectoSelec);
		proyectos = proyectoService.findAll();
		
		if (!editando) {
			Sprint nuevo = new Sprint();
			nuevo.setNombre("Sprint 1");
			nuevo.setEstado("current");
			nuevo.setProyecto(proyectoSelec);
			Calendar fecIni = Calendar.getInstance();
			nuevo.setFechaInicio(fecIni.getTime());
			fecIni.add(Calendar.DAY_OF_YEAR, 30);
			nuevo.setFechaFin(fecIni.getTime());
			nuevo = sprintService.saveOrUpdate(nuevo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Proyecto creado", proyectoSelec.getCodigo() + " se ha creado correctamente."));
		}
		if (editando) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Proyecto editado", proyectoSelec.getCodigo() + " se ha editado correctamente."));
		}
	}

	public void eliminarProyecto() {
		proyectoService.delete(proyectoSelec);
		proyectos = proyectoService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Proyecto eliminado", proyectoSelec.getCodigo() + " se ha borrado correctamente."));
	}

	public void nuevoProyecto() {
		proyectoSelec = new Proyecto();
		proyectoSelec.setProductOwner(miembroAuth);
	}
	
	public String goToProyecto(Long id) {
		globalController.setEntidad(proyectoService.findById(id));
		return "gotobacklog";
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public List<Proyecto> getProyectosSeleccionados() {
		return proyectosSeleccionados;
	}

	public void setProyectosSeleccionados(List<Proyecto> proyectosSeleccionados) {
		this.proyectosSeleccionados = proyectosSeleccionados;
	}

	public Proyecto getProyectoSelec() {
		return proyectoSelec;
	}

	public void setProyectoSelec(Proyecto proyectoSelec) {
		this.proyectoSelec = proyectoSelec;
	}


	public Miembro getMiembroAuth() {
		return miembroAuth;
	}

	public void setMiembroAuth(Miembro miembroAuth) {
		this.miembroAuth = miembroAuth;
	}

	public List<Miembro> getProductOwnerDisponibles() {
		return productOwnerDisponibles;
	}

	public void setProductOwnerDisponibles(List<Miembro> productOwnerDisponibles) {
		this.productOwnerDisponibles = productOwnerDisponibles;
	}

	public List<Miembro> getScrumMasterDisponibles() {
		return scrumMasterDisponibles;
	}

	public void setScrumMasterDisponibles(List<Miembro> scrumMasterDisponibles) {
		this.scrumMasterDisponibles = scrumMasterDisponibles;
	}

	public List<Miembro> getDevelopersDisponibles() {
		return developersDisponibles;
	}

	public void setDevelopersDisponibles(List<Miembro> developersDisponibles) {
		this.developersDisponibles = developersDisponibles;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	
	
}
