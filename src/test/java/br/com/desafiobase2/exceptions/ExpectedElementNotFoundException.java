package br.com.desafiobase2.exceptions;

public class ExpectedElementNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Não foi possível localizar o elemento esperado.";

	public ExpectedElementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public ExpectedElementNotFoundException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public ExpectedElementNotFoundException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public ExpectedElementNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
