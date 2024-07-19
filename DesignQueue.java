public class QueueP {
  public static void main(String[] args) {
    CircularQueue cq = new CircularQueue(5);
    cq.dequeue();
    cq.enqueue(34);
    cq.enqueue(3);
    cq.enqueue(45);
    System.out.println(cq.dequeue());
    cq.enqueue(56);
    cq.enqueue(78);
    System.out.println(cq.dequeue());
  }
}

class CircularQueue {
  int front;
  int rear;
  int[] arr;

  CircularQueue(int capacity) {
    this.front = -1;
    this.rear = -1;
    // initializing the array with default values and with its actual capacity
    arr = new int[capacity];
  }

  public boolean isEmpty() {
    return front == -1;
  }

  public boolean isFull() {
    return (rear + 1) % arr.length == front;
  }

  // ENQUEUE OPERATION
  public void enqueue(int x) {
    if (isFull()) {
      System.out.println("Queue is full, cannot ENQUEUE!!");
      return;
    } else if (isEmpty()) {
      // yaha pe maine galti ki hai
      // agar queue empty ho jaaega toh mujhe front aur rear ko initialize krna pdega
      front = 0;
      rear = 0;
      arr[rear] = x;
    } else {
      // update krdo rear ko circular array ke fashion mei
      rear = (rear + 1) % arr.length;
      arr[rear] = x;
    }
  }

  // DEQUEUE
  public int dequeue() {
    if (isEmpty()) {
      // throw new Exception("Cannot dequeue since queue is empty!!");
      System.out.println("Queue is already empty!!");
      return -1;
    } else {
      int ele = arr[front];
      if (front == rear) {
        front = -1;
        rear = -1;
        // means saare elements humne dequeue kr liye hai aur ab queue empty hoga
      } else {
        // update krdo FRONT ko circular array ke fashion mei
        front = (front + 1) % arr.length;
      }
      return ele;
    }
  }

}
