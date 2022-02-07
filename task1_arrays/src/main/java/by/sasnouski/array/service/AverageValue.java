package by.sasnouski.array.service;

public class AverageValue {

    public static double findAverageValue(Double[] srcArray) {
        double avrgRslt = 0;
        for (Double nmb : srcArray) {
            avrgRslt += nmb;
        }
        avrgRslt /= srcArray.length;

        return avrgRslt;
    }
}