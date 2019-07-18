package com.kcb.oknmadminext.exception;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 6035909130488647463L;

	public InvalidCredentialsException(String message){
        super(message);
    }
}