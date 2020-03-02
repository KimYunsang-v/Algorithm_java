# Comparator (비교 하기)

Java 에서 Arrays, Collections sort 메서드로 객체 비교하기


Arrays 또는 Collections 의 sort 메서드 호출 후 첫 번째 인자로 배열 또는 리스트 
두 번째 인자로 Comparator 인터페이스를 넘긴다.

Comparator 인터페이스의 compare 메소드를 오버라이드 한다.

리턴값이 참이면 그대로

거짓이면 자리 바꿈

<pre><code>
public class Main {

    public static void main(String[] args) {
        int N = 10;
        Fail[] fails = new Fail[N+1];

        Arrays.sort(fails, new Comparator< Fail>(){
            public int compare(Fail o1, Fail o2) {
                // 내림차순
                if(o1.rate != o2.rate){
                    return - Double.compare(o1.rate, o2.rate);
                }
                // 오름차순
                return o1.num - o2.num;
            }
        });

    }

    static class Fail {
        int num;
        double rate;
        public Fail(int num, double rate) {
            this.num = num;
            this.rate = rate;
        }
    }
}
</code> </pre>

