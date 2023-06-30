package com.nkxgen.spring.jdbc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.nkxgen.spring.jdbc.DaoInterfaces.UserCredentialsDAO;

public class LoginFilter implements Filter {

	@Autowired
	private UserCredentialsDAO userCredentialsDAO;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// Get the username and password from the request parameters
		String username = httpRequest.getParameter("username");
		String password = httpRequest.getParameter("password");

		System.out.println(username + " " + password);

		// Perform your login verification logic here
		System.out.println(userCredentialsDAO.userCredentialsCheck(username, password));
		boolean isValidCredentials = userCredentialsDAO.userCredentialsCheck(username, password);

		if (isValidCredentials) {
			// Create a session and set an attribute to store the logged-in user information
			HttpSession session = httpRequest.getSession(true);
			session.setAttribute("username", username);

			// Continue the request processing
			chain.doFilter(request, response);
		} else {
			// Invalid credentials, return an error message
			String errorMessage = "Bad credentials";
			httpResponse.getWriter().write(errorMessage);
		}
	}

	@Override
	public void destroy() {
		// Cleanup code goes here, if needed
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
