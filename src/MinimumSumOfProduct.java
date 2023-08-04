import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumSumOfProduct {

    public  static int findMinSum(int[] a,int[] b,int k){
        int sumOfProduct=0;

        for (int i = 0; i < a.length; i++) {
            sumOfProduct += a[i] * b[i];
        }

        int minSumOfProduct=sumOfProduct;

        for (int i = 0; i < a.length; i++) {
            int newElement;
            if (b[i]<0){
                newElement=a[i]+2*k;
            }
            else{
                newElement=a[i]-2*k;
            }

            int newSumOfProduct=sumOfProduct - a[i] * b[i]
                    + newElement * b[i];

            minSumOfProduct=Math.min(minSumOfProduct,newSumOfProduct);
        }

        return minSumOfProduct;
    }
    public static void main(String[] args) {
        int[] a={2, 3, 4, 5, 4};
        int[] b={3, 4, 2, 3, 2};
        int k=3;

        int minSum=findMinSum(a,b,k);
        System.out.println("Minimum sum:"+minSum);
    }
}
