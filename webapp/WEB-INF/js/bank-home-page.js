// JavaScript to handle page load on Neeraj dropdown click
$(document).ready(function() {
	var adduser = $('#adduser');
	var mainContent = $('#main-content');

	adduser.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'addUser',
			type: 'POST',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//-------------------------logout--------------------------------------------------
	var logout = $('#logout');

	logout.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'logOut',
			type: 'GET',
			success: function(response) {
				location.href = "LoginPage";
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//--------------------------    list users button ajax call       --------------------------
	var listusers = $('#listusers');
	var mainContent = $('#main-content');

	listusers.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'mainUser',
			type: 'GET',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});

	//--------------------------- Master Entry Accounts------------------------
	var accounts = $('#accounts');
	var mainContent = $('#main-content');

	accounts.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'accountDataSave',
			type: 'POST',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//--------------------------- Master Entry Loans------------------------
	var loans = $('#loans');
	var mainContent = $('#main-content');

	loans.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'loanDataSave',
			type: 'POST',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//--------------------------- Account New Application------------------------
	
	//------------------------------------ Loans New Application -------------------
	var newloan = $('#newloan');
	var mainContent = $('#main-content');

	newloan.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'loanNewApplicationForm',
			type: 'GET',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	// ------------------------------- Customers ------------------------------
	var customers = $('#customers');
	var mainContent = $('#main-content');

	customers.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'customers',
			type: 'POST',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	// ------------------------------------ savingsaccountview -------------------
	var savingsacc = $('#savingsacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'anyTypeAccountInfo',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#currentacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'anyTypeAccountInfo',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#recurrentacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'anyTypeAccountInfo',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#FDacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'anyTypeAccountInfo',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//---------------------------------- savingsapplication -------------------------
	var savingsapp = $('#savingsapp');
	var mainContent = $('#main-content');

	savingsapp.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'newAccountApplication',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsapp = $('#currentapp');
	var mainContent = $('#main-content');

	savingsapp.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'newAccountApplication',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsapp = $('#recurrentapp');
	var mainContent = $('#main-content');

	savingsapp.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'newAccountApplication',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsapp = $('#FDapp');
	var mainContent = $('#main-content');

	savingsapp.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'newAccountApplication',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	// ------------------------------------


	//================================================================================loanaccounts
	var savingsacc = $('#Personalacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'account',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#Vehicleacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'account',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#Goldacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'account',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#Mortageacc');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'account',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//=================================================================
	var savingsacc = $('#Mortageapp');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'getApplications',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#Goldapp');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'getApplications',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#Vehicleapp');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'getApplications',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#Personalapp');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		var listItemValue = $(this).data("value");
		console.log(listItemValue);
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'getApplications',
			type: 'POST',
			data: { Typevalue: listItemValue },
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var savingsacc = $('#redirected');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'redirected',
			type: 'GET',
			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//========================================================forms==================
	var savingsacc = $('#newloan');
	var mainContent = $('#main-content');

	savingsacc.on('click', function(event) {
		// Prevent the default behavior of the anchor tag

		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'loanNewApplicationForm',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var account = $('#newaccount');
	var mainContent = $('#main-content');

	account.on('click', function(event) {
		
		$.ajax({
			url: 'accountNewApplicationForm',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});

	//========================loans transactions==========================
	var loanrepay = $('#loanrepay');
	var mainContent = $('#main-content');

	loanrepay.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'loanRepay',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});

	var loanwithdraw = $('#loanwithdraw');
	var mainContent = $('#main-content');

	loanwithdraw.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'lowid',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});

	//================================================account transactions========================

	var moneydeposit = $('#moneydeposit');
	var mainContent = $('#main-content');

	moneydeposit.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'moneyDeposit',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var moneywithdraw = $('#moneywithdraw');
	var mainContent = $('#main-content');

	moneywithdraw.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'withdrawl',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});

	//================================auditlogs==========================


	var auditlogs = $('#auditlogs');
	var mainContent = $('#main-content');

	auditlogs.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'auditLogs',
			type: 'GET',

			success: function(response) {

				// Open a new window and display the HTML content
				var newWindow = window.open("", "_blank");
				newWindow.document.open();
				newWindow.document.write(response);
				newWindow.document.close();
				//mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	//======================================================================

	var statement_generation = $('#statement_generation');
	var mainContent = $('#main-content');

	statement_generation.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'statementPage',
			type: 'POST',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
	var intrest_caluclation = $('#intrest_caluclation');
	var mainContent = $('#main-content');

	intrest_caluclation.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'getAccounts',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});

	var cashchest = $('#cashchest');
	var mainContent = $('#main-content');

	cashchest.on('click', function(event) {
		// Prevent the default behavior of the anchor tag
		// Load Neeraj page content using AJAX
		$.ajax({
			url: 'cashChest',
			type: 'GET',

			success: function(response) {
				mainContent.html(response);
			},
			error: function() {
				alert('Failed to load page.');
			}
		});
	});
});