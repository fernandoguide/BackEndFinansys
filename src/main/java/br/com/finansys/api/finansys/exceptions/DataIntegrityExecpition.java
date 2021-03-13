package br.com.finansys.api.finansys.exceptions;

public class DataIntegrityExecpition  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityExecpition(String msg) {
		super(msg);
	}
	public DataIntegrityExecpition (String msg, Throwable cause) {
		super(msg,cause);
	}

}
