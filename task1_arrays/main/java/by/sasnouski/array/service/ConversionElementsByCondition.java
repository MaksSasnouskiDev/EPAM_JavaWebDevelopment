package by.sasnouski.array.service;

public class ConversionElementsByCondition {

    public static Double[] addNumber(Double[] srcArray, double number) {
        Double[] rstArr = new Double[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            rstArr[i] = srcArray[i] + number;
        }
        return rstArr;
    }

    public static Double[] subtractNumber(Double[] srcArray, double number) {
        Double[] rstArr = new Double[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            rstArr[i] = srcArray[i] + number;
        }
        return rstArr;
    }
}
