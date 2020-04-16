package es.datastructur.synthesizer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        // format of using a generic type: className<DataType> newObjectName = new className<>(init size or other init value);
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(5);
        Assert.assertEquals(Integer.valueOf(5), arb.peek());
        arb.enqueue(3);
        arb.dequeue();
        arb.enqueue(2);
        System.out.println(arb);

        arb.dequeue();
        Assert.assertEquals(Integer.valueOf(2), arb.peek());
        Assert.assertEquals(1, arb.fillCount());
        arb.enqueue(1);
        System.out.println(arb);
        arb.enqueue(4);// 2,1,4
        arb.dequeue();
        arb.dequeue();//4
        System.out.println(arb);

        Assert.assertEquals(Integer.valueOf(4), arb.peek());
        Assert.assertEquals(1, arb.fillCount());
    }
}

