package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TAREA")
public class Tarea {

	@Id
	@Column(name = "ID_TAREA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTarea;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private Integer estimacion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_ESTIMADA_FIN")
	private Date fechaEstimadaFin;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "HORAS_DEDICADAS")
	private Integer horasDedicadas;
	
	@Column
	private String observaciones;
	
	@Column
	private String problemas;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO_TAREA", nullable = false)
	@JsonBackReference
	private EstadoTarea estadoTarea;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DEVELOPER", nullable = false)
	@JsonBackReference
	private Miembro developer;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_HISTORIA_USUARIO", nullable = false)
	@JsonBackReference
	private HistoriaUsuario historiaUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SPRINT", nullable = false)
	@JsonBackReference
	private Sprint sprint;

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
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

	public Integer getEstimacion() {
		return estimacion;
	}

	public void setEstimacion(Integer estimacion) {
		this.estimacion = estimacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaEstimadaFin() {
		return fechaEstimadaFin;
	}

	public void setFechaEstimadaFin(Date fechaEstimadaFin) {
		this.fechaEstimadaFin = fechaEstimadaFin;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getHorasDedicadas() {
		return horasDedicadas;
	}

	public void setHorasDedicadas(Integer horasDedicadas) {
		this.horasDedicadas = horasDedicadas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getProblemas() {
		return problemas;
	}

	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}

	public Miembro getDeveloper() {
		return developer;
	}

	public void setDeveloper(Miembro developer) {
		this.developer = developer;
	}

	public HistoriaUsuario getHistoriaUsuario() {
		return historiaUsuario;
	}

	public void setHistoriaUsuario(HistoriaUsuario historiaUsuario) {
		this.historiaUsuario = historiaUsuario;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public EstadoTarea getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(EstadoTarea estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	
	
}
