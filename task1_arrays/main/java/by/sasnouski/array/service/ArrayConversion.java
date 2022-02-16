package by.sasnouski.array.service;

import java.util.ArrayList;
import java.util.List;

public class ArrayConversion {

    public List<Double> changeElements(List<Double> list, double newValue) {
        List<Double>rsltList=new ArrayList<>(list.size());

        for (Double nmb : list) {
            if (nmb == newValue) {
                rsltList.add(newValue);
            } else {
                rsltList.add(nmb);
            }
        }
        return rsltList;
    }
}