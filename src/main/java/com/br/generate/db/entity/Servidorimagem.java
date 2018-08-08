package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servidorimagem database table.
 * 
 */
@Entity
@Table(name="servidorimagem")
@NamedQuery(name="Servidorimagem.findAll", query="SELECT s FROM Servidorimagem s")
public class Servidorimagem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idServicor;
	private String descServidor;
	private String ipServidor;
	private String nomeServidor;
	private String tipoServidor;

	public Servidorimagem() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdServicor() {
		return this.idServicor;
	}

	public void setIdServicor(int idServicor) {
		this.idServicor = idServicor;
	}


	@Column(length=256)
	public String getDescServidor() {
		return this.descServidor;
	}

	public void setDescServidor(String descServidor) {
		this.descServidor = descServidor;
	}


	@Column(length=256)
	public String getIpServidor() {
		return this.ipServidor;
	}

	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}


	@Column(length=256)
	public String getNomeServidor() {
		return this.nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}


	@Column(length=256)
	public String getTipoServidor() {
		return this.tipoServidor;
	}

	public void setTipoServidor(String tipoServidor) {
		this.tipoServidor = tipoServidor;
	}

}