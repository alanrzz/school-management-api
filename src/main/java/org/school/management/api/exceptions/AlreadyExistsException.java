package org.school.management.api.exceptions;

import java.io.Serial;

public class AlreadyExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 6551485332255356688L;

    public AlreadyExistsException() {}

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
