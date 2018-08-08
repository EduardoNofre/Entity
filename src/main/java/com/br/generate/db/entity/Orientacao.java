package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orientacao database table.
 * 
 */
@Entity
@Table(name="orientacao")
@NamedQuery(name="Orientacao.findAll", query="SELECT o FROM Orientacao o")
public class Orientacao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idorientacao;
	private String descorientacao;
	private String orientacao;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Orientacao() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdorientacao() {
		return this.idorientacao;
	}

	public void setIdorientacao(int idorientacao) {
		this.idorientacao = idorientacao;
	}


	@Column(length=256)
	public String getDescorientacao() {
		return this.descorientacao;
	}

	public void setDescorientacao(String descorientacao) {
		this.descorientacao = descorientacao;
	}


	@Column(length=256)
	public String getOrientacao() {
		return this.orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="orientacao")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setOrientacao(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setOrientacao(null);

		return personalizacaocliente;
	}

}