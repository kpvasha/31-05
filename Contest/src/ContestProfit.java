/*
Максимальний прибуток зі змагань
Умова:
Дано n змагань. Кожне змагання має:
час початку start[i],
час закінчення end[i],
прибуток profit[i].
Потрібно вибрати набір неперетинаючихся змагань так, щоб максимізувати загальний прибуток.
 */
import java.util.Arrays;
import java.util.Comparator;

class Contest {
    int start;
    int end;
    int profit;

    public Contest(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class ContestProfit {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int[] profit = {50, 20, 100, 200, 150, 80};
        int n = start.length;

        Contest[] contests = new Contest[n];
        for (int i = 0; i < n; i++) {
            contests[i] = new Contest(start[i], end[i], profit[i]);
        }

        Arrays.sort(contests, Comparator.comparingInt(c -> c.end));

        int[] dp = new int[n];

        dp[0] = contests[0].profit;

        for (int i = 1; i < n; i++) {
            int profitWithoutCurrent = dp[i - 1];

            int profitWithCurrent = contests[i].profit;
            int lastCompatibleContestIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (contests[j].end <= contests[i].start) {
                    lastCompatibleContestIndex = j;
                    break;
                }
            }

            if (lastCompatibleContestIndex != -1) {
                profitWithCurrent += dp[lastCompatibleContestIndex];
            }

            dp[i] = Math.max(profitWithoutCurrent, profitWithCurrent);
        }

        System.out.println("Максимальний прибуток: " + dp[n - 1]);
    }
}