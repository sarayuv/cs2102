
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Represents the daily ratings data for a stream
 */

public class DailyRatings {
    private GregorianCalendar date;
    private LinkedList<Integer> ranks;
    private LinkedList<Integer> subs;

    /**
     * Constructs a DailyRating
     * @param date of the data, linked list of ranks, linked list of subs
     */
    public DailyRatings(GregorianCalendar date, LinkedList<Integer> ranks, LinkedList<Integer>  subs){
        this.date = (GregorianCalendar) date.clone();
        this.ranks = new LinkedList<>(ranks);
        this.subs = new LinkedList<>(subs);
    }

    /**
     * Gets the date of something with the GregorianCalendar
     * @return a cloned date
     */
    public GregorianCalendar getDate() {
        return ((GregorianCalendar) date.clone());
    }

    /**
     * Gets the list of rankings
     * @return linked list of ranks
     */
    public LinkedList<Integer> getRanks() {
        return new LinkedList<>(ranks);
    }

    /**
     * Gets the list of subscribers
     * @return linked list of subs
     */
    public LinkedList<Integer> getSubs() {
        return new LinkedList<>(subs);
    }
}
