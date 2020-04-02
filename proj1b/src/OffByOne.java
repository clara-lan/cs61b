public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        // copy a, b
        char a = x;
        char b = y;
        // convert a/b to ascii val
        int valA = (int)a;
        int valB = (int)b;
        int diff = Math.abs(valA - valB);
        return diff == 1;
    }
}
