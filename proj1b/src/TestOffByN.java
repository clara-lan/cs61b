import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    static CharacterComparator offByN = new OffByN(2);

    @Test
    public void testEqualChars() {

        assertTrue("should be true",offByN.equalChars('x', 'z'));
        assertFalse("should be false", offByN.equalChars('a','a'));

    }

}
