package com.agenda.exceção;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExcecaoGeral extends ResponseEntityExceptionHandler {
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<MensagemExcecao> mens = criarListaExcecoes(ex.getBindingResult());
		return handleExceptionInternal(ex, mens, headers, org.springframework.http.HttpStatus.BAD_REQUEST, request);

	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String mensUsuario = messageSource.getMessage("mensagem.erro.propriedade", null,
				LocaleContextHolder.getLocale());
		String mensDev = ex.getCause().toString();
		List<MensagemExcecao> mens = Arrays.asList(new MensagemExcecao(mensUsuario, mensDev));

		return handleExceptionInternal(ex, mens, headers, HttpStatus.BAD_REQUEST, request);

	}

	private List<MensagemExcecao> criarListaExcecoes(BindingResult bindingResult) {
		List<MensagemExcecao> mens = new ArrayList<MensagemExcecao>();
		for (FieldError f : bindingResult.getFieldErrors()) {
			String mensUsuario = messageSource.getMessage(f, LocaleContextHolder.getLocale());
			String mensDev = f.toString();
			mens.add(new MensagemExcecao(mensUsuario, mensDev));
		}

		return mens;

	}
}
