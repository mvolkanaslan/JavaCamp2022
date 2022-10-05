package oop1;

public class Main {

	public static void main(String[] args) {
		Product product1 = new Product();
		product1.name = "Laptop";
		product1.unitPrice = 12500;
		product1.discount = 0.12;
		product1.imageUrl="image.jpg";
		product1.unitsInStock=25;
		System.out.println(product1.name);
	}
}
