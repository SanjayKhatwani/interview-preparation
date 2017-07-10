public class Solution {
    public int leastInterval(char[] tasks, int n) {

        if (tasks.length == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) 
            map.put(c, map.getOrDefault(c, 0) + 1);

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.addAll(map.values());

        int total = 0;
        int cycle = n + 1;
        Queue<Integer> coolDown = new LinkedList<>();

        while (!heap.isEmpty()) {
            int workTime = 0;
            for (int i = 0; i < cycle; i++) {
                if (!heap.isEmpty()) {
                    coolDown.add(heap.poll() - 1);
                    workTime++;
                }
            }
            while (!coolDown.isEmpty()) {
                int left = coolDown.poll();
                if (left > 0)
                    heap.add(left);
            }
            total += heap.isEmpty() ? workTime : cycle;
        }
        
        return total;
    }
}