import java.util.Arrays;
import java.util.Arrays;
import java.util.Comparator;

public class nonOverLapingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals based on end times in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0; // Count of overlapping intervals
        int prevEnd = Integer.MIN_VALUE; // Previous interval's end time

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start < prevEnd) {
                // Overlapping interval found, remove the one with the larger end time
                count++;
                prevEnd = Math.min(prevEnd, end);
            } else {
                prevEnd = end;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        int minIntervalsToRemove = eraseOverlapIntervals(intervals);
        System.out.println("Minimum Intervals to Remove: " + minIntervalsToRemove);
    }
}

