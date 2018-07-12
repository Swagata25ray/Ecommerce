package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("productList", productDAO.listProducts());
		return "ManageProduct";
	}
	
	@RequestMapping(value="/ProductInsert",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product)
	{
		productDAO.addProduct(product);
		//System.out.println("Product Added");
		m.addAttribute("categoryList", this.getCategories());
		
		return "ManageProduct";
	}
	
	@RequestMapping(value="/ProductInsert",method=RequestMethod.POST)
	public String updateProduct()
	
}
