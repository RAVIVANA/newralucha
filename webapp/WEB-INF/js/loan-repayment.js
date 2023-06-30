function validateAndProcessAccountNumber() {
	var input = document.getElementById("loanid");
	var value = input.value;

	if (value.length > 1) {
		input.value = value.slice(0, 2);
	}

	if (value.length >= 1) {
		processAccountNumber(value);
	}
}

function processAccountNumber(accountNumber) {
	document.getElementById('resulttable').innerHTML = "";
	$.ajax({
		url: 'getLoanRepaytDetails',
		method: 'post',
		data: { accountNumber: accountNumber },
		success: function(resultText) {
			$('#resulttable').html(resultText);
		},
		error: function(jqXHR, exception) {
			console.log('Error occurred!');
		}
	})
}
