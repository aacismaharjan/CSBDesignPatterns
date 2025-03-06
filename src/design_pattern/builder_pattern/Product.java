package design_pattern.builder_pattern;

public class Product<T> {
	private final String name;
	private final double price;
	private final String category;
	private final T extraDetails;
	
	private Product(Builder<T> builder) {
		this.name = builder.name;
		this.price = builder.price;
		this.category = builder.category;
		this.extraDetails = builder.extraDetails;
	}
	
	public String getName() {return name;}
	public double getPrice() {return price;}
	public String getCategory() {return category;}
	public T getExtraDetails() { return extraDetails;}
	
	@Override
	public String toString() {
		return "Product{name='" + name + "', price=" + price +
				", category='" + category + "', extraDetails=" + extraDetails + "}";
	}
	
	public static class Builder<T> {
		private String name;
		private double price;
		private String category;
		private T extraDetails;
		
		public Builder<T> setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder<T> setPrice(double price) {
			this.price = price;
			return this;
		}
		
		public Builder<T> setCategory(String category) {
			this.category = category;
			return this;
		}
		
		public Builder<T> setExtraDetails(T extraDetails) {
			this.extraDetails = extraDetails;
			return this;
		}
		
		public Product<T> build() {
			return new Product<>(this);
		}
		
	}
}


