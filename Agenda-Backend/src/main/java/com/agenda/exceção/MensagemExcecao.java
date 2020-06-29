package com.agenda.exceção;

public class MensagemExcecao {

	private String mensUsuarioFinal;
	private String mensDesenvolvedor;

	public MensagemExcecao(String mensUsuarioFinal, String mensDesenvolvedor) {

		this.mensUsuarioFinal = mensUsuarioFinal;
		this.mensDesenvolvedor = mensDesenvolvedor;
	}

	public String getMensUsuarioFinal() {
		return mensUsuarioFinal;
	}

	public String getMensDesenvolvedor() {
		return mensDesenvolvedor;
	}
}
