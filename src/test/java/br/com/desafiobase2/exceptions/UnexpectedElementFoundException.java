package br.com.desafiobase2.exceptions;

public class UnexpectedElementFoundException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Elemento inesperado encontrado.";

	public UnexpectedElementFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public UnexpectedElementFoundException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public UnexpectedElementFoundException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public UnexpectedElementFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
