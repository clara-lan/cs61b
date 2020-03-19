public class SLList{

//  private makes any func outside SLList cannot use var first
    private IntNode first;

    public class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

//    add constructor(methods) to do something on the SLList
    public void addFirst(int x){

        first = new IntNode(x, first);

        size += 1;
    }

    public int getFirst(){

        return first.item;
    }




    public void addLast(int x)  {
        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }


    public static int size(IntNode p){
        if(p.next == null){
                return 1;
            }

            return 1 + size(p.next);

        }

    public int size(){
        return size( );
    }


    public static void main(String[] args) {

        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addFirst(0);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size());


    }


}

