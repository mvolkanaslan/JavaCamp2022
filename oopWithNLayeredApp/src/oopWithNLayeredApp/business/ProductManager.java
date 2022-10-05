package oopWithNLayeredApp.business;

import java.util.List;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class ProductManager {
	
	//Bir islemi birden fazla alternatif ile yapabilmek yani herhangi birine bagimli kalmamak icin soyut sinif olan Interface yapilarini kullaniriz.
	//Bu soyut sinifi dependency Injection yoluyla enjecte ettigimiz classta bu interface i implemnte etmis diger tum siniflar kullanabiliriz.
	//Constructor blogunda Bu soyut sinifi miraz alan hangi servisi kullanacagimizi belirterek o servis uzerinden islemlerimizi yapariz
	//Boylece Manager sinifi o isi yapmak icin sadece bir sinifa bagimli kalmamais oldu
	
	
	private ProductDao productDao;
	private List<Logger> loggers;
	
	// Constructor ile enjecte islemini bu sekilde yapiyoruz
	public ProductManager(ProductDao productDao, List<Logger> loggers) {
		this.productDao = productDao;
		this.loggers = loggers;
	}


	public void add(Product product) throws Exception {
		
		if(product.getUnitPrice()<10)  {
			throw new Exception("Product Unit Price can not be small then 10");
		}
		//productDao herhangi bir ProductDao sinifini temsil eder hangi ProductDao enjecte edilmis ise onun methodlarini calistirir
		productDao.add(product);
		
		for(Logger logger : loggers) {
			logger.log(product.getName());
		}
	}
}
