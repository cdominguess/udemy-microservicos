package com.github.cdominguess.testeambiente;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacoesController {

	private static final String template = "Olá, %s!";
	private final AtomicLong contador = new AtomicLong();

	/**
	 * A anotação @RequestParam setando value=nome e defaultValue=Mundo faz com que
	 * caso acessar o recurso /saudacao sem passar ?nome=alguma coisa, que seja
	 * default "Mundo"
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/saudacao")
	public Saudacoes saudacao(@RequestParam(value = "nome", defaultValue = "Mundo") String nome) {
		return new Saudacoes(contador.incrementAndGet(), String.format(template, nome));
	}
}
