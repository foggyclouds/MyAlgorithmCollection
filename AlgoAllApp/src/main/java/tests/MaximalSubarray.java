package tests;



public class MaximalSubarray {

    public static void main(String[] args) {

        //int[] arr = {-1,3,-5,4,6,-1,2,-7,13,-3};
        int[] arr = {4,-2,-4,5};

        int[] result = findMaxSumIndex(arr);
        System.out.println("start index :"+result[0]);
        System.out.println("End index :"+result[1]);
        System.out.println("Sum :"+result[2]);

    }

    private static int[] findMaxSumIndex(int[] arr){
        int[] result = new int[3];
        int maxSumTillNow = Integer.MIN_VALUE;

        int tempStartIndex = 0;
        int tempSum = 0;

        for (int i = 0; i < arr.length; i++) {
            tempSum = tempSum + arr[i];

            if(tempSum > maxSumTillNow){
                maxSumTillNow = tempSum;
                result[0] = tempStartIndex;
                result[1] = i;
                result[2] = maxSumTillNow;
            }

            if(tempSum<0){
                tempSum = 0;
                tempStartIndex = i + 1;
            }
        }
        return result;
    }
}