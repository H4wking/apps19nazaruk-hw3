package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        removeDuplicates();
    }

    private void removeDuplicates() {
        Object[] elements = smartArray.toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < newArray.size(); j++) {
                if (elements[i].toString().equals(newArray.get(j).toString())) {
                    duplicate = true;
                }
            }
            if (!duplicate) {
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
        return "Distinct" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
