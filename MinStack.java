// pblm link --> 
// mine Approach --> we will have two stacks -- allData, minData stacks
//ek extra stack bhi hoga usme , so in that what we can store min value till now
// so hum jab bhi element aayege we will simply push it into the stack allData and minData stack ko check karenge ki agar woh empty hai stating mein toh push kardo and than remaining value ko tabhi push karenge into the stack only if incoming value <= minData.peek value
// and during pop,top hum pehle check kareng ki kya stack empty hai and if yes than pop the value out or get the data from minData and allData stack
// pop karte time we will check ki allData ke top pe jo value hai wahi agar minData ke top pe hai than pop from minData stack as well
// and in getMin we will check ki kya element is present in stack , if yes than minData.peek()
class MinStack {
    Stack<Integer> allData;
    Stack<Integer> minData;
    public MinStack() {
        allData = new Stack<>();
        minData = new Stack<>();
    }
    
    public void push(int val) {
        allData.push(val);
        // val<=minData.peek() yaha comparison mein koi issue nhi aayega because java will dereference the object and will give the OG value
        if(minData.size()==0 || val<=minData.peek()){
            minData.push(val);
        }
    }
    
    public void pop() {
        // NOTE --> minData.peek() == allData.peek() isko use mat karo for comparing the values 
        // == --> Integer object return hota hai actual mein aur uske references compare hote hai naa ki actual values isiliye we have to use .equals method for dereferencing
        if(minData.peek().equals(allData.peek())){
            minData.pop();// ye pop() method work nhi kar raha h
        }
        allData.pop();
    }
    
    public int top() {
        return allData.peek();
    }
    
    public int getMin() {
        return minData.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
