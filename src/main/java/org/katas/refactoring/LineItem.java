package org.katas.refactoring;

public class LineItem {
    private String description;
    private double price;
    private int quality;

    public LineItem(String description, double price, int quality) {
        super();
        this.description = description;
        this.price = price;
        this.quality = quality;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quality;
    }

    double calculateTotalAmount() {
        return price * quality;
    }
    
    public String genrateItemsInformation() {
    	return this.getDescription()+'\t'
    			+this.getPrice()+"\t"
    			+this.getQuantity()+"\t"
    			+this.calculateTotalAmount()+"\n";
    }
}