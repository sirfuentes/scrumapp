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
}
