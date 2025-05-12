// Meeting Rooms III

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                long[] finished = busy.poll();
                available.offer((int) finished[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                busy.offer(new long[]{start + duration, room});
                count[room]++;
            } else {
                long[] earliest = busy.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                busy.offer(new long[]{newStart + duration, room});
                count[room]++;
            }
        }

        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
