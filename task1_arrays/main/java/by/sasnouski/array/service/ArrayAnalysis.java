package by.sasnouski.array.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArrayAnalysis {

    private static final Logger logger = LogManager.getLogger();

    public double averageValue(List<Double>srcList) {
        if (srcList==null){
            logger.log(Level.WARN,"Warn: the List given " +
                    "to averageValue method is null.");
            return 0;
        }else if(srcList.isEmpty()){
            logger.log(Level.WARN,"Warn: the List given " +
                    "to averageValue method is empty.");
            return 0;
        }
        double sum = 0;
        double rstValue=Double.MIN_VALUE;

        sum=srcList.stream().mapToDouble(Double::doubleValue).sum();;

        rstValue=sum/srcList.size();

        return rstValue;
    }

    public int findAmountPositiveElements(List<Double>srcList) {
        if (srcList==null){
            logger.log(Level.WARN,"Warn: the List given " +
                    "to findAmountPositiveElements method is null.");
            return 0;
        }else if(srcList.isEmpty()){
            logger.log(Level.WARN,"Warn: the List given " +
                    "to findAmountPositiveElements method is empty.");
            return 0;
        }
        int amount = 0;
        for (Double nmb:srcList) {
            if (nmb >= 0) {
                amount++;
            }
        }
        return amount;
    }

    public int findAmountNegativeElements(List<Double>srcList) {
        if (srcList==null){
            logger.log(Level.WARN,"Warn: the List given " +
                    "to findAmountNegativeElements method is null.");
            return 0;
        }else if(srcList.isEmpty()){
            logger.log(Level.WARN,"Warn: the List given " +
                    "to findAmountNegativeElements method is empty.");
            return 0;
        }
        int amount = 0;
        for (Double nmb:srcList) {
            if (nmb >= 0) {
                amount++;
            }
        }
        return amount;
    }
}