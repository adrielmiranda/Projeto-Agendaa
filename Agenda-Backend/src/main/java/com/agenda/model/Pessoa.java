package com.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pessoa_id")
	private long pessoa_id;
	
	@NotNull
	@Column(name = "pessoa_nome")
	private String pessoa_nome;

	@NotNull
	@Pattern(regexp = "(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})")
	@Column(name = "pessoa_cpf_cnpj")
	private String pessoa_cpfcnpj;

	@Pattern(regexp = "(\\(\\d{2}\\)\\s)(\\d{4,5}\\-\\d{4})")
	@Column(name = "pessoa_telefone")
	private String pessoa_telefone;

	@NotNull
	@Pattern(regexp = "^\\w*(\\.\\w*)?@\\w*\\.[a-z]+(\\.[a-z]+)?$")
	@Column(name = "pessoa_email")
	private String pessoa_email;

	@Column(name = "pessoa_funcao")
	private String pessoa_funcao;

	@NotNull
	@Size(min = 6, max = 20)
	@Column(name = "pessoa_login")
	private String pessoa_login;

	@NotNull
	@Size(min = 6, max = 15)
	@Pattern(regexp = "^([a-zA-Z0-9@*#]{6,15})$")
	@Column(name = "pessoa_senha")
	private String pessoa_senha;

	@NotNull
	@Pattern(regexp = "Interno|Externo")
	@Column(name = "pessoa_perfil")
	private String pessoa_perfil;

	public long getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	public String getPessoa_nome() {
		return pessoa_nome;
	}

	public void setPessoa_nome(String pessoa_nome) {
		this.pessoa_nome = pessoa_nome;
	}

	public String getPessoa_cpfcnpj() {
		return pessoa_cpfcnpj;
	}

	public void setPessoa_cpfCnpj(String pessoa_cpfCnpj) {
		this.pessoa_cpfcnpj = pessoa_cpfCnpj;
	}

	public String getPessoa_telefone() {
		return pessoa_telefone;
	}

	public void setPessoa_telefone(String pessoa_telefone) {
		this.pessoa_telefone = pessoa_telefone;
	}

	public String getPessoa_email() {
		return pessoa_email;
	}

	public void setPessoa_email(String pessoa_email) {
		this.pessoa_email = pessoa_email;
	}

	public String getPessoa_funcao() {
		return pessoa_funcao;
	}

	public void setPessoa_funcao(String pessoa_funcao) {
		this.pessoa_funcao = pessoa_funcao;
	}

	public String getPessoa_login() {
		return pessoa_login;
	}

	public void setPessoa_login(String pessoa_login) {
		this.pessoa_login = pessoa_login;
	}

	public String getPessoa_senha() {
		return pessoa_senha;
	}

	public void setPessoa_senha(String pessoa_senha) {
		this.pessoa_senha = pessoa_senha;
	}

	public String getPessoa_perfil() {
		return pessoa_perfil;
	}

	public void setPessoa_perfil(String pessoa_perfil) {
		this.pessoa_perfil = pessoa_perfil;
	}

}
