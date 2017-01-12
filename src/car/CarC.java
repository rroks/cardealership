package car;

/**
 * This is a class of a specified car of model CAR_C. Abstractcar is the generalization. Attributions can be
 * specified to distinguish it from other subclasses of Abstractcar.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class CarC extends AbstractCar{
    /**
     * This is a public constructor of the class.
     *
     * @param fueltype      This is a FUELTYPE parameter to decide the car fuel type.
     * @param gearboxtype   This is a GEARBOXTYPE parameter to decide the car gearboxtype.
     */
    public CarC(FUELTYPE fueltype, GEARBOXTYPE gearboxtype) {
        super(fueltype, gearboxtype);
        cartype = CARTYPE.CAR_C;
        modelName = String.valueOf(cartype);
    }
}
