package cardealership;

import association.*;
import car.*;

/**
 * This is a class with members to store a car deal information and functionalities to change the
 * information before record it into a database.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class DealMaker {
    /**
     * @param cstmrName         This is a String to store the name of a customer.
     * @param price             This is an int to store the price of a car.
     * @param car               This is an instance of subclass of abstract class AbstractCar.
     */
    private String cstmrName;
    private int price = 0;
    private AbstractCar car;

    /**
     * This is a public functionality for outer class/method to change an association of a car
     * through DealMaker.
     *
     * @param association The parameter must be an instance of subclass of Association.
     */
    public void setAssociation(Association association){
        car.setAssociation(association);
    }

    /**
     * This is the constructor of this class whose duty is to create a deal, and it also stores the
     * deal information temporarily.
     *
     * @param cstmrName     This is a String to store the customer's name.
     * @param cartype       This is a CARTYPE parameter to decide the model of car.
     * @param fueltype      This is a FUELTYPE parameter to decide the fuel type of car.
     * @param gearboxtype   This is a GEARBOXTYPE parameter to decide the gearbox type of car
     */
    public DealMaker(String cstmrName, CARTYPE cartype, FUELTYPE fueltype, GEARBOXTYPE gearboxtype){
        this.cstmrName = cstmrName;
        switch (cartype){
            case CAR_A:
                car = new CarA(fueltype, gearboxtype);
                break;
            case CAR_B:
                car = new CarB(fueltype, gearboxtype);
                break;
            case CAR_C:
                car = new CarC(fueltype, gearboxtype);
                break;
            default:
                break;
        }
    }

    /**
     * This is a public functionality for outer class/method to calculate the total price of the car.
     *
     * @return Returns an int of the car price.
     */
    public String price(){
        price = car.getPrice();
        if (car.getFuel().equalsIgnoreCase("hybrid")){
            price -= 5000;
        }
        return String.valueOf(price);
    }

    /**
     * This is a public functionality for outer class/method to get the customer's name.
     *
     * @return Returns a String of the customer's name.
     */
    public String getName(){
        return this.cstmrName;
    }

    /**
     * This is a public functionality for outer class/method to get the model of the car.
     *
     * @return Returns a String of the car model.
     */
    public String getModelName(){
        return car.getModelName();
    }

    /**
     * This is a public functionality for outer class/method to get the car fuel type.
     *
     * @return Returns a String of the car fuel type.
     */
    public String getFuel(){
        return car.getFuel();
    }

    /**
     * This is a public functionality for outer class/method to get the car gearbox type.
     *
     * @return Returns a String of the car gearbox type.
     */
    public String getGearBox(){
        return car.getGearBox();
    }

    /**
     * This is a public functionality for outer class/method to get a String of the information of
     * associations in the format to store in the database.
     *
     * @return Returns a String of the car associations information.
     */
    public String getAssociations(){
        return car.getAssociations();
    }

    /**
     * This is a public functionality for outer class/method to get the car MPG.
     *
     * @return Returns an int of the car MPG.
     */
    public int getMpg() {
        return car.getMpg();
    }
}
