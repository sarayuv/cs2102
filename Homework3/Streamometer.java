
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Tracks analytics for streaming service
 */
public class Streamometer {
    private GregorianCalendar today;
    private InterfaceRatings dailyRatings;

    /**
     * Constructs a new streamometer object
     * @param today's date, an input of unknown type dailyRatings
     */
    public Streamometer(GregorianCalendar today, InterfaceRatings dailyRatings) {
        this.today = today;
        this.dailyRatings = dailyRatings;
    }

    /**
     * Calculates the best rank (or lowest number) for this month
     * @return integer rank
     */
    public int bestRankThisMonth() {
        int thisMonth = today.get(GregorianCalendar.MONTH);
        int thisYear = today.get(GregorianCalendar.YEAR);

        return dailyRatings.getBestRank(thisMonth, thisYear);
    }

    /**
     * Calculates the total subscribers in a given month and year
     * @param integer month, integer year
     * @return integer total
     */
    public int totalSubscribers(int month, int year) {
        return dailyRatings.totalSubscribers(month, year);
    }

    /**
     * Adds analytics data to the Streamometer for today. Info is stored in a dailyRatings object
     * @param linked list of analytics
     */
    public void addTodaysAnalytics(LinkedList<Analytics> analytics) {
        LinkedList<Integer> rankings = new LinkedList<>();
        LinkedList<Integer> subscribers = new LinkedList<>();

        for (Analytics a : analytics) {
            rankings.add(a.getRank());
            subscribers.add(a.getSubs());
        }

        dailyRatings.createTodaysRating((GregorianCalendar) today.clone(), rankings, subscribers);

        today.add(GregorianCalendar.DAY_OF_MONTH, 1);
    }

}
