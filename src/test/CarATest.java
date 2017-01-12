package test;

import association.AirConditioning;
import car.CarA;
import car.FUELTYPE;
import car.GEARBOXTYPE;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class CarATest {
    CarA carA = new CarA(FUELTYPE.PETROL, GEARBOXTYPE.MANUAL);

    @Test
    public void getPrice() throws Exception {
        assertEquals(11000, carA.getPrice());
    }

    @Test
    public void getModelName() throws Exception {
        assertEquals("CAR_A", carA.getModelName());
    }

    @Test
    public void getFuel() throws Exception {
        assertEquals("PETROL", carA.getFuel());
    }

    @Test
    public void getGearBox() throws Exception {
        assertEquals("MANUAL", carA.getGearBox());
    }

    @Test
    public void setAssociation() throws Exception {
//check if the amount increase after this
        AirConditioning airConditioning = new AirConditioning();
        airConditioning.setState(true);
        carA.setAssociation(airConditioning);
        Assert.assertEquals(12000, carA.getPrice());
    }

    @Test
    public void getAssociations() throws Exception {
        String str = "'No', 'No', 'No', 'No', ";
        Assert.assertEquals(str, carA.getAssociations());
//string
    }

    @Test
    public void getMPG() throws Exception {
        Assert.assertEquals(32, carA.getMpg());
    }
}