package hust.soict.ite6.aims.exception;


/**
 * Runtime exception used for invalid data (e.g., negative cost, empty title).
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}