package hackerrank.dp.BricksGame;

import java.util.Scanner;

public class BricksGame4 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer tests = reader.nextInt();

        for(Integer x=0;x<tests;x++){
            Integer n = reader.nextInt();
            Integer a[] = new Integer[n];
            for(Integer y=0;y<n;y++)
                a[y]=reader.nextInt();

            Integer dp[][] = new Integer[n][n];

            for(Integer i=0;i<n;i++) {
                dp[i][i] = a[i];
                if(i+1<n)
                    dp[i][i+1]=a[i]+a[i+1];
                if(i+2<n)
                    dp[i][i+2]=a[i]+a[i+1]+a[i+2];
            }

            Integer k = 0;
            for(Integer i=n-4;i>-1;i--) {
                k++;
                for(Integer j=0;j<k;j++) {
                    Integer t = Math.max(a[i]+getSum(a,i+1,n-1-j)-dp[i+1][n-1-j]
                            ,a[i]+a[i+1]+getSum(a,i+2,n-1-j)-dp[i+2][n-1-j]);
                    t = Math.max(t,a[i]+a[i+1]+a[i+2]+getSum(a,i+3,n-1-j)-dp[i+3][n-1-j]);
                    dp[i][n-1-j] = t;
                }
            }

            /*for(Integer i=0;i<n;i++) {
                for (Integer j = 0; j < n; j++) {
                    System.out.print(dp[i][j] + ",");
                }
                System.out.println("");
            }*/

            System.out.println(dp[0][n-1]);
        }
    }

    private static Integer getSum(Integer a[],Integer st, Integer end) {
        Integer sum = 0;
        for(Integer i=st;i<end+1;i++) {
            sum += a[i];
        }
        return sum;
    }
}
