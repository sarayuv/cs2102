import java.util.LinkedList;

public class CatastropheZone extends UniZone {
    LinkedList<Cat> cats = new LinkedList<>();
    private int dryQty;
    private int wetQty;
    public LinkedList<? extends Adoptable> getAdoptable() {return this.cats;}

    /**
     * Creates an appropriate adoptable pet-to-be's profile
     *
     * @param name
     * @param age
     * @param currentWeight
     * @param whereabouts
     * @return
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Cat c = new Cat(name, age, currentWeight, whereabouts);
        this.cats.add(c);
        return this;
    }

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     the type of food being added
     * @param quantity the amount of food being added or subtracted
     * @return a string of the form "Species: # unit of food-type | ..."
     * where # is either a number or the text "unknown" if the amount is currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        String dryStr = String.valueOf(this.dryQty);
        String wetStr = String.valueOf(this.wetQty);

        if (food.equals("dry")) {
            this.dryQty += quantity;
            if (this.dryQty >= 0) {
                dryStr = String.valueOf(this.dryQty);
            } else {
                dryStr = "unknown";
            }
        }
        else if (food.equals("wet")) {
            this.wetQty += quantity;
            if (this.wetQty >= 0) {
                wetStr = String.valueOf(this.wetQty);
            } else {
                wetStr = "unknown";
            }
        }
        return String.format("Cat: %s lbs. of dry food | %s cans of wet food", dryStr, wetStr);

    }

}
