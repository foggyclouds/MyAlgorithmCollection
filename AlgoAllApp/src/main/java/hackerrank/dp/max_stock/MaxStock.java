package hackerrank.dp.max_stock;


/**
 * Created by RoySh on 9/16/2015.
 */
public class MaxStock {

    public static void main(String[] args) {
        Integer[] p = {5,4,3,2,8};
        Integer max = 0, profit = 0;
        Integer st = 0;
        Integer maxIndex = 0;
        Integer n = p.length;

        for(Integer i=1;i<n;i++) {
            if(p[i-1]<=p[i]) {
                max = p[i];
                maxIndex = i;
            } else if(i!=1){
                System.out.println("max = "+max);
                for(int j=st;j<i-1;j++) {
                    profit = profit - p[j];
                }
                profit = profit + p[i-1]*(i-st-1);
                st = i;
                max = p[i];
                maxIndex = i;
            }
        }

        if(p[n-1]>=p[n-2]) {
            for(int j=st;j<n-1;j++) {
                profit = profit - p[j];
            }
            profit = profit + p[n-1]*(n-st-1);
        }

        System.out.println(profit);
    }
}
