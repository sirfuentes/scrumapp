package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SPRINT")
public class Sprint {

	@Id
	@Column(name = "ID_SPRINT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSprint;
	
	@Column
	private String nombre;
	
	@Column
	private String estado;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "HORAS_JORNADA")
	private Integer horasJornada;
	
	@Column(name = "HORAS_TOTALES")
	private Integer horasTotales;
	
	@Column
	private String version;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
	@JsonBackReference
	private Proyecto proyecto;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sprint")
    @JsonManagedReference
    @Fetch(FetchMode.SUBSELECT)
    private List<Tarea> tareas = new ArrayList<Tarea>();

	public Long getIdSprint() {
		return idSprint;
	}

	public void setIdSprint(Long idSprint) {
		this.idSprint = idSprint;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getHorasJornada() {
		return horasJornada;
	}

	public void setHorasJornada(Integer horasJornada) {
		this.horasJornada = horasJornada;
	}

	public Integer getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(Integer horasTotales) {
		this.horasTotales = horasTotales;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

}
