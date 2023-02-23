import java.util.Iterator;
import java.util.Enumeration;

// Our Iterator (adaptee) to Enumeration (target interface) adapter
public class IteratorEnumeration implements Enumeration {
    private Iterator iterator; // Object to "disguise"
    
    public IteratorEnumeration(Iterator iterator) {
        this.iterator = iterator; // Initialization by reference
    }

    // Method mapping
    // Tells if there are more elements in the collection
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    // Gives the next element in the collection (current value that gets hasMoreElements)
    public Object nextElement() {
        return iterator.next();
    }
}
