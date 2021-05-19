package br.com.desafiobase2.exceptions;

public class NeededFileNotFoundException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "Não foi possível tratar o arquivo necessário para execução.";

	public NeededFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(DEFAULT_MESSAGE + "\n" + message, cause, enableSuppression, writableStackTrace);
	}

	public NeededFileNotFoundException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE + "\n" + message, cause);
	}

	public NeededFileNotFoundException(String message) {
		super(DEFAULT_MESSAGE + "\n" + message);
	}

	public NeededFileNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
