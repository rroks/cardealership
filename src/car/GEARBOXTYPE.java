package car;

/**
 * Created by Rroks on 2016/12/29.
 */
public enum GEARBOXTYPE {
    /**
     * The fllowing set of car fuel type indicates the gearbox type and the price of each kind of
     * gearbox.
     *
     * @param price     This is an int and it should be a positive integer.
     */
    MANUAL(3000, 2), AUTOMATIC(5000, 3);
    private int price;
    private int mpg;
    GEARBOXTYPE(int price, int mpg){
        this.price = price;
        this.mpg = mpg;
    }
    /**
     * This is a public functionality for outer class/method to get the additional price of a car with a
     * specified car gearbox.
     *
     * @return Returns an int.
     */
    public int getPrice(){
        return price;
    }
    public int getMpg() {
        return mpg;
    }
}
