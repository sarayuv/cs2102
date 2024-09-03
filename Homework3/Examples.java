import static org.junit.Assert.assertEquals;
import java.util.GregorianCalendar;     // months start from 0
import java.util.LinkedList;

import org.junit.Test;

public class Examples {

    @Test
    public void test_streamometer1() {
        // tests best rank of March

        // March 30
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 30);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 30 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 30
        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);    // advance the day to March 31

        assertEquals(2, s.bestRankThisMonth());
    }

    @Test
    public void test_streamometer2() {
        // tests best rank at the beginning of the month

        // March 31
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 31);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 31 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 31
        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);    // advance the day to April 1

        // find some data for April 1
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(3, 100));
        analytics2.add(new Analytics(2, 50));
        analytics2.add(new Analytics(1, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics2);    // advance the day to April 2

        assertEquals(1, s.bestRankThisMonth());
    }

    @Test
    public void test_streamometer3() {
        // tests best rank on the last day of March

        // March 31
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 31);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 31 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 31
        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);    // advance the day to April 1

        assertEquals(-1, s.bestRankThisMonth());
    }

    @Test
    public void test_streamometer4() {
        // tests total subs for March when April rankings were already added

        // March 31
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 31);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 31 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 31
        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);

        // find some data for April 1
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(3, 100));
        analytics2.add(new Analytics(2, 50));
        analytics2.add(new Analytics(1, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics2);

        assertEquals(150, s.totalSubscribers(2, 2023));
    }

    @Test
    public void test_streamometer5() {
        // tests total subs for April when also given March rankings

        // March 31
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 31);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 31 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 31
        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);

        // find some data for April 1
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(3, 100));
        analytics2.add(new Analytics(2, 50));
        analytics2.add(new Analytics(1, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics2);

        // find some data for April 2
        LinkedList<Analytics> analytics3 = new LinkedList<>();
        analytics3.add(new Analytics(3, 66));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics3);

        assertEquals(266, s.totalSubscribers(3, 2023));
    }

    @Test
    public void test_streamometer6() {
        // tests total subs for April (once initially and then again when given another rating)

        // March 31
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 31);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 31 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 31
        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);    // advance the day to April 1

        // find some data for April 1
        LinkedList<Analytics> analytics2 = new LinkedList<>();
        analytics2.add(new Analytics(3, 100));
        analytics2.add(new Analytics(2, 50));
        analytics2.add(new Analytics(1, 50));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics2);    // advance the day to April 2

        assertEquals(200, s.totalSubscribers(3, 2023));

        // find some data for April 2
        LinkedList<Analytics> analytics3 = new LinkedList<>();
        analytics3.add(new Analytics(3, 66));

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics3);    // advance the day to April 3

        assertEquals(266, s.totalSubscribers(3, 2023));
    }

    @Test
    public void test_streamometer7() {
        // tests best rank of March when there are no analytics

        // March 30
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 30);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 30 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 30
        LinkedList<Analytics> analytics = new LinkedList<>();

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);    // advance the day to March 31

        assertEquals(-1, s.bestRankThisMonth());
    }

    @Test
    public void test_streamometer8() {
        // tests total subs for March when there are no analytics

        // March 29
        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 29);
        InterfaceRatings drs = new LLRatings();

        // initialize streamometer with March 39 and no ratings
        Streamometer s = new Streamometer(aDay, drs);

        // find some data for March 39
        LinkedList<Analytics> analytics = new LinkedList<>();

        // add the data in the streamometer
        s.addTodaysAnalytics(analytics);

        assertEquals(0, s.totalSubscribers(2, 2023));
    }

    @Test
    public void test_mutation1() {
        // checks that totalSubscribers works on original object and is not mutated when passed as a parameter

        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 29);
        InterfaceRatings drs = new LLRatings();
        Streamometer s = new Streamometer(aDay, drs);

        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(3, 100));
        analytics.add(new Analytics(2, 50));
        s.addTodaysAnalytics(analytics);

        LinkedList<Analytics> originalAnalytics = new LinkedList<>(analytics);
        originalAnalytics.remove(0);

        assertEquals(150, s.totalSubscribers(2, 2023));

    }

    @Test
    public void test_mutation2() {
        // checks that bestRankThisMonth() works on original object and is not mutated when passed as a parameter

        GregorianCalendar aDay = new GregorianCalendar(2023, 02, 29);
        InterfaceRatings drs = new LLRatings();
        Streamometer s = new Streamometer(aDay, drs);

        LinkedList<Analytics> analytics = new LinkedList<>();
        analytics.add(new Analytics(2, 50));
        analytics.add(new Analytics(3, 100));
        s.addTodaysAnalytics(analytics);

        LinkedList<Analytics> originalAnalytics = new LinkedList<>(analytics);
        originalAnalytics.remove(0);

        assertEquals(2, s.bestRankThisMonth());

    }

}





