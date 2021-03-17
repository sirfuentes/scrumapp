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
@Table(name = "PROYECTO")
public class Proyecto {

	@Id
	@Column(name = "ID_PROYECTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyecto;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProductOwner", nullable = false)
	@JsonBackReference
	private ProductOwner productOwner;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<Sprint> sprints = new ArrayList<Sprint>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<HistoriaUsuario> miembros = new ArrayList<HistoriaUsuario>();
}
