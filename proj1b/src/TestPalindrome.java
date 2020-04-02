import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue("should be true", palindrome.isPalindrome("bab"));
        //use " " to input string,
        assertTrue(palindrome.isPalindrome(""));
        assertFalse("should be false", palindrome.isPalindrome("cat"));

    }

    @Test
    public void testOffByOneP(){
        Deque<Character> queue = palindrome.wordToDeque("aaaa");
        CharacterComparator comparator = new OffByOne();
        assertFalse("should be false", palindrome.isPalindrome(queue, comparator));
    }
}
// Uncomment this class once you've created your Palindrome class.