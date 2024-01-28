// pblm link --> https://www.codingninjas.com/studio/problems/implement-stack-with-linked-list_1279905?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
/****************************************************************

 Following is the class structure of the Node class:

 static class Node
 {
     int data;
     Node next;
     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };


 *****************************************************************/
public class Solution {
    static class Stack {
        Node head = null;

        Stack()
        {
            //Write your code here
        }

        int getSize()
        {
            Node temp = head;
            int nodes =0;
            while(temp!=null){
                temp = temp.next;
                nodes++;
            }
            return nodes;
        }

        boolean isEmpty()
        {
            return head==null;
        }

        void push(int data)
        {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void pop()
        {
            if(isEmpty()) return;
            Node temp = head;
            head = head.next;
            temp.next = null;
        }

        int getTop()
        {
            if(isEmpty()) return -1;
            int num = head.data;
            return num;
        }
    }
}
