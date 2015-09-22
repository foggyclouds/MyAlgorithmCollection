package hackerrank.graphs.clique;

import java.util.Scanner;

public class Clique {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer tests = reader.nextInt();
        Long[] output = new Long[tests];
        for(Integer i = 1;i<tests+1;i++) {
            Integer n = reader.nextInt();
            Integer m = reader.nextInt();

            /*Double d = n*n/(n*n-2.0*m);
            System.out.println(d.toString());
            if(d> (double) d.longValue())
                output[i-1] = d.longValue()+1;
            else
                output[i-1] = d.longValue();*/

            boolean notFound=true;
            Long min = new Long(2);
            Long max = new Long(n);

            while(notFound) {
                Long x = (min + max)/2;
                double ceilnx = Math.floor(n/x)+1;
                double floornx = Math.floor(n/x);
                Double fn = ((n*n - (n%x)*ceilnx*ceilnx) - (x-(n%x))*floornx*floornx)/2;
                //System.out.println("TC "+i+"--> "+"x="+x+", fn="+fn +", min="+min+", max="+max);

                if(fn.longValue()>m) {
                    max=x-1;
                } else if(fn.longValue()<m) {
                    min = x+1;
                } else {
                    notFound = false;
                    output[i-1] = new Long(x);
                }

                if(min>=max) {
                    fn = ((n*n - (n%x)*ceilnx*ceilnx) - (x-(n%x))*floornx*floornx)/2;
                    //System.out.println("TC "+i+"--> "+"x="+x+", fn="+fn +", min="+min+", max="+max);
                    if(fn<=m)
                        output[i-1] = new Long(x+1);
                    else
                        output[i-1] = new Long(x);
                    notFound = false;
                }

            }
        }

        for(Integer i = 0;i<tests;i++) {
            System.out.println(output[i]);
        }
    }
}
