import java.util.HashMap;
import java.util.Optional;

/**
 * A strategy where the winner is determined by having the most votes in a single category (first, second, or third).
 */
public class MostAgreeableStrategy implements I3VoteStrategy {
    /**
     * Sums up each candidate's votes for each category (first, second, third) to calculate the winner.
     * @param votes
     * @return Optional<String> candidate or Optional.empty()
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        Optional<String> winner = Optional.empty();
        int mostVotes = 0;

        for (String candidate : votes.keySet()) {
            Votes candidateVotes = votes.get(candidate);

            if (candidateVotes.getFirstVotes() > mostVotes) {
                winner = Optional.of(candidate);
                mostVotes = candidateVotes.getFirstVotes();
            }
            if (candidateVotes.getSecondVotes() > mostVotes) {
                winner = Optional.of(candidate);
                mostVotes = candidateVotes.getSecondVotes();
            }
            if (candidateVotes.getThirdVotes() > mostVotes) {
                winner = Optional.of(candidate);
                mostVotes = candidateVotes.getThirdVotes();
            }
        }
        return winner;
    }
}
