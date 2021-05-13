package org.cfuentes.scrumapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MIEMBRO")
public class Miembro implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4952392472341890932L;

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

    @Column
    private String rol;
    
    @ManyToMany(mappedBy = "developers")
	private List<Proyecto> proyectosAsDev;
    
    @OneToMany(mappedBy = "productOwner")
    private List<Proyecto> proyectosAsPO;
    
    @OneToMany(mappedBy = "scrumMaster")
    private List<Proyecto> proyectosAsSM;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "developer")
    @JsonManagedReference
    //@Fetch(FetchMode.SUBSELECT)
    private List<Tarea> tareas = new ArrayList<Tarea>();

    @Transient
    List<GrantedAuthority> roles;

    public Miembro() {
    }

    public Miembro(String email, String password, List<GrantedAuthority> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idMiembro == null) ? 0 : idMiembro.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Miembro other = (Miembro) obj;
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
		if (idMiembro == null) {
			if (other.idMiembro != null)
				return false;
		} else if (!idMiembro.equals(other.idMiembro))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Miembro [idMiembro=" + idMiembro + ", email=" + email + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + "]";
	}

	public Long getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Long idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }

	public List<Proyecto> getProyectosAsDev() {
		return proyectosAsDev;
	}

	public void setProyectosAsDev(List<Proyecto> proyectosAsDev) {
		this.proyectosAsDev = proyectosAsDev;
	}

	public List<Proyecto> getProyectosAsPO() {
		return proyectosAsPO;
	}

	public void setProyectosAsPO(List<Proyecto> proyectosAsPO) {
		this.proyectosAsPO = proyectosAsPO;
	}

	public List<Proyecto> getProyectosAsSM() {
		return proyectosAsSM;
	}

	public void setProyectosAsSM(List<Proyecto> proyectosAsSM) {
		this.proyectosAsSM = proyectosAsSM;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}


}
