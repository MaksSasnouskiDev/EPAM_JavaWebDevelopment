package by.sasnouski.array.service;

public class MinMaxValue {

    public static double maxValue(double[] srcArray) {
        double maxVal = Double.MIN_VALUE;
        for (int i = 0; i < srcArray.length - 1; i++) {
            double tempNmb = Math.max(srcArray[i], srcArray[i + 1]);

            if (maxVal < tempNmb) {
                maxVal = tempNmb;
            }
        }
        return maxVal;
    }

    public static double minValue(double[] srcArray) {
        double minVal = Double.MAX_VALUE;
        for (int i = 0; i < srcArray.length - 1; i++) {
            double tempNmb = Math.min(srcArray[i], srcArray[i + 1]);

            if (minVal > tempNmb) {
                minVal = tempNmb;
            }
        }
        return minVal;
    }
}