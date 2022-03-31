package exception;

public class LocationZoneException extends RuntimeException {

    private final static String BASE_MESSAGE = "Not supported location zone: ";

    public LocationZoneException(String message) {
        super(BASE_MESSAGE + message);
    }
}
