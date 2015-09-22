package hackerrank.dp.coin_change;

import java.util.Scanner;

public class CoinChange4 {

    /*public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer s = reader.nextInt();
        Integer n = reader.nextInt();
        Integer[] c = new Integer[n];
        for(Integer i=0;i<n;i++)
            c[i]=reader.nextInt();

        Long w[][] = new Long[n+1][s+1];

        for(Integer j=0;j<s+1;j++)
            w[0][j] = 0L;

        for(Integer i=0;i<n+1;i++)
            w[i][0] = 1L;

        for(Integer i=0;i<n;i++) {
            for (Integer j = 1; j<s+1; j++) {
                if((j - c[i])>=0)
                    w[i + 1][j] = w[i][j] + w[i + 1][j-new Integer(c[i])];
                else
                    w[i + 1][j] = w[i][j];
            }
        }

        System.out.println(w[n][s]);
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String line= in.nextLine();
        int amt = 10;
        //String[] nums = line.split(",");
        int[] coins = {5,2,1};
        /*for(int i = 0; i < nums.length; i++){
            coins[i] = Integer.parseInt(nums[i].trim());
        }*/
        int[] ways = new int[amt+1];
        for(int i = 0; i <= amt; i++)
            ways[i] = 0;
        ways[0] = 1;
        for(int i = 0; i < coins.length; i++)
            for(int j = coins[i]; j <= amt; j++) {
                System.out.print("i="+i+",j="+j+"");
                ways[j] += ways[j - coins[i]];
                System.out.println("ways["+j+"]="+ways[j]);
            }
        System.out.println(ways[amt]);
    }
}
