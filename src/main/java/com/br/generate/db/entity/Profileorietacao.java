package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profileorietacao database table.
 * 
 */
@Entity
@Table(name="profileorietacao")
@NamedQuery(name="Profileorietacao.findAll", query="SELECT p FROM Profileorietacao p")
public class Profileorietacao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idprofileOrietacao;
	private String descprofileOrietacao;
	private String profileOrietacao;

	public Profileorietacao() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdprofileOrietacao() {
		return this.idprofileOrietacao;
	}

	public void setIdprofileOrietacao(int idprofileOrietacao) {
		this.idprofileOrietacao = idprofileOrietacao;
	}


	@Column(length=256)
	public String getDescprofileOrietacao() {
		return this.descprofileOrietacao;
	}

	public void setDescprofileOrietacao(String descprofileOrietacao) {
		this.descprofileOrietacao = descprofileOrietacao;
	}


	@Column(length=256)
	public String getProfileOrietacao() {
		return this.profileOrietacao;
	}

	public void setProfileOrietacao(String profileOrietacao) {
		this.profileOrietacao = profileOrietacao;
	}

}