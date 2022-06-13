
package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
import dmacc.beans.CustomerOrder;
import dmacc.beans.MenuItems;
import dmacc.repository.CustomerOrderRepository;
import dmacc.repository.MenuItemsRepoitory;

@Controller
public class CustomerOrderController {
	
	@Autowired
	CustomerOrderRepository repo;
	
	@Autowired
	MenuItemsRepoitory r;
	
	// display an order
	@GetMapping({"update/displayCustomerOrder"})
	public String viewCustomerOrder(Model model) {
		
/**
		if(repo.findAll().isEmpty()) {
			return addCustomerOrder(model);
		}
**/
		model.addAttribute("orderDetails", repo.findAll());
		return "displayCustomerOrder";
	}
	
	// adds a new order to database
	@GetMapping("/addCustomerOrder")
	public String addCustomerOrder(Model model) {
			CustomerOrder o = new CustomerOrder();
			model.addAttribute("newCustomerOrder", o);
			model.addAttribute("menuItems", r.findAll());
			return "CustomerOrder";
	}

	@PostMapping("/update/addCustomerOrder")
	public String addCustomerOrder(@ModelAttribute CustomerOrder o, Model model) {
		repo.save(o);
		return viewCustomerOrder(model);
		//return "displayCustomerOrder";
	}

	// edits order pull order from database by id
	@GetMapping("/editOrder/{id}")
	public String editCustomerOrder(@PathVariable("id") long id, Model model) {
		CustomerOrder o = repo.findById(id).orElse(null);
		model.addAttribute("newOrder", o);
		return "CustomerOrder";
	}

	// updates a current order
	@PostMapping("/updateOrder/{id}")
	public String updateCustomerOrder(@ModelAttribute CustomerOrder o, Model model) {
		repo.save(o);
		return viewCustomerOrder(model);
	}	
	// deletes current order id
	@GetMapping("/deleteCustomerOrder/{id}")
	public String deleteCustomerOrder(@PathVariable("id") long id, Model model) {
		CustomerOrder o = repo.findById(id).orElse(null);
		repo.delete(o);
		return viewCustomerOrder(model);
	}
}
