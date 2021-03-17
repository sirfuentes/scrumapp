package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EQUIPO")
public class Equipo {

	@Id
	@Column(name = "ID_EQUIPO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipo;
	
	@Column
	private String nombre;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Column
	private String especialidad;
	
	@Column
	private String observaciones;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipo")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<Miembro> miembros = new ArrayList<Miembro>();
}
