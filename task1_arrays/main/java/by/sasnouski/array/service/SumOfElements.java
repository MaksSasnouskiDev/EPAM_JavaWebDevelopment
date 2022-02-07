package by.sasnouski.array.service;

public class SumOfElements {

    public static double findSum(Double[] srcArray) {
        double rsltSum = 0;
        for (Double nmb : srcArray) {
            rsltSum += nmb;
        }
        return rsltSum;
    }
}