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
	private String esfuerzo;
	
	@Column
	private String estado;
	
	@Column
	private String prioridad;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProyecto", nullable = false)
	@JsonBackReference
	private Proyecto proyecto;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSprint", nullable = false)
	@JsonBackReference
	private Sprint sprint;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "historiaUsuario")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<Tarea> miembros = new ArrayList<Tarea>();
}
