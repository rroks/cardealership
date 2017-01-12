package test;

import association.AirConditioning;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class AirConditioningTest {
    AirConditioning airConditioning = new AirConditioning();
    @Test
    public void price() throws Exception {
        assertEquals(0, airConditioning.price());
    }

    @Test
    public void getAsctName() throws Exception {
        assertEquals("AirConditioning", airConditioning.getAsctName());
    }

    @Test
    public void getState() throws Exception {
        assertEquals("No", airConditioning.getState());
    }

    @Test
    public void setState() throws Exception {
        airConditioning.setState(true);
        assertEquals("Yes", airConditioning.getState());
    }

    @Test
    public void changedPrice() throws Exception {
        airConditioning.setState(true);
        assertEquals(1000, airConditioning.price());
    }

}