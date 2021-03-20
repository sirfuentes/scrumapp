package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
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
	private List<HistoriaUsuario> miembros = new ArrayList<HistoriaUsuario>();
}
