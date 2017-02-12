package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product product) {
		products.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		if(quantity == null || quantity <= 0) {
			throw new IllegalArgumentException("Niepoprawna ilosc");
		}
		
		for(int i = 0; i < quantity; i++) {
			this.addProduct(product);
		}
	}

	public BigDecimal getSubtotal() {
		BigDecimal subtotal = new BigDecimal("0");
		for (Product product : products){
			subtotal = subtotal.add(product.getPrice());
		}
		return subtotal;
	}

	public BigDecimal getTax() {
		BigDecimal tax = new BigDecimal("0");
		for(Product product : this.products) {
			tax = tax.add(product.getPrice().multiply(product.getTaxPercent()));
		}
		
		return tax;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal("0");
		for(Product product : this.products) {
			total = total.add(product.getPriceWithTax());
		}
		
		total = total.setScale(2, BigDecimal.ROUND_DOWN);
		return total;
	}
}

