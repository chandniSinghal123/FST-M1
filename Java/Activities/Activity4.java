import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args){
        int[] arr = {3,2,4,1};
        System.out.println("Array before sorting is: "+Arrays.toString(arr));
        for (int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while (j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                --j;
            }
            arr[j+1]=key;
        }
        System.out.println("Array after sorting is: "+Arrays.toString(arr));
    }
}
