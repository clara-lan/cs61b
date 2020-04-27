import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class BSTMap<Key extends Comparable<Key>, Value> implements Map61B  {

    private Node root;
    private class Node{
        private Key key; // sorted by key
        private Value val;
        private Node left, right;
        private int size;// numbers of nodes in subtree

        // every node contains Key:Value pair(as a map)
        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }


    // in order to remove, use min to find the smallest node
    private Node min(Node x){
        if(x.left == null) return x;
        else return min(x.left);
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public Key min(){
        if(isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        else return min(root).key;
    }

    private Node deleteMin(Node x){
        if (x.left == null) return x.left;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void clear() {
        // point root to null could pass the test
        root = null;
    }

    @Override
    public boolean containsKey(Object key) {
        if(key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }


    //recursively get key, write private method then use is in public method which inherit from the interface
    private Value get(Node x, Key key){
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key); // key - x.key < 0
        else if(cmp > 0) return get(x.right, key); //key > x.key
        else return x.val;// if key doesn't exist, return root.val
    }


    @Override
    public Object get(Object key) {
        // except for primitive types, all the other types are object(here is node)
        // casting key into Key k; return Key
        Key k = (Key) key;
        Value res = get(root, k);
        return res;
    }

// private method of find size of a certain node.
    private int size(Node x){
        if(x == null) return 0;
        else return x.size;
    }

    // find size of node x (generic type)
    @Override
    public int size() {
        return size(root);
    }

//private method to insert new node
    private Node put(Node x, Key key, Value val){
        if(x == null ) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    // insert new node(generic type)
    @Override
    public void put(Object key, Object value) {
        Key k = (Key) key;
        Value val = (Value) value;
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null){
//            delete(key);
            return ;
        }
        root = put(root, k, val);
//        assert check();
    }


    @Override
    public Set keySet() {
        throw new UnsupportedOperationException("unsupported operation.");
    }




    @Override
    public Object remove(Object key){ throw new UnsupportedOperationException("unsupported operation."); }


    public Object remove(Object key, Object value){ throw new UnsupportedOperationException("unsupported operation."); }

    @Override
    public Iterator iterator() { throw new UnsupportedOperationException("unsupported operation."); }

    private void printNode(Node x){
        System.out.print(x.key);
        System.out.print(":" + x.val);
    }

    private void printInOrder(Node x){
        if(x.left == null && x.right == null){
            printNode(x);
        }else if(x.left != null){
            printInOrder(x.left);
            printNode(x);
        }else if (x.right != null){
            printNode(x);
            printInOrder(x.right);
        }else{
            printInOrder(x.left);
            printNode(x);
            printInOrder(x.right);
        }
   }

    public void printInOrder(){
        printInOrder(root);
    }

}
