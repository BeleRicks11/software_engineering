package it.unipr.fava_pellegrini;

/**
 * Bottle Class
 * Each bottle has the wine attribute and the amount of the wine (number of bottles)
 *
 * @author Daniele Pellegrini <daniele.pellegrini@studenti.unipr.it> - 285240
 * @author Riccardo Fava <riccardo.fava@studenti.unipr.it> - 287516
 */
public class Bottle {
    private Wine wine;
    private int bottleAmount;

    /**
     * This constructor generates an empty Bottle object
     *
     */
    public Bottle(){
        this.wine = new Wine();
        this.bottleAmount = 0;
    }

    /**
     * This constructor generates a Bottle from its parameters.
     *
     * @param wine the wine to be bottled
     * @param bottleAmount the number of bottles to be added
     */
    public Bottle(Wine wine, int bottleAmount){
        this.wine = wine;
        this.bottleAmount = bottleAmount;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public void setBottleAmount(int bottleAmount) {this.bottleAmount = bottleAmount; }

    public int getBottleAmount() { return bottleAmount; }

    /**
     * Return a string showing bottle's
     * wine and quantity
     *
     * @return String the string
     *
     */
    public String toString(){
        return this.wine.toString() + " Quantity of bottles: " + this.bottleAmount;
    }
}
