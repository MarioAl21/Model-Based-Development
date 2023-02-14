// Java code to illustrate iterator()

import java.util.*;

public class AdapterIterator {
 public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<>();

	list.add("Adapter -");
	list.add("Facade");
	list.add("Pattern");
	list.add("rocks");
	list.add("into");
	list.add("Java");
	list.add("Patterns,");
	list.add("Yeah!");

	System.out.println("The list is: \n" + list);

        Iterator<String> iter = list.iterator();
        Enumeration enumerator = new IteratorToEnumeration(iter);

	System.out.println("\nThe enumerator values of list are: ");
	while (enumerator.hasMoreElements())
	 System.out.print(enumerator.nextElement() + " ");
 }
}

class IteratorToEnumeration implements Enumeration {
 Iterator iter;
 
 public IteratorToEnumeration(Iterator iter) {
  this.iter = iter;
 } 

 public boolean hasMoreElements() {
  return iter.hasNext();
 }
 
 public Object nextElement() {
  return iter.next();
 }
}