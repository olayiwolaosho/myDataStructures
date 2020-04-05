import java.util.Iterator;

public class DLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> Head = null;
    private Node<T> Tail = null;

    private class Node<T>{
        T data;
        Node<T> Next;
        Node<T> Previous;


        public Node(T data, Node<T> Next , Node<T> Previous){
            this.data = data;
            this.Next = Next;
            this.Previous = Previous;
        }
        @Override public String toString(){
            return data.toString();
        }
    }

    public void Add(T element){
        if(size == 0){
            Head = Tail = new Node<T>(element,null,null);

        }
        else {
            Tail.Next = new Node<>(element,null,Tail);
            Tail = Tail.Next;
        }
        size++;
    }

    public void clearList(){
        while (size != 0){
           Node tailPrev = Tail.Previous;
           Tail = null;
           Tail = tailPrev;
           size--;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
