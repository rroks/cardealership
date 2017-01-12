package test;

import car.GEARBOXTYPE;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class GEARBOXTYPETest {
    @Test
    public void getPrice() throws Exception {
        GEARBOXTYPE gearboxtype = GEARBOXTYPE.MANUAL;
        assertEquals(3000, gearboxtype.getPrice());
    }

}