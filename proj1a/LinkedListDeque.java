// definition LinkedListDeque
public class LinkedListDeque<AnyType> {
    // private class StuffNode is not accessible outside class LinkedListDeque. but is accessible to other classes
    // within LinkedListDeque.

    // definition of StuffNode
    private class StuffNode {
        public AnyType item;
        public StuffNode next;
        public StuffNode sentFront;
        // prev and next are a pointers, while other stuffnodes are nodes;
        public StuffNode prev;

        //StuffNode constructor
        public  StuffNode(StuffNode prev, AnyType i, StuffNode n){
            this.prev = prev; // define as: StuffNode p, prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentFront;
    private int size;

    // constructor LinkedListDeque
    public LinkedListDeque() {
        // assign address to sentinel
        // sentinel val == null, prev == null, next == null
        sentFront = new StuffNode(null, null, null);
        size = 0;
    }

    // constructor2, copy a new linkedlist which has the same value with the first one but is a different obj
//    public LinkedListDeque(LinkedListDeque other){
//        StuffNode newSent = new StuffNode(null, null, null);
//        size = 0;
//        if(other.size  == 0){
//            newSent.next = null;
//        }else{
//            StuffNode p = other.sentFront.next;
//            newSent.next = p;
//            newSent.next.prev = newSent;
//            size += 1;
//            while(p.next != null) {
//                StuffNode nextNode = new StuffNode(p.prev, p.item ,p.next);
//                size += 1;
//                // pass p to the next node and keep copy
//                p = p.next;
//            }
//        }
//    }


    // constructor2, without cast
    public  LinkedListDeque(LinkedListDeque<AnyType> other) {
        // define constructor with cast
        // public LinkedListDeque(LinkedListDeque other)
        StuffNode sentinel= new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i++){
            // cast the generic type of value in the list
//            addLast((AnyType) other.get(i));
            addLast(other.get(i));

        }

    }

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

    public boolean isEmpty(){
//        if(size == 0)
//            return true;
//        return false;
        return size == 0;
    }

    public int size(){
        return size;
    }

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
        // do not use p = p.next && p.next = sentFront, which will directly skip p and lose the val.
        p.prev.next = sentFront;
        sentFront.prev = p.prev;
        size -= 1;
        return p.item;
    }

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
