function toggleForms() {
  document.getElementById("second-form").classList.add("hidden");
  document.getElementById("first-form").classList.remove("hidden");

}


function submit_application_data() {
	// Code for submitting application data
	var acap_nominee_fn = document.getElementById('acap_nominee_fn').value;
	var acap_nominee_ln = document.getElementById('acap_nominee_ln').value;
	var acap_cust_id = document.getElementById('acap_cust_id').value;
	var acap_apdate = document.getElementById('acap_apdate').value;
	var acap_acty_id = document.getElementById('acap_acty_id').value;
	var acap_createdby = document.getElementById('acap_createdby').value;
	var acap_createddate = document.getElementById('acap_createddate').value;
	var acap_processby = document.getElementById('acap_processBy').value;
	var aadhar = document.getElementById('aadhar').value;
	var pan = document.getElementById('pan').value;
	var passport = document.getElementById('passport').value;
	var driving = document.getElementById('driving').value;
	var jobcard = document.getElementById('jobcard').value;

	$.ajax({
		url: "accountApplicationSave",
		type: "post",
		data: {
			CustomerId: acap_cust_id,
			AcapNomineeFirstName: acap_nominee_fn,
			AcapNomineeLastName: acap_nominee_ln,
			ApplicationDate: acap_apdate,
			Acap_acty_id: acap_acty_id,
			ProcessedBy: acap_processby,
			CreatedBy: acap_createdby,
			CreatedDate: acap_createddate,
			Aadhar: aadhar,
			Pan: pan,
			Passport: passport,
			Driving: driving,
			Jobcard: jobcard


		},
		success: function(response) {
			$('#successMessage').text(response).fadeIn();
			setTimeout(function() {
				$('#successMessage').fadeOut();
			}, 3000);

			form.trigger('reset'); // Optional: Reset the form after successful submission
			console.log('First form submitted successfully');

		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log('Error occurred while submitting first form:', errorThrown);
		}


	})

}

function showFirstForm() {
	document.getElementById("second-form").classList.add("hidden");
	document.getElementById("first-form").classList.remove("hidden");
}


function submit_cutomer_data() {
	document.getElementById('acap_cust_id').value = document.getElementById('cust_id').value;
	document.getElementById("second-form").classList.add("hidden");
	document.getElementById("first-form").classList.remove("hidden");
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

	var formData = {
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
	};

	// Make AJAX call to save the form data
	$.ajax({
		url: "customer_data_trail_save",
		type: "POST",
		data: formData,
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
function submitbothforms() {
	submit_cutomer_data();
	submit_application_data();
	
}


//===========================

