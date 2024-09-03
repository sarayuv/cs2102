import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {

    @Test
    public void test_coord1() {
        Coord c1 = new Coord(0, 0);
        Coord c2 = new Coord(3, 4);

        assertEquals(5.0d, c1.distanceFrom(c2), 0.01d);
    }

    @Test
    public void test_catast_addCat1() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));

    }

    @Test
    public void test_hutch_addChinchilla1() {
        TheHutchZone hz = new TheHutchZone();
        hz.registerAdoptable("Melica", 9.0d, 4000.0d, new Coord(0, 0));
        hz.registerAdoptable("Melissa", 84.0d, 2000.0d, new Coord(9, 0));
    }

    @Test
    public void test_goatery_addGoat1() {
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Tammy", 9.0d, 4000.0d, new Coord(8, 0));
        g.registerAdoptable("Tam", 84.0d, 2000.0d, new Coord(9, 1));

    }

    @Test
    public void test_goatery_addGoat2() {
        //Buggy
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Terry", -9.0d, -4000.0d, new Coord(8, 0));

    }

    @Test
    public void test_catast_totalYoungins1() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        assertEquals(1, cz.totalYoungins());
    }

    @Test
    public void test_catast_totalYoungins2(){
        //No cats
        CatastropheZone cz = new CatastropheZone();
        assertEquals(0, cz.totalYoungins());
    }

    @Test
    public void test_hutch_totalYoungins1() {
        TheHutchZone hz = new TheHutchZone();
        hz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        assertEquals(0, hz.totalYoungins());
    }

    @Test
    public void test_hutch_totalYoungins2() {
        // No goats
        TheHutchZone hz = new TheHutchZone();

        assertEquals(0, hz.totalYoungins());
    }

    @Test
    public void test_goatery_totalYoungins1() {
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Gompei", 24.0d, 5000.0d, new Coord(1, 1));
        g.registerAdoptable("Jenna", 3.8d, 500.0d, new Coord(5, 1));
        g.registerAdoptable("Hannah", 20.0d, 1000.0d, new Coord(1, 1));
        g.registerAdoptable("Tom", 19.9d, 5000.0d, new Coord(4, 9));

        assertEquals(1, g.totalYoungins());
    }

    @Test
    public void test_goatery_totalYoungins2() {
        //No goats
        GoateryZone g = new GoateryZone();

        assertEquals(0, g.totalYoungins());
    }

    @Test
    public void test_goatery_totalYoungins3() {
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Jemma", 24.0d, 5000.0d, new Coord(1, 1));
        g.registerAdoptable("John", 14.0d, 4500.0d, new Coord(1, 1));

        assertEquals(0, g.totalYoungins(), 0.01);
    }

    @Test
    public void test_catast_averageAge1() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));
        assertEquals(33.0/2.0d, cz.averageAge(),0.01);
    }

    @Test
    public void test_catast_averageAge2() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Tree", 30.0d, 6000.0d, new Coord(0, 0));

        assertEquals(30.0d, cz.averageAge(), 0.01);
    }

    @Test
    public void test_hutch_averageAge1() {
        TheHutchZone hz = new TheHutchZone();
        hz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        assertEquals(24.0d, hz.averageAge(), 0.01);
    }

    @Test
    public void test_goatery_averageAge1() {
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Gompei", 24.0d, 5000.0d, new Coord(1, 1));
        g.registerAdoptable("Jenna", 3.8d, 500.0d, new Coord(1, 1));
        g.registerAdoptable("Hannah", 20.0d, 1000.0d, new Coord(1, 1));
        g.registerAdoptable("Tom", 19.9d, 5000.0d, new Coord(4, 9));

        assertEquals(16.93d, g.averageAge(), 0.01);
    }

    @Test
    public void test_goatery_averageAge2() {
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Jemma", 24.0d, 5000.0d, new Coord(1, 1));
        g.registerAdoptable("John", 14.0d, 4500.0d, new Coord(1, 1));

        assertEquals(19.0d, g.averageAge(), 0.01);
    }

    @Test
    public void test_catast_catFeed1() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("dry", 100);

        assertEquals("Cat: 100 lbs. of dry food | 0 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeed2() {
        CatastropheZone cz = new CatastropheZone();
        //First shipment
        String s = cz.changeFeed("wet", 100);
        //Second shipment
        s = cz.changeFeed("dry", 50);
        //Third shipment
        s = cz.changeFeed("dry", 70);
        assertEquals("Cat: 120 lbs. of dry food | 100 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeed3() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("wet", 0);

        assertEquals("Cat: 0 lbs. of dry food | 0 cans of wet food", s);
    }
    @Test
    public void test_hutch_chinchillaFeed1() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("pellets", 10);

        assertEquals("Chinchilla: 10 lbs. of pellets | 0 oz. of hay | 0 units of dried fruit", s);
    }

    @Test
    public void test_hutch_chinchillaFeed2() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("hay", 100);
        s = hz.changeFeed("fruit", -20);

        assertEquals("Chinchilla: 0 lbs. of pellets | 100 oz. of hay | unknown units of dried fruit", s);
    }

    @Test
    public void test_hutch_chinchillaFeed3() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("fruit", 100);

        assertEquals("Chinchilla: 0 lbs. of pellets | 0 oz. of hay | 100 units of dried fruit", s);
    }

    @Test
    public void test_hutch_chinchillaFeed4() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("fruit", -100);

        assertEquals("Chinchilla: 0 lbs. of pellets | 0 oz. of hay | unknown units of dried fruit", s);
    }

    @Test
    public void test_hutch_chinchillaFeed5() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("pellets", 20);
        s = hz.changeFeed("pellets", -10);
        s = hz.changeFeed("hay", 20);
        s = hz.changeFeed("fruit", 0);

        assertEquals("Chinchilla: 10 lbs. of pellets | 20 oz. of hay | 0 units of dried fruit", s);
    }

    @Test
    public void test_goatery_goatFeed1() {
        GoateryZone g = new GoateryZone();
        String s = g.changeFeed("", 100);

        assertEquals("Goat: 100 piles of edible substance", s);
    }

    @Test
    public void test_goatery_goatFeed2() {
        // Negative input
        GoateryZone g = new GoateryZone();
        String s = g.changeFeed("", -50);

        assertEquals("Goat: unknown piles of edible substance", s);
    }

    @Test
    public void test_catast_closestTo1() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(7, 8));
        cz.registerAdoptable("Fluf", 92.0d, 4000.0d, new Coord(2, 1));

        Coord location = new Coord(0, 0);

        assertEquals(cz.cats.get(1), cz.closestTo(location));
    }

    @Test
    public void test_catast_closestTo2() {
        //No cats
        CatastropheZone cz = new CatastropheZone();

        Coord location = new Coord(0, 0);

        assertNull("This should be null", cz.closestTo(location));
    }

    @Test
    public void test_hutch_closestTo1() {
        TheHutchZone hz = new TheHutchZone();
        hz.registerAdoptable("Flame", 9.0d, 4000.0d, new Coord(6, 1));

        Coord location = new Coord(0, 0);

        assertEquals(hz.chinchillas.get(0), hz.closestTo(location));
    }

    @Test
    public void test_goatery_closestTo1() {
        GoateryZone g = new GoateryZone();
        g.registerAdoptable("Gompei", 24.0d, 5000.0d, new Coord(1, 1));
        g.registerAdoptable("Jenna", 3.8d, 500.0d, new Coord(24, 12));
        g.registerAdoptable("Hannah", 20.0d, 1000.0d, new Coord(15, 1));
        g.registerAdoptable("Tom", 19.9d, 5000.0d, new Coord(4, 18));

        Coord location = new Coord(1, 1);

        assertEquals(g.goats.get(0), g.closestTo(location));
    }

    @Test
    public void test_catWeight1() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Molly", 24.0d, 5000.0d, new Coord(2, 5)); //True
        cz.registerAdoptable("Tammy", 14.0d, 2000.0d, new Coord(2, 1));  //True
        cz.registerAdoptable("Helen", 30.0d, 2000.0d, new Coord(8, 5));  //False
        cz.registerAdoptable("Charles", 29.0d, 4700.0d, new Coord(4, 0));  //True

        LinkedList<Cat> catConcern = new LinkedList<>();
        //catConcern.add(cz.get(1));
        //catConcern.add(cz.get(2));

        assertEquals(catConcern, cz.weighIn(0.2d));
    }

}