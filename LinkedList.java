// Chunyi Lyu assignment6

public class LinkedList implements ListInterface {

    // instance variables
    private Node head;
    private Node tail;
    private int size;
    
    // constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // for debugging only
    public Node getHead() { return this.head; }
    public Node getTail() { return this.tail; }

    // return a readable string representation of the list
    public String toString() {
      String s = "";
     if (this.size == 0) {
            return "[]";
        } else {
            Node n = this.head;  
            s = "[" + n.data.toString();
            n = n.next;
            for (int i = 0; i < this.size-1; i++) {
             s = s + "," + " " + n.data.toString() ;
                n = n.next;               
            }
            s = s + "]";
        }
        return s;
    }

    // return the number of elements currently in the list
    public int getSize() {
        return this.size;
    }

    // return true if the list is empty
    public boolean isEmpty() {
        return (this.size == 0);
    }

    // return the first element, or null if the list is empty
    public Object getFirst() {
        if (this.size == 0) {
            return null;
        } else {
            return this.head.data;
        }   
    }
    
    // return the last element, or null if the list is empty
    public Object getLast() {
     if (this.isEmpty()){
      return null;
     }
     
        return this.tail.data;
    }

    // return the element at a given position, or null if no such element exists
    public Object get(int position) {
        if (position < 0 || position >= this.size) {
            return null;
        } else {
            Node ref = this.head;
            for (int i = 0; i < position; i++) {
                ref = ref.next;
            }
            return ref.data;
        }
    }
    
    // add element to the front of the list and return true if successful
    public boolean addFirst(Object element) {
        Node n = new Node(element);
        n.next = this.head;
        this.head = n;
        if (this.isEmpty()){
         this.tail = n;
        }
        this.size++;
        return true;
    }
    
    // add element to the end of the list and return true if successful
    public boolean addLast(Object element) {
     Node n = new Node(element);
     if (this.isEmpty()){
      this.head= n;
      this.tail = n;
      this.size++;
      return true;     
     }
     Node ref = this.head;
        for (int i = 0; i <this.size-1; i++){
         ref = ref.next;
        }
        ref.next = n;
        this.tail = n;
        this.size++;
        return true;
    }

    // remove and return the first element, or null if list is empty
    public Object removeFirst() {
     if (this.isEmpty()){
      return null;
     }
     
     Object n = this.head.data;
     if (this.size == 1){
      this.head = null;
      this.tail = null;
      this.size--;
      return n;
     }    
     this.head = this.head.next;
     this.size--;
     return n;
    }

    // remove and return the last element, or null if list is empty
    public Object removeLast() {
     if (this.isEmpty()){
      return null;
     }
     
     Object n = this.tail.data;
     if (this.size == 1){
      this.tail = null;
      this.head = null;
      this.size--;
      return n;
     }
     
     Node temp = this.head;
     for (int i = 0; i < this.size-2; i++){
      temp = temp.next;
     }
     this.tail = temp;
     this.tail.next = null;
     this.size--;
     return n;
        
    }
    
    // remove all elements from the list
    public void clear() {
      if (this.isEmpty()){
      }
      
      for (int i = 0; i < this.size; i++){
        this.removeFirst();
      }
      
      this.size = 0;
    }
    // replace the element at the given position with the given element
    // and return true if successful
      
    public boolean set(int position, Object element) {
        if (position < 0 || position >= this.size) {
            return false;
        } else {
            Node ref = this.head;
            for (int i = 0; i < position; i++) {
                ref = ref.next;
            }
            ref.data = element;
            return true;
        }
    }

    // return true if the given element is in the list
    public boolean contains(Object element) {
      if (this.isEmpty()){
        return false;
      }
      int check = 0;
      Node ref = this.head;
            for (int i = 0; i < this.size; i++) {
              Object data = ref.data;
              if (data.equals(element)){
                return true;
              }
              ref = ref.next;
            }
            return false;
   }
   
    
    public boolean add(int position, Object element){
      Node n = new Node(element);
      if (position < 0 || position >= this.size) {
            return false;
      } 
      else if (position == 0){
        this.addFirst(element); 
        return true;
      }
      
 
            Node ref = this.head;
            for (int i = 0; i < position-1; i++) {
                ref = ref.next;
            }
            Node temp = ref.next;
            ref.next = n;
            n.next = temp;
            ref.next = n;
            this.size++;
            return true;
     
      
    }  
    public  Object remove(int position){
      if (position < 0 || position >= this.size || this.isEmpty()) {
            return null;
      }
      else if (position == 0 && this.size == 1){
        Node n = this.head;
        this.clear();
        return n.data;
      }
      else if (position == 0){
        Object n = this.removeFirst();
        return n;
      }
      else if (position == this.size-1){
        Object n = this.removeLast();
        return n;
      }  
     
      Node ref = this.head;
      for (int i = 0; i < position-1; i++) {
        ref = ref.next;
      }
      
      Node n = ref.next;
      Node next = ref.next.next;
      Object data = n.data;     
      n = null;     
      ref.next = next;              
      this.size--;
      return data;
      
    } 

}
