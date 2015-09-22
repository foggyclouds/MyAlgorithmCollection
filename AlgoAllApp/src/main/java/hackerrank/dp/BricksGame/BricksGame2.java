package hackerrank.dp.BricksGame;


public class BricksGame2 {

    public static void main(String[] args) {
        Integer a[] = {5,6,8,9,2,99,4};
        //Integer stack[] = {5,6,8};

        Integer opt[] = {1,2,3};
        Integer n = a.length;
        Integer meSum = 0;
        Integer lastIndex = -1;

        for(Integer i=0;i<n;i++) {
            if(n-i<4) {
                meSum += a[i];
            } else {
                Integer t[] = new Integer[9];
                Integer min = Integer.MIN_VALUE;
                min = a[i]-a[i+1];
                min = a[i]-a[i+1]-a[i+2]>min?a[i]-a[i+1]-a[i+2]:min;
                t[2] = a[i]-a[i+1]-a[i+2]-a[i+3];

                t[3] = a[i]+a[i+1]-a[i+2];
                t[4] = a[i]+a[i+1]-a[i+2]-a[i+3];

                if(i+4>n)
                    t[5]=Integer.MAX_VALUE;
                else
                    t[5] = a[i]+a[i+1]-a[i+2]-a[i+3]-a[i+4];

                if(i+4>n)
                    t[6]=Integer.MAX_VALUE;
                else
                    t[6] = a[i]+a[i+1]+a[i+2]-a[i+4];

                if(i+4>n)
                    t[7]=Integer.MAX_VALUE;
                else
                    t[7] = a[i]+a[i+1]+a[i+2]-a[i+4]-a[i+5];

                if(i+4>n)
                    t[8]=Integer.MAX_VALUE;
                else
                    t[8] = a[i]+a[i+1]+a[i+2]-a[i+4]-a[i+6];

                Integer maxIndex = getMax(t);

                System.out.println(t[maxIndex]);

                meSum += a[maxIndex];
            }
        }

        System.out.println(meSum);
    }

    private static Integer getMax(Integer a[]) {
        Integer ind= -1;
        Integer max = Integer.MIN_VALUE;
        for(Integer i=0;i<a.length;i++) {
            if(a[i]>max) {
                max = a[i];
                ind = i;
            }
        }
        return ind;
    }
}
