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
	private Long estimacion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_ESTIMADA_FIN")
	private Date fechaEstimadaFin;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "HORAS_DEDICADAS")
	private Long horasDedicadas;
	
	@Column
	private String observaciones;
	
	@Column
	private String problemas;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEstadoTarea", nullable = false)
	@JsonBackReference
	private EstadoTarea estadoTarea;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMiembro", nullable = false)
	@JsonBackReference
	private Miembro miembro;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idHistoriaUsuario", nullable = false)
	@JsonBackReference
	private HistoriaUsuario historiaUsuario;
}
