package org.cfuentes.scrumapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "OWNER")
public class ProductOwner {
	
	@Id
	@Column(name = "ID_OWNER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProductOwner;
	
	@Column
	private String email;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String telefono;
}
