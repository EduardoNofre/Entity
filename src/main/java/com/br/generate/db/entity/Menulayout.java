package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menulayout database table.
 * 
 */
@Entity
@Table(name="menulayout")
@NamedQuery(name="Menulayout.findAll", query="SELECT m FROM Menulayout m")
public class Menulayout implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idmenuLayout;
	private String descmenuLayout;
	private String menuLayout;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Menulayout() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdmenuLayout() {
		return this.idmenuLayout;
	}

	public void setIdmenuLayout(int idmenuLayout) {
		this.idmenuLayout = idmenuLayout;
	}


	@Column(length=256)
	public String getDescmenuLayout() {
		return this.descmenuLayout;
	}

	public void setDescmenuLayout(String descmenuLayout) {
		this.descmenuLayout = descmenuLayout;
	}


	@Column(length=256)
	public String getMenuLayout() {
		return this.menuLayout;
	}

	public void setMenuLayout(String menuLayout) {
		this.menuLayout = menuLayout;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="menulayout")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setMenulayout(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setMenulayout(null);

		return personalizacaocliente;
	}

}