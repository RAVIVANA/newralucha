var selectedRow;
function editRow(button) {
	// Get the row and populate the form fields with its data
	selectedRow = button.parentNode.parentNode;
	var cells = selectedRow.getElementsByTagName("td");
	document.getElementById("edit_cust_id").value = cells[0].innerText;
	document.getElementById("edit_cust_title").value = cells[1].innerText;
	document.getElementById("edit_cust_type").value = cells[2].innerText;
	document.getElementById("edit_cust_caddress").value = cells[3].innerText;
	document.getElementById("edit_cust_capincode").value = cells[4].innerText;
	document.getElementById("edit_cust_dob").value = cells[5].innerText;
	document.getElementById("edit_cust_mobile1").value = cells[6].innerText;
	document.getElementById("edit_cust_mobile2").value = cells[7].innerText;
	document.getElementById("edit_cust_rphone").value = cells[8].innerText;
	document.getElementById("edit_cust_raddress").value = cells[9].innerText;

	document.getElementById("editForm").style.display = "block";
}

function updateRow() {
	// Get the updated values from the form
	var cells = selectedRow.getElementsByTagName("td");
	cells[1].innerText = document.getElementById("edit_cust_title").value;
	cells[2].innerText = document.getElementById("edit_cust_type").value;
	cells[3].innerText = document.getElementById("edit_cust_caddress").value;
	cells[4].innerText = document.getElementById("edit_cust_capincode").value;
	cells[5].innerText = document.getElementById("edit_cust_dob").value;
	cells[6].innerText = document.getElementById("edit_cust_mobile1").value;
	cells[7].innerText = document.getElementById("edit_cust_mobile2").value;
	cells[8].innerText = document.getElementById("edit_cust_rphone").value;
	cells[9].innerText = document.getElementById("edit_cust_raddress").value;


	// Send the updated values to the server using AJAX
	var cust_id = document.getElementById("edit_cust_id").value;
	var cust_title = document.getElementById("edit_cust_title").value;
	var cust_type = document.getElementById("edit_cust_type").value;
	var cust_caddress = document.getElementById("edit_cust_caddress").value;
	var cust_capincode = document.getElementById("edit_cust_capincode").value;
	var cust_dob = document.getElementById("edit_cust_dob").value;
	var cust_mobile1 = document.getElementById("edit_cust_mobile1").value;
	var cust_mobile2 = document.getElementById("edit_cust_mobile2").value;
	var cust_rphone = document.getElementById("edit_cust_rphone").value;
	var cust_raddress = document.getElementById("edit_cust_raddress").value;
	$.ajax({
		url: 'customerDataUpdation',
		type: 'POST',
		data: {
			Id: cust_id,
			custTitle: cust_title,
			cust_type: cust_type,
			cust_caddress: cust_caddress,
			cust_capincode: cust_capincode,
			cust_dob: cust_dob,
			cust_mobile1: cust_mobile1,
			cust_mobile2: cust_mobile2,
			cust_rphone: cust_rphone,
			Cust_raddress: cust_raddress,
		},
		success: function(response) {
			// Handle the server response here
			console.log('Success: ', response);

		},
		error: function(error) {
			console.log('Error: ', error);
		}
	});
	closeForm();
}

function closeForm() {
	// Hide the form
	document.getElementById("editForm").style.display = "none";
}