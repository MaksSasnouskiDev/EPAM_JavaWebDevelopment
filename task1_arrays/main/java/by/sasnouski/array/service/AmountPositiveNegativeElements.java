package by.sasnouski.array.service;

import java.util.List;

public class AmountPositiveNegativeElements {

    public static int findAmountPositiveElements(List<Double> srcList) {
        int amount = 0;
        for (Double nmb : srcList) {
            if (nmb >= 0) {
                amount++;
            }
        }
        return amount;
    }

    public static int findAmountNegativeElements(List<Double> srcArray) {
        int amount = 0;
        for (Double nmb : srcArray) {
            if (nmb < 0) {
                amount++;
            }
        }
        return amount;
    }
}