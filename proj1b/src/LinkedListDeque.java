import java.util.LinkedList;

public class LinkedListDeque<AnyType> extends LinkedList<AnyType>
        implements Deque <AnyType> {
    private class StuffNode {
        public AnyType item;
        public StuffNode next;
        public StuffNode sentFront;

        public StuffNode prev;


        public  StuffNode(StuffNode prev, AnyType i, StuffNode n){
            this.prev = prev; // define as: StuffNode p, prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentFront;
    private int size;


    public LinkedListDeque() {

        sentFront = new StuffNode(null, null, null);
        size = 0;
    }



    public  LinkedListDeque(LinkedListDeque<AnyType> other) {

        StuffNode sentinel= new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i++){

            addLast(other.get(i));

        }

    }

    @Override
    public void addFirst (AnyType x) {
        // add a node to sentFront.next, which will be the first.
        StuffNode newNode = new StuffNode(sentFront, x, sentFront.next);
        // if (size == 0), empty list
        if(sentFront.next == null){
            //挂上next
            sentFront.next = newNode;

            // make it double linked
            newNode.prev = sentFront;
            sentFront.prev = newNode;
            newNode.next = sentFront;

        }else{
            sentFront.next = newNode;
            newNode.next.prev = newNode;
        }
        size += 1;
    }

    @Override
    public void addLast(AnyType x) {
        StuffNode newNode = new StuffNode(sentFront.prev, x, sentFront);
        if(size == 0){
            sentFront.next = newNode;
            newNode.prev = sentFront;
            sentFront.prev = newNode;
            newNode.next = sentFront;

        }else{
            // let sentFront.prev = 3, sentFront == null, x = 4,
            // after init newNode: 3 <- 4 -> null
            sentFront.prev = newNode; // 3 <- 4 <-> null;
            newNode.prev.next = newNode; // 3 <-> 4 <-> null;
        }
        size += 1;

    }

    // duplication in Deque class
//    public boolean isEmpty(){
//        return size == 0;
//    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        StuffNode p = sentFront.next;
        if (p == null)// empty list, object p is null, init sentFront with null value means object sentFront
            System.out.print("Empty List.");
        while (p != sentFront){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public AnyType removeFirst(){
        StuffNode p = sentFront.next;
        if(size == 0)
            return null;
        if(size == 1){
            sentFront.prev = null;
            sentFront.next = null;
            size = 0;
            return p.item;
        }
        sentFront.next = p.next;
        p.next.prev = sentFront;
        size -= 1;
        return p.item;
    }

    @Override
    public AnyType removeLast(){
        // sentFront.prev is the last node.
        StuffNode p = sentFront.prev;
        if(size == 0)
            return null;
        if(size == 1){
            sentFront.prev = null;
            sentFront.next = null;
            size = 0;
            return p.item;
        }
        p.prev.next = sentFront;
        sentFront.prev = p.prev;
        size -= 1;
        return p.item;
    }

    @Override
    public AnyType get(int index){
        StuffNode p = sentFront.next;
        if (p == null)
            return null;
        while(index>0) {
            p = p.next;
            index--;
        }
        return p.item;
    }


    // get item on index recursively
    public AnyType getRecursive(int index) {
        if (sentFront.next != null) {
            StuffNode p = sentFront.next;
            if(index == 0)
                return p.item;
            return getRecursive(index-1);
        }
        return null;
    }
}
