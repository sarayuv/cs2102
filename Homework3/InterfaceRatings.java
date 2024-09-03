import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Defines methods for any cass that provides ratings data
 */
public interface InterfaceRatings {

    /**
     * Calculates the best rank (or lowest number) for this month
     * @return integer rank
     */
    int getBestRank(int month, int year);

    /**
     * Calculates the total subscribers in a given month and year
     * @param integer month, integer year
     * @return integer total
     */
    int totalSubscribers(int month, int year);

    /**
     * Adds analytics data to the Streamometer for today. Info is stored in a dailyRatings object
     * @param linked list of analytics
     */
    void createTodaysRating(GregorianCalendar clone, LinkedList<Integer> rankings, LinkedList<Integer> subscribers);

}
