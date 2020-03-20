import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    public static void main(String[] args){
       DynamicArray<Integer> DA = new DynamicArray<Integer>();
        DA.add(1);

    }

    //T[] array is an array of any type
    //length is the amount of elements in the array
    //capacity is the total number of slots in the array or the amount of elements the array can hold
    private T[] array;
    private  int length;
    private int capacity;

    public DynamicArray(){
        this(0);
    }

    public DynamicArray(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Illegal Capacity : " + capacity );
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];//we create a new object array cast/unBox it to become a (T[]) and and equate it to arr with is of type T[]
    }

    public T[] getArray(){
        return array;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private void checkOutOfBound(int index){
        if(index >= capacity && index < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    public T get(int index){
        checkOutOfBound(index);
        return array[index];
    }

    public void set(int index,T element){
        checkOutOfBound(index);
        array[index] = element;
    }
    //i is the index of the array which starts from zero
    public void clear(){
        for(int i= 0; i < capacity; i++){
            array[i] = null;
        }
        length = 0;
    }

    public void setCapacity(){
        if(capacity == 0){
            capacity++;
        }
        else {
            capacity *= 2;
        }
    }

    public void createNewArray(){
        T[] newArray = (T[]) new Object[capacity];
        for(int i = 0 ; i < length;  i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void growArray(T element){
        if(length+1 > capacity){
            setCapacity();
            createNewArray();
        }
    }

    public void add(T element){
        growArray(element);
        array[length++] = element;
    }

    public T reduceArray(int rm_index){
        T data = array[rm_index];
        T[] newArray = (T[]) new Object[length-1];
        for (int i = 0,j=0; i < length; i++,j++){
            if(i == rm_index){
                j--;
            }
            else {
                newArray[j] = array[i];
            }
        }
        changeArrayPointer(newArray);
        return data;
    }

    private void changeArrayPointer(T[] newArray){
        array = newArray;
    }

    public void handleException(int rm_index){
        if(rm_index >= length && rm_index < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    public T removeAt(int rm_index){
        handleException(rm_index);
        return reduceArray(rm_index);
    }

    public boolean remove(T object) {
        for (int i = 0; i > length; i++) {
            if (array[i] == object){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T object){
        for (int i = 0 ; i < length; i++){
            if(array[i] == object){
                return i;
            }
        }
        return -1;
    }

    public boolean Contains(T obj){
        return indexOf(obj) != -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>(){

            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString(){
        if(length == 0 ){
            return "[]";
        }
        else {
            StringBuilder str = new StringBuilder(length).append("[");
            //We use -1 because we do not want a comma at the end we want ]
            for (int i = 0; i < length-1; i++){
                str.append(array[i] + ",");
            }
            return str.append(array[length - 1] + "]").toString();
        }
    }

}



