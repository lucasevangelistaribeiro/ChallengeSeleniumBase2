package br.com.desafiobase2.exceptions;

public class ExpectedFileNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Não foi possível localizar o arquivo esperado.";

	public ExpectedFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public ExpectedFileNotFoundException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public ExpectedFileNotFoundException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public ExpectedFileNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
