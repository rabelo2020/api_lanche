package com.lanches.api.model.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private static final String MSG_ENTIDADE_NAO_ENCONTRADA = "Entidade com o Id %d, não encontrada!";
	
	
	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public EntidadeNaoEncontradaException(Long id) {

		this(String.format(MSG_ENTIDADE_NAO_ENCONTRADA, id));
	}

}
