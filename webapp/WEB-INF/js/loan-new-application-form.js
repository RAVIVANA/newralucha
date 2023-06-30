function Next() {
	document.getElementById("second-form").classList.add("hidden");
	document.getElementById("first-form").classList.remove("hidden");
}

function submit() {
	var customerId = document.getElementById("apcust_id").value;
	var applicationDate = document.getElementById("apdate").value;
	var loanTypeId = document.getElementById("lnty_id").value;
	var loanAmount = document.getElementById("amount").value;
	var interest = document.getElementById("intrest").value;
	var emiLimitFrom = document.getElementById("emilimitfrom").value;
	var emiLimitTo = document.getElementById("emilimitto").value;
	var tenureRequested = document.getElementById("tenure_requested").value;
	var nominee = document.getElementById("nominee").value;
	var createdBy = document.getElementById("createdby").value;
	var createdDate = document.getElementById("createddate").value;
	var processedBy = document.getElementById("processedby").value;
	var processDate = document.getElementById("processdate").value;
	var processedStatus = document.getElementById("processedstatus").value;
	var lastUpdatedDate = document.getElementById("luudate").value;
	var lastUpdatedUser = document.getElementById("luuser").value;
	var status = document.getElementById("status").value;
	var remarks = document.getElementById("remarks").value;
	var attachment = document.getElementById("attachment").value;

	console.log(attachment);
	$.ajax({
		url: 'newLoanApplication',
		type: 'post',
		data: {
			CustId: customerId,
			ApplicationDate: applicationDate,
			LoanTypeId: loanTypeId,
			Amount: loanAmount,
			Intrest: interest,
			EmiLimitFrom: emiLimitFrom,
			EmiLimitTo: emiLimitTo,
			TenureRequested: tenureRequested,
			nominee: nominee,
			CreatedBy: createdBy,
			CreatedDate: createdDate,
			ProcessedBy: processedBy,
			ProcessDate: processDate,
			ProcessedStatus: processedStatus,
			LastUpdatedDate: lastUpdatedDate,
			LastUpdatedUser: lastUpdatedUser,
			status: status,
			remarks: remarks,
			Attachment: attachment
		},
		success: function(resultText) {
			
			console.log('First form submitted successfully');
		},
		error: function(jqXHR, exception) {
			console.log('Error occurred!');
		}
	});
}

function showFirstForm() {
	document.getElementById("second-form").classList.add("hidden");
	document.getElementById("first-form").classList.remove("hidden");
}

function submit2() {
	document.getElementById('apcust_id').value = document.getElementById('cust_id').value;
	Next();
	var custId = document.getElementById("cust_id").value;
	var custTitle = document.getElementById("cust_title").value;
	var custType = document.getElementById("cust_type").value;
	var custCAddress = document.getElementById("cust_caddress").value;
	var custCAPincode = document.getElementById("cust_capincode").value;
	var custDOB = document.getElementById("cust_dob").value;
	var custMobile1 = document.getElementById("cust_mobile1").value;
	var custMobile2 = document.getElementById("cust_mobile2").value;
	var custRPhone = document.getElementById("cust_rphone").value;
	var custRAddress = document.getElementById("cust_raddress").value;





	// Make AJAX call to save the form data
	$.ajax({
		url: "customer_data_trail_save",
		type: "POST",
		data: {
			Id: custId,
			custTitle: custTitle,
			cust_type: custType,
			cust_caddress: custCAddress,
			cust_capincode: custCAPincode,
			cust_dob: custDOB,
			cust_mobile1: custMobile1,
			cust_mobile2: custMobile2,
			cust_rphone: custRPhone,
			cust_raddress: custRAddress
		},
		success: function(response) {
			// Handle success response
			console.log("Form data saved successfully");
		},
		error: function(xhr, status, error) {
			// Handle error response
			console.log("Error occurred while saving form data");
		}
	});
}

function submitBothForms() {
	submit();
	submit2();
}