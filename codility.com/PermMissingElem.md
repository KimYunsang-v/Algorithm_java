# Perm Missing Elem

An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5

the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];

the elements of A are all distinct;

each element of array A is an integer within the range [1..(N + 1)].

---

1 ~ (n+1) 까지 있는 배열에서 누락된 번호 찾기

<pre><code>

public static int solution(int[] A) {
        int answer = 1;
        Arrays.sort(A);
        boolean check = false;
        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1){
                answer = i + 1;
                check = true;
                break;
            }
        }

        // 누락된 번호가 마지막일 경우
        if(!check) return A.length + 1;
        else return answer;
    }


</code></pre>