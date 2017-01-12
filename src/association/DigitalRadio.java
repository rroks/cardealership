package association;

/**
 * This is a class of digital radio which is a subclass of Association. Association is the
 * generalization. Additional price and name of association should be specified.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public class DigitalRadio extends Association{
    /**
     * This is the constructor specifying the additional price and name of this association.
     */
    public DigitalRadio() {
        super();
        this.asctName = "DigitalRadio";
        this.price = 1200;
    }
}
