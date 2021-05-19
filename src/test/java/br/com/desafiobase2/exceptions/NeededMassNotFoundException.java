package br.com.desafiobase2.exceptions;

public class NeededMassNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Não foi possível obter a massa de testes.";

	public NeededMassNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public NeededMassNotFoundException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public NeededMassNotFoundException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public NeededMassNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
	
	public NeededMassNotFoundException() {
		super(DEFAULT_MESSAGE);
	}
}
