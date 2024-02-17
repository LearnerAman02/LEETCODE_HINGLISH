// pblm link --> https://leetcode.com/problems/furthest-building-you-can-reach/description/?envType=daily-question&envId=2024-02-17
// NOTE --> PriorityQueue hume by Default increasing order mein elements ko dequeue karke deta hai
// [2,6,3,1,0]
// ans --> [0,1,2,3,6]
// BRUTE FORCE --> Aap normally ye sochoge ki hum check karenge, nextBuildingHeight and currentBuildingHeight
// than if difference is <=0 than no need to use BRICK or LADDER
// but if difference >0 than we will have to use BRICK or LADDER
// NOTE --> Here the catch is that we have to identify cases so that BRICK and LADDER usage should be in such a way that maximum buildings can be covered
// Lets deeply understanf through this example
// [1,5,1,2,3,4,1000] --> bricks = 4, ladder = 1
//  i 
// diff = arr[i+1]-arr[i] and here diff is > 0 and suppose we use 4 bricks
// [1,5,1,2,3,4,1000] --> bricks = 0, ladder = 1
//    i 
// diff = arr[i+1]-arr[i]  and here diff is < 0 so no need to use BRICK/LADDER
// diff = arr[i+1]-arr[i] and here diff is > 0 and suppose we use 4 bricks
// [1,5,1,2,3,4,1000] --> bricks = 0, ladder = 1
//      i 
// diff = arr[i+1]-arr[i]  , diff = 1 and we have only one ladder so we will use it
// [1,5,1,2,3,4,1000] --> bricks = 0, ladder = 0
//      i 
// diff = arr[i+1]-arr[i]  , diff = 1 and since we don't have LADDER nor BRICK so we cannot climb to next bulding and return the index
// so we are only able to climb 3 buildings
// But now let us try other way
// [1,5,1,2,3,4,1000] --> bricks = 4, ladder = 1
//  i 
// diff = arr[i+1]-arr[i] and here diff is > 0 and store difference in a queue [4]
// and since queue ke andar abhi sirf ek element we can climb it using our ladder
// [1,5,1,2,3,4,1000] --> bricks = 4, ladder = 1
//    i 
// diff = arr[i+1]-arr[i] and here diff is < 0, so no need to put in queue and no need to use LADDER/BRICK
// [1,5,1,2,3,4,1000] --> bricks = 4, ladder = 1
//      i 
// diff = arr[i+1]-arr[i] and here diff is > 0 and store difference in a queue [4,1]
// now queue size is greater than number of ladders so ab hum check karenge ki hume brick use karna chahiye yaa actual mein we will have to use LADDER
// so hum poll karayenge element ko and check karenge can we use brick for that climb kyunki bahot chhote height ko climb karne ke liye we need to prioritize BRICK rather than LADDER
// so use brick is that smallest height in queue can be climbed using BRICK
// [1,5,1,2,3,4,1000] --> bricks = 3, ladder = 1
//        i 
// diff = arr[i+1]-arr[i] and here diff is > 0 and store difference in a queue [4,1]
// same logic, we will poll the element and since it is priority queue and queue.size > ladders , poll that element and subtract the no. of bricks
// [1,5,1,2,3,4,1000] --> bricks = 2, ladder = 1
//          i 
// diff = arr[i+1]-arr[i] and here diff is > 0 and store difference in a queue [4,1]
// same logic, we will poll the element and since it is priority queue and queue.size > ladders , poll that element and subtract the no. of bricks
// [1,5,1,2,3,4,1000] --> bricks = 1, ladder = 1
//            i 
// diff = arr[i+1]-arr[i] and here diff is = 996 and store difference in a queue [4,996]
// same logic, we will poll the element and since it is priority queue and queue.size > ladders , poll that element and subtract the no. of bricks
// now since no. of bricks < current requirement so iska matlab brick so we cannot climb this height and only remaining other element is [4] in the queue which will be climbed using ladder so now this is the final building we cannot climb further
// SO THE CONCLUSION IS -->
// Hum chhote heigts ko climb karenge using bricks and larger heights ko climb karenge using ladder after ensuring ki hamare paas ladders ho to climb
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                heap.offer(diff);
                if (heap.size() > ladders) {
                    bricks -= heap.poll();
                }
                if (bricks < 0) {
                    return i;
                }
            }
            System.out.println(heap);
        }
        return heights.length - 1;
    }
}
