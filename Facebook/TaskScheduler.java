public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[25];
        for (char c : tasks) arr[c - 'A']++;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : arr) {
            if (a > 0) pq.offer(a);
        }
        List<Integer> coolDown = new LinkedList<>();
        int total = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int workTime = 0;
            for (int i = 0; i < cycle; i++) {
                if (pq.isEmpty()) break;
                coolDown.add(pq.poll() - 1);
                workTime++;
            }
            for (int num : coolDown) {
                if (num > 0) pq.offer(num);
            }
            coolDown.clear();
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