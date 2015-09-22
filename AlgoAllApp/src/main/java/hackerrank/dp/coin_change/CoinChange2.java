package hackerrank.dp.coin_change;

import java.util.Scanner;

/**
 * Created by RoySh on 9/16/2015.
 */
public class CoinChange2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer s = reader.nextInt();
        Integer m = reader.nextInt();
        Integer[] coins = new Integer[m];
        for(Integer i=0;i<m;i++)
            coins[i]=reader.nextInt();

        Long[][] val = new Long[coins.length][s+1];

        for(int i=0;i<coins.length;i++) {
            val[i][0]=new Long(1);
        }

        for(int i=0;i<s+1;i++) {
            val[0][i] = i%coins[0]==0?new Long(1):new Long(0);
        }

        for(int i=1;i<coins.length;i++) {
            for(int j=1;j<s+1;j++) {
                if(j>=coins[i]) {
                    val[i][j] = val[i-1][j]+val[i][j-coins[i]];
                } else {
                    val[i][j] = val[i-1][j];
                }
            }
        }

        System.out.println(val[coins.length-1][s]);
        /*for(int i=0;i<coins.length;i++) {
            for(int j=0;j<s+1;j++) {
                System.out.print(val[i][j]+",");
            }
            System.out.println();
        }*/

    }
}
