package by.sasnouski.array.service;

public class ConversionElementsByCondition {

    public static void addNumber(double[] srcArray,double number) {
        for (int i = 0; i < srcArray.length; i++) {
                srcArray[i]+=number;
        }
    }

    public static void subtractNumber(double[] srcArray,double number) {
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i]-=number;
        }
    }
}
