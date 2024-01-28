// pblm link --> https://www.codingninjas.com/studio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166?leftPanelTabValue=PROBLEM
import java.util.* ;
import java.io.*; 
public class Solution 
{
  public static void insert(Stack<Integer> s, int num) {
    // recursion ke help se we are doing it in constant space just IMPLICIT STACK
    // MEMORY consume hogi bas
    if (s.isEmpty()) {
      s.push(num);
      return;
    }
    // recursion call se pehle element ko pop karake store karado
    int element = s.pop();
    insert(s, num);
    s.push(element);// during backtracking poped element ko phirse push karado into the stack
  }
  public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) 
  {
    insert(myStack,x);
    return myStack;
  }
}
