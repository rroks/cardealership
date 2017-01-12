package association;

/**
 * This is an abstract class of association which defines all basic attributions an association should have.
 *
 * @author Yufeng
 * @since 2016-12-23
 */
public abstract class Association {
    /**
     * @param isAssociation This is a boolean parameter represents if a car has such a kind of
     *                      association or not.
     * @param price         This is a int parameter.
     */
    private boolean isAssociation;
    protected int price;
    String asctName;

    /**
     * This is a public functionality to decide the addiction cost of an association.
     *
     * @return Returns 0 if the association is not chosen and returns the specified price if
     * it is chosen.
     */
    public int price(){
        if (isAssociation == true){
            return price;
        }
        else return price = 0;
    }

    /**
     * This is the default constructor. The initial state of an association defined here means the
     * customer does not choose to have an association and the additional price should be 0.
     */
    Association(){
        this.isAssociation = false;
        this.price = 0;
    }

    /**
     * This is a public functionality to get the name of a kind of association.
     *
     * @return Returns a String.
     */
    public String getAsctName(){
        return this.asctName;
    }

    /**
     * This is a public functionality to check the isAssociation which indicates if an association is
     * chosen or not.
     * @return Rturns a String "Yes" if isAssociation is true, "No" if false.
     */
    public String getState(){
        if (isAssociation) return "Yes";
        else return "No";
    }

    /**
     * This is a public functionality for outer class/method to change isAssociation.
     * @param flag This is a boolean parameter.
     */
    public void setState(boolean flag){
        this.isAssociation = flag;
    }
}
