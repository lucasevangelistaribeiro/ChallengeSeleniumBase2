package br.com.desafiobase2.exceptions;

/**
 * 
 * Exceções durante a execução dos testes.
 * 
 * @author Juliano Costa
 *
 */
public class MantisTestException extends BaseException {

	private static final long serialVersionUID = 1L;

	public MantisTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MantisTestException(String message, Throwable cause) {
		super(message, cause);
	}

	public MantisTestException(String message) {
		super(message);
	}

	public MantisTestException(Throwable cause) {
		super(cause);
	}
}