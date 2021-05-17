package org.cfuentes.scrumapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "ESTADO_TAREA")
public class EstadoTarea {

    @Id
    @Column(name = "ID_ESTADO_TAREA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoTarea;

    @Column
    private String nombre;
    
    @Column
    private String codigo;
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((idEstadoTarea == null) ? 0 : idEstadoTarea.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		EstadoTarea other = (EstadoTarea) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (idEstadoTarea == null) {
			if (other.idEstadoTarea != null)
				return false;
		} else if (!idEstadoTarea.equals(other.idEstadoTarea))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Long getIdEstadoTarea() {
		return idEstadoTarea;
	}

	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
    
    
}
