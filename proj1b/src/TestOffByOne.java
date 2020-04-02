import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue("should be true",offByOne.equalChars('x', 'y'));
        assertFalse("should be false", offByOne.equalChars('a','a'));

    }
}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/