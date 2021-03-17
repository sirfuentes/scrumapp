package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MIEMBRO")
public class Miembro {
	
	@Id
	@Column(name = "ID_MIEMBRO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMiembro;
	
	@Column
	private String email;
	
	@JsonIgnore
	@Column
	private String password;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String telefono;
	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEquipo", nullable = false)
	@JsonBackReference
	private Equipo equipo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "miembro")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<Tarea> miembros = new ArrayList<Tarea>();
}
