package stepik;

import java.util.Arrays;

public class Unit2 {
    public static void main(String[] args) {
        int [] arr1 =  {250,1,0,8,-99};
        int [] arr2 =  {1};
        System.out.println(Arrays.toString(unitSort(arr1,arr2)));
    }
    public static int[] unitSort(int [] arr1, int [] arr2){
        int [] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return mergeSort(result);
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

