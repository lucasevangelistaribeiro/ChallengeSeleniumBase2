package br.com.desafiobase2.exceptions;

public class InvalidDataException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Não foi possível tratar os dados.";

	public InvalidDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidDataException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public InvalidDataException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public InvalidDataException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
