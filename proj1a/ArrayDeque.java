public class ArrayDeque<AnyType> {
    // definition; int[] signifies object ArrayDeque contains an array items;
    private AnyType[] items;
    private int size;
    // save head and tail of the array.
    private int head;
    private int tail;

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == items.length;
    }

    // no class keyword as only one class for a single class file
    public ArrayDeque(){
        items = (AnyType[]) new Object[8];
        size = 0;
        // head/tail points to the array(with value), not the head/tail of the empty array
        head = 0;
        tail = 0;
    }

    public void ArrayDeque(ArrayDeque other) {
        // init a new int array at the size of ArrayDeque other
        AnyType[] newArray = (AnyType[]) new Object[other.items.length];
        //copy from other to newArray.
        System.arraycopy(other, 0, newArray, 0, other.items.length);
        // primitive type data(int, boolean, etc.) passed by value, object/array passed by reference(pointer).
        this.size = other.size;
        this.head = other.head;
        this.tail = other.tail;

        //  one line code:
        //  AnyType[] newArray = (AnyType[]) Arrays.copyOf(other.items, other.items.length);
    }

    //resize the array if size out of range
    public void resize (AnyType[] items) {
        if(isFull()){
            // increase size
            int capacity = size * 2;
            AnyType[] a = (AnyType[]) new Object[capacity];
            size = 0;
            for(int i=0; i < items.length; i++){
                a[i] = items[head % items.length];
                head = (head+1) % items.length;
                size += 1;
            }
            // discard orig array(items), pointer to the new array(a)
            items = a;
            head = 0;
            // reset tail to the end val of current array
            tail = size - 1;
        }
        else if(4 * size < items.length) {
            // decrease size when R is lower than 1/4
            int capacity = items.length / 2;
            AnyType[] a = (AnyType[]) new Object[capacity];
            size = 0;
            for(int i=0; i < size; i++){
                a[i] = items[head % items.length];
                head = (head + 1) % items.length;
                size += 1;
            }
            items = a;
            head = 0;
            tail = size - 1;
        }
    }

    public void addFirst(AnyType x) {
        //pos of the new head
        if(!isFull()) {
            if(!isEmpty()){
                if (head > 0){
                    head -= 1;
                }else{
                    head = items.length - 1;
                }
                // one line to calculate new pos of head:
                // head = (head - 1 + items.length) % items.length;
            }

            items[head] = x;
        }else{
            // if the array is full,call the func again;
            resize(items);
            addFirst(x);
        }
        size += 1;
    }

    public void addLast(AnyType x) {
        if(!isFull()){
            if(!isEmpty())
                tail = (tail + 1) % items.length;
            // if empty, insert x to tail.
            items[tail] = x;
        }else{
            resize(items);
            addLast(x);
        }
        size += 1;
    }


    public AnyType removeFirst(){
        if(isEmpty()) return null;
        size -= 1;
        AnyType res = items[head];
        if(!isEmpty()){
            // move head to right by 1
            head = (head + 1) % items.length;
        }
        return res;
    }

    public AnyType removeLast(){
        if(isEmpty()) return null;
        size -= 1;
        AnyType res = items[tail];
        if(!isEmpty()) {
            // move tail to left by 1
            tail = (tail - 1 + items.length) % items.length;
        }
        return res;
    }

    public AnyType get(int i){
        //mod capacity
        return items[(head + i) % items.length];
    }

    public int size(){
        return size;
    }
}
