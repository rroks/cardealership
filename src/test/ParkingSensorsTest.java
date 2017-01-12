package test;

import association.ParkingSensors;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class ParkingSensorsTest {
    ParkingSensors parkingSensors = new ParkingSensors();
    @Test
    public void price() throws Exception {
        assertEquals(0, parkingSensors.price());
    }

    @Test
    public void getAsctName() throws Exception {
        assertEquals("ParkingSensor", parkingSensors.getAsctName());
    }

    @Test
    public void getState() throws Exception {
        assertEquals("No", parkingSensors.getState());
    }

    @Test
    public void setState() throws Exception {
        parkingSensors.setState(true);
        assertEquals("Yes", parkingSensors.getState());
    }

    @Test
    public void changedPrice() throws Exception {
        parkingSensors.setState(true);
        assertEquals(1300, parkingSensors.price());
    }
}