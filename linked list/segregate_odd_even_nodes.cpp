class Solution {
public:
    ListNode* oddEvenList(ListNode* &head) {

        if(head == NULL)
            return NULL;

        ListNode* oddH = NULL;
        ListNode* oddT = NULL;

        ListNode* evenH = NULL;
        ListNode* evenT = NULL;

        int temp = 1;

        while(head != NULL){

            if(temp % 2 == 0){

                if(evenH == NULL){
                    evenH = head;
                    evenT = head;
                }
                else{
                    evenT->next = head;
                    evenT = evenT->next;
                }

            }
            else{

                if(oddH == NULL){
                    oddH = head;
                    oddT = head;
                }
                else{
                    oddT->next = head;
                    oddT = oddT->next;
                }
            }

            head = head->next;
            temp++;
        }

        if(evenT != NULL)
            evenT->next = NULL;

        if(oddT != NULL)
            oddT->next = evenH;

        return oddH;
    }
};
