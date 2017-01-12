package association;

/**
 * This is a class of air conditioning which is a subclass of Association. Association is the
 * generalization. Additional price and name of association should be specified.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class AirConditioning extends Association{
    /**
     * This is the constructor specifying the additional price and name of this association.
     */
    public AirConditioning (){
        super();
        asctName = "AirConditioning";
        price = 1000;
    }
}
