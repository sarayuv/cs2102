import java.util.Optional;
import java.util.Set;
import java.util.HashMap;

/**
 * Manages nominations and voting data for an election.
 * Stores candidate names, people's votes, and calculates the winner based on the chosen strategy.
 */
public class ElectionData {

    private HashMap<String, Votes> votes;

    private I3VoteStrategy strategy;

    /**
     * A constructor that takes a strategy for calculating the winner and initializes a hashmap.
     * @param strategy
     */
    public ElectionData(I3VoteStrategy strategy) {
        this.strategy = strategy;
        this.votes = new HashMap<>();
    }

    /**
     * Sets the strategy for calculating the winner.
     * @param strategy
     */
    public void setStrategy(I3VoteStrategy strategy) {
        // updates the strategy field
        this.strategy = strategy;
    }

    /**
     * Gets the set of the nominated candidates.
     * @return
     */
    public Set<String> getCandidates() {
        return votes.keySet();
    }

    /**
     * Adds a candidate to the election.
     * @param person
     * @throws AlreadyNominatedException
     */
    public void nominateCandidate(String person) throws AlreadyNominatedException {
        if (votes.containsKey(person)) {
            throw new AlreadyNominatedException(person);
        }
        else {
            votes.put(person, new Votes(0, 0, 0));
        }
    }

    /**
     * Submits a vote for three nominated candidates.
     * @param first
     * @param second
     * @param third
     * @throws CandidateNotNominatedException
     * @throws MoreThanOnceException
     */
    public void submitVote(String first, String second, String third) throws CandidateNotNominatedException, MoreThanOnceException {
        if (!votes.containsKey(first)) {
            throw new CandidateNotNominatedException(first);
        }
        if (!votes.containsKey(second)) {
            throw new CandidateNotNominatedException(second);
        }
        if (!votes.containsKey(third)) {
            throw new CandidateNotNominatedException(third);
        }

        if (first.equals(second)) {
            throw new MoreThanOnceException(first);
        }
        if (first.equals(third)) {
            throw new MoreThanOnceException(first);
        }
        if (second.equals(third)) {
            throw new MoreThanOnceException(second);
        }

        votes.get(first).voteFirst();
        votes.get(second).voteSecond();
        votes.get(third).voteThird();
    }

    /**
     * Calculates the winner based on the chosen strategy.
     * @return Optional<String>
     */
    public Optional<String> calculateWinner() {
        HashMap<String, Votes> copyVotes = new HashMap<>(votes);
        return strategy.calculateWinner(copyVotes);
    }

}
