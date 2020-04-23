import java.util.Arrays;

public class UnionFind {

    // TODO - Add instance variables?
    private int[] parent;
    private int size;



    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO
        parent = new int[n];
        size = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) throws Exception{
        // TODO
        if (vertex < 0 || vertex >= parent.length){
            throw new Exception("Not a valid vertex.");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) throws Exception {
        // TODO
        // increase size if vertex has the same parent value of v1 and vertex is not v1

        // validate v1
        validate(v1);
        int set_size = 1;
        for( int i=0; i < parent.length; i++ ){
            if(parent[i] == parent[v1] && i != v1){
                set_size += 1;
            }
        }
        return set_size;
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) throws Exception  {
        // TODO
        validate(v1);
        if(parent[v1] == v1){
            return -sizeOf(v1);
        }else{
            return parent[v1];
        }
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) throws Exception {
        // TODO
        validate(v1);
        validate(v2);
        return parent[v1] == parent[v2];
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) throws Exception {
        // TODO
        validate(v1);
        validate(v2);
        int temp;
        int root1 = parent[v1];
        int root2 = parent[v2];
        if(sizeOf(v1) <= sizeOf(v2)){
            // change v1'root to v2'root
            temp = root2;
            // change parent of every node within union
            for(int i=0; i < parent.length; i++){
                if(parent[i] == root1){
                    parent[i] = temp;
                }
            }
        }else{
            temp = root1;
            for(int i=0; i < parent.length; i++){
                if(parent[i] == root2){
                    parent[i] = temp;
                }
            }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) throws Exception{
        // TODO
        validate(vertex);
        return parent[vertex];// use path-compression, root has been updated everytime call union(a, b)

    }

}
