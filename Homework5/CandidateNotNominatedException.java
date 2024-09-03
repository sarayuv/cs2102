/**
 * An exception that gets thrown when a candidate is voted for but has not been nominated.
 */
public class CandidateNotNominatedException extends Exception{
    private String candidate;

    /**
     * A constructor for CandidateNotNominatedException.
     * @param candidate
     */
    public CandidateNotNominatedException(String candidate) {
        super(candidate + " was not nominated.");
        this.candidate = candidate;
    }

    /**
     * Gets the name of the candidate in this exception.
     * @return String of candidate's name
     */
    public String getCandidate() {
        return this.candidate;
    }
}
