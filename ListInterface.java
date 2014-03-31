// Starting code from professor
// an interface for list operations (similar to, but not exactly the
// same as, Java's List interface)

public interface ListInterface {
    
    // return the number of elements currently in the list
    public int getSize();
    
    // return true if the list is empty
    public boolean isEmpty();
    
    // return the first element, or null if the list is empty
    public Object getFirst();

    // return the last element, or null if the list is empty
    public Object getLast();

    // return the element at a given position, or null if no such element exists
    public Object get(int position);
    
    // add element to the front of the list and return true if successful
    public boolean addFirst(Object element);
    
    // add element to the end of the list and return true if successful
    public boolean addLast(Object element);

    // remove and return the first element, or null if list is empty
    public Object removeFirst();
    
    // remove and return the last element, or null if list is empty
    public Object removeLast();
    
    // remove all elements from the list
    public void clear();
    
    // replace the element at the given position with the given element
    // and return true if successful
    public boolean set(int position, Object element);

    // return true if the given element is in the list
    public boolean contains(Object element);

}
