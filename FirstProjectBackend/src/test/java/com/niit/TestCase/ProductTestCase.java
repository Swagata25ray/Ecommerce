package com.niit.TestCase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;

public class ProductTestCase 
{

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}

	@Test
	public void addProductTestCase()
	{
		Product product=new Product();
		product.setProductName("Samsung J7");
		product.setProductDesc("Samsung Mobile with 4G Features");
		product.setPrice(12000);
		product.setStock(20);
		product.setCategoryId(1);
		product.setSupplierId(1);
		
		assertNotNull("Problem in Adding Product",productDAO.addProduct(product));
	}
	
}
