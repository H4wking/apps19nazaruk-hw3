package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
        sort();
    }

    private void sort() {
        Object[] elements = smartArray.toArray();
        Arrays.sort(elements, comparator);
        smartArray = new BaseArray(elements);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sort" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
