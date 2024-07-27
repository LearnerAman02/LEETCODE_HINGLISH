-------------------------  1- Implement LL from scratch  --------------------------
public class LinkedListP {
  public static void main(String[] args) {
    LinkedList l = new LinkedList();
    l.insert(23);
    l.insert(34);
    l.insert(45);
    l.insert(67);
    l.insert(56);
    l.display();
    l.delete();
    l.delete();
    l.display();
    l.delete();
    l.delete();
    l.delete();
    l.delete();
    l.display();
  }
}

class Node {
  int data;
  Node next;

  public Node(int val) {
    this.data = val;
    this.next = null;
  }
}

class LinkedList {
  private Node head = null;

  public boolean isEmpty() {
    return head == null;
  }

  public void insert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public void delete() {
    if (isEmpty()) {
      System.out.println("List is Empty, cannot delete!!");
      return;
    }
    if (head.next == null) {
      head = null;
    } else {
      Node temp = head;
      while (temp.next.next != null) {
        temp = temp.next;
      }
      temp.next = null;
    }
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Linked List is Empty!!");
      return;
    } else {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.data + "--->");
        temp = temp.next;
      }
      System.out.println("null");
    }
  }
}

-------------------------------------------------------------------------------------------------------------------------------------------
  

