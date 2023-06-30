package com.nkxgen.spring.jdbc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.events.LoginEvent;
import com.nkxgen.spring.jdbc.events.LogoutEvent;
import com.nkxgen.spring.jdbc.validation.MailSender;;

@Controller
public class LoginController {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	// =====================================================================================================
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "login-page";
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String login2(HttpServletRequest request) {
		// Get the session object from the request
		HttpSession session = request.getSession();

		// Get the username attribute from the session
		String username = (String) session.getAttribute("username");

		// Publish a LogoutEvent with the appropriate message and username
		applicationEventPublisher.publishEvent(new LogoutEvent("Logged Out", username));

		// Change the return to the view name "LoginPage" to render the page
		return "login-page";
	}

	String otp;
	@Autowired
	MailSender obj;

	@RequestMapping(value = "/enterOtp", method = RequestMethod.POST)
	public String enterOtp(@RequestParam("email") String to) {
		// Call the "send" method on the "obj" object to send the OTP to the specified email
		otp = obj.send(to);

		// Change the return to the view name "EnterOtp" to render the page
		return "EnterOtp";
	}

	@RequestMapping(value = "/enteremail")
	public String sendOtp() {
		return "EnterEmail";
	}

	@RequestMapping(value = "/confirmPass", method = RequestMethod.POST)
	public String cp(@RequestParam("otp") String otp1) {
		System.out.println("Entered OTP : " + otp1 + " Sent OTP : " + otp);

		// Check if the entered OTP matches the sent OTP
		if (otp1.equals(otp))
			return "confirmpass"; // If OTP is correct, return the view name "confirmPass"
		else
			return "EnterOtp"; // If OTP is incorrect, return the view name "EnterOtp"
	}

	@RequestMapping(value = "/Test", method = RequestMethod.POST)
	public String main_page(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		// Add the username as an attribute to the model
		model.addAttribute("username", username);

		// Publish a LoginEvent with the username
		applicationEventPublisher.publishEvent(new LoginEvent("Logged In", username));

		return "bank-home-page"; // Return the view name "BankHomePage" to render the page
	}

	// ============================================================================================================================
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String user1(Model model) {

		return "new-bank-user";

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {

		return "user-details";

	}
	// ================================================================================================================================

	// =============================================================================

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String customers(Model model) {
		System.out.println("requested for the customer_entry");

		return "customer-edit-details-form"; // Return the view name "customer_edit_details_form" to render the page
	}


	// ===========================================================================

}
