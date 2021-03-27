/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist1;

import java.util.Objects;
import javafx.scene.Node;

/**
 *
 * @author Taif
 */
public class DoublyLinkedList1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        public static class DoublyLinkedList1<E> {
    private Node<E> header;
    private Node<E> trailer;

    /** 
     * Constructor that creates an empty DLL
     */
    public DoublyLinkedList1() {
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, header, null);
        this.header.setNext(trailer);
    }

    /**
     * @return if the list is empty.
     */
    public boolean isEmpty() {
      return this.header.getNext() == this.trailer;
    }

    /**
     * @return the first element of the list.
     */
    public E getFirst() {
      if (isEmpty()) return null;
        return this.header.getNext().getElement();
    }

    /**
     * @return the last element of the list.
     */
    public E getLast() {
      if (isEmpty()) return null;
        return this.trailer.getPrevious().getElement();
    }


    /**
     * Adds a new Node to the beginning of the list, 
     * containing the specified value.
         * @param element
     */
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, header, header.getNext());
        header.getNext().setPrevious(newNode);
        header.setNext(newNode);
    }

    /**
     * This method should return true iff the values of this list 
     * and that are identical and in the same order.
     * @param that list to compare this to.
     * @return true iff the values are identical and in the same order
     */
        @Override
    public int hashCode() {
            int hash = 3;
            hash = 97 * hash + Objects.hashCode(this.header);
        return hash;
    }

        public boolean equals(Object that) {
            if (that == null)
                return false;
            if (!(that instanceof DoublyLinkedList1) )
                return false;
            
            DoublyLinkedList1<E> other = (DoublyLinkedList1<E>) that;
            if (header == null&&other.header != null)
                return false;
            if (trailer == null&&other.trailer != null)
                return false;
            
            while (header.getNext() != trailer){
                if (!(header.equals(other.header))){
                    return false;
                }
                header = header.getNext();
                other.header = other.header.getNext();
            }
            return true;
        }


    /**
     * Simple toString for testing purposes. Please note that solutions that use the
     * .toString() to implement the .equals() method will be rejected.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoublyLinkedList1<");

        Node<E> finger = header.getNext();
        while (finger != trailer) {
            sb.append(finger.toString());
            if (finger.getNext() != trailer) {
                sb.append("-");
            }
            finger = finger.getNext();
        }

        sb.append(">");
        return sb.toString();
    }
    }
    
}
