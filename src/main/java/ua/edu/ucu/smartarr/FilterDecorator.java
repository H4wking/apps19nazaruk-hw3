package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    public MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
        filter();
    }

    private void filter() {
        Object[] elements = smartArray.toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (predicate.test(elements[i])) {
                newArray.add(elements[i]);
            }
        }
        smartArray = new BaseArray(newArray.toArray());
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filter" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
