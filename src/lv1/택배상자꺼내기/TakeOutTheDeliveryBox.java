package lv1.택배상자꺼내기;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        while(true){
            if(getUpperBoxNumber(num, w) > n)
                break;
            answer++;
            num = getUpperBoxNumber(num, w);
        }
        return answer + 1;
    }

    public int getUpperBoxNumber(int selfBoxNumber, int w) {
        if (selfBoxNumber % w == 0){
            return selfBoxNumber + 1;
        }
        return selfBoxNumber + (w - (selfBoxNumber % w)) * 2 + 1;
    }
}

public class TakeOutTheDeliveryBox {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(13,3,6));
    }
}
