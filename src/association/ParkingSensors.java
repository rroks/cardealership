package association;

/**
 * This is a class of parking sensor which is a subclass of Association. Association is the
 * generalization. Additional price and name of association should be specified.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class ParkingSensors extends Association{
    /**
     * This is the constructor specifying the additional price and name of this association.
     */
    public ParkingSensors() {
        super();
        this.asctName = "ParkingSensor";
        this.price = 1300;
    }
}
