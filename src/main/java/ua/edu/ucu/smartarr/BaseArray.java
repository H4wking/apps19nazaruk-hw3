package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] elements;

    public BaseArray(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size());
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return elements.length;
    }
}
