package com.niit.TestCase;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierTestCase 
{
static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		
		supplier.setSupplierId(1);
		supplier.setSupplierName("AR");
		supplier.setSupplierAddr("Bangalore");
		System.out.println("Supplier Added");
		
		assertNotNull("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
		supplier.setSupplierName("SR");
		supplier.setSupplierAddr("Indore");
		
		assertNotNull("Problem in Updating the Supplier",supplierDAO.updateSupplier(supplier));
	}
	
	
	@Test 
	public void deleteSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(1);
		assertNotNull("Problem in Deleting the Supplier",supplierDAO.deleteSupplier(supplier));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		//assertNotNull("Problem in Listing Suppliers",listSuppliers);
		System.out.println("List supplier");
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierAddr()+":::");
		}
	}


	

}
