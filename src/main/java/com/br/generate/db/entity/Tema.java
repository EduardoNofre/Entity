package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tema database table.
 * 
 */
@Entity
@Table(name="tema")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idtema;
	private String desctema;
	private String tema;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Tema() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdtema() {
		return this.idtema;
	}

	public void setIdtema(int idtema) {
		this.idtema = idtema;
	}


	@Column(length=256)
	public String getDesctema() {
		return this.desctema;
	}

	public void setDesctema(String desctema) {
		this.desctema = desctema;
	}


	@Column(length=256)
	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="tema")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setTema(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setTema(null);

		return personalizacaocliente;
	}

}