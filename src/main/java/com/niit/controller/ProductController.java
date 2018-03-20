package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	private com.niit.DAO.ProductDAO productDAO;
	@Autowired
	private com.niit.DAO.CategoryDAO categoryDAO;

	@Autowired
	private com.niit.DAO.SupplierDAO supplierDAO;

	@RequestMapping(value = { "product" }, method = RequestMethod.GET)

	public String productcontroller2(Model m) {
		List<Product> prodlist = productDAO.getAllProduct();
		m.addAttribute("prodlist", prodlist);
		m.addAttribute("supplist", listsupplier());
		m.addAttribute("catlist", listcat());
		m.addAttribute("product", new Product());
		return "product";
	}

	private List<Category> listcat() {
		List<Category>catlist=categoryDAO.getAllCategory();
		return catlist;
	}
	private List<Supplier> listsupplier() {
		List<Supplier> supplist=supplierDAO.getAllSupplier();
		return supplist;
	}
	@RequestMapping(value="saveproduct", method=RequestMethod.POST)
	public String saveprod(@ModelAttribute("product")Product prod,Model m)
{
		
		productDAO.addProduct(prod);
		MultipartFile mf=prod.getImage();
		String imagepath="C:\\Users\\Chaitali\\Downloads\\frontend todays\\chaitalifrontend\\src\\main\\webapp\\resources\\productimage\\"+prod.getProdId()+".jpg";
		File image=new File(imagepath);
		if(!mf.isEmpty())
		{
			try{
				
				byte[] filebuffer=mf.getBytes();
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(filebuffer);
				bs.flush();
				bs.close();
				}
			catch(Exception e)
			{
				System.out.println("Exception arised"+e);
				
			}
		}
		else
		{
			System.out.println("image is not available");
		}
	
		m.addAttribute("catlist",this.listcat());
		m.addAttribute("supplist",this.listcat());
		return "redirect:product";
	}
	@RequestMapping(value={"/updateproduct{Prodid}"})
	public String updateprod(@PathVariable("Prodid")int prodid,Model m)
	{
	Product prod=productDAO.getOneProduct(prodid);
	List<Product> prodlist=productDAO.getAllProduct();
	m.addAttribute("prodlist",prodlist);
	m.addAttribute("supplist", listsupplier());
	m.addAttribute("catlist", listcat());
	m.addAttribute("product",prod);
	return "product";
	}
	@RequestMapping(value={"/deleteproduct{prodid}"})
	public String deleteprod(@PathVariable("prodid")int prodid)
	{
		productDAO.deleteProduct(prodid);
		return "redirect:product";
		
	}
}