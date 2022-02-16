package by.sasnouski.array.service;

import java.util.ArrayList;
import java.util.List;

public class ConversionElementsByCondition {

    public static List<Double> addNumber(List<Double> srcArray, double number) {
        List<Double> rstArr = new ArrayList<>(List.copyOf(srcArray));
        for (int i = 0; i < srcArray.size(); i++) {
            rstArr.set(i, srcArray.get(i) + number);
        }
        return rstArr;
    }

    public static List<Double> subtractNumber(List<Double> srcArray, double number) {
        List<Double> rstArr = new ArrayList<>(List.copyOf(srcArray));
        for (int i = 0; i < srcArray.size(); i++) {
            rstArr.set(i, srcArray.get(i) - number);
        }
        return rstArr;
    }
}