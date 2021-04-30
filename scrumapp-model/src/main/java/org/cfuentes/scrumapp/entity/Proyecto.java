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

@Entity
@Table(name = "PROYECTO")
public class Proyecto implements Serializable {

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
    @JoinColumn(name = "ID_OWNER", nullable = false)
	@JsonBackReference
	private Miembro productOwner;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SCRUMMASTER", nullable = false)
	@JsonBackReference
	private Miembro scrumMaster;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<Sprint> sprints = new ArrayList<Sprint>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<HistoriaUsuario> miembros = new ArrayList<HistoriaUsuario>();

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

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public List<HistoriaUsuario> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<HistoriaUsuario> miembros) {
		this.miembros = miembros;
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
	
	
}
