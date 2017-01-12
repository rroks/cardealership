package car;

/**
 * This is an ENUM class contains a set of constant of car fuel type.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public enum FUELTYPE {
    /**
     * The fllowing set of car fuel type indicates the fuel type and the price of each car fuel type.
     *
     * @param price     This is an int and it should be a positive integer.
     */
    PETROL(3000, 4), DIESEL(4000, 4), HYBRID(5000, 3), ELECTRIC(6000, 0);
    private int price;
    int mpg;
    FUELTYPE(int price, int mpg){
        this.price =price;
        this.mpg = mpg;
    }
    /**
     * This is a public functionality for outer class/method to get the additional price of a car with a
     * specified car fuel type.
     *
     * @return Returns an int.
     */
    public int getPrice(){
        return price;
    }
    public int getMpg(){
        return mpg;
    }
}
