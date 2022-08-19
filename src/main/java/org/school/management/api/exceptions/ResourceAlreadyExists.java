package org.school.management.api.exceptions;

import java.io.Serial;

public class ResourceAlreadyExists extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3191713917718739200L;

    public ResourceAlreadyExists() {}

    public ResourceAlreadyExists(String message) {
        super(message);
    }

    public ResourceAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }
}
