package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.Bal.ViewInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.CustomerDaoInterface;
import com.nkxgen.spring.jdbc.DaoInterfaces.LoanApplicationDaoInterface;
import com.nkxgen.spring.jdbc.InputModels.LoanApplicationInput;
import com.nkxgen.spring.jdbc.ViewModels.LoanAccountViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanApplicationViewModel;
import com.nkxgen.spring.jdbc.ViewModels.LoanViewModel;
import com.nkxgen.spring.jdbc.events.LoanAppApprovalEvent;
import com.nkxgen.spring.jdbc.events.LoanAppRequestEvent;
import com.nkxgen.spring.jdbc.model.LoanApplication;

@Controller
public class LoanController {

	@Autowired
	LoanApplicationDaoInterface ll;
	@Autowired
	CustomerDaoInterface cd;
	@Autowired
	ViewInterface v;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@RequestMapping(value = "/loanNewApplicationForm", method = RequestMethod.GET)
	public String loanNewApplicationForm(Model model) {
		List<LoanViewModel> list = v.getAllLoans();

		// Print the loan type for each loan in the list
		for (LoanViewModel ll : list) {
			System.out.println(ll.getLoanType());
		}

		// Add the list of loans to the model attribute "loans"
		model.addAttribute("loan", list);
		return "loan-new-application-form";
	}

	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(Model model) {
		return "edit-form";
	}

	@RequestMapping(value = "/redirected", method = RequestMethod.GET)
	public String redirectForm(Model model) {
		// Get a list of loan applications with the status "redirecting"
		List<LoanApplicationViewModel> list = v.getLoanApplicationsByStatus("redirecting");

		// Add the list of loan applications as a model attribute
		model.addAttribute("loanApplications", list);

		// Return the view name "Application1" to render the page
		return "redirected-applications";
	}

	@RequestMapping(value = "/newLoanApplication", method = RequestMethod.POST)
	public String NewLoanApplication(@Validated LoanApplicationInput l, Model model, HttpServletRequest request) {
		// Create a new instance of LoanApplication
		LoanApplication loan = new LoanApplication();

		// Set the input model values of the loan application using the LoanApplicationInput object
		loan.LoanApplication(l);

		// Save the loan application to the database using the ll (LoanApplicationDaoInterface) object
		ll.saveLoanApplication(loan);

		// Get the current session
		HttpSession session = request.getSession();

		// Get the username from the session attribute
		String username = (String) session.getAttribute("username");

		// Publish a loan application request event with the event message and username
		applicationEventPublisher.publishEvent(new LoanAppRequestEvent("New Loan Application Filled", username));

		// Change the return to the view name "loan_new_application_form" to render the page
		return "loan-new-application-form";
	}

	@RequestMapping(value = "/updateApplication", method = RequestMethod.POST)
	public String updateLoanApplication(@Validated LoanApplicationInput loanApplication, HttpServletRequest request) {
		// Update the loan application using the ll (LoanApplicationDaoInterface) object
		ll.updateLoanApplication(loanApplication);

		// Get the current session
		HttpSession session = request.getSession();

		// Get the username from the session attribute
		String username = (String) session.getAttribute("username");

		// Publish a loan application approval event with the event message and username
		applicationEventPublisher.publishEvent(new LoanAppApprovalEvent("Loan Application Updated", username));

		// Change the return to the view name "Application" to render the page
		return "loan-approval";
	}

	@RequestMapping(value = "/getApplications", method = RequestMethod.POST)
	public String GetLoanApplication(@RequestParam("Typevalue") String accountType, Model model) {
		// Get the loan applications based on the value from the Types object
		List<LoanApplicationViewModel> list = v.getLoanApplicationByValue(accountType);

		// Add the loan applications to the model attribute
		model.addAttribute("loanApplications", list);

		// Change the return to the view name "Application" to render the page
		return "loan-approval";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String GetLoanAccounts(@RequestParam("Typevalue") String accountType, Model model) {
		// Get the loan accounts based on the loan type value from the Types object
		List<LoanAccountViewModel> list = v.getLoanAccountsByLoanType(accountType);

		// Add the loan accounts to the model attribute
		model.addAttribute("loanAccounts", list);

		// Change the return to the view name "Application3" to render the page
		return "loan-account-details";
	}

	@RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
	public String deleteLoanApplication(@RequestParam("loanId") int accountType, Model model) {
		// Delete the loan application based on the loanId parameter
		ll.deleteApplication(accountType);

		// Change the return to the view name "Application" to render the page
		return "loan-approval";
	}

	@RequestMapping(value = "/approveLoan", method = RequestMethod.POST)
	public String approveLoanApplication(@RequestParam("loanId") int accountType,
			@RequestParam("customerId") Long custid, Model model, HttpServletRequest request) {
		// Approve the loan application based on the loanId and customerId parameters
		ll.approveApplication(accountType, custid);

		System.out.println("the loan application id is :" + accountType);
		LoanApplication loanapp = ll.getLoanApplicationByid(accountType);
		System.out.println("the acquired looan id is :" + loanapp.getId());
		loanapp.setProcessedStatus("Approved");
		loanapp.setStatus("Approved");

		ll.saveTheApprovedLoanApplication(loanapp);

		// Get the session object from the request
		HttpSession session = request.getSession();

		// Get the username attribute from the session
		String username = (String) session.getAttribute("username");

		// Publish a LoanAppApprovalEvent with the appropriate message and username
		applicationEventPublisher.publishEvent(new LoanAppApprovalEvent("Loan Application Approved", "No user"));

		// Change the return to the view name "Application" to render the page
		return "loan-approval";
	}

}
