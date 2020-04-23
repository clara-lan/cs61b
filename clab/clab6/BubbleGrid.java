public class BubbleGrid {
    private int[][] grid;

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        // TODO
        int[] res = new int[darts.length]; //results would be same len as the darts
        int i = grid.length - 1 ;
        int j = grid[0].length -1;
        int index = 0;

        for(int[] pos:darts){
            if (i == pos[0] && j == pos[1]){
                if(grid[i][j] != 0){

                }
                res[index] = 0;
                index += 1;

            }
            i -= 1;
            j -= 1;
        }
        return null;
    }
}
