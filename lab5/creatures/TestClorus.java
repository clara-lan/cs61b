package creatures;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

public class TestClorus {
    @Test
    public void testBasic(){
        Clorus c = new Clorus(2);
        assertEquals(2, c.energy(), 0.01);
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        c.stay();
        assertEquals(1.96,c.energy(), 0.01);
    }


    @Test
    public void testReplicate(){
        Clorus c = new Clorus(1);
        Clorus newC = c.replicate();
        assertEquals(0.5, newC.energy(), 0.01);


    }
}
