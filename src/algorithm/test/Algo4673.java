package algorithm.test;

public class Algo4673 {
    public static void main(String[] args) {
        int n = 1;
        boolean[] isSelf = new boolean[10000];
        for(int i = 1; i < 10000; i++){
            int index = sumDigit(i);
            if (index < 10000)
                isSelf[index] = true;
        }
        for(int i = 1; i<10000; i++){
            if(isSelf[i] == false){
                System.out.println(i);
            }
        }
    }

    public static int sumDigit(int n){
        int result = n;
        while(n > 0){
            result += n % 10;
            n /= 10;
        }

        return result;
    }
}
