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
        ListNode *i=l1,*j=l2;
        ListNode *answer=0,*list;
        list = new ListNode(0);
        int add=0,a,b,sum;
        while (i || j) {
            if (i) {
                a=i->val;
                i=i->next;
            }
            else    a=0;
            if (j) {
                b=j->val;
                j=j->next;
            }
            else    b=0;
            sum = a+b+add;
            if (sum>=10) {
                sum%=10;
                add=1;
            }
            else    add=0;
            list->next = new ListNode(sum);
            if (!answer)    answer=list->next; 
            list = list->next;
        }
        if (add)
            list->next = new ListNode(1);
        return answer;
    }
};
