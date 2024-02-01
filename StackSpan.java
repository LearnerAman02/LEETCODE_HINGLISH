// problem link --> https://leetcode.com/problems/online-stock-span/description/
// My Approach --> hum har ek din ka price ka span kitna hai uska track record rakhna hai means hume ek aisa problem solve krna hai jisme we have to store answer till that particular day
// since answer till a particular point/day chahiye than isiliye hum STACK DATA STRUCTURE ka use karenge
// now solving strategy --> hum har ek din ke price ko lenge and we will store in the stack , but uske pehle hum ye track rakhenge ki kya jo current day price hai woh greater than = stack ke peek par jo price hai usse
// if TRUE than hume woh peek value ka price span kitna tha usko hamare span value mein add krna hoga if woh peek value hamare hashmap mein hai ELSE simply agar current day price < stack.peek() than simply put (price,count) in hashmap
// and than finally uss din ka price value ko push kardo into the stack 
// hashmap ka extra space isiliye use kar rahe hai so that we can get the stock span value of the stock price which we are poping out
class StockSpanner {
    Stack<Integer> s;
    HashMap<Integer,Integer> hmap = new HashMap<>();// for storing the span value of each price

    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int count =1;// uss din pe toh woh price value hold karegi hi
        while(!s.isEmpty() && price>=s.peek()){
            int top = s.pop();
            if(hmap.containsKey(top)){
                count += hmap.get(top);
            }
        }
        hmap.put(price,count);
        s.push(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
