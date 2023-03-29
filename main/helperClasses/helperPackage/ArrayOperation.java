package helperPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class ArrayOperation {
    /**
     * Split a string into an 1D array of string
     * @param stringToSplit string to be splitted
     * @param separator to split string
     * @return splitted String array
     */
    public static String[] splitStringToArray(String stringToSplit, String separator){
        String[] result = stringToSplit.split(separator);
        return result;
    }

    /**
     * ONLY WORKS FOR REFERENCE TYPE
     * Print 1D array of any type to the console for DEBUG
     * @param arrayToPrint 1D array to be printed
     * @param <T> array type
     */
    public static <T> void print1DArray(T[] arrayToPrint){
        for(T elem:arrayToPrint){
            System.out.print(elem + " ");
        }
    }
    /**
     * ONLY WORKS FOR REFERENCE TYPE
     * Print 2D array of any type to the console for DEBUG
     * @param arrayToPrint 2D array to be printed
     * @param <T> array type
     */
    public static <T> void print2DArray(T[][] arrayToPrint){
        for(T[] elem:arrayToPrint){
            StringBuilder sb = new StringBuilder();
            for(T element:elem){
                sb.append(element);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }

    /**
     * ONLY WORKS FOR REFERENCE TYPE
     * Convert an array of one type A to another type B.
     * @param arrA array of type A to be converted
     * @param converter convert function
     * @return an array which has the same number of elements as arrA, but in type B
     * @param <A> type of the to be converted array
     * @param <B> type of the converted array
     */
    public static <A, B> B[] convertArray(A[] arrA, B[] arrB, Function<A, B> converter) {

        for (int i = 0; i < arrA.length; i++) {
            arrB[i] = converter.apply(arrA[i]); // apply the converter function to each element in the original array
        }

        return arrB; // return the new array of type B
    }

    public static int[] convertIntegerArrayToIntArray (Integer[] integerArray){
         return Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
    }

    public static double[] convertDoubleArrayTodoubleArray (Double[] doubleArray){
        return Arrays.stream(doubleArray).mapToDouble(Double::doubleValue).toArray();
    }

    public static Integer[] convertIntArrayToIntegerArray(int[] intArray){
        return Arrays.stream(intArray).boxed().toArray(Integer[]::new);
    }

    public static Double[] convertdoubleArrayToDoubleArray(double[] doubleArray){
        return Arrays.stream(doubleArray).boxed().toArray(Double[]::new);
    }




    public static void main(String[] args) {
        Integer[] intArray = new Integer[3];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        System.out.println(convertIntArrayToIntegerArray(convertIntegerArrayToIntArray(intArray)).getClass());
    }

}
