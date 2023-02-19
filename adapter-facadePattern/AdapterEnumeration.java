import static java.lang.System.*;
import java.lang.*;
import java.util.*;

public class AdapterEnumeration {
 @SuppressWarnings({ "unchecked", "rawtypes" })
 public static void main(String[] args) {
        Vector days_of_week = new Vector();

        days_of_week.add("Monday");
        days_of_week.add("Tuesday");
        days_of_week.add("Wednesday");
        days_of_week.add("Thursday");
        days_of_week.add("Friday");
        days_of_week.add("Saturday");
        days_of_week.add("Sunday");

        System.out.println("The days of the week: \n" + days_of_week);

        Enumeration enumerator = days_of_week.elements();
        Iterator enumeratorIterator = new EnumerationIterator(enumerator);

        System.out.println("\nThe iterator values of days_of_week are: ");
        while (enumeratorIterator.hasNext())
         System.out.print(enumeratorIterator.next() + " ");

	try{
   	 enumeratorIterator.remove();
        }
  	catch(UnsupportedOperationException e) {
 	 out.println("\n\n\tUps! That operation is not avalilable" +
     	  "\n\tNOTE:Remove is not supported due is an enumeration disguised as an iterator."
	 );
        }
 }
}

// Adapter
class EnumerationIterator implements Iterator {
 Enumeration enumerator;

 public EnumerationIterator(Enumeration enumerator) {
  this.enumerator = enumerator;
 }

 public boolean hasNext() {
  return enumerator.hasMoreElements();
 }

 public Object next() {
  return enumerator.nextElement();
 }

 public void remove() {
  throw new UnsupportedOperationException();
 }
}
