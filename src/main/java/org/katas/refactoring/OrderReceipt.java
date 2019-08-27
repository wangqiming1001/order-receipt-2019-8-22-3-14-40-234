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
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        pringHeaders(output);
        return printReceiptString(output);
    }

	private String printReceiptString(StringBuilder output) {
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
            tot += lineItem.totalAmount() + salesTax;
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
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
	}
}