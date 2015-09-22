package hackerrank.dp.equal_chocolates;

import java.util.Arrays;

public class EqualChoco {

    public static void main(String[] args) {
        System.out.println(getCount(2, 2));

        Integer c[]={5,3,6,2};
        Integer digits[] = {5,2,1};
        Arrays.sort(c); // n*log(n)

        for(Integer i=0;i<c.length;i++) {

        }


    }

    public static Integer getCount(Integer a, Integer b) {
        if(a>b) {
            Integer t = a;
            b = a;
            a = b;
        }
        Integer c = 0;
        Integer r=b-a;
        Integer digits[] = {5,2,1};

        for(Integer i=0;i<digits.length && r>0;i++) {
            if (r/digits[i] > 0) {
                Integer q = r/digits[i];
                c += q;
                r = r%digits[i];
            }
        }

        return c;
    }
}
