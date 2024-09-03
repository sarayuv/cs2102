/**
 * An exception that gets thrown when a candidate is redundantly nominated.
 */

public class AlreadyNominatedException extends Exception{

    /**
     * A constructor for AlreadyNominatedException
     * @param candidate
     */
    public AlreadyNominatedException(String candidate) {
        super(candidate + " has already been nominated.");
    }
}
