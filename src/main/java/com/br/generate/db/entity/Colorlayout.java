package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the colorlayout database table.
 * 
 */
@Entity
@Table(name="colorlayout")
@NamedQuery(name="Colorlayout.findAll", query="SELECT c FROM Colorlayout c")
public class Colorlayout implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idcolorLayout;
	private String colorLayout;
	private String desctema;
	private String valuecolorLayout;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Colorlayout() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdcolorLayout() {
		return this.idcolorLayout;
	}

	public void setIdcolorLayout(int idcolorLayout) {
		this.idcolorLayout = idcolorLayout;
	}


	@Column(length=256)
	public String getColorLayout() {
		return this.colorLayout;
	}

	public void setColorLayout(String colorLayout) {
		this.colorLayout = colorLayout;
	}


	@Column(length=256)
	public String getDesctema() {
		return this.desctema;
	}

	public void setDesctema(String desctema) {
		this.desctema = desctema;
	}


	@Column(length=256)
	public String getValuecolorLayout() {
		return this.valuecolorLayout;
	}

	public void setValuecolorLayout(String valuecolorLayout) {
		this.valuecolorLayout = valuecolorLayout;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="colorlayout")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setColorlayout(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setColorlayout(null);

		return personalizacaocliente;
	}

}