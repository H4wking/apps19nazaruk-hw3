package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
        map();
    }

    private void map() {
        Object[] elements = smartArray.toArray();
        for (int i = 0; i < elements.length; i++) {
            elements[i] = function.apply(elements[i]);
        }
        smartArray = new BaseArray(elements);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Map" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
