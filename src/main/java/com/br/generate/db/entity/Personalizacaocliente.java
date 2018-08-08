package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personalizacaocliente database table.
 * 
 */
@Entity
@Table(name="personalizacaocliente")
@NamedQuery(name="Personalizacaocliente.findAll", query="SELECT p FROM Personalizacaocliente p")
public class Personalizacaocliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idpersonalizacaoCliente;
	private Colorlayout colorlayout;
	private Colormenu colormenu;
	private Compacto compacto;
	private Menulayout menulayout;
	private Orientacao orientacao;
	private Profile profile;
	private Tema tema;
	private Usuario usuario;

	public Personalizacaocliente() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdpersonalizacaoCliente() {
		return this.idpersonalizacaoCliente;
	}

	public void setIdpersonalizacaoCliente(int idpersonalizacaoCliente) {
		this.idpersonalizacaoCliente = idpersonalizacaoCliente;
	}


	//bi-directional many-to-one association to Colorlayout
	@ManyToOne
	@JoinColumn(name="idcolorLayout")
	public Colorlayout getColorlayout() {
		return this.colorlayout;
	}

	public void setColorlayout(Colorlayout colorlayout) {
		this.colorlayout = colorlayout;
	}


	//bi-directional many-to-one association to Colormenu
	@ManyToOne
	@JoinColumn(name="idcolorMenu")
	public Colormenu getColormenu() {
		return this.colormenu;
	}

	public void setColormenu(Colormenu colormenu) {
		this.colormenu = colormenu;
	}


	//bi-directional many-to-one association to Compacto
	@ManyToOne
	@JoinColumn(name="idcompacto")
	public Compacto getCompacto() {
		return this.compacto;
	}

	public void setCompacto(Compacto compacto) {
		this.compacto = compacto;
	}


	//bi-directional many-to-one association to Menulayout
	@ManyToOne
	@JoinColumn(name="idmenuLayout")
	public Menulayout getMenulayout() {
		return this.menulayout;
	}

	public void setMenulayout(Menulayout menulayout) {
		this.menulayout = menulayout;
	}


	//bi-directional many-to-one association to Orientacao
	@ManyToOne
	@JoinColumn(name="idorientacao")
	public Orientacao getOrientacao() {
		return this.orientacao;
	}

	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}


	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="idprofile")
	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="idtema")
	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}