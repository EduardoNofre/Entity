package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private Object ativo;
	private Date dataExclusao;
	private Date dataInclusao;
	private Date dataUltimologin;
	private String emailUsuario;
	private String empresaFilial;
	private Object logado;
	private String loginUsuario;
	private String nomeUsuario;
	private String senhaUsuario;
	private String telefoneUsuario;
	private List<Perfil> perfils;
	private List<Perfilacesso> perfilacessos;
	private List<Personalizacaocliente> personalizacaoclientes;
	private Empresafilial empresafilial;

	public Usuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Object getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Object ativo) {
		this.ativo = ativo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataExclusao() {
		return this.dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataUltimologin() {
		return this.dataUltimologin;
	}

	public void setDataUltimologin(Date dataUltimologin) {
		this.dataUltimologin = dataUltimologin;
	}


	@Column(length=250)
	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}


	@Column(length=250)
	public String getEmpresaFilial() {
		return this.empresaFilial;
	}

	public void setEmpresaFilial(String empresaFilial) {
		this.empresaFilial = empresaFilial;
	}


	public Object getLogado() {
		return this.logado;
	}

	public void setLogado(Object logado) {
		this.logado = logado;
	}


	@Column(length=250)
	public String getLoginUsuario() {
		return this.loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}


	@Column(length=250)
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	@Column(length=250)
	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}


	@Column(length=250)
	public String getTelefoneUsuario() {
		return this.telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}


	//bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy="usuario")
	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setUsuario(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setUsuario(null);

		return perfil;
	}


	//bi-directional many-to-one association to Perfilacesso
	@OneToMany(mappedBy="usuario")
	public List<Perfilacesso> getPerfilacessos() {
		return this.perfilacessos;
	}

	public void setPerfilacessos(List<Perfilacesso> perfilacessos) {
		this.perfilacessos = perfilacessos;
	}

	public Perfilacesso addPerfilacesso(Perfilacesso perfilacesso) {
		getPerfilacessos().add(perfilacesso);
		perfilacesso.setUsuario(this);

		return perfilacesso;
	}

	public Perfilacesso removePerfilacesso(Perfilacesso perfilacesso) {
		getPerfilacessos().remove(perfilacesso);
		perfilacesso.setUsuario(null);

		return perfilacesso;
	}


	//bi-directional many-to-one association to Personalizacaocliente
	@OneToMany(mappedBy="usuario")
	public List<Personalizacaocliente> getPersonalizacaoclientes() {
		return this.personalizacaoclientes;
	}

	public void setPersonalizacaoclientes(List<Personalizacaocliente> personalizacaoclientes) {
		this.personalizacaoclientes = personalizacaoclientes;
	}

	public Personalizacaocliente addPersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().add(personalizacaocliente);
		personalizacaocliente.setUsuario(this);

		return personalizacaocliente;
	}

	public Personalizacaocliente removePersonalizacaocliente(Personalizacaocliente personalizacaocliente) {
		getPersonalizacaoclientes().remove(personalizacaocliente);
		personalizacaocliente.setUsuario(null);

		return personalizacaocliente;
	}


	//bi-directional many-to-one association to Empresafilial
	@ManyToOne
	@JoinColumn(name="idEmpresaFilial")
	public Empresafilial getEmpresafilial() {
		return this.empresafilial;
	}

	public void setEmpresafilial(Empresafilial empresafilial) {
		this.empresafilial = empresafilial;
	}

}