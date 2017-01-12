package test;

import association.AirConditioning;
import car.CarB;
import car.FUELTYPE;
import car.GEARBOXTYPE;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class CarBTest {
    CarB carB = new CarB(FUELTYPE.PETROL, GEARBOXTYPE.MANUAL);

    @Test
    public void getPrice() throws Exception {
        assertEquals(16000, carB.getPrice());
    }

    @Test
    public void getModelName() throws Exception {
        assertEquals("CAR_B", carB.getModelName());
    }

    @Test
    public void getFuel() throws Exception {
        assertEquals("PETROL", carB.getFuel());
    }

    @Test
    public void getGearBox() throws Exception {
        assertEquals("MANUAL", carB.getGearBox());
    }

    @Test
    public void setAssociation() throws Exception {
//check if the amount increase after this
        AirConditioning airConditioning = new AirConditioning();
        airConditioning.setState(true);
        carB.setAssociation(airConditioning);
        Assert.assertEquals(17000, carB.getPrice());
    }

    @Test
    public void getAssociations() throws Exception {
        String str = "'No', 'No', 'No', 'No', ";
        Assert.assertEquals(str, carB.getAssociations());
//string
    }

    @Test
    public void getMPG() throws Exception {
        Assert.assertEquals(40, carB.getMpg());
    }
}