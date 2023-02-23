import static java.lang.System.*; // Allows to only use out.println
import java.util.ArrayList;
import java.util.Iterator; // <<Adaptee>>
import java.util.Enumeration; // <<Target Interface>>

public class App {
    public static void main(String[] args) throws Exception {
        /* 
         ArrayList only supports an iterator object 
         (Let's make an adapter to use it with an Enumeration)
        */
        ArrayList<String> list = new ArrayList<String>();

        // Let's add its data (Strings)
        list.add("Adapter -");
        list.add("Facade");
        list.add("Pattern");
        list.add("rules");
        list.add("into");
        list.add("Java");
        list.add("Patterns!");

        // Now print the list
        out.println("\nThe list has: \n\t" + list + "\n"); // Prints the entire list at once (neat, right?)

        // Let's create an iterator to disguise it as an enumeration
        Iterator<String> iterator = list.iterator(); // ArrayList has a method that returns an iterator object ;)
        Enumeration iterator_as_enum = new IteratorEnumeration(iterator); // Iterator disguised as an Enumeration

        if(iterator_as_enum != null)
         out.println("**** We did it! We're using an iterator as an enumeration! Congrat!!! ****");

        out.print("\nThe enumeration instance has retrieve the follow list:\n\t");
        while(iterator_as_enum.hasMoreElements()) // We use hasMoreElements
         out.print(iterator_as_enum.nextElement() + " ");
        out.println("\n");
    }
}
