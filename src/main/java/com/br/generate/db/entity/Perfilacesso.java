package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the perfilacesso database table.
 * 
 */
@Entity
@Table(name="perfilacesso")
@NamedQuery(name="Perfilacesso.findAll", query="SELECT p FROM Perfilacesso p")
public class Perfilacesso implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPerfilAcesso;
	private Object acesso;
	private Object ativo;
	private Date dataAlteracao;
	private Date dataExclusao;
	private Date dataInclusao;
	private String nomeAcesso;
	private Perfil perfil;
	private Usuario usuario;

	public Perfilacesso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdPerfilAcesso() {
		return this.idPerfilAcesso;
	}

	public void setIdPerfilAcesso(int idPerfilAcesso) {
		this.idPerfilAcesso = idPerfilAcesso;
	}


	public Object getAcesso() {
		return this.acesso;
	}

	public void setAcesso(Object acesso) {
		this.acesso = acesso;
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
	public String getNomeAcesso() {
		return this.nomeAcesso;
	}

	public void setNomeAcesso(String nomeAcesso) {
		this.nomeAcesso = nomeAcesso;
	}


	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="idPerfil")
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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

}