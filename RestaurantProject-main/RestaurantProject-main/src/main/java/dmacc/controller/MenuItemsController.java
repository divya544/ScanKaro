
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dmacc.repository.MenuItemsRepoitory;


@Controller
public class MenuItemsController {

	@Autowired
	MenuItemsRepoitory repo;

	// view current menus
	@GetMapping({ "displayMenu" })
	public String viewMenu(Model model) {
		model.addAttribute("menuItems", repo.findAll());
		return "displayMenu";
	}

}
