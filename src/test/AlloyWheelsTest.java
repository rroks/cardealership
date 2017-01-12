package test;

import association.AlloyWheels;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class AlloyWheelsTest {
    AlloyWheels alloyWheels = new AlloyWheels();
    @Test
    public void price() throws Exception {
        assertEquals(0, alloyWheels.price());
    }

    @Test
    public void getAsctName() throws Exception {
        assertEquals("AlloyWheels", alloyWheels.getAsctName());
    }

    @Test
    public void getState() throws Exception {
        assertEquals("No", alloyWheels.getState());
    }

    @Test
    public void setState() throws Exception {
        alloyWheels.setState(true);
        assertEquals("Yes", alloyWheels.getState());
    }

    @Test
    public void changedPrice() throws Exception {
        alloyWheels.setState(true);
        assertEquals(1100, alloyWheels.price());
    }
}