import java.util.LinkedList;

import static java.lang.Math.abs;

public class Chinchilla extends Adoptable{
    public String title0 = "";
    public String credential0 = "";
    private LinkedList<Chinchilla> chinchillas;

    /**
     * Creates a profile for an adoptable pet-to-be
     *
     * @param name          the name of the animal with no title(s) nor credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public Chinchilla(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Returns the age of the selected chinchilla
     *
     * @return double
     */
    public Double getChinchillaAge() {
        return age;
    }

    /**
     * Calculates the difference between this adoptable pet-to-be's current weight and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    @Override
    public Double deltaWeight() {
        Double dWeight = 0.0d;
        Double sumWeights = 0.0d;

        for (int i = 0; i < chinchillas.size(); i++) {
            sumWeights += currentWeight;
        }

        Double targetWeight = sumWeights / chinchillas.size();
        dWeight = Adoptable.weightRound((abs(targetWeight - currentWeight)), 2);

        return dWeight;
    }

    /**
     * Constructs a name from the adoptable pet-to-be's base name and their title and credentials
     *
     * @return the full name of the pet in "title name, cred" format.
     */
    @Override
    public String getName() {
        String fullName = String.format(title0 + " " + name + credential0);
        return fullName;
    }

    /**
     * Determines whether the current pet's name has a title and a credential
     *
     * @return true if the name is both titled and credentialed.
     */
    @Override
    public Boolean honorablyTitled() {
        if ((title0.equals("")) && (credential0.equals(""))) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Takes a title and adds it to the adoptable pet's name
     * If the adoptable already has a title, it should replace the old title with a new one
     *
     * @param title the title to bestow
     */
    @Override
    public void bestowTitle(String title) {
        title0 = title;
    }

    /**
     * Takes a credential and adds it to the end of the adoptable pet's name after a ","
     * If the name already has a credential, add this credential after the current one(s) space separated
     *
     * @param credential the credential to add
     */
    @Override
    public void bestowCredential(String credential) {
        if (!(credential.contains(", "))) {
            credential0 = credential;
        } else {
            credential0 = String.format(credential + credential0);
        }
    }

    @Override
    public String toString() {
        return "Chinchilla [name=" + name + ", age=" + age + ", currentWeight=" + currentWeight +"]";
    }
}
