package Lesson15;

import java.util.Arrays;

public class CustomArrayList<T> {
    private Object[] elements;
    private int size = 0;

    public CustomArrayList(){
        elements = new Object[10];
    }
    public CustomArrayList(int capacity){
        elements = new Object[capacity];
    }
    public void add(T element){
        if (size == elements.length){
            expandCapacity();
        }
        elements[size++] = element;
    }
    public void remove(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        System.arraycopy(elements,index +1,elements,index,size - index - 1);
        size--;
    }
    public T get(int index){
        if (index < 0 || index >= size ) throw new IndexOutOfBoundsException();
        return (T) elements[index];

    }
    public boolean contais(T element){
        for (int i = 0 ; i <size; i++){
            if (elements[i].equals(element)) return true;
        }
        return false;
    }
    public void clear(){
        elements = new Object[0];
        size = 0;
    }
    public void expandCapacity(){
        elements = Arrays.copyOf(elements,elements.length * 2);
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Coconut");

        System.out.println("Element 1 : " + list.get(1));
        list.remove(1);
        System.out.println("Whith Apple? " + list.contais("Apple"));
        System.out.println("Size: " + list.size());
    }
}
