package car;

import association.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This is an abstract class of car which defines all basic attributions a cas should have.
 * Formats represents the relation among parameters, but all formats does not represent any
 * actual cars. It is just an example. They should be rewrite according to the actual condition.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public abstract class AbstractCar {
    /**
     * Bassically a car should be of a model and shoule decide which kind of energy it needs
     * which kind gearbox to uses at the very beginning.
     *
     * @param cartype       This is a CARTYPE to indicate the model of the car.
     * @param fueltype      This is a FUELTYPE to indicate the car fuel type.
     * @param gearboxtype   This is a GEARBOXTYPE to indicate the car gearbox type.
     * @param price         This is a protected int to store the car price. And it could not be
     *                      changed by outer class.
     * @param String        This is a protected String to store the model name of a car. It's an
     *                      attribution.
     * @param associations  This is a HashMap to store instance of subclasses of Association.
     * @see CARTYPE
     * @see FUELTYPE
     * @see GEARBOXTYPE
     */
    CARTYPE cartype;
    private FUELTYPE fueltype;
    private GEARBOXTYPE gearboxtype;
    protected int price;
    String modelName;
    private Map<String, Association> associations = new HashMap<>();

    /**
     * This is the constructor of the class. The car model should be decided before initializing
     * for different model of cars could have different kinds of engine, gearbox and associations.
     *
     * @param fueltype      This is a FUELTYPE parameter to indicate which kind of
     *                      fuel the car requires.
     * @param gearboxtype   This is a GEARBOXTYPE parameter to indicate which kind of gearbox the
     *                      car has.
     */
    AbstractCar(FUELTYPE fueltype, GEARBOXTYPE gearboxtype){
        this.fueltype = fueltype;
        this.gearboxtype = gearboxtype;
        addAssociation();
    }

    /**
     * This is a private functionality to add all associations with default settings to a car instance.
     * @see Association
     * @see AirConditioning
     * @see ParkingSensors
     * @see DigitalRadio
     * @see AlloyWheels
     */
    private void addAssociation(){
        AirConditioning airConditioning = new AirConditioning();
        associations.put(airConditioning.getAsctName(), airConditioning);
        ParkingSensors parkingSensors = new ParkingSensors();
        associations.put(parkingSensors.getAsctName(), parkingSensors);
        DigitalRadio digitalRadio = new DigitalRadio();
        associations.put(digitalRadio.getAsctName(), digitalRadio);
        AlloyWheels alloyWheels = new AlloyWheels();
        associations.put(alloyWheels.getAsctName(), alloyWheels);
    }
    /**
     * This is a public functionality for outer class/method to change an association.
     *
     * @param association The parameter must be an instance of subclass of Association.
     */
    public void setAssociation(Association association){
        associations.remove(association.getAsctName());
        associations.put(association.getAsctName(), association);
    }
    /**
     * This is a public functionality for outer class/method to get the total price of an instance of a car.
     * The format can be rewritten depending on the actual condition.
     *
     * @return Returns an int.
     */
    public int getPrice(){
        /*
        Traverse the HashMap and get price of all associations.
         */
        for (String key : associations.keySet()){
            price += associations.get(key).price();
        }
        price += cartype.getPrice() + fueltype.getPrice() + gearboxtype.getPrice();
        return price;
    }

    /**
     * This is a public funcionality for outer class/method to get the car model.
     *
     * @return Returns a String of the car model instead of a CARTYPE.
     */
    public String getModelName(){
        return this.modelName;
    }

    /**
     * This is a public functionality for outer class/method to get the car fuel type.
     *
     * @return Returns a String of the car fuel type instead of a FUELTYPE.
     */
    public String getFuel(){
        return String.valueOf(fueltype);
    }

    /**
     * This is a public functionality for outer class/method to get the car gearbox type.
     *
     * @return Returns a String of the car gearbox type instead of a GEARBOXTYPE.
     */
    public String getGearBox(){
        return String.valueOf(gearboxtype);
    }

    /**
     * This is a public functionality for outer class to get MPG of a car.
     * Because MPG of a car is related to its car model, fuel type and gearbox, in this
     * program it is the product of three parameters. It can be specified and rewritten in subclass
     * depending on the relation.
     *
     * @return Returns an int of the car MPG.
     */
    public int getMpg(){
        int mpg;
        mpg = cartype.getMpg() * fueltype.getMpg() * gearboxtype.getMpg();
        return mpg;
    }
    /**
     * This is a public functionality for outer class/method to get a String of the information of associations
     * in the format to store in the database.
     *
     * @return Returns a String of car associations information.
     */
    public String getAssociations(){
        String str = "";
        str += "'" + associations.get("AirConditioning").getState() + "', " +
                "'" + associations.get("ParkingSensor").getState() + "', " +
                "'" + associations.get("DigitalRadio").getState() + "', " +
                "'" + associations.get("AlloyWheels").getState() + "', ";
        return str;
    }
}
