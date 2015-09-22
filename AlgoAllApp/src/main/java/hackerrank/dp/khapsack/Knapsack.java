package hackerrank.dp.khapsack;

/**
 * Created by RoySh on 9/18/2015.
 */
public class Knapsack {

    public static void main(String[] args) {
        Integer a[] = {3, 3, 3, 3, 3, 3};
        Integer sum = 8;

        /*Integer a[] = {5};
        Integer sum = 6;*/

        Integer c[] = new Integer[sum+1];
        c[0] = 1;

        Integer lastSum = 0;

        for(Integer i=1;i<sum+1;i++) {
            for(Integer j=0;j<a.length;j++) {
                if(i<a[j])
                    c[i]=0;
                else if(c[i-a[j]]>0){
                    lastSum = i;
                    c[i]=1;
                    break;
                } else {
                    c[i]=0;
                }
            }
        }

        System.out.println(lastSum);
    }
}
