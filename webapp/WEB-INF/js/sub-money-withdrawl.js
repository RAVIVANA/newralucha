function getDate()
{
	var today = new Date();
	document.getElementById("date").value = today.getFullYear()+'-'+('0'+(today.getMonth()+1)).slice(-2)+'-'+('0'+today.getDate()).slice(-2);
}

function validateWithdrawlForm() 
{
	let x = document.getElementById("date").value;
	let z = document.getElementById("mode").value;
	let y = document.getElementById("amount").value;
	
	if (x == "") 
	{
		alert("date must be filled");
	    return false;
	}
	else if (z == "") 
	{
		alert("select Mode of withdrawl");
	    return false;
	}
	else if (y == "") 
	{
		alert("enter amount to deposit");
	    return false;
	}
	else if (y<=0 || y.includes(".")) 
	{
		alert("invalid amount");
	    return false;
	}
	
	else
	{
		withdraw_money(); 
	}
}

function withdraw_money() {

	var accountNumber = document.getElementById("accountNumber").value;
	var amount = document.getElementById("amount").value;
	var date = document.getElementById("date").value;  
	var mode = document.getElementById("mode").value;  
	
	var requestData = {
		AccountNumber: accountNumber,
		Amount: amount,
		Date: date,
		Mode: mode
	};

	// Send the AJAX request
	$.ajax({
		url: 'moneyWithDrawlUrl',
		type: 'POST',
		data: requestData,
		success: function(response) {
			$('#successMessage').text(response).fadeIn();

			setTimeout(function() {
				$('#successMessage').fadeOut();
			}, 3000);
			form.trigger('reset'); // Optional: Reset the form after successful submission
			console.log('Third server request success:', response);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// Handle the error
			console.error('Third server request error:', textStatus, errorThrown);
		}
	});

}