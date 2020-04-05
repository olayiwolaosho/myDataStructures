public class SinglyLinkedList<T> {
     Node<T> Head = null;
    Node<T> Tail = null;
    private int size = 0;

    class Node<T>{
        T data;
        Node next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }
       public int listLength(){
        return size;
        }

        public void addAtBeginning(T value){
        if(size == 0){
            Head = Tail = new Node<T>(value,null);
        }
        else {
            Node<T> newHead = new Node<T>(value,Head);
            setHead(newHead);

        }
            size++;
        }

        public void addAtEnd(T value){
        if(size == 0){
            Tail = Head = new Node<T>(value,null);
        }
        else {
            Node<T> newTail = new Node<T>(value,null);
            setTail(newTail);

        }
        size++;
    }

    public void insertAtIndex(T value,int Index){
        if(Index > size){
            throw new IllegalArgumentException("Illegal Capacity : " + size );
        }
       if(Index == 0){
           addAtBeginning(value);
       }
       else if(Index == size-1){
           addAtEnd(value);
       }
       else {
           Node<T> pointer = Head;
           for (int i = 0; i < Index-1; i++){
               pointer = pointer.next;
           }
           //Pointer is at the node before the node index
           Node indexNode = pointer.next;
           pointer.next = new Node<T>(value,indexNode);
          size++;
       }

    }

    private void setTail(Node<T> node){
        Tail.next = node;
        Tail = node;
    }

        private void setHead(Node<T> node){

            Head = node;
        }

    public T getAtIndex(int num){
        if(num == 0){
            return Head.data;
        }

     if(num >= size){
         throw new IllegalArgumentException("Illegal Capacity : " + num );
     }
     else {
         Node<T> value = Head;
         // value is already at index one/ num starts at 1
        for (int i = 0; i < num; i++){
            value = value.next;
        }
         return value.data;
     }

    }

    public void getAllValues(){
        for (int i = 0; i < size ; i++){
            System.out.println(getAtIndex(i));
        }
    }
}
