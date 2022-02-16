package by.sasnouski.array.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Integer, ArrayProperties> listProperties;
    private static Warehouse instance;

    private Warehouse() {
        this.listProperties = new HashMap<>();
    }
    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayProperties putById(int arrayId, ArrayProperties parameters) {
        return listProperties.put(arrayId, parameters);
    }

    public void removeById(int arrayId) {
        if (listProperties.containsKey(arrayId)) {
            listProperties.remove(arrayId);
        }
    }

    public ArrayProperties getByID(int arrayId) {
        return listProperties.get(arrayId);
    }
}
