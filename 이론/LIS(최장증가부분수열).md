# LIS (Longest Increasing Subsequence) 알고리즘

1. 수가 증가하는 부분수열에서 가장 긴 길이를 찾는 알고리즘

ex) 수열 : 10 20 50 30 40 60 70 에서

10 20 30 40 60 70 이 가장 긴 증가 부분수열


<pre><code>

int[] d = new int[N];
        int max = 1;
        for (int i = 1; i < N; i++) {
            // 최소는 무조건 1이기 때문에
            d[i] = 1;

            // 현재값을 넣을지 말지를 결정
            // 때문에 0부터 현재 전까지 검사
            for (int j = 0; j < i; j++) {

                // 만약 넣을값이 이전값보다 크고
                // (현재 최대 길이)보다 (전 값에서 하나 추가 길이)가 길면 체인지
                if(line[i] > line[j] && d[i] < d[j]+1){
                    d[i] = d[j]+1;
                }
            }
        }

</code></pre>