
package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkxgen.spring.jdbc.Bal.ViewInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.BankUserInterface;
import com.nkxgen.spring.jdbc.InputModels.BankUserInput;
import com.nkxgen.spring.jdbc.ViewModels.BankUserViewModel;
import com.nkxgen.spring.jdbc.events.BankUserCreationEvent;
import com.nkxgen.spring.jdbc.events.BankUserDetailsModificationEvent;
import com.nkxgen.spring.jdbc.model.BankUser;

@Controller
public class UserController {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser() {
		return "add-user";
	}

	private final BankUserInterface bankUserService;
	@Autowired
	ViewInterface v;

	@Autowired
	public UserController(BankUserInterface bankUserService) {
		this.bankUserService = bankUserService;
	}

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public ResponseEntity<String> submitForm(BankUserInput bankUser, HttpServletRequest request) {

		BankUser b = new BankUser();
		b.setInputModelValues(bankUser); // Set the input model values from the bankUser object
		bankUserService.saveBankUser(b); // Save the bank user details
		System.out.println("Submitted Form"); // Print a message indicating that the form has been submitted
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username"); // Get the username from the session attribute
		applicationEventPublisher.publishEvent(new BankUserCreationEvent("Bank User Created ", username)); // Publish a
																											// Bank User
																											// Creation
																											// event
		return ResponseEntity.ok("Data saved successfully!"); // Return a response entity indicating successful data
																// submission
	}

	@RequestMapping(value = "/mainUser", method = RequestMethod.GET)
	public String getBankUsers(Model model) {

		List<BankUserViewModel> bankUsers = v.getAllBankUsers(); // Retrieve all bank users from the view model
		model.addAttribute("bankUsers", bankUsers); // Add the bank users to the model attribute
		return "bank-users"; // Return the view name "mainUser"
	}

	@RequestMapping("/saveUserData")
	@ResponseBody
	public String saveUserData(BankUserInput bankUser, HttpServletRequest request) {
		BankUser b = new BankUser(); // Create a new BankUser object
		System.out.println(bankUser.getBusr_id()); // Print the value of busr_id from the bankUser input
		b.setInputModelValues(bankUser); // Set the input model values on the BankUser object
		System.out.println(b.getBusr_id()); // Print the value of busr_id from the BankUser object
		bankUserService.saveUser(b); // Save the BankUser object using the bankUserService
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username"); // Get the username from the session
		applicationEventPublisher
				.publishEvent(new BankUserDetailsModificationEvent("Bank User Details Modified", username)); // Publish
																												// a
																												// BankUserDetailsModificationEvent
		return "User data updated successfully"; // Return a success message
	}
	@RequestMapping(value = "/fetchData", method = RequestMethod.POST)
	public String getBankUserByDesignation(@ModelAttribute("BankUser") BankUserInput bankUser, Model model) {
		BankUser b = new BankUser(); // Create a new BankUser object
		b.setInputModelValues(bankUser); // Set the input model values on the BankUser object
		List<BankUserViewModel> bankUsers; // Declare a list to store BankUserViewModel objects

		if (bankUser.getBusr_desg().equals("All")) {
			bankUsers = v.getAllBankUsers(); // Get all bank users if the designation is "All"
		} else {
			bankUsers = v.getBankUsersByDesignation(b); // Get bank users by designation
		}

		model.addAttribute("bankUsers", bankUsers); // Add the bankUsers list to the model
		return "bank-users"; // Return the name of the HTML page as the view
	}

}