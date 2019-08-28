package org.katas.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<LineItem> lineItem;

    public Order(String customerName, String address, List<LineItem> lineItem) {
        this.customerName = customerName;
        this.address = address;
        this.lineItem = lineItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
    	List<LineItem> returnlineItems = new ArrayList<LineItem>();
    	returnlineItems.addAll(lineItem);
        return lineItem;
    }
    
}
