package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		
		if (name == null) {
			  throw new IllegalArgumentException("Nie można stworzyc produktu o nazwie NULL");
			}
		if (name.length() == 0) {
			  throw new IllegalArgumentException("Nie można stworzyc produktu bez nazwy");
			}
		if (price == null) {
			  throw new IllegalArgumentException("Nie można stworzyc produktu o cenie NULL");
			}
		if (price.equals(BigDecimal.ZERO)) {
			  throw new IllegalArgumentException("Nie można stworzyc produktu z zerowa cena");
			}
		if (price.compareTo(BigDecimal.ZERO) <0){
			 throw new IllegalArgumentException("Nie można stworzyc produktu z ujemna cena");
		}

	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		BigDecimal taxValue = this.price.multiply(this.taxPercent) ;
		return taxValue.add(this.price);
	}
}
