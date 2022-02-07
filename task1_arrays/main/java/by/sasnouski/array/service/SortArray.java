package by.sasnouski.array.service;

public class SortArray {

    public static void sortArray1(double[] srcArray) {
        for (int i = 0; i < srcArray.length; i++) {
            int tempIndex = i;
            for (int j = i; j < srcArray.length; j++) {
                if (srcArray[tempIndex] > srcArray[j]) {
                    tempIndex = j;
                }
            }
            double tempNmb = srcArray[i];
            srcArray[i] = srcArray[tempIndex];
            srcArray[tempIndex] = tempNmb;
        }
    }

    public static void sortArray2(double[] srcArray) {
        for (int i = 0; i < srcArray.length; i++) {
            for (int j = i; j < srcArray.length - 1; j++) {
                if (srcArray[j] > srcArray[j + 1]) {
                    double tempNmb = srcArray[j];
                    srcArray[j] = srcArray[j + 1];
                    srcArray[j + 1] = tempNmb;
                }
            }
        }
    }

    public static void sortArray3(double[] srcArray) {
        boolean isSorted = false;
        double tempNmb;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < srcArray.length - 1; i++) {
                if (srcArray[i] > srcArray[i + 1]) {
                    isSorted = false;
                    tempNmb = srcArray[i];
                    srcArray[i] = srcArray[i + 1];
                    srcArray[i + 1] = tempNmb;
                }
            }
        }
    }
}