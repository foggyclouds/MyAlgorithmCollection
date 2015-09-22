package hackerrank.dp.coin_change;

/**
 * Created by RoySh on 9/17/2015.
 */
public class CoinChange3 {

    public static void main(String[] args) {
        Integer c[] = {1,2,5};
        Integer s = 10;

        Integer n = c.length;
        Integer w[][] = new Integer[n+1][s+1];

        for(Integer j=0;j<s+1;j++)
            w[0][j] = 0;

        for(Integer i=0;i<n+1;i++)
            w[i][0] = 1;

        for(Integer i=0;i<n;i++) {
            //System.out.print(c[i]+"--");
            for (Integer j = 1; j<s+1; j++) {
                if((j - c[i])>=0)
                    w[i + 1][j] = w[i][j] + w[i + 1][j-c[i]];
                else
                    w[i + 1][j] = w[i][j];

                //System.out.println("     w[" + (i + 1) + "][" + j + "]=" + w[i + 1][j] + ",");
            }
            //System.out.println("");
        }

        System.out.println(w[n][s]);
    }
}
