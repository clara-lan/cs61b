package src;
import java.util.Arrays;
/**Exercise before classes, following https://sp18.datastructur.es/materials/hw/hw0/hw0.html*/
// find max in an array
//public class Triangles {
//
//   public static int max(int[] x) {
//        int maxValue = x[0];
//        for(int i : x) {
//            maxValue = Math.max(maxValue, i);
//        }
//        return maxValue;
//   }
//
//    public static void main(String[] args) {
//        int[] numbers = new int[]{9,2,5,12,3,8};
//        System.out.println(max(numbers));
//    }
//
//}

/**use a while loop to sum an array */
//public class Triangles{
//    public static int whileSum(int[] a){
//        int i = 0;
//        int sum = 0;
//        while (i < a.length){
//            sum += a[i];
//            i += 1;
//        }
//        return sum;
//    }
//
//    public static void main(String[] args){
//        int[] a = new int[]{1,2,3,4,5};
//        System.out.println(whileSum(a));
//    }
//}

/**exercise 3 */
//public class Triangles{
//    public static int forMax(int[] a){
//        int max = a[0];
//        for (int i= 0; i < a.length; i++){
//           max = Math.max(max, a[i]);
//        }
//        return max;
//    }
//
//    public static void main(String[] args){
//        int[] a = new int[]{1,2,32,3,4,5,20};
//        System.out.println(forMax(a));
//    }
//}

/**BREAK and CONTINUE*/
//public class Triangles{
//    public static void main(String[] args){
//        String[] a = {"cat", "dog", "laser horse","ketchup", "horse", "horbse"};
//        for (int i = 0; i < a.length; i += 1){
//            if(a[i].contains("horse")){
//                continue;
//            }
//            for (int j = 0; j<3; j += 1 ){
//                System.out.println((a[i]));
//            }
//        }
//    }
//}

/**EXERCISE 4*/
public class Triangles{
    public static void windowPosSum1(int[] a, int n) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] < 0) continue;
            for(int j = 1; j <= n && i+j < a.length; j++) {
                a[i] += a[i+j];
            }
        }
    }

    /**public static void, void must not to return*/
    public static void windowPosSum(int[] a, int n){
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            sum += a[i];
        }
        int[] b = new int[a.length];

        for(int i=0; i<a.length; i++){
            b[i] = a[i] < 0 ? sum : a[i];
            sum -= a[i];
            if(i+n+1 < a.length) sum += a[i+n+1];
        }

        for(int i = 0; i < a.length; i++) a[i] = b[i];
    }

    public static void main(String[] args){
        int[] a = new int[]{1,2,-3,4,5,4};
        int n = 3;
        windowPosSum(a, n);
        System.out.println(Arrays.toString(a));
    }
}