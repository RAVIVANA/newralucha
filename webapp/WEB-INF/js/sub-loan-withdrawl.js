function getDate()
{
	var today = new Date();
	document.getElementById("date").value = today.getFullYear()+'-'+('0'+(today.getMonth()+1)).slice(-2)+'-'+('0'+today.getDate()).slice(-2);
}
function validateLoanWithdrawlForm() 
{
	let x = document.getElementById("date").value;
	
	if (x == "") 
	{
		alert("date must be filled");
	    return false;
	}
	
	
	else
	{
		withdrawMoney(); 
	}
}


function withdrawMoney() {
	var accountNumber = document.getElementById("loanid").value;
	var loanamount = document.getElementById("loanamount").value;
	var date = document.getElementById("date").value;

	// Send the AJAX request
	$.ajax({
		url: 'loanWithdrawlUrl',
		type: 'POST',
		data: {
			AccountNumber: accountNumber,
			Amount: loanamount,
			Date: date

		},
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