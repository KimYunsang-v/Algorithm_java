# CyclicRotation

An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

- class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


---

주어진 수 만큼 맨 뒤 인덱스를 맨 앞으로 옮기고 나머지 인덱스 쉬프트 라이트

( 배열 길이 ) - (배열 길이 % 횟수) 가 처음 시작 인덱스

새로운 배열에 하나씩 넣어준다

<pre><code>

public static int[] solution(int[] A, int K) {
        if(A.length == 0) return new int[0];

        int[] answer = new int[A.length];
        // 시작 인덱스 구하기
        int index = (A.length) - K % A.length;
        //시작 인덱스가 마지막이면 처음부터
        if(index >= A.length) index = 0;

        for (int i = 0; i < answer.length; i++) {
            answer[i] = A[index];
            index++;
            // 마지막까지 가면 처음부터
            if(index >= A.length) index = 0;
        }
        
        return answer;
        // write your code in Java SE 8
    }

</code></pre>