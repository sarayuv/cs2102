import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MoreExamples {
    @Test
    public void test_catHT1() {
        //Pet has no title or credential
        Cat cat1 = new Cat("Molly", 24.0d, 4000.0d, new Coord(2, 5));

        assertEquals(false, cat1.honorablyTitled());

    }

    @Test
    public void test_catHT2() {
        //Pet has title but no credential
        Cat cat1 = new Cat("Tammy", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowTitle("Prince");

        assertEquals(false, cat1.honorablyTitled());
    }

    @Test
    public void test_catHT3() {
        //Pet has credential but no title
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowCredential(", MD");

        assertEquals(false, cat1.honorablyTitled());

    }

    @Test
    public void test_catHT4() {
        //Pet has title and credential
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowTitle("Prince");
        cat1.bestowCredential(", MD");

        assertEquals(true, cat1.honorablyTitled());

    }

    @Test
    public void test_catHT5() {
        //Pet has title and 2 credentials
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowTitle("Prince");
        cat1.bestowCredential(", MD");
        cat1.bestowCredential("Esq");

        assertEquals(true, cat1.honorablyTitled());

    }

    @Test
    public void test_catName1() {
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowTitle("Prince");
        cat1.bestowCredential(", MD");

        assertEquals("Prince Thomas, MD", cat1.getName());

    }

    @Test
    public void test_catTitle1() {
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowTitle("Prince");

        assertEquals("Prince", cat1.title0);
    }

    @Test
    public void test_catCredential1() {
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowCredential(", MD");

        assertEquals(", MD", cat1.credential0);
    }

    @Test
    public void test_catCredential2() {
        Cat cat1 = new Cat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        cat1.bestowCredential(", MD");
        cat1.bestowCredential(", PHD");

        assertEquals(", PHD, MD", cat1.credential0);
    }

    ///// Chinchilla

    @Test
    public void test_chinchillaHT1() {
        //Pet has no title or credential
        Chinchilla chinchilla1 = new Chinchilla("Molly", 24.0d, 4000.0d, new Coord(2, 5));

        assertEquals(false, chinchilla1.honorablyTitled());

    }

    @Test
    public void test_chinchillaHT2() {
        //Pet has title but no credential
        Chinchilla chinchilla1 = new Chinchilla("Tammy", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowTitle("Prince");

        assertEquals(false, chinchilla1.honorablyTitled());
    }

    @Test
    public void test_chinchillaHT3() {
        //Pet has credential but no title
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowCredential(", MD");

        assertEquals(false, chinchilla1.honorablyTitled());

    }

    @Test
    public void test_chinchillaHT4() {
        //Pet has title and credential
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowTitle("Prince");
        chinchilla1.bestowCredential(", MD");

        assertEquals(true, chinchilla1.honorablyTitled());

    }

    @Test
    public void test_chinchillaHT5() {
        //Pet has title and 2 credentials
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowTitle("Prince");
        chinchilla1.bestowCredential(", MD");
        chinchilla1.bestowCredential("Esq");

        assertEquals(true, chinchilla1.honorablyTitled());

    }

    @Test
    public void test_chinchillaName1() {
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowTitle("Prince");
        chinchilla1.bestowCredential(", MD");

        assertEquals("Prince Thomas, MD", chinchilla1.getName());

    }

    @Test
    public void test_chinchillaTitle1() {
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowTitle("Prince");

        assertEquals("Prince", chinchilla1.title0);
    }

    @Test
    public void test_chinchillaCredential1() {
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowCredential(", MD");

        assertEquals(", MD", chinchilla1.credential0);
    }

    @Test
    public void test_chinchillaCredential2() {
        Chinchilla chinchilla1 = new Chinchilla("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        chinchilla1.bestowCredential(", MD");
        chinchilla1.bestowCredential(", PHD");

        assertEquals(", PHD, MD", chinchilla1.credential0);
    }

    ///// Goat

    @Test
    public void test_goatHT1() {
        //Pet has no title or credential
        Goat goat1 = new Goat("Molly", 24.0d, 4000.0d, new Coord(2, 5));

        assertEquals(false, goat1.honorablyTitled());

    }

    @Test
    public void test_goatHT2() {
        //Pet has title but no credential
        Goat goat1 = new Goat("Tammy", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowTitle("Prince");

        assertEquals(false, goat1.honorablyTitled());
    }

    @Test
    public void test_goatHT3() {
        //Pet has credential but no title
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowCredential(", MD");

        assertEquals(false, goat1.honorablyTitled());

    }

    @Test
    public void test_goatHT4() {
        //Pet has title and credential
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowTitle("Prince");
        goat1.bestowCredential(", MD");

        assertEquals(true, goat1.honorablyTitled());

    }

    @Test
    public void test_goatHT5() {
        //Pet has title and 2 credentials
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowTitle("Prince");
        goat1.bestowCredential(", MD");
        goat1.bestowCredential("Esq");
        System.out.println(goat1.getName());

        assertEquals(true, goat1.honorablyTitled());

    }

    @Test
    public void test_goatName1() {
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowTitle("Prince");
        goat1.bestowCredential(", MD");

        assertEquals("Prince Thomas, MD", goat1.getName());

    }

    @Test
    public void test_goatTitle1() {
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowTitle("Prince");

        assertEquals("Prince", goat1.title0);
    }

    @Test
    public void test_goatCredential1() {
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowCredential(", MD");

        assertEquals(", MD", goat1.credential0);
    }

    @Test
    public void test_goatCredential2() {
        Goat goat1 = new Goat("Thomas", 24.0d, 4000.0d, new Coord(2, 5));
        goat1.bestowCredential(", MD");
        goat1.bestowCredential(", PHD");

        assertEquals(", PHD, MD", goat1.credential0);
    }

    @Test
    public void test_goat_dW() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("pellets", 20);
        s = hz.changeFeed("pellets", -10);
        s = hz.changeFeed("hay", 20);
        s = hz.changeFeed("fruit", 0);

        assertEquals("Chinchilla: 10 lbs. of pellets | 20 oz. of hay | 0 units of dried fruit", s);
    }

    ///// Dog

    @Test
    public void test_dogzone_addDog1() {
        DogHouseZone dh = new DogHouseZone();
        dh.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));

    }

    @Test
    public void test_doghouse_totalYoungins1() {
        DogHouseZone dh = new DogHouseZone();
        dh.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        dh.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        assertEquals(1, dh.totalYoungins());
    }

    @Test
    public void test_doghouse_totalYoungins2(){
        //No dogs
        DogHouseZone dh = new DogHouseZone();
        assertEquals(0, dh.totalYoungins());
    }

    @Test
    public void test_doghouse_averageAge1() {
        DogHouseZone dh = new DogHouseZone();
        dh.registerAdoptable("Gompei", 24.0d, 5000.0d, new Coord(1, 1));
        dh.registerAdoptable("Jenna", 3.8d, 500.0d, new Coord(1, 1));
        dh.registerAdoptable("Hannah", 20.0d, 1000.0d, new Coord(1, 1));
        dh.registerAdoptable("Tom", 19.9d, 5000.0d, new Coord(4, 9));

        assertEquals(16.93d, dh.averageAge(), 0.01);
    }

    @Test
    public void test_doghouse_dogFeed1() {
        DogHouseZone dh = new DogHouseZone();
        //First shipment
        String s = dh.changeFeed("kibble", 10);
        //Second shipment
        s = dh.changeFeed("vegetables", 50);

        assertEquals("Dog: 10 oz. of kibble | 3 units of vegetables", s);
    }

}
