package org.cfuentes.scrumapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SCRUM_MASTER")
@PrimaryKeyJoinColumn(name = "ID_SCRUM_MASTER")
public class ScrumMaster extends Miembro {

	
}
