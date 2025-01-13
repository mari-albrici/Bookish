package bookish.exceptions;

import java.sql.Date;

import lombok.Getter;

@Getter
public class ErrorsPayload {
    private String message;
    public Date timestamp;
    private int internalCode;

    public ErrorsPayload(String message, Date timestamp, int internalCode) {
        this.message = message;
        this.timestamp = timestamp;
        this.internalCode = internalCode;
    }
}