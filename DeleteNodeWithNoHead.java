// problem link --> https://leetcode.com/problems/delete-node-in-a-linked-list/description/?envType=daily-question&envId=2024-05-05
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 LOGIC -->
 Hamara normal Approach kya ho sakta hai iss question ke liye -->
Agar maan lo ye meri linked list hai 1-->4-->5-->6-->8--->9--->0
Aur hume question mei given node hai NODE(6)

Toh hamara pehla intuition ye hota hai ki kaise bhi hume NODE 6 pe pehle waala node mil jaaye i.e. NODE 5
And than simply hum uss NODE 5 ko attach kara deta NODE 6 ke next node se and simply phir hamara NODE 6 delete ho jaata 

But iss approach mei issue ye hai ki hume HEAD OF LINKED LIST given nhi hai and uski wajah se hum NODE 5 tak (i.e. Node previous to given node) waha tak nhi reach kar paayenge hum

BUT CATCH OF THIS QUESTION IS --
Hume ye bola gaya hai ki zaroori nhi hai ki hum iss node ko memory se hi delete iska matlab
GIVEN LL --  1-->4-->5-->6-->8--->9--->0
NODE 6 deleted from Memory --  1-->4-->5-->8--->9--->0

So hume ye pata chal gaya hai ki pehla intuition toh fail hoga, but ab thoda BRAIN STORM karke sochte hai
Hume ye bola gaya ki (it is not necessary that u delete the node from the memory) so hamara approach ye rahega ki hum

OPTIMIZED APPROACH -
NEXT NODE KI VALUE KO CURRENT NODE MEIN PUT KARTE JAAYE, LAST NODE TAK REACH KARNE SE PEHLE AND THAN FINALLY LAST NODE KO DELETE KAR DE

                          N{given node}
| 1 |-->| 4 |-->| 5 |-->| 6 |-->| 8 |--->| 9 |--->| 0 |

CURRENT GIVEN NODE SE ITERATION START KARO AND USKE NEXT WALE NODE KI VALUE KO CURRENT NODE KE VALUE MEI PUT KARO

                          N{given node}
| 1 |-->| 4 |-->| 5 |-->| 8 |-->| 8 |--->| 9 |--->| 0 |

                          N{given node}
| 1 |-->| 4 |-->| 5 |-->| 8 |-->| 9 |--->| 9 |--->| 0 |

                          N{given node}
| 1 |-->| 4 |-->| 5 |-->| 8 |-->| 9 |--->| 0 |--->| 0 |

Ab dekho Last node ko chhor de toh phir second last node tak jo Linked List hai woh ye hai -- 1-->4-->5-->8--->9--->0
And yahi hamara required answer bhi hai
So just simply delete maar do ab LAST NODE ko
*/
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode ptr = temp;
        while(temp.next != null){
            temp.val = temp.next.val;
            temp = temp.next;
        }
        //ab just last node ko delete kardo
        while(ptr.next != null){
            if(ptr.next.next==null){
                ptr.next = null;
                break;
            }
            ptr = ptr.next;
        }
    }
}
