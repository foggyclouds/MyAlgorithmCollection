package hackerrank.dp.BricksGame;

import java.util.Arrays;
import java.util.Scanner;

public class BricksGame6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer tests = reader.nextInt();

        for(Integer t=0;t<tests;t++) {
            Integer n = reader.nextInt();
            Long b[] = new Long[n];
            for(Integer y=0;y<n;y++)
                b[y]=reader.nextLong();

            //Long b[] = {5,7,8,9,2,99};
            //Long b[] = {0, 1, 1, 1, 999};
            //Integer n = b.length;

            Long dp[] = new Long[n];
            Arrays.fill(dp, Long.MIN_VALUE);

            Long s[] = new Long[n];
            s[n - 1] = b[n - 1];

            for (Integer i = n - 2; i > -1; i--)
                s[i] = s[i + 1] + b[i];

            for (Integer i = n - 1; i > -1; i--) {
                if (i == n - 1)
                    dp[i] = b[i];
                else if (i == n - 2)
                    dp[i] = b[i] + b[i + 1];
                else if (i == n - 3)
                    dp[i] = b[i] + b[i + 1] + b[i + 2];
                else {
                    dp[i] = Math.max(b[i] + s[i + 1] - dp[i + 1], b[i] + b[i + 1] + s[i + 2] - dp[i + 2]);
                    dp[i] = Math.max(dp[i], b[i] + b[i + 1] + b[i + 2] + s[i + 3] - dp[i + 3]);
                }
            }

            System.out.println(dp[0]);
        }
    }
}
