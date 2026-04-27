// Detect in linked list
class Solution {
public:
    bool hasCycle(ListNode *head) {
      if(head == NULL) return false;
      map<ListNode*,bool> visited;
      ListNode*temp = head;
      while(temp != NULL){
        if(visited[temp]){
            return true;
        }
        visited[temp] = true;
        temp = temp -> next;
      }
      return false;
    }
};
