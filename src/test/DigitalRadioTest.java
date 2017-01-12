package test;

import association.DigitalRadio;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class DigitalRadioTest {
    DigitalRadio digitalRadio = new DigitalRadio();
    @Test
    public void price() throws Exception {
        assertEquals(0, digitalRadio.price());
    }

    @Test
    public void getAsctName() throws Exception {
        assertEquals("DigitalRadio", digitalRadio.getAsctName());
    }

    @Test
    public void getState() throws Exception {
        assertEquals("No", digitalRadio.getState());
    }

    @Test
    public void setState() throws Exception {
        digitalRadio.setState(true);
        assertEquals("Yes", digitalRadio.getState());
    }

    @Test
    public void changedPrice() throws Exception {
        digitalRadio.setState(true);
        assertEquals(1200, digitalRadio.price());
    }
}