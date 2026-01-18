package com.trainingday2;
 interface Payable{
	double getPayment();
}
class Invoice implements Payable {
	private int invoiceId;
	private String itemDescription;
	private int quantity;
	private double pricePerUnit;

    Invoice(int invoiceId, String itemDescription, int quantity, double pricePerUnit) {
        this.invoiceId = invoiceId;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
    @Override 
    public double getPayment() {
    		return quantity*pricePerUnit;
    }
    public int getInvoiceId() {
        return invoiceId;
    }

    public String getItemDescription() {
        return itemDescription;
    }
	
}
public class Q5_UnifiedPaymentSys {

}
