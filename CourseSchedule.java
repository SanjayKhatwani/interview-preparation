public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomes = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>();
        initGraph(incomes, prerequisites, adjs);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < incomes.length; i++) {
            if (incomes[i] == 0) queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            visited++;
            for (int to : adjs.get(from)) {
                incomes[to]--;
                if (incomes[to] == 0)
                    queue.offer(to);
            }
        }
        return visited == numCourses;
    }
    
    private void initGraph(int[] incomes, int[][] prerequisites, List<List<Integer>> adjs) {
        for (int i = 0; i < incomes.length; i++) {
            adjs.add(new ArrayList<Integer>());
        }
        for (int[] pair : prerequisites) {
            incomes[pair[0]]++;
            adjs.get(pair[1]).add(pair[0]);
        }
    }
}