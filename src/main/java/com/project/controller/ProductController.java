package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.ProductDao;
import com.project.model.ProductModel;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		
		List<ProductModel> listProduct = productDao.listAll();
		model.addAttribute("listProduct", listProduct);
		
		return "index";
	}
	
	@RequestMapping("/new_product")
 	public String showNewProductPage(Model model) {
 		
 		ProductModel productModel = new ProductModel();
 		model.addAttribute("productModel", productModel);
 		
 		return "new_product";
 	}
	
	@RequestMapping("/edit_product/{idProduct}")
	public ModelAndView showEditProductPage(@PathVariable(name ="idProduct")long idProduct) {
	
		ModelAndView mav = new ModelAndView("edit_product");
		ProductModel productModel = productDao.get(idProduct);
		mav.addObject("productModel", productModel);
		return mav;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(ProductModel productModel) {
		productDao.save(productModel);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{idProduct}")
	public String deleteProduct(@PathVariable(name="idProduct") long idProduct) {
		productDao.delete(idProduct);
		return "redirect:/";
	}
	
}
