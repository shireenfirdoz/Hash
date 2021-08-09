package hash;

import java.io.FileNotFoundException;

public class Driver1 {

  public static void main(String[] args) throws FileNotFoundException {
    CustomHash hashObject = new CustomHash(1000);

    Node node = hashObject.find("hello");
    if (node != null) {
      hashObject.insert("hello", node.value + 1);
    } else {
      hashObject.insert("hello", 1);
    }

    hashObject.insert("shireen", 23);
    hashObject.list();
    hashObject.delete("shireen");

    hashObject.list();

    Node node1 = hashObject.find("shireen");
    if (node1 != null) {
      System.out.println("Searched node : key " + node1.key + " value " + node1.value);
    } else {
      System.out.println("Node not found");
    }
    
    hashObject.list();

  }
}
