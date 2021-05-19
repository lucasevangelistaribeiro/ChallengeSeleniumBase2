package br.com.desafiobase2.exceptions;

/**
 * 
 * Exceções durante a execução dos testes.
 * 
 * @author Juliano Costa
 *
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message+ " " + cause.getMessage(), null, enableSuppression, writableStackTrace);
	}

	public BaseException(String message, Throwable cause) {
		super(message + " " + cause.getMessage(), null);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause.getMessage(), null);
	}
}