package by.sasnouski.array.service;

public class AmountPositiveNegativeElements {

    public static int findAmountPositiveElements(Double[] srcArray) {
        int amount = 0;
        for (Double nmb : srcArray) {
            if (nmb >= 0) {
                amount++;
            }
        }
        return amount;
    }

    public static int findAmountNegativeElements(Double[] srcArray) {
        int amount = 0;
        for (Double nmb : srcArray) {
            if (nmb < 0) {
                amount++;
            }
        }
        return amount;
    }
}