package test;

import car.FUELTYPE;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class FUELTYPETest {
    @Test
    public void getPrice() throws Exception {
        FUELTYPE fueltype = FUELTYPE.PETROL;
        assertEquals(3000, fueltype.getPrice());
    }

}