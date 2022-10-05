package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class HiberNateProductDao implements ProductDao {
	@Override
	public void add(Product product) {
		System.out.println("Product added with Hıbernate !");
	}
}
