/*
Problem link --> https://leetcode.com/problems/implement-stack-using-queues/description/
Basic Queue program for understanding different queue operations
//Queue<Integer> que = new LinkedList<>(); queue is implemented using LinkedList
		// enqueue operation
		que.offer(12);
		que.offer(14);
		que.offer(10);
		System.out.println(que);
		que.poll();
		System.out.println("After removal of one element : "+que);
		// getting the first front element
		System.out.println("Front element is : "+que.peek());
		// checking whether queue is empty or not use --> que.isEmpty()
        */
/*
// Logic --> hum 2 queue ka use karenge 
que1 hamara main queue hoga jisme we will be storing the content and que2 we will be using to perform pop and top operation
PUSH operation --> simply que1 mein we will store the incoming value and it will get stored at the REAR end of the queue
POP operation --> hum que1 ke content ko tranfer karenge into que2
que1 - [4,3,7] , que2 - [](empty)
transfering from que1 to que2 and tab tak hi karenge jab tak 1 element is left in the que1 because it will be our topmost element for the stack
que1 - [3,7] , que2 - [4]
que1 - [7] , que2 - [4,3]
now since one element element is only left in the que1 remove it from que1 and store it in some variable for returning it
que1 - [](empty) , que2 - [4,3]
now again get the que1 og content
que1 - [4,3] , que2 - [](empty)

NOTE --> Same thing we will do in getting the top element also
but usme jab hum og que1 ko getback karenge toh uss case mein we will atlast hum top element ko bhi ENQUEUE karenge in que1 
*/

class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;
    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }
    
    public void push(int x) {
        que1.offer(x);
    }
    
    public int pop() {
        int top=0;
        System.out.println("Before pop : "+que1);
        while(que1.size()!=1){
            int element = que1.poll();
            que2.offer(element);
        }
        top =  que1.poll();// removing the last element
        // again again putting elements back to que1
        while(que2.size()!=0){
            int element = que2.poll();
            que1.offer(element);
        }
        System.out.println("After pop : "+que1);
        return top;
    }
    
    public int top() {
        System.out.println("Before top : "+que1);
        while(que1.size()!=1){
            int element = que1.poll();
            que2.offer(element);
        }
        int top =  que1.poll();// removing the last element
        // again again putting elements back to que1
        while(que2.size()!=0){
            int element = que2.poll();
            que1.offer(element);
        }
        // now inserting the top element at last because we dont have to pop it
        que1.offer(top);
        System.out.println("After top : "+que1);
        return top;
    }
    
    public boolean empty() {
        return que1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
