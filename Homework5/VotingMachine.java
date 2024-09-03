import java.util.Optional;
import java.util.Scanner;

public class VotingMachine {

    Scanner scanner = new Scanner(System.in);
    ElectionData eData = new ElectionData(new MostFirstVotesStrategy());

    public void run() {
        boolean keepGoing = true;

        while(keepGoing) {
            System.out.print("Current candidates are: " + eData.getCandidates());
            System.out.println("\n");


            System.out.println("Do you want to [n]ominate someone, [v]ote for someone, change winner [s]trategy, see who [w]on, or [q]uit?");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.startsWith("n")) {
                System.out.println("Who do you want to nominate?");
                String person = scanner.nextLine().toLowerCase();

                try {
                    eData.nominateCandidate(person);
                }
                catch(AlreadyNominatedException a) {
                    System.out.println(a.getMessage());
                }

            }
            else if (input.startsWith("v")) {
                System.out.println("Who is your first choice?");
                String voteScanner1 = scanner.nextLine().toLowerCase();

                System.out.println("Who is your second choice?");
                String voteScanner2 = scanner.nextLine().toLowerCase();

                System.out.println("Who is your third choice?");
                String voteScanner3 = scanner.nextLine().toLowerCase();

                try {
                    eData.submitVote(voteScanner1, voteScanner2, voteScanner3);
                }
                catch (MoreThanOnceException | CandidateNotNominatedException m) {
                    System.out.println(m.getMessage());
                }
            }
            else if (input.startsWith("s")) {
                System.out.println("Which strategy would you like to use? most [a]greeable or most [f]irst votes?");
                String strategyScanner = scanner.nextLine().toLowerCase().trim();
                if (strategyScanner.startsWith("a")) {
                    eData.setStrategy(new MostAgreeableStrategy());
                }
                else if (strategyScanner.startsWith("f")) {
                    eData.setStrategy(new MostFirstVotesStrategy());
                }
                else {
                    System.out.println("Bad input. Please select [a] or [f].");
                }
            }
            else if (input.startsWith("w")) {
                Optional<String> winner = eData.calculateWinner();

                if (winner.get().equals(Optional.empty())) {
                    System.out.println("No clear winner under the current strategy.");
                }
                else {
                    System.out.println(winner.get() + " is the winner.");
                }
            }
            else {
                keepGoing = false;
                System.out.println("Program terminated.");
            }
        }
    }

    public static void main(String[] args) {
        new VotingMachine().run();
    }
}
