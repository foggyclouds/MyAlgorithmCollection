package hackerrank.dp.MinCoin;

public class MinCoin3 {

    public static void main(String[] args) {
        Integer c[] = {2,5};
        Integer n = c.length;
        Integer s = 8;

        Integer dp[] = new Integer[s+1];
        for(Integer i=1;i<s+1;i++)
            dp[i]=Integer.MAX_VALUE;
        dp[0]=0;

        for(Integer i=1;i<s+1;i++) {
            for(Integer j=0;j<n;j++) {
                if(i<c[j])
                    dp[i]=dp[i]==Integer.MAX_VALUE?0:dp[i]==0?0:dp[i];
                else if(i>c[j])
                    dp[i]=dp[i-c[j]]==0?0:Math.min(dp[i],1+dp[i-c[j]]);
                else
                    dp[i]=Math.min(dp[i]==0?Integer.MAX_VALUE:dp[i], 1 + dp[i - c[j]]);

                System.out.println("i="+i+",c[j]="+c[j]+",dp["+i+"]="+dp[i]);
            }
        }

        System.out.println(dp[s]);
    }
}
