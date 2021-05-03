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
@Table(name = "PRODUCT_OWNER")
@PrimaryKeyJoinColumn(name = "ID_PRODUCT_OWNER")
public class ProductOwner extends Miembro {


}
