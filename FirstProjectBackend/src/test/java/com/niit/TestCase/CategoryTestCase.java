package com.niit.TestCase;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

public class CategoryTestCase 
{

	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		
		category.setCategoryName("Lenovo");
		category.setCategoryDesc("Lenove Mobiles");
		System.out.print("In add cat");
		assertNotNull("Problem in Adding Category:",categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryName("Samsung");
		category.setCategoryDesc("Samsung Smart Mobiles with 4G Feature");
		
		assertNotNull("Problem in Updating the Category",categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test 
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		assertNotNull("Problem in Deleting the Category",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertNotNull("Problem in Listing Categories",listCategories);
		System.out.println("List cat");
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc()+":::");
		}
	}

}
