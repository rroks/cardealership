package car;

/**
 * This is a class of a specified car of model CAR_B. Abstractcar is the generalization. Attributions can be
 * specified to distinguish it from other subclasses of Abstractcar.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class CarB extends AbstractCar {
    /**
     * This is a public constructor of the class.
     *
     * @param fueltype      This is a FUELTYPE parameter to decide the car fuel type.
     * @param gearboxtype   This is a GEARBOXTYPE parameter to decide the car gearboxtype.
     */
    public CarB(FUELTYPE fueltype, GEARBOXTYPE gearboxtype) {
        super(fueltype, gearboxtype);
        cartype = CARTYPE.CAR_B;
        modelName = String.valueOf(cartype);
    }
}
