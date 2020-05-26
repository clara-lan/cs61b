import edu.princeton.cs.algs4.WeightedQuickUnionUF;
// open marks as -1, blocked as ?, water/percolated as union of the first row

public class Percolation {

    private boolean[][] grid;
    private WeightedQuickUnionUF map;
    private int size;
    private int openSize;
    private int pos;
    private int top;
    private int bottom;


    public Percolation(int N){
        if(N <= 0){
            throw new java.lang.IllegalArgumentException();
        }

        // add dummy head for top and bottom row
        map = new WeightedQuickUnionUF(N*N+2);
        grid = new boolean[N][N];
        size = N;
        openSize = 0;
        // first row, from 1 to N
        top = N;
        // last row, from N * N to N * N
        bottom = N*N;
        int start = 0;
        int end = N*N+1;
        //union [0] with the first row
        for(int i = 1; i <= top; i++){
            map.union(i, start);
        }
        // union [length-1] with the last row
        for(int j = bottom-2; j <= bottom;j++){
            map.union(j, end);
        }

    }

    // validate row and col in grid, incase index out of range
    private boolean validate(int row, int col){
        int index = toArray(row, col);
        return index >= 0 || index <= bottom + 1;
    }

    //convert grid[row][col] into the 1D array (var map)
    private int toArray(int row, int col){
        if(row == 0) return col;
        if(col == 0) return row;
        return (row+1)*(col+1);

    }

    public void open(int row, int col){
        if(!validate(row, col)){
            throw new java.lang.IndexOutOfBoundsException();
        }else if(!isOpen(row,col)){
            grid[row][col] = true;
        }
        pos = toArray(row, col);
        int left = col - 1;
        int right = col + 1;
        int up = row - 1;
        int down = row + 1;
        //check nearby site isOpen and union to current pos if true
        if(validate(row,left) && isOpen(row,left)){
            map.union(pos, toArray(row, left));
        }else if (validate(row, right) && isOpen(row, right)){
            map.union(pos, toArray(row, right));
        }else if(validate(up, col) && isOpen(up,col)){
            map.union(pos, toArray(up,col));
        }else if (validate(down, col) && isOpen(down, col)){
            map.union(pos, toArray(down, col));
        }

    }


    public boolean isOpen(int row, int col){
        if (!validate(row, col)){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return grid[row][col];
    }


// if the site is with water(connected with the first row)
    public boolean isFull(int row, int col){
        if(!validate(row, col)){
            throw new java.lang.IndexOutOfBoundsException();
        }
         return map.connected(0, toArray(row, col)) || map.connected((bottom+1), toArray(row,col));
    }

    public int numberOfOpenSites(){
        return openSize;
    }

    public boolean percolates(){
        // check if first dummy is connected with the last dummy
      return map.connected(0,bottom + 1);
    }

    public static void main(String[] args){
        Percolation temp = new Percolation(3);
        System.out.print(temp.percolates());

    }

}
