package test;

import car.CARTYPE;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rroks on 2017/1/3.
 */
public class CARTYPETest {
    @Test
    public void getPrice() throws Exception {
        CARTYPE cartype = CARTYPE.CAR_A;
        assertEquals(5000, cartype.getPrice());
    }

}