# Longest Substring Without Repeating Characters

문제 보기 : <https://leetcode.com/problems/longest-substring-without-repeating-characters/>

## 접근 

1. 각 위치에서 중복없이 가장 긴 문자열 찾으면 된다.

## 풀이 



1. 2중 for문을 사용해서 현재 인덱스부터 set에 넣는다.
2. set에 이미 있는 값이 나오면 중복이므로 현재 set size가 중복 없이 만들 수 있는 문자열이다.
3. set size 중 가장 큰 값을 찾는다.



## 코드

```
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();

        Set<Character> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                if(!set.contains(charArray[j])){
                    set.add(charArray[j]);
                } else {
                    break;
                }
            }
            answer = Math.max(answer, set.size());
            set = new HashSet<>();
        }
        return answer;
    }
}
```