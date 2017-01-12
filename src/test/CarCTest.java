package test;

import association.AirConditioning;
import car.CarC;
import car.FUELTYPE;
import car.GEARBOXTYPE;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class CarCTest {
    CarC carC = new CarC(FUELTYPE.PETROL, GEARBOXTYPE.MANUAL);

    @Test
    public void getPrice() throws Exception {
        assertEquals(21000, carC.getPrice());
    }

    @Test
    public void getModelName() throws Exception {
        assertEquals("CAR_C", carC.getModelName());
    }

    @Test
    public void getFuel() throws Exception {
        assertEquals("PETROL", carC.getFuel());
    }

    @Test
    public void getGearBox() throws Exception {
        assertEquals("MANUAL", carC.getGearBox());
    }

    @Test
    public void setAssociation() throws Exception {
//check if the amount increase after this
        AirConditioning airConditioning = new AirConditioning();
        airConditioning.setState(true);
        carC.setAssociation(airConditioning);
        Assert.assertEquals(22000, carC.getPrice());
    }

    @Test
    public void getAssociations() throws Exception {
        String str = "'No', 'No', 'No', 'No', ";
        Assert.assertEquals(str, carC.getAssociations());
//string
    }

    @Test
    public void getMPG() throws Exception {
        Assert.assertEquals(32, carC.getMpg());
    }
}