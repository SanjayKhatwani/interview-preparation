public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cycle = n + 1;
        int total = 0;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> cool = new LinkedList<>();
        pq.addAll(map.values());
        while (!pq.isEmpty()) {
            int workTime = 0;
            for (int i = 0; i < cycle; i++) {
                if (pq.isEmpty()) break;
                cool.add(pq.poll() - 1);
                workTime++;
            }
            for (int a : cool) {
                if (a > 0) pq.offer(a);
            }
            cool.clear();
            total += pq.isEmpty() ? workTime : cycle;
        }
        return total;
    }
}


public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;
        Arrays.sort(arr, (a, b) -> b - a);
        int i = 0;
        while (i < 26 && arr[i] == arr[0]) i++;
        int cycle = n + 1;
        return Math.max(tasks.length, cycle * (arr[0] - 1) + i);
    }
}