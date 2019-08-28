package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
	private static String SALES_TAX = "Sales Tax";
	private static String TOTAL_AMOUNT = "Total Amount";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        pringHeaders(output);
        return printReceiptString(output);
    }

	private String printReceiptString(StringBuilder output) {
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
        	output.append(lineItem.genrateItemsInformation());
            double salesTax = lineItem.calculateTotalAmount() * .10;
            totSalesTx += salesTax;
            tot += lineItem.calculateTotalAmount() + salesTax;
        }
        String status = printStatus(output, totSalesTx, tot);
        return status;
	}
	
    //prints the state tax & print total amount
	private String printStatus(StringBuilder output, double totSalesTx, double tot) {
        output.append(SALES_TAX).append('\t').append(totSalesTx);
        output.append(TOTAL_AMOUNT).append('\t').append(tot);
        return output.toString();
	}
	
	//print headers & date, bill no, customer name
	private void pringHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
	}
}