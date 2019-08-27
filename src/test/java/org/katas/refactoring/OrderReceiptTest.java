package org.katas.refactoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class OrderReceiptTest {
	private static String MR_X = "Mr X";
	private static String MILK = "milk";
	private static String BISCUITS = "biscuits";
	private static String CHOCOLATE = "chocolate";

	
    @Test
    public void shouldPrintCustomerInformationOnOrder() {
        //given
		Order order = new Order(MR_X, "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);
        //when
        String output = receipt.printReceipt();
        //THEN
        assertThat(output).contains(MR_X, "Chicago, 60601");
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
    	//given
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem(MILK, 10.0, 2));
            add(new LineItem(BISCUITS, 5.0, 5));
            add(new LineItem(CHOCOLATE, 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));
        //when
        String output = receipt.printReceipt();
        //then
        assertThat(output).contains(
                "milk\t10.0\t2\t20.0\n",
                "biscuits\t5.0\t5\t25.0\n",
                "chocolate\t20.0\t1\t20.0\n",
                "Sales Tax\t6.5",
                "Total Amount\t71.5"
        );
    }

}
