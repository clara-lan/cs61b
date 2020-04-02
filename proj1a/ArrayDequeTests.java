import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTests {
    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Assert.assertTrue(deque.isEmpty());
        deque.addLast(1);
        Assert.assertFalse(deque.isEmpty());
    }
}
