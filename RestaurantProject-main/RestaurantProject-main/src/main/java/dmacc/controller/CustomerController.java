
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
import dmacc.repository.CustomerRepository;

@Controller
public class CustomerController {

	@Autowired
	CustomerRepository repo;

	// will display a customers profile
	@GetMapping({ "displayProfile" })
	public String viewCustomer(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("customer", repo.findAll());
		return "displayProfile";
	}

	// will add a customer to the database
	@GetMapping("/addNewCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "input";
	}
	
	@PostMapping("/addNewCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		repo.save(c);
		return viewCustomer(model);
		
	}

	// choose a customer by id to edit
	@GetMapping("/edit/{id}")
	public String editCustomer(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		model.addAttribute("newCustomer", c);
		return "input";
	}

	// updates customer information
	@PostMapping("/update/{id}")
	public String updateCustomer(@ModelAttribute Customer c, Model model) {
		repo.save(c);
		return viewCustomer(model);
	}

	// will delete a customer from the database by id
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") long id, Model model) {
		Customer c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewCustomer(model);
	}
}
