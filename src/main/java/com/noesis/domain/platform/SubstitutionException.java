package com.noesis.domain.platform;

public class SubstitutionException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs an instance of <code>SubstitutionException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SubstitutionException(String msg) {
        super(msg);
    }
}