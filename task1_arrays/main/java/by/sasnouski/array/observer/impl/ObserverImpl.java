package by.sasnouski.array.observer.impl;

import by.sasnouski.array.entity.ArrayProperties;
import by.sasnouski.array.entity.ListsOfNumbers;
import by.sasnouski.array.entity.Warehouse;
import by.sasnouski.array.observer.ArrayEvent;
import by.sasnouski.array.observer.Observer;
import by.sasnouski.array.service.AverageValue;
import by.sasnouski.array.service.MinMaxValue;
import by.sasnouski.array.service.SumOfElements;

import java.util.List;

public class ObserverImpl implements Observer {
    @Override
    public void parameterChanged(ArrayEvent arrayEvent)  {
        ListsOfNumbers listsOfNumbers = arrayEvent.getSource();
        List<Double> list=listsOfNumbers.getOneListByIndex(1);
        Warehouse wareHouse = Warehouse.getInstance();
        ArrayProperties arrayProperties = wareHouse.getByID(1);

        double sum = SumOfElements.findSum(list);
        double average = AverageValue.findAverageValue(list);
        double min = MinMaxValue.minValue(list);
        double max = MinMaxValue.maxValue(list);
        arrayProperties.setSumElements(sum);
        arrayProperties.setAverageValue(average);
        arrayProperties.setMinElement(min);
        arrayProperties.setMaxValue(max);

    }

}
