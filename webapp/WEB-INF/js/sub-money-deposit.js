function getDate()
{
	var today = new Date();
	document.getElementById("date").value = today.getFullYear()+'-'+('0'+(today.getMonth()+1)).slice(-2)+'-'+('0'+today.getDate()).slice(-2);
}

function validateDepositeForm() 
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
		deposit_money(); 
	}
}



   function deposit_money() {
	  
	  var accountNumber = document.getElementById("accountNumber").value;
	  var amount = document.getElementById("amount").value;  
	  var date = document.getElementById("date").value;  
	      
	  var requestData = {
			  AccountNumber: accountNumber,
			  Amount: amount,
			  Date: date
	  };

	  // Send the AJAX request
	  $.ajax({
	    url: 'moneyDepositUrl',
	    type: 'POST',
	    data: requestData,
	    success: function(response) {
	      // Handle the success response
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
  