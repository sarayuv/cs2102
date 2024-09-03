/**
 * An exception that gets thrown when a candidate is voted for more than once by the same person (in the same vote).
 */
public class MoreThanOnceException extends Exception {
    /**
     * A constructor for MoreThanOnceException.
     * @param candidate
     */
    public MoreThanOnceException(String candidate) {
        super(candidate + " was voted for more than once in a single vote.");
    }
}
