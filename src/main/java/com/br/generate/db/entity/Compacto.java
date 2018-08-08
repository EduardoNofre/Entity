package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compacto database table.
 * 
 */
@Entity
@Table(name="compacto")
@NamedQuery(name="Compacto.findAll", query="SELECT c FROM Compacto c")
public class Compacto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idcompacto;
	private String compacto;
	private String desccompacto;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Compacto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdcompacto() {
		return this.idcompacto;
	}

	public void setIdcompacto(int idcompacto) {
		this.idcompacto = idcompacto;
	}


	@Column(length=256)
	public String getCompacto() {
		return this.compacto;
	}

	public void setCompacto(String compacto) {
		this.compacto = compacto;
	}


	@Column(length=256)
	public String getDesccompacto() {
		return this.desccompacto;
	}

	public void setDesccompacto(String desccompacto) {
		this.desccompacto = desccompacto;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="compacto")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setCompacto(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setCompacto(null);

		return personalizacaocliente;
	}

}