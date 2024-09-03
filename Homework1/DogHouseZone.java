import java.util.LinkedList;

public class DogHouseZone extends UniZone{
    LinkedList<Dog> dogs = new LinkedList<>();
    private int kibbleQty;
    private int vegetablesQty;

    public LinkedList<? extends Adoptable> getAdoptable() {return this.dogs;}

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
        Dog d = new Dog(name, age, currentWeight, whereabouts);
        this.dogs.add(d);
        return this;
    }

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     the type of food being added
     * @param quantity the amount of food being added or subtracted
     * @return a string of the form "Dog: # oz. of food-type | ..."
     * where # is either a number or the text "unknown" if the amount is currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        String kibbleStr = String.valueOf(this.kibbleQty);
        String vegetablesStr = String.valueOf(this.vegetablesQty);

        if (food.equals("kibble")) {
            this.kibbleQty += quantity;
            if (this.kibbleQty >= 0) {
                kibbleStr = String.valueOf(this.kibbleQty);
            } else {
                kibbleStr = "unknown";
            }
        }
        if (food.equals("vegetables")) {
            this.vegetablesQty += quantity;
            if (this.vegetablesQty >= 0) {
                vegetablesStr = String.valueOf(this.vegetablesQty);
            } else {
                vegetablesStr = "unknown";
            }
        }

        return String.format("Dog: %s oz. of kibble | %s units of vegetables", kibbleStr, vegetablesStr);
    }

}
