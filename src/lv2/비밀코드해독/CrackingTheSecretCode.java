package lv2.비밀코드해독;

import java.util.ArrayList;
import java.util.List;

public class CrackingTheSecretCode {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    private int n;
    private int[][] q;
    private int[] ans;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        for(int i=1;i<=n-4;i++){
            list.add(i);
            answer+=pickNum(list);
            list.remove(0);
        }

        return answer;
    }

    public int pickNum(List<Integer> list) {
        if (list.size() == 5) {
            for (int i = 0; i < q.length; i++) {
                if (!compare(list, i)) {
                    return 0;
                }
            }
            return 1;
        }

        int cnt = 0;
        for (int i = list.get(list.size() - 1) + 1; i <= n; i++) {
            list.add(i);
            cnt += pickNum(list);
            list.remove(list.size() - 1);
        }

        return cnt;
    }

    public boolean compare(List<Integer> list, int idx) {
        int cnt = 0;
        for (int i : q[idx]) {
            if (list.contains(i)) {
                cnt++;
            }
        }
        return cnt == ans[idx];
    }
}

/**
 * 1. 5개 짜리 조합을 오름차순으로 만든다. 2. 모든 조합과 비교해서 가능한 지 확인한다. 가능하면 answer++; 3. 1,2를 반복한다.
 */
