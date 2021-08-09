package hash;

public class CustomHash {

  private Node[] table;

  public CustomHash(int length) {
    table = new Node[length];

  }

  public String insert(String key, int value) {

    if (key == null) {
      return " key is null";
    }

    if (key.length() <= 0) {
      return " key length is 0";
    }

    Node newNode = new Node(key, value, null);
    int indexLocation = (hashFunction(key) % table.length);
    Node oldNode = table[indexLocation];
    if (oldNode == null) {
      table[indexLocation] = newNode;
    } else {
      while (oldNode.next != null) {

        if (key.equalsIgnoreCase(oldNode.key)) {
          oldNode.value = value;
          return "Insert Operation completed successfully";
        }
        oldNode = oldNode.next;
      }

      if (key.equalsIgnoreCase(oldNode.key)) {
        oldNode.value = value;
      } else {
        oldNode.next = newNode;
      }

    }
    return "Insert Operation completed successfully";
  }

  public String delete(String key) {
    if (key == null) {
      return " key is null";
    }
    if (key.length() <= 0) {
      return " key length is 0";
    }
    Node prev = null;
    int indexLocation = (hashFunction(key) % table.length);
    Node node = table[indexLocation];

    if (node != null) {
      if (key.equalsIgnoreCase(node.key)) {
        if (null != node.next) {
          table[indexLocation] = node.next;
          return "Key delete operation completed successfully";
        } else {
          table[indexLocation] = null;
        }
      } else {
        prev = node;
        node = node.next;
        while (node.next != null) {
          if (key.equalsIgnoreCase(node.key)) {
            prev.next = node.next;
            node = node.next;
            return "Key delete operation completed successfully";
          }
          prev = node;
          node = node.next;
        }

        if (key.equalsIgnoreCase(node.key)) {
          prev.next = node.next;
          node = node.next;
          return "Key delete operation completed successfully";
        }

      }
    }

    return "Key deletion operation completed failed";
  }

  public String increase(String key) {
    if (key == null) {
      return " key is null";
    }

    Node node = find(key);
    if (node != null) {
      node.value = node.value + 1;
    } else {
      return " node found is null";
    }
    return "Key increase operation completed successfully";

  }

  public Node find(String key) {

    if (key == null) {
      return null;
    }
    if (key.length() <= 0) {
      return null;
    }
    int hash = hashFunction(key);
    int indexLocation = (hash % table.length);
    Node node = table[indexLocation];

    if (node != null) {
      if (key.equalsIgnoreCase(node.key)) {
        return node;
      } else {

        while (node.next != null) {

          if (key.equalsIgnoreCase(node.key)) {
            return node;
          }
          node = node.next;
        }

        if (key.equalsIgnoreCase(node.key)) {
          return node;
        }

      }
    }

    return null;
  }

  public void list() {
    for (int i = 0; i < table.length; i++) {
      Node node = table[i];
      if (node != null) {
        while (node.next != null) {
          System.out.println("Node key " + node.key + " value " + node.value);
          node = node.next;

        }

        System.out.println("Node key " + node.key + " value " + node.value);
      }
    }

  }

  private int hashFunction(String key) {
    if (key == null) {
      throw new IllegalArgumentException(" key is null");
    }

    if (key.length() <= 0) {
      throw new IllegalArgumentException(" key length is negative or zero");
    }
    int sum = 0;
    for (int i = 0; i < key.length(); i++) {
      char charac = key.charAt(i);
      int ascii = charac;
      if (ascii >= 1) {
        sum = sum + ascii;
      }
    }
    int mod = sum % key.length();
    return mod;
  }

}
