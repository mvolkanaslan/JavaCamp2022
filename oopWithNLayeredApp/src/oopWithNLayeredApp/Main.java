package oopWithNLayeredApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.HiberNateProductDao;
import oopWithNLayeredApp.entities.Product;

public class Main {

	public static void main(String[] args) throws Exception {
		Product product1 = new Product(1,"Laptop",50);
		List<Logger> loggers = new ArrayList<Logger>(Arrays.asList(new DatabaseLogger(),new FileLogger(), new MailLogger()));
		ProductManager productManager = new ProductManager(new HiberNateProductDao(), loggers);
		productManager.add(product1);

	}

}
