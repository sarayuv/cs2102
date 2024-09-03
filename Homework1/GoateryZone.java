import java.util.LinkedList;

public class GoateryZone extends UniZone {
    LinkedList<Goat> goats = new LinkedList<>();
    private int pilesQty;
    public LinkedList<? extends Adoptable> getAdoptable() {return this.goats;}

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
        Goat g = new Goat(name, age, currentWeight, whereabouts);
        this.goats.add(g);
        return this;
    }

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     the type of food being added
     * @param quantity the amount of food being added or subtracked
     * @return a string of the form "Goat: # piles of edible substance"
     * where # is either a number or the text "unknown" if the amount is currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        String pilesStr = "unknown";
        this.pilesQty += quantity;

        if (this.pilesQty >= 0) {
            pilesStr = String.valueOf(pilesQty);
        }

        return String.format("Goat: %s piles of edible substance", pilesStr);

    }
}