# 1759번 암호 만들기

문제 보기 : <https://www.acmicpc.net/problem/1759>

<pre><code>

import java.util.*;
import java.io.*;

class Main {
    static int stoi(String s) {return Integer.parseInt(s);}

    static int L;
    static int C;
    static char[] alpha;
    static List< String> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = stoi(st.nextToken());
        C = stoi(st.nextToken());
        alpha = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        answer = new ArrayList<>();

        // 오름차순
        Arrays.sort(alpha);

        for (int i = 0; i < alpha.length; i++) {
            if(C - i < L) break;
            dfs(alpha[i] + "", i+1);
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }

    static void dfs(String key, int depth){
        if(key.length() == L) {
            String temp = "aeiou";
            int vowel = 0, consonant = 0;
            for (int i = 0; i < key.length(); i++) {
                if (temp.contains(key.charAt(i) + "")) vowel++;
                else consonant++;
            }
            // 자음 1개 이상 모음 2개 이상 조건 만족 시 정답 추가
            if(vowel >= 1 && consonant >= 2) answer.add(key);
            return;
        } else {
            for (int i = depth; i < C; i++) {
                if(C - i < L - key.length()) return;
                dfs(key + alpha[i], i+1);
            }
        }
    }
}


</code></pre>