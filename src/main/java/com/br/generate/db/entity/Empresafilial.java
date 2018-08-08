package com.br.generate.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the empresafilial database table.
 * 
 */
@Entity
@Table(name="empresafilial")
@NamedQuery(name="Empresafilial.findAll", query="SELECT e FROM Empresafilial e")
public class Empresafilial implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEmpresaFilial;
	private Object ativo;
	private Date dataAlteracao;
	private Date dataExclusao;
	private Date dataInclusao;
	private String nomeEmpresaFilial;
	private String usuarioAlteracao;
	private String usuarioInclusao;
	private List<Usuario> usuarios;

	public Empresafilial() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdEmpresaFilial() {
		return this.idEmpresaFilial;
	}

	public void setIdEmpresaFilial(int idEmpresaFilial) {
		this.idEmpresaFilial = idEmpresaFilial;
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
	public String getNomeEmpresaFilial() {
		return this.nomeEmpresaFilial;
	}

	public void setNomeEmpresaFilial(String nomeEmpresaFilial) {
		this.nomeEmpresaFilial = nomeEmpresaFilial;
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
	@OneToMany(mappedBy="empresafilial")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEmpresafilial(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEmpresafilial(null);

		return usuario;
	}

}