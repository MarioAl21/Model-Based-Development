import static java.lang.System.*;
import java.util.*;

public class useSingletonPattern {
 public static void main(String[] args) {
  out.println("Hey!");
 }
}

final class Singleton {
 static volatile Singleton unique;
 static readonly Object lock = new Object();
}