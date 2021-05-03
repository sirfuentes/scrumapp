package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HISTORIA_USUARIO")
public class HistoriaUsuario {

    @Id
    @Column(name = "ID_HISTORIA_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriaUsuario;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Integer esfuerzo;

    @Column
    private String estado;

    @Column
    private Integer prioridad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
    @JsonBackReference
    private Proyecto proyecto;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "historiaUsuario")
    @JsonManagedReference
    @Fetch(FetchMode.SUBSELECT)
    private List<Tarea> tareas = new ArrayList<Tarea>();

	public Long getIdHistoriaUsuario() {
		return idHistoriaUsuario;
	}

	public void setIdHistoriaUsuario(Long idHistoriaUsuario) {
		this.idHistoriaUsuario = idHistoriaUsuario;
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

	public Integer getEsfuerzo() {
		return esfuerzo;
	}

	public void setEsfuerzo(Integer esfuerzo) {
		this.esfuerzo = esfuerzo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
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
