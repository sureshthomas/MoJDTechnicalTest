package uk.gov.justice.digital.legaladviser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The exception when nothing returned
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LegalAdviserNotFoundException extends RuntimeException{


    public LegalAdviserNotFoundException(String message) {
        super(message);
    }
}
