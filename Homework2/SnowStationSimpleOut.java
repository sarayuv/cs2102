import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class SnowStationSimpleOut implements IWeatherStation {
    private LinkedList<SnowReading> sensorReadings;
    public SnowStationSimpleOut() {
        sensorReadings = new LinkedList<>();
    }
    private LinkedList<Integer> temps = new LinkedList<>();
    private LinkedList<Integer> cms = new LinkedList<>();

    /**
     * Reads an ordered sequence of data from the weather sensors to store in the station
     * When called multiple times, appends the new readings after the current sensor readings
     *
     * @param values A sequence of readings
     *               If the sensor has an error, the tempC or cm might be -999
     */
    @Override
    public void readSensorData(LinkedList<SensorReading> values) {
        // Converting the sensor readings to snow readings and adding them to the sensorReadings list
        for (SensorReading reading : values) {
            SnowReading snowReading = new SnowReading(reading.tempC, reading.cm);
            sensorReadings.add(snowReading);

            Integer aTemp = snowReading.getTempC();
            Integer aCm = snowReading.getCm();
            if (aTemp < 0 && (aTemp!= -999)) {
                snowReading.setTempC(0);
            }
            if (aCm < 0 && (aCm!= -999)) {
                snowReading.setCm(0);
            }
        }

        // creating new linked lists that hold only temps and only cms
        for (SnowReading reading : sensorReadings) {
            Integer aTemp = reading.getTempC();
            Integer aCm = reading.getCm();
            temps.add(aTemp);
            cms.add(aCm);

            if (aTemp == -999) {
                temps.remove(aTemp);
            }
            if (aCm == -999) {
                cms.remove(aCm);
            }
        }
    }

    /**
     * Retrieves the current sensor data
     *
     * @return the current sensor data (append together of multiple readings have occurred)
     * returns an empty list if there is no data
     */
    @Override
    public LinkedList<SensorReading> getCurrentSensorData() {
        LinkedList<SensorReading> currentSensorData = new LinkedList<>();
        currentSensorData.addAll(sensorReadings);
        return currentSensorData;    }

    /**
     * produces a sensor value of the median temperature and cm (respectively) from the stored readings ignoring error values (-999s)
     *
     * @return a new SensorReading object that has the median temperature of all the sensor values
     * and the median cm of all the sensor values
     * If there are no valid temp or cm values, then the resulting sensor reading should have -999 for that data, respectively
     */
    @Override
    public SensorReading medianReading() {
        Integer medianTemp = 0;
        Integer medianCms = 0;
        SensorReading mediansFinal;

        if (temps.isEmpty()) {
            medianTemp = -999;
        }
        else {
            // orders the temp list and finds the median
            Collections.sort(temps);
            int findIndexT = (temps.size()/2);
            medianTemp = (temps.get(findIndexT));
        }

        if (cms.isEmpty()) {
            medianCms = -999;
        } else {
            // orders the cms list and finds the median
            Collections.sort(cms);
            int findIndexC = (cms.size()/2);
            medianCms = (cms.get(findIndexC));
        }

        // assembles the sensor reading with the median of temps and cms
        mediansFinal = new SnowReading(medianTemp, medianCms);

        return mediansFinal;
    }
}