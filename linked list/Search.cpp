#linked list / Search.cpp
class Solution {
public:
    bool searchKey(ListNode* head, int key) {
        // Your code goes here
        ListNode*temp = head;
        while(temp != NULL){
            if (temp->val == key){
            return true;
            }
            temp = temp-> next;
        }
        return false;
    }
   
};
