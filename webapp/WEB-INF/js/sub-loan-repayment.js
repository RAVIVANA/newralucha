
function getDate()
{
	var today = new Date();
	document.getElementById("date").value = today.getFullYear()+'-'+('0'+(today.getMonth()+1)).slice(-2)+'-'+('0'+today.getDate()).slice(-2);
}


function validateLoanWithdrawlForm() 
{
	let x = document.getElementById("date").value;
	let y = document.getElementById("amount").value;
	if (x == "") 
	{
		alert("date must be filled");
	    return false;
	}
	else if (y == "") 
	{
		alert("enter amount");
	    return false;
	}
	else if (y<=0 || y.includes(".")) 
	{
		alert("invalid amount");
	    return false;
	}
	else
	{
		depositMoney(); 
	}
}

function depositMoney() {
	var loanid = document.getElementById("loanid").value;
	var emi = document.getElementById("emi").value;
	var interest = document.getElementById("interest").value;
	var total = document.getElementById("total").value;
	var amount = document.getElementById("amount").value;
	var complete = document.getElementById("complete").value;
	var date = document.getElementById("date").value;
	var installment_no = document.getElementById("paidMonths").value;
	var pastdue = document.getElementById("pastdue").value;
	var totalwithpenalty = document.getElementById("totalwithpenalty").value;
	
	var requestData = {
		loanid: loanid,
		EMI: emi,
		interest: interest,
		total: total,
		amount: amount,
		complete: complete,
		Date: date,
		installment_no: installment_no
	};
	// Send the AJAX request
	$.ajax({
		url: 'loanRepaymentUrl',
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