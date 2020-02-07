# 2 x n 타일링

문제보기 : <https://programmers.co.kr/learn/courses/30/lessons/12900>

피보나치 수열을 사용하여 문제 풀기

자바에서 재귀함수를 사용하면 시간초과가 나기 때문에

반복문으로 문제 풀이

<pre><code>

public static int solution(int n) {
        int answer = 0;
        int num1 = 1;
        int num2 = 2;
        
        int i = 3;
        while(i < n){
            answer = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = answer;
            i++;
        }

        answer = (num1 + num2) % 1000000007;

        return answer;
    }

</code></pre>

