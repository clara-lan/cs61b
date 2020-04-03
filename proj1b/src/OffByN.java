public class OffByN implements CharacterComparator {
    private int diff;

    // make constructor for OffByN to enable params
    public OffByN(int N){
        diff = N;
    }
    @Override
    public boolean equalChars(char x, char y){
        return x-y == diff || y - x == diff;
    }
}
