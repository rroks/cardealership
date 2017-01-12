package test;

import car.CARTYPE;
import car.FUELTYPE;
import car.GEARBOXTYPE;
import cardealership.DealMaker;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rroks on 2017/1/2.
 */
public class DealMakerTest {
    DealMaker dealMaker = new DealMaker("tester", CARTYPE.CAR_A, FUELTYPE.PETROL, GEARBOXTYPE.MANUAL);

    @Test
    public void price() throws Exception {
        Assert.assertEquals("11000", dealMaker.price());
    }

    @Test
    public void discountPrice() throws Exception {
        dealMaker = new DealMaker("tester", CARTYPE.CAR_A, FUELTYPE.HYBRID, GEARBOXTYPE.MANUAL);
        Assert.assertEquals("8000", dealMaker.price());
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("tester", dealMaker.getName());
    }

    @Test
    public void getModelName() throws Exception {
        Assert.assertEquals("CAR_A", dealMaker.getModelName());
    }

    @Test
    public void getFuel() throws Exception {
        Assert.assertEquals("PETROL", dealMaker.getFuel());
    }

    @Test
    public void getGearBox() throws Exception {
        Assert.assertEquals("MANUAL", dealMaker.getGearBox());
    }

    @Test
    public void getAC() throws Exception {
        String str = "'No', 'No', 'No', 'No', ";
        Assert.assertEquals(str, dealMaker.getAssociations());
    }

}