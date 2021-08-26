package com.github.cdominguess.testeambiente;

public class Saudacoes {
	private final Long id;
	private final String conteudo;

	public Saudacoes(Long id, String conteudo) {
		this.id = id;
		this.conteudo = conteudo;
	}

	public Long getId() {
		return id;
	}

	public String getConteudo() {
		return conteudo;
	}
}
