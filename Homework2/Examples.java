import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    @Test
    public void test_SI_read1() {
        // 1 list with normal readings
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);

        sssi.readSensorData(values);

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(reading1);
        expectedValues.add(reading2);
        expectedValues.add(reading3);

        assertTrue(expectedValues.equals(values));
    }

    @Test
    public void test_SI_read2() {
        // 2 lists with normal readings
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values1 = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        values1.add(reading1);
        values1.add(reading2);
        values1.add(reading3);

        LinkedList<SensorReading> values2 = new LinkedList<>();
        SensorReading reading4 = new SnowReading(35, 2);
        SensorReading reading5 = new SnowReading(40, 2);
        values2.add(reading4);
        values2.add(reading5);

        // Expected values when read
        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(reading1);
        expectedValues.add(reading2);
        expectedValues.add(reading3);
        expectedValues.add(reading4);
        expectedValues.add(reading5);

        sssi.readSensorData(values1);
        sssi.readSensorData(values2);

        // another list that adds all values1 and values2
        LinkedList<SensorReading> list3 = new LinkedList<>();
        list3.addAll(values1);
        list3.addAll(values2);

        assertTrue(expectedValues.equals(list3));
        // is this a proper test?
    }

    @Test
    public void test_SI_read3() {
        // 1 list with errors reading
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(-999, 5);
        SensorReading reading2 = new SnowReading(25, -10);
        SensorReading reading3 = new SnowReading(30, -999);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);

        sssi.readSensorData(values);

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(-999, 5));
        expectedValues.add(new SnowReading(25, -10));
        expectedValues.add(new SnowReading(30, -999));

        assertTrue(expectedValues.equals(values));
    }

    @Test
    public void test_SO_read1() {
        // 1 list with errors reading
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(-999, 5);
        SensorReading reading2 = new SnowReading(25, -10);
        SensorReading reading3 = new SnowReading(30, -999);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);

        ssso.readSensorData(values);

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(-999, 5));
        expectedValues.add(new SnowReading(25, 0));
        expectedValues.add(new SnowReading(30, -999));

        assertTrue(expectedValues.equals(values));
    }

    @Test
    public void test_SO_read2() {
        // 2 lists with normal readings
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values1 = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        values1.add(reading1);
        values1.add(reading2);
        values1.add(reading3);

        LinkedList<SensorReading> values2 = new LinkedList<>();
        SensorReading reading4 = new SnowReading(35, 2);
        SensorReading reading5 = new SnowReading(40, 2);
        values2.add(reading4);
        values2.add(reading5);

        // Expected values when read
        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(reading1);
        expectedValues.add(reading2);
        expectedValues.add(reading3);
        expectedValues.add(reading4);
        expectedValues.add(reading5);

        ssso.readSensorData(values1);
        ssso.readSensorData(values2);

        // another list that adds all values1 and values2
        LinkedList<SensorReading> list3 = new LinkedList<>();
        list3.addAll(values1);
        list3.addAll(values2);

        assertTrue(expectedValues.equals(list3));
    }

    @Test
    public void test_SO_read3() {
        // 1 list with errors reading
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(-999, 5);
        SensorReading reading2 = new SnowReading(25, -10);
        SensorReading reading3 = new SnowReading(30, -999);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);

        ssso.readSensorData(values);

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(-999, 5));
        expectedValues.add(new SnowReading(25, 0));
        expectedValues.add(new SnowReading(30, -999));

        assertTrue(expectedValues.equals(values));
    }

    @Test
    public void test_SO_read4() {
        // 1 list with no readings
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();

        ssso.readSensorData(values);

        LinkedList<SensorReading> expectedValues = new LinkedList<>();

        assertTrue(expectedValues.equals(values));
    }

    @Test
    public void test_SI_get1() {
        //return empty list, no data
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        sssi.readSensorData(values);

        LinkedList<SensorReading> gettingValues = sssi.getCurrentSensorData();

        LinkedList<SensorReading> expectedValues = new LinkedList<>();

        assertTrue(expectedValues.equals(gettingValues));
    }

    @Test
    public void test_SI_get2() {
        // returning just one list
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        values.add(reading1);
        values.add(reading2);

        sssi.readSensorData(values);

        LinkedList<SensorReading> gettingValues = sssi.getCurrentSensorData();

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(20, 5));
        expectedValues.add(new SnowReading(25, 4));

        assertTrue(expectedValues.equals(gettingValues));
    }

    @Test
    public void test_SI_get3() {
        // multiple lists
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values1 = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        values1.add(reading1);
        values1.add(reading2);

        LinkedList<SensorReading> values2 = new LinkedList<>();
        SensorReading reading3 = new SnowReading(30, 3);
        SensorReading reading4 = new SnowReading(35, 2);
        values2.add(reading3);
        values2.add(reading4);

        sssi.readSensorData(values1);
        sssi.readSensorData(values2);

        LinkedList<SensorReading> gettingValues = sssi.getCurrentSensorData();

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(20, 5));
        expectedValues.add(new SnowReading(25, 4));
        expectedValues.add(new SnowReading(30, 3));
        expectedValues.add(new SnowReading(35, 2));

        assertTrue(expectedValues.equals(gettingValues));
    }

    @Test
    public void test_SO_get1() {
        //return empty list, no data
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        ssso.readSensorData(values);

        LinkedList<SensorReading> gettingValues = ssso.getCurrentSensorData();

        LinkedList<SensorReading> expectedValues = new LinkedList<>();

        assertTrue(expectedValues.equals(gettingValues));
    }

    @Test
    public void test_SO_get2() {
        // returning just one list
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        values.add(reading1);
        values.add(reading2);

        ssso.readSensorData(values);

        LinkedList<SensorReading> gettingValues = ssso.getCurrentSensorData();

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(20, 5));
        expectedValues.add(new SnowReading(25, 4));

        assertTrue(expectedValues.equals(gettingValues));
    }

    @Test
    public void test_SO_get3() {
        // multiple lists
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values1 = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        values1.add(reading1);
        values1.add(reading2);

        LinkedList<SensorReading> values2 = new LinkedList<>();
        SensorReading reading3 = new SnowReading(30, 3);
        SensorReading reading4 = new SnowReading(35, 2);
        values2.add(reading3);
        values2.add(reading4);

        ssso.readSensorData(values1);
        ssso.readSensorData(values2);

        LinkedList<SensorReading> gettingValues = ssso.getCurrentSensorData();

        LinkedList<SensorReading> expectedValues = new LinkedList<>();
        expectedValues.add(new SnowReading(20, 5));
        expectedValues.add(new SnowReading(25, 4));
        expectedValues.add(new SnowReading(30, 3));
        expectedValues.add(new SnowReading(35, 2));

        assertTrue(expectedValues.equals(gettingValues));
    }

    @Test
    public void test_overrideTS1() {
        // a SnowReading(13,3) would print as "13C:3cm"
        SnowReading reading = new SnowReading(13,3);

        assertEquals("13C:3cm", reading.toString());
    }

    @Test
    public void test_overrideTS2() {
        // a SnowReading(-999,5) would print as "Err:5cm"
        SnowReading reading = new SnowReading(-999,5);

        assertEquals("Err:5cm", reading.toString());
    }

    @Test
    public void test_overrideTS3() {
        // a SnowReading(15,-999) would print as "15C:Err"
        SnowReading reading = new SnowReading(15,-999);

        assertEquals("15C:Err", reading.toString());
    }

    @Test
    public void test_SI_median1() {
        //even list
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        SensorReading reading4 = new SnowReading(35, 2);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(30, 4);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SI_median2() {
        //odd list
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        SensorReading reading4 = new SnowReading(35, 2);
        SensorReading reading5 = new SnowReading(40, 2);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(30, 3);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SI_median3() {
        // normal case
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 3);
        SensorReading reading2 = new SnowReading(25, 2);
        SensorReading reading3 = new SnowReading(30, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, 1);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(30, 3);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SI_median4() {
        //no valid temp or cm values
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(-999, -999);
        SensorReading reading2 = new SnowReading(-999, -999);
        SensorReading reading3 = new SnowReading(-999, -999);

        values.add(reading1);
        values.add(reading2);
        values.add(reading3);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(-999, -999);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SI_median5() {
        // case with 1 error
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 3);
        SensorReading reading2 = new SnowReading(-999, 2);
        SensorReading reading3 = new SnowReading(30, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, 1);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(35, 3);
        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SI_median6() {
        // case with 1 error
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 3);
        SensorReading reading2 = new SnowReading(25, 2);
        SensorReading reading3 = new SnowReading(30, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, -999);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(30, 4);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SI_median7() {
        // case with multiple errors
        SnowStationSimpleIn sssi = new SnowStationSimpleIn();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, -999);
        SensorReading reading2 = new SnowReading(25, 2);
        SensorReading reading3 = new SnowReading(-999, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, 1);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        sssi.readSensorData(values);

        SensorReading theMedian = sssi.medianReading();

        SensorReading exp = new SnowReading(35, 4);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median1() {
        //even list
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        SensorReading reading4 = new SnowReading(35, 2);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(30, 4);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median2() {
        //odd list
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 5);
        SensorReading reading2 = new SnowReading(25, 4);
        SensorReading reading3 = new SnowReading(30, 3);
        SensorReading reading4 = new SnowReading(35, 2);
        SensorReading reading5 = new SnowReading(40, 2);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(30, 3);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median3() {
        // normal case
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 3);
        SensorReading reading2 = new SnowReading(25, 2);
        SensorReading reading3 = new SnowReading(30, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, 1);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(30, 3);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median4() {
        //no valid temp or cm values
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(-999, -999);
        SensorReading reading2 = new SnowReading(-999, -999);
        SensorReading reading3 = new SnowReading(-999, -999);

        values.add(reading1);
        values.add(reading2);
        values.add(reading3);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(-999, -999);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median5() {
        // case with 1 error
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 3);
        SensorReading reading2 = new SnowReading(-999, 2);
        SensorReading reading3 = new SnowReading(30, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, 1);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(35, 3);
        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median6() {
        // case with 1 error
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, 3);
        SensorReading reading2 = new SnowReading(25, 2);
        SensorReading reading3 = new SnowReading(30, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, -999);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(30, 4);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median7() {
        // case with multiple errors
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();
        SensorReading reading1 = new SnowReading(20, -999);
        SensorReading reading2 = new SnowReading(25, 2);
        SensorReading reading3 = new SnowReading(-999, 4);
        SensorReading reading4 = new SnowReading(35, 5);
        SensorReading reading5 = new SnowReading(40, 1);
        values.add(reading1);
        values.add(reading2);
        values.add(reading3);
        values.add(reading4);
        values.add(reading5);

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(35, 4);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_SO_median8() {
        // no readings
        SnowStationSimpleOut ssso = new SnowStationSimpleOut();

        LinkedList<SensorReading> values = new LinkedList<>();

        ssso.readSensorData(values);

        SensorReading theMedian = ssso.medianReading();

        SensorReading exp = new SnowReading(-999, -999);

        assertTrue(theMedian.equals(exp));
    }

    @Test
    public void test_equality1() {
        SnowReading reading1 = new SnowReading(20,10);
        SnowReading reading2 = new SnowReading(32, 4);

        // not semantically equal
        assertNotEquals(reading1, reading2);

        // not the same object in memory
        assertNotSame(reading1, reading2);
    }

    @Test
    public void test_equality2() {
        SnowReading reading1 = new SnowReading(32,4);
        SnowReading reading2 = new SnowReading(32, 4);

        // semantically equal
        assertEquals(reading1, reading2);

        // not the same object in memory
        assertNotSame(reading1, reading2);
    }

    @Test
    public void test_equality3() {
        //10 I can prob delete this
        SnowReading reading1 = new SnowReading();
        SnowReading reading2 = new SnowReading();

        // semantically equal
        assertTrue(reading1.equals(reading2));
    }

    @Test
    public void test_equality3point5() {
        //10 I can prob delete this
        SnowReading reading1 = new SnowReading();
        SnowReading reading2 = new SnowReading();

        // not the same object in memory
        assertNotSame(reading1, reading2);
    }

    @Test
    public void test_equality4() {
        //11 I can prob delete this
        SnowReading reading1 = new SnowReading();
        SnowReading reading2 = new SnowReading(-999, -999);

        assertTrue(reading2.equals(reading1));

    }

    @Test
    public void test_equality5() {
        //11 I can prob delete this
        SnowReading reading1 = new SnowReading();
        SnowReading reading2 = new SnowReading(-999, -999);

        // not the same object in memory
        assertNotSame(reading1, reading2);
    }

}