package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PROYECTO")
public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PROYECTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyecto;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCT_OWNER", nullable = false)
	private Miembro productOwner;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SCRUM_MASTER", nullable = false)
	private Miembro scrumMaster;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.REMOVE)
	private List<Sprint> sprints = new ArrayList<Sprint>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.REMOVE)
	private List<HistoriaUsuario> historias = new ArrayList<HistoriaUsuario>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(
	  name = "PROYECTO_DEVELOPER", 
	  joinColumns = @JoinColumn(name = "ID_PROYECTO"), 
	  inverseJoinColumns = @JoinColumn(name = "ID_MIEMBRO"))
	private List<Miembro> developers;
	
	
	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Miembro getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(Miembro productOwner) {
		this.productOwner = productOwner;
	}

	public Miembro getScrumMaster() {
		return scrumMaster;
	}

	public void setScrumMaster(Miembro scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	public List<Miembro> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Miembro> developers) {
		this.developers = developers;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public List<HistoriaUsuario> getHistorias() {
		return historias;
	}

	public void setHistorias(List<HistoriaUsuario> historias) {
		this.historias = historias;
	}



	
	

}
