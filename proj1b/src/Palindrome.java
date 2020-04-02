public class Palindrome {
    //use interface to declare instance
    public Deque<Character> wordToDeque(String word){
        // char(type) - Character (object), int - Integer, ect.
        // interface<data type> name =  new Implementation
        Deque<Character> queue = new LinkedListDeque<>();
        // a.toCharArray: convert a into an array
        // for c in array
        for(char c:word.toCharArray()){
            queue.addLast(c);
        }
        return queue;
    }

    public boolean isPalindrome(String word){
        Deque queue = new Palindrome().wordToDeque(word);
        while (queue.size() > 1){
            return queue.removeFirst() == queue.removeLast();
        }
        return true;
    }

    public boolean isPalindrome(Deque<Character> queue, CharacterComparator cc){
       while(queue.size() > 1){
           // recursively check palindrome
           return cc.equalChars(queue.removeFirst(), queue.removeLast()) && isPalindrome(queue, cc);
       }
       return true;
    }
}

