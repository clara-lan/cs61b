package es.datastructur.synthesizer;
import java.util.Arrays;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer <T> implements BoundedQueue <T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;



    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */

    public ArrayRingBuffer(int capacity) {
        // constructor, use all the definitions
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first = 0;
        last = 0;
        fillCount = 0;
        // use casting for generic array
        rb = (T[]) new Object[capacity];

    }

    // constructor, enable to pass a new array at initialization
    public ArrayRingBuffer(T[] rb) {
        this.rb = rb;
        first = 0;
        last = 0;
        fillCount = 0;
    }

    public String toString() {
        return Arrays.toString(rb);
    }


    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if (isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }else{
            if(last >= rb.length){
                // if no vacancy near the end, insert x to 0, new last = 1
                rb[0] = x;
                last = 1;
                fillCount += 1;
            } else{
                rb[last] = x;
                last += 1;
                fillCount += 1;// actual number of items
            }
        }
        return;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.

        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = rb[first];
        if(first < rb.length - 1){
            // if first index out of range, move first to 0
            first += 1;
        }else{
            first = 0;
        }
        fillCount -= 1;
        return item;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }else{
            T item = rb[first];
            return item;
        }

    }


    @Override
    public boolean equals(Object o){
        //use object method equals to compare object o vs arrayringbuffer
        if(this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (o.getClass() != this.getClass()){
            return false;
        }
        //casting obj o as a new arrayringbuffer
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;

        if (other.fillCount() != this.fillCount()){
            return false;
        }
        Iterator<T> thisIter = this.iterator();
        Iterator<T> otherIter = other.iterator();
        while(thisIter.hasNext() && otherIter.hasNext()){
            if(thisIter.next()!=otherIter.next()){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator{
        private int pos;
        private int count;
        private ArrayIterator() {
            pos = first; count = 0;
        }

        @Override
        public boolean hasNext(){
            return  pos < fillCount();
        }

// source: https://github.com/yngz/cs61b/blob/master/hw1/es/datastructur/synthesizer/ArrayRingBuffer.java
        @Override
        public T next() {
            T item = rb[pos];
            pos +=1;
            if (pos == capacity()){
                pos = 0;
            }
            count += 1;
            return item;
        }

    }

   // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
