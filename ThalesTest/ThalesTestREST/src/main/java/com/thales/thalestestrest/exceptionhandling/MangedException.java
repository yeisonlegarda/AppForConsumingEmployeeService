
package com.thales.thalestestrest.exceptionhandling;


public class MangedException extends RuntimeException {

    public MangedException() {
    }

    public MangedException(String message) {
        super(message);
    }

    public MangedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MangedException(Throwable cause) {
        super(cause);
    }

    public MangedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
