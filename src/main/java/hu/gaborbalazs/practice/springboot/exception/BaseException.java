package hu.gaborbalazs.practice.springboot.exception;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {

	public BaseException(String message) {
		super(message);
	}
}
