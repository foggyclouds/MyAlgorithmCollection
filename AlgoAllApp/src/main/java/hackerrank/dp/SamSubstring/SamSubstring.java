package hackerrank.dp.SamSubstring;

/**
 * Created by RoySh on 9/20/2015.
 */
public class SamSubstring {
    public static void main(String[] args) {
        //Integer a[] = {3,5,4,2,7};
        Integer a[] = {1,2,3,8};
        Integer n = a.length;
        Integer[] fact = new Integer[n+1];
        fact[0]=1;

        Double dp[] = new Double[n+1];
        dp[n]=0d;

        for(Integer i=1;i<n+1;i++)
            fact[i] = fact[i-1]*i;

        for(Integer i=0;i<n+1;i++)
            System.out.println(fact[i]);

        n--;
        for(Integer i=n;i>-1;i--) {
            if(i==n)
                dp[i]=new Double(a[i]);
            else {
                dp[i] = 2 * dp[i + 1];
                for (Integer j = 0; j < n - i + 1; j++) {
                    dp[i] += fact[n - i] * a[i] * Math.pow(10, j) / fact[n - i - j] / fact[j];
                }
            }
        }

        //System.out.println(dp[0]);

        for(Integer i=0;i<n+1;i++)
            System.out.println(dp[i]);
    }
}
