import java.util.LinkedList;

public class TheHutchZone extends UniZone{
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    private int pelletsQty;
    private int hayQty;
    private int fruitQty;
    public LinkedList<? extends Adoptable> getAdoptable() {return this.chinchillas;}


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
        Chinchilla ch = new Chinchilla(name, age, currentWeight, whereabouts);
        this.chinchillas.add(ch);
        return this;
    }

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     the type of food being added
     * @param quantity the amount of food being added or subtracted
     * @return a string of the form "Chinchilla: # unit of food-type | ..."
     * where # is either a number or the text "unknown" if the amount is currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        String pelletsStr = String.valueOf(this.pelletsQty);
        String hayStr = String.valueOf(this.hayQty);
        String fruitStr = String.valueOf(this.fruitQty);

        if (food.equals("pellets")) {
            this.pelletsQty += quantity;
            if (this.pelletsQty >= 0) {
                pelletsStr = String.valueOf(this.pelletsQty);
            } else {
                pelletsStr = "unknown";
            }
        }
        if (food.equals("hay")) {
            this.hayQty += quantity;
            if (this.hayQty >= 0) {
                hayStr = String.valueOf(this.hayQty);
            } else {
                hayStr = "unknown";
            }
        }
        if (food.equals("fruit")) {
            this.fruitQty += quantity;
            if (this.fruitQty >= 0) {
                fruitStr = String.valueOf(this.fruitQty);
            } else {
                fruitStr = "unknown";
            }
        }

        return String.format("Chinchilla: %s lbs. of pellets | %s oz. of hay | %s units of dried fruit", pelletsStr, hayStr, fruitStr);
    }

}
