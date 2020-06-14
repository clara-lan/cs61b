import java.util.*;

public class MyHashMap <K,V> implements Map61B <K,V>{
    private int init;
    private Entry entry;
    private int curSize; // current size of valid values
    private double factor;
    private ArrayList<Entry<K, V>>[] buckets; // define buckets as a class variable, can be accessed within this class
    //save keys in hashset as a set, import HashSet
    private HashSet<K> keys;


    private class Entry<K, V>{
        private K key;
        private V val;
        Entry(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    // init buckets
    private void initMap(int cap){
        init = cap;
        buckets = new ArrayList[init];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>(); // init every bucket as an arraylist to store multiple entry in the future
        }
    }

//when initialSize or loadFactor is not given, use this to call function MyHashMap line 41
    public MyHashMap(){
        this(16, 0.75);
    }

    public MyHashMap(int initSize){
        this(initSize, 0.75);
    }


    public MyHashMap(int initialSize, double loadFactor){
        if(initialSize < 1 || loadFactor < 0.0){
            // default init=16, factor=0.75
            this.init = initialSize;
            this.factor = loadFactor;
        }
        initMap(initialSize);
        this.keys = new HashSet<>();
        this.curSize = 0;
    }

  // get hash code of key;
    private int hash(K key){
        if(key != null){
            // generate hash code based on key, using Object.hashCode();
         // map current hashcode to the right index position, data-structure p139
            return (key.hashCode() & 0x7ffffff) % init;
        }else{
            return 0;
        }
    }


    @Override
    public int size() {
        return curSize;
    }

    @Override
    public void clear(){
        this.curSize = 0;
        this.keys = new HashSet<>(init);
    }


    @Override
    public boolean containsKey(K key){
        return this.keys.contains(key);
    };


    @Override
    public V get(K key){
        if(key == null){
            throw new IllegalArgumentException("argument can not be null");
        }
        if(!this.keys.contains(key)) return null;
        int hash = hash(key);
        ArrayList<Entry<K, V>> bucket = buckets[hash];// find arraylist bucket based on hash code.

        for(Entry<K, V> entry: bucket){
            if (entry.key.equals(key)) { // find val based on key
                return entry.val;
            }
        }

        return null;
    }


    @Override
    public void put(K key, V val){
        if(this.keys.contains(key)){// if key in current keysSet, this.keys is a hashset which will improve searching efficiency
            int hash = hash(key);
            ArrayList<Entry<K, V>> bucket = buckets[hash];// find right bucket based on hash code
            for(Entry<K, V> entry: bucket) { // find the right entry object in bucket
                if(entry.key.equals(key)) {
                    entry.val = val;
                    return;
                }
            }
        };
        this.keys.add(key);
        int hash = hash(key);
        ArrayList<Entry<K, V>> bucket = buckets[hash];// bucket: values of corresponding hashcode in buckets
        bucket.add(new Entry<>(key, val));
        curSize += 1;
    }



    @Override
    public V remove(K key) {
            throw new UnsupportedOperationException();
        }


    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }


    @Override
    public HashSet<K> keySet(){
        return this.keys;
    }



    @Override
    public Iterator<K> iterator() {
        return this.keys.iterator();
    }




    public static void main(String[] args){
        MyHashMap map = new MyHashMap();
    }
}
