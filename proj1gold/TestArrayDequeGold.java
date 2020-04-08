import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold extends ArrayDequeSolution{
    @Test
    /**@source StudentArrayDequeLauncher.java
     * @source https://github.com/zangsy/cs61b_sp19/blob/master/proj1gold/TestArrayDequeGold.java
     * */
    public void TestDeque() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> deque2 = new ArrayDequeSolution<>();

        for(int i = 0; i < 10; i++){
            int num = StdRandom.uniform(0,100);
            deque.addLast(num);
            deque2.addLast(num);
        }

        for(int i = 0; i< 10; i++) {

        }

    }

}
