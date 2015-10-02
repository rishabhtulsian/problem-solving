/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    	int carryover = 0;
    	ListNode* added = NULL;
    	ListNode* current = NULL;
        while(l1 != NULL || l2 != NULL) {
        	int sum = 0;
        	if(l1 != NULL) {
        		sum += l1->val;
        		l1 = l1->next;
    		}
    		if(l2 != NULL) {
    			sum += l2->val;
    			l2 = l2->next;
    		}
    		sum += carryover;

    		carryover = sum / 10;
    		sum -= carryover * 10;

        	if(current != NULL) {
        		current->next = new ListNode(sum);
        		current = current->next;
        	} else {
        		added = current = new ListNode(sum);
        	}
        }
        if(carryover > 0) {
        	current->next = new ListNode(carryover);
        }
        return added;
    }
};
