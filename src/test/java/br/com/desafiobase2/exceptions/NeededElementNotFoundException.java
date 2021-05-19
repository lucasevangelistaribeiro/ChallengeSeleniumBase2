package br.com.desafiobase2.exceptions;

public class NeededElementNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Não foi possível encontrar o elemento necessário.";

	public NeededElementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public NeededElementNotFoundException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public NeededElementNotFoundException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public NeededElementNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
