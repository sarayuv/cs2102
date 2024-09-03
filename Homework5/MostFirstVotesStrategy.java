import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * A strategy where the winner is determined by having the most first votes.
 */
public class MostFirstVotesStrategy implements I3VoteStrategy {
    /**
     * Sums up each candidate's first votes to calculate the winner.
     * @param votes
     * @return Optional<String> candidate or Optional.empty()
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        Optional<String> winner;
        int mostVotes = 0;

        List<String> candidatesMFV = new ArrayList<>();
        for (String candidate : votes.keySet()) {
            int candidateFirstVotes = votes.get(candidate).getFirstVotes();
            if (candidateFirstVotes > mostVotes) {
                candidatesMFV.clear();
                candidatesMFV.add(candidate);
                mostVotes = candidateFirstVotes;
            } else if (candidateFirstVotes == mostVotes) {
                candidatesMFV.add(candidate);
            }
        }

        if (candidatesMFV.size() == 1) {
            winner = Optional.of(candidatesMFV.get(0));
        } else {
            winner = Optional.empty();
        }

        return winner;
    }
}
