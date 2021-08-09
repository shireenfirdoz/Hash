package hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

  public static void main(String[] args) throws FileNotFoundException {
    CustomHash hashObject = new CustomHash(1000);

    Scanner sc = new Scanner(new File("res/alice.txt"));
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] input = line.split(" ");
      for (String key : input) {
        Node node = hashObject.find(key);
        if (node != null) {
          hashObject.insert(key, node.value + 1);
        } else {
          hashObject.insert(key, 1);
        }
      }
    }

    sc = new Scanner(System.in);

    System.out.println(
        "List of operations \n 1.) insert <key> \n 2.) delete <key> \n 3.) increase<key> \n 4.)"
            + " find<key> \n 5.) listAll \n 6.) q\nPlease select the operation:");
    while (sc.hasNextLine()) {

      print(sc.nextLine(), hashObject);
      System.out.println("Please select the operation: ");
    }
  }

  public static void print(String operation, CustomHash customHash) {
    String[] input = operation.split(" ");
    String message = null;
    switch (input[0]) {
    case "insert":
      if (input.length <= 1)
        System.out.println("Command for inserting an element is : \"insert <key>\"");
      else {
        Node node = customHash.find(input[1]);
        if (node != null) {
          message = customHash.insert(input[1], node.value + 1);
          System.out.println(message);
        } else {
          message = customHash.insert(input[1], 1);
          System.out.println(message);
        }
      }
      break;
    case "delete":
      if (input.length <= 1)
        System.out.println("Command for deleting an element is : \"delete <key>\"");
      else {
        message = customHash.delete(input[1]);
        System.out.println(message);
      }
      break;

    case "find":
      if (input.length <= 1)
        System.out.println("Command for finding the key of an element is : \"find <key>\"");
      else {
        Node node = customHash.find(input[1]);
        if (node != null) {
          System.out.println("Searched node : key " + node.key + " value " + node.value);
        } else {
          System.out.println("Node not found");
        }

      }
      break;
    case "increase":
      if (input.length <= 1)
        System.out.println("Command for increasing the key of an element is : \"increase <key>\"");
      else {
        message = customHash.increase(input[1]);
        System.out.println(message);
      }
      break;

    case "listAll":
      customHash.list();
      break;

    case "q":
      return;
    default:
      System.out.println("Invalid Command.");
      break;
    }

  }

}
