import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Represents ratings for a stream stored as a linked list
 */
public class LLRatings implements InterfaceRatings {
    private LinkedList<DailyRatings> dailyRatings;

    /**
     *  Constructs a new LLRating
     */
    public LLRatings() {
        dailyRatings = new LinkedList<>();
    }

    /**
     * Calculates the best rank (or lowest number) for this month
     * @param integer current month, integer current year
     * @return integer rank
     */
    public int getBestRank(int thisMonth, int thisYear) {
        int bestRank = Integer.MAX_VALUE;

        for (DailyRatings rating : dailyRatings) {
            int month = rating.getDate().get(GregorianCalendar.MONTH);
            int year = rating.getDate().get(GregorianCalendar.YEAR);

            if ((month == thisMonth) && (year == thisYear)) {
                for (int rank : rating.getRanks()) {
                    if (rank < bestRank) {
                        bestRank = rank;
                    }
                }
            }
        }
        if (bestRank != Integer.MAX_VALUE) {
            return bestRank;
        } else {
            return -1;
        }
    }

    /**
     * Calculates the total subscribers in a given month and year
     * @param integer month, integer year
     * @return integer total
     */
    public int totalSubscribers(int month, int year) {
        int totalSubs = 0;
        for (DailyRatings rating : dailyRatings) {
            int ratingMonth = rating.getDate().get(GregorianCalendar.MONTH);
            int ratingYear = rating.getDate().get(GregorianCalendar.YEAR);

            if ((ratingMonth == month) && (ratingYear == year)) {
                for (int subscribers : rating.getSubs()) {
                    totalSubs += subscribers;
                }
            }
        }
        return totalSubs;
    }

    /**
     * Creates today's dailyRatings object
     * @param today's date, linked list of rankings, linked list of subscribers
     */
    public void createTodaysRating(GregorianCalendar today, LinkedList<Integer> rankings, LinkedList<Integer> subscribers) {
        DailyRatings todaysRating = new DailyRatings((GregorianCalendar) today.clone(), rankings, subscribers);
        dailyRatings.add(todaysRating);
    }

}
