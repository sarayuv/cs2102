import java.util.Objects;

public class SnowReading extends SensorReading{
    /**
     * Construct a weather reading with default values -999
     * Takes in no arguments
     */
    public SnowReading(){
        super(-999, -999);
    }

    /**
     * Construct a weather reading from a temperature and amount (snow, rain, dust/debris, fog, etc)
     *
     * @param tempC the temperature of the sensor reading in degrees Celsius
     * @param cm    the amount of some weather phenomenon in centimeters
     */
    public SnowReading(Integer tempC, Integer cm) {
        super(tempC, cm);
    }



    /**
     * Gets the temperature value from a sensor reading
     * @return Integer
     */
    public Integer getTempC() {
        return tempC;
    }

    /**
     * Sets/updates the temperature value for a snow reading
     * @param tempC
     */
    public void setTempC(Integer tempC) {
        this.tempC = tempC;
    }

    /**
     * Gets the cm value from a sensor reading
     * @return Integer
     */
    public Integer getCm() {
        return cm;
    }

    /**
     * Sets/updates the cm value for a sensor reading
     * @param cm
     */
    public void setCm(Integer cm) {
        this.cm = cm;
    }

    /**
     * Sets/updates the cm value for a snow reading
     * @param o object
     * @return boolean
     */
    public boolean equals(Object o) {
        if (! (o instanceof SnowReading)) {
            return false;
        }

        return (Objects.equals(((SnowReading) o).tempC, this.tempC)) && (Objects.equals(((SnowReading) o).cm, this.cm));
    }

    public String toString() {
        String tempStr = "Err:";
        String cmStr = "Err";

        if (!(tempC == -999)) {
            tempStr = tempC.toString() + "C:";
        }

        if (!(cm == -999)) {
            cmStr = cm.toString() + "cm";
        }

        return String.format(tempStr + cmStr);
    }

}