package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the colormenu database table.
 * 
 */
@Entity
@Table(name="colormenu")
@NamedQuery(name="Colormenu.findAll", query="SELECT c FROM Colormenu c")
public class Colormenu implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idcolorMenu;
	private String colorMenu;
	private String desccolorMenu;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Colormenu() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdcolorMenu() {
		return this.idcolorMenu;
	}

	public void setIdcolorMenu(int idcolorMenu) {
		this.idcolorMenu = idcolorMenu;
	}


	@Column(length=256)
	public String getColorMenu() {
		return this.colorMenu;
	}

	public void setColorMenu(String colorMenu) {
		this.colorMenu = colorMenu;
	}


	@Column(length=256)
	public String getDesccolorMenu() {
		return this.desccolorMenu;
	}

	public void setDesccolorMenu(String desccolorMenu) {
		this.desccolorMenu = desccolorMenu;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="colormenu")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setColormenu(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setColormenu(null);

		return personalizacaocliente;
	}

}