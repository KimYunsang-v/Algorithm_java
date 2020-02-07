# n 진수 게임

문제 보기 : <https://programmers.co.kr/learn/courses/30/lessons/17687>

10 진수를 n 진수로 변형하는 문제


<pre><code>

public static String solution(int n, int t, int m, int p) {
        // 최대 16진법까지 변형하기 위한 숫자 리스트
        String[] number = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String answer = "";

        // 현재 플레이어
        int i = 1;
        // 현재 말 할 숫자
        int currentNum = 0;

        while(true) {
            // 현재 숫자를 n 진수로 변형한 숫자
            String tempStr = "";
            // 남은 숫자
            int remain = currentNum;
            while(true) {
                System.out.println(remain);
                // 나머지를 문자열에 추가
                tempStr += number[remain % n];
                // 문자열을 n으로 나눔
                remain /= n;
                // 남은 숫자가 0이면 변환 끝
                if(remain == 0) break;
            }
            // System.out.println("tempStr = " + tempStr);
            char[] charArray = tempStr.toCharArray();
            // 나머지를 추가한 문자열을 뒤집어야 하므로 뒤에서 부터 검사
            for (int i1 = charArray.length-1 ; i1 >=0; i1--) {
                // 플레이어 숫자를 넘어가면 첫번째 부터 시작
                if(i > m) i = 1;
                // 현재 튜브의 순서이면 숫자 추가
                if(i == p) answer += charArray[i1];
                // 튜브가 말할 글자수가 t이면 나가기
                if(answer.length() == t) break;
                i++;
            }
            currentNum++; 
            if(answer.length() == t) break;
        }
        // System.out.println(answer);
        return answer;
    }


</code></pre>
