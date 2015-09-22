package hackerrank.dp.BricksGame;

// Working DP Solution

public class BricksGame5 {

    public static void main(String[] args) {
        //Integer a[] = {5,6,8,9,2,99,4};
        Integer a[] = {0,1,1,1,999};
        Integer n = a.length;
        Integer sum = 0;

        Integer dp[][] = new Integer[n+1][n+1];

        for(Integer i=0;i<n;i++) {
            dp[i][i] = a[i];
            if(i+1<n)
                dp[i][i+1]=a[i]+a[i+1];
            if(i+2<n)
                dp[i][i+2]=a[i]+a[i+1]+a[i+2];
        }

        for(Integer i=0;i<n;i++) {
            for (Integer j = 0; j < n; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println("");
        }

        Integer k = 0;
        for(Integer i=n-4;i>-1;i--) {
            k++;
            for(Integer j=0;j<k;j++) {

                System.out.println("i="+i+"(n-1-j)="+(n-1-j));
                Integer t = Math.max(a[i]+getSum(a,i+1,n-1-j)-dp[i+1][n-1-j]
                                    ,a[i]+a[i+1]+getSum(a,i+2,n-1-j)-dp[i+2][n-1-j]);
                t = Math.max(t,a[i]+a[i+1]+a[i+2]+getSum(a,i+3,n-1-j)-dp[i+3][n-1-j]);
                dp[i][n-1-j] = t;
            }
        }

        for(Integer i=0;i<n;i++) {
            for (Integer j = 0; j < n; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println("");
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
