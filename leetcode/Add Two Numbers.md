# Add Two Numbers

문제 보기 : <https://leetcode.com/problems/add-two-numbers/>

접근

1. 연결리스트에 뒷자리부터 연결되어있다.
2. 두 연결리스트를 처음 노드부터 더해가면 됨

풀이 

1. 먼저 첫자리를 구한다.
2. while문을 돌면서 각 자릿수를 더해주고 올림수가 발생하면 올린다.
3. 마지막에 올림수가 있는지 확인 후 추가한다.

```
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int pre = 0;
            int temp = l1.val + l2.val;
            if(temp >= 10) {
                pre = 1;
                temp -= 10 ;
            }
            ListNode answer = new ListNode(temp);

            l1 = l1.next;
            l2 = l2.next;

            ListNode lastNode = answer;
            while(true){
                int l1Val = 0;
                int l2Val = 0;
                if(l1 == null && l2 == null) break;
                if(l1 != null) l1Val = l1.val;
                if(l2 != null) l2Val = l2.val;
                temp = l1Val + l2Val + pre;

                if(temp >= 10) {
                    pre = 1;
                    temp -= 10 ;
                } else {
                    pre = 0;
                }

                lastNode.next = new ListNode(temp);
                lastNode = lastNode.next;

                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }

            if(pre == 1) lastNode.next = new ListNode(1);
            return answer;
        }

```