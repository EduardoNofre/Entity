package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPerfil;
	private Object ativo;
	private Date dataAlteracao;
	private Date dataExclusao;
	private Date dataInclusao;
	private String nomePerfil;
	private String usuarioAlteracao;
	private String usuarioInclusao;
	private Usuario usuario;
	private List<Perfilacesso> perfilacessos;

	public Perfil() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}


	public Object getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Object ativo) {
		this.ativo = ativo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
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


	@Column(length=250)
	public String getNomePerfil() {
		return this.nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}


	@Column(length=250)
	public String getUsuarioAlteracao() {
		return this.usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


	@Column(length=250)
	public String getUsuarioInclusao() {
		return this.usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to Perfilacesso
	@OneToMany(mappedBy="perfil")
	public List<Perfilacesso> getPerfilacessos() {
		return this.perfilacessos;
	}

	public void setPerfilacessos(List<Perfilacesso> perfilacessos) {
		this.perfilacessos = perfilacessos;
	}

	public Perfilacesso addPerfilacesso(Perfilacesso perfilacesso) {
		getPerfilacessos().add(perfilacesso);
		perfilacesso.setPerfil(this);

		return perfilacesso;
	}

	public Perfilacesso removePerfilacesso(Perfilacesso perfilacesso) {
		getPerfilacessos().remove(perfilacesso);
		perfilacesso.setPerfil(null);

		return perfilacesso;
	}

}