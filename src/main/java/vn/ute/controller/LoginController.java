package vn.ute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.ute.entity.Product;
import vn.ute.service.ProductServices;

@Controller
public class LoginController {
	@Autowired
	private ProductServices service;
	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
	System.out.println("Logging user login success...");
	return "index";
	}
	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
	System.out.println("Login failure handler....");
	return "login";
	}
	@RequestMapping("/")
	public String viewHomePage (Model model) {
	List<Product> listProducts = service.listAll();
	model.addAttribute("listProducts", listProducts);
	return "index";
	}
}
