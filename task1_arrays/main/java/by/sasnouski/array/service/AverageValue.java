package by.sasnouski.array.service;

import java.util.List;

public class AverageValue {

    public static double findAverageValue(List<Double> srcArray) {
        double avrgRslt = 0;
        for (Double nmb : srcArray) {
            avrgRslt += nmb;
        }
        avrgRslt /= srcArray.size();

        return avrgRslt;
    }
}