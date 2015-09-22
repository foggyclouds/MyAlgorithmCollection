package hackerrank.dp.max_stock;


import java.util.Scanner;

/**
 * Created by RoySh on 9/16/2015.
 */
public class MaxStock2 {

    public static void main(String[] args) {
        Long[] p ;
        Scanner reader = new Scanner(System.in);

        Integer t = reader.nextInt();
        for(Integer y=0;y<t;y++) {
            Integer n = reader.nextInt();
            p = new Long[n];
            for (int i = 0; i < n; i++)
                p[i] = reader.nextLong();

            Long max = new Long(0);
            Long profit = new Long(0);
            Long st = new Long(0);
            Integer maxIndex = 0;
            //Integer n = p.length;

            for(Integer x = 0; x<p.length;) {
                for (Integer i = x; i < p.length; i++) {
                    if (p[i] > max) {
                        max = new Long(p[i]);
                        maxIndex = i;
                    }
                }

                if(maxIndex!=0) {
                    profit = profit + getProfit(p, x, maxIndex);
                    if(p.length == maxIndex+1 || p.length == maxIndex+2)
                        break;
                    x = maxIndex + 1;
                    max = new Long(0);
                }
                else {
                    max = new Long(0);
                    maxIndex = 0;
                    x = 1;
                }
            }

            System.out.println(profit);
        }
    }

    private static Long getProfit(Long[] p, Integer st, Integer end) {
        Integer max = 0, maxIndex = 0;
        Long profit = 0L;

        for(Integer i = st;i<end;i++) {
            profit = profit - p[i];
        }

        profit = profit + p[end]*(end-st);

        return profit;
    }
}
