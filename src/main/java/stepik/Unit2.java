package stepik;

import java.util.Arrays;

public class Unit2 {
    public static void main(String[] args) {
        int [] arr1 =  {-90,1,8,10};
        int [] arr2 =  {-65, 100};
        System.out.println(Arrays.toString(mergeSort(arr1,arr2)));
    }
    public static int[] unitSort(int [] arr1, int [] arr2){
        int [] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        Arrays.sort(result);
        return result;
    }
    //если предположить что входные массивы изначально отсортированы по возрастанию
    public static int[] mergeSort(int[] a1, int[] a2) {
        int n = a1.length + a2.length;
        int[] arr = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == a1.length) {
                arr[i] = a2[i2++];
            } else if (i2 == a2.length) {
                arr[i] = a1[i1++];
            } else {
                if (a1[i1] < a2[i2]) {
                    arr[i] = a1[i1++];
                } else {
                    arr[i] = a2[i2++];
                }
            }
        }
        return arr;
    }
    public static int [] mergeSort(int [] arr1){
        // условие выхода из рекурсии
        if(arr1.length == 1){
            return arr1;
        }
        int entry = arr1.length;
        int [] result = new int[entry];
        int middle = entry/2;
        int [] beforeMiddle = mergeSort(Arrays.copyOfRange(arr1,0,middle));
        int [] afterMiddle  = mergeSort(Arrays.copyOfRange(arr1,middle,arr1.length));

        int iBefore = 0;
        int iAfter = 0;
        int counter = 0;

        while(counter < entry){
            if(iAfter == afterMiddle.length){
                result[counter++] = beforeMiddle[iBefore++];
            }else if(iBefore == beforeMiddle.length){
                result[counter++] = afterMiddle[iAfter++];
            }else{
                result[counter++] = beforeMiddle[iBefore]< afterMiddle[iAfter] ? beforeMiddle[iBefore++] : afterMiddle[iAfter++];
            }
        }
        return result;
    }
}

