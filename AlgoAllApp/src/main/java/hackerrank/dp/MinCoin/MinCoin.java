package hackerrank.dp.MinCoin;

/**
 * Created by RoySh on 9/17/2015.
 */
public class MinCoin {

    public static void main(String[] args) {
        Integer c[] = {2,1,3};
        Integer sum = 4;

        Integer s[] = new Integer[sum+1];
        Integer n = c.length;
        Integer d[][] = new Integer[n][sum+1];

        for(Integer i=0;i<sum+1;i++) {
            s[i] = Integer.MAX_VALUE;
            for(Integer j=0;j<n;j++) {
                d[j][i] = 0;
            }
        }

        s[0] = 0;

        for(Integer i=1;i<sum+1;i++) {
            for(Integer j=0;j<n;j++) {
                if(i>=c[j] && (s[i-c[j]]+1)<s[i]) {
                    s[i] = s[i-c[j]]+1;

                    System.out.println("i="+i+",j="+j+",s["+i+"]="+s[i]);

                    for(Integer k=0;k<n;k++) {
                        if(k==j)
                            d[k][i] = d[k][i-c[j]] + 1;
                        else
                            d[k][i] = d[k][i-c[j]];
                    }
                }
            }
        }

        System.out.println(s[sum]);
        for(Integer i=0;i<n;i++)
            System.out.print(d[i][sum] + ",");
        System.out.println();
    }
}
