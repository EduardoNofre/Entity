package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idprofile;
	private String descprofile;
	private String profile;
	private List<Personalizacaocliente> personalizacaoclientes;

	public Profile() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdprofile() {
		return this.idprofile;
	}

	public void setIdprofile(int idprofile) {
		this.idprofile = idprofile;
	}


	@Column(length=256)
	public String getDescprofile() {
		return this.descprofile;
	}

	public void setDescprofile(String descprofile) {
		this.descprofile = descprofile;
	}


	@Column(length=256)
	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="profile")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setProfile(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setProfile(null);

		return personalizacaocliente;
	}

}