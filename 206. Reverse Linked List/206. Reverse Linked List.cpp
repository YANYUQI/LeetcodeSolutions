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
	ListNode* reverseList(ListNode* head) {
		if (head == NULL || head->next == NULL) return head;

		ListNode result(0);
		ListNode *cur = head;
		while (cur) {
			ListNode *next = cur->next;
			cur->next = result.next;
			result.next = cur;
			cur = next;
		}
		return result.next;
	}
};