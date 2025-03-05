package com.simplecrm.app;

public class InteractionNotFoundException extends RuntimeException {
    public InteractionNotFoundException(Long id) {
        super("Could not find interaction " + id);
    }

}
