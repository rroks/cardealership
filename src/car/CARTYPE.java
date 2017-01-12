package car;

/**
 * This is an ENUM class contains a set of constant of car models.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public enum CARTYPE {
    /**
     * The fllowing set of car models indicates the model name and the price of each car model.
     *
     * @param price     This is an int and it should be a positive integer.
     * @param modelName This is a String to indicate the car model.
     */
    CAR_A(5000, 4), CAR_B(10000, 5), CAR_C(15000, 4);
    private int price;
//    private String modelName;
    private int mpg;
    CARTYPE(int price, int mpg){
//        this.modelName = modelName;
        this.price = price;
        this.mpg = mpg;
    }

    /**
     * This is a public functionality for outer class/method to get the price of a car.
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
