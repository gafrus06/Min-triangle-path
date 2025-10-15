package ru.funkids;

import java.util.*;

public class TriangleMinPathMemo {
    public static void main(String[] args) {
        List<List<Integer>> t = List.of(
                List.of(-1),
                List.of(2, 3),
                List.of(1, -1, -3),
                List.of(4, 2, 1, 3)
        );
        System.out.println(dfsMin(0, 0, t, new HashMap<>()));
    }

    static int dfsMin(int i, int j, List<List<Integer>> t, Map<Long,Integer> memo) {
        if (i == t.size() - 1) return t.get(i).get(j);
        long key = (((long)i) << 32) | j;
        Integer got = memo.get(key);
        if (got != null) return got;
        int me = t.get(i).get(j);
        int down = dfsMin(i + 1, j, t, memo);
        int right = dfsMin(i + 1, j + 1, t, memo);
        int ans = me + Math.min(down, right);
        memo.put(key, ans);
        return ans;
    }
}
