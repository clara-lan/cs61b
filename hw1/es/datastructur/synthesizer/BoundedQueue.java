package es.datastructur.synthesizer; // declaring this file as a part of the package
import java.util.Iterator;

public interface BoundedQueue<Item> extends Iterable<Item> {
    //all the definitions and methods are default public in an interface class
    int capacity(); // return size of the buffer
    int fillCount(); // return number of items currently in the buffer
    void enqueue(Item x);// add item x to the end
    Item dequeue(); // delete and return item from the front
    Item peek(); // return (but do not delete) item from the front
    Iterator<Item> iterator();// make iterator interface
    default boolean isEmpty(){ // if without default, return nothing, only keeps the name
        return capacity() == 0;
    };
    default boolean isFull(){
        return capacity() == fillCount();
    };

}
