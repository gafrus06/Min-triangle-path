package ru.funkids;

import java.util.List;


public class TriangleMinPathNaive {

    public static void main(String[] args) {
        List<List<Integer>> triangle1 = List.of(
                List.of(-1),
                List.of(2, 3),
                List.of(1, -1, -3),
                List.of(4, 2, 1, 3)
        );
        int answer = dfsMin(0, 0, triangle1);
        System.out.println(answer);
    }

    private static int dfsMin(int i, int j, List<List<Integer>> t) {
        int me = t.get(i).get(j);
        if (i == t.size() - 1) {
            return me;
        }
        int down = dfsMin(i + 1, j, t);
        int downRight = dfsMin(i + 1, j + 1, t);
        return me + Math.min(down, downRight);
    }

}
