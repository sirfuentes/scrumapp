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

    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((esfuerzo == null) ? 0 : esfuerzo.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((idHistoriaUsuario == null) ? 0 : idHistoriaUsuario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((prioridad == null) ? 0 : prioridad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoriaUsuario other = (HistoriaUsuario) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (esfuerzo == null) {
			if (other.esfuerzo != null)
				return false;
		} else if (!esfuerzo.equals(other.esfuerzo))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idHistoriaUsuario == null) {
			if (other.idHistoriaUsuario != null)
				return false;
		} else if (!idHistoriaUsuario.equals(other.idHistoriaUsuario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (prioridad == null) {
			if (other.prioridad != null)
				return false;
		} else if (!prioridad.equals(other.prioridad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoriaUsuario [idHistoriaUsuario=" + idHistoriaUsuario + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", esfuerzo=" + esfuerzo + ", estado=" + estado + ", prioridad=" + prioridad + "]";
	}

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
