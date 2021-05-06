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
