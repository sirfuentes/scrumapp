package org.cfuentes.scrumapp.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "OWNER")
public class ProductOwner implements Serializable {
	
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

	@Override
	public String toString() {
		return "ProductOwner [idProductOwner=" + idProductOwner + ", email=" + email + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idProductOwner == null) ? 0 : idProductOwner.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		ProductOwner other = (ProductOwner) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idProductOwner == null) {
			if (other.idProductOwner != null)
				return false;
		} else if (!idProductOwner.equals(other.idProductOwner))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}


	public Long getIdProductOwner() {
		return idProductOwner;
	}

	public void setIdProductOwner(Long idProductOwner) {
		this.idProductOwner = idProductOwner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
