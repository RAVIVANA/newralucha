function fetchTransactions() {
	var type = $("#selectOption").val();
	var accno = $("#accno").val();
	var selectedOption = $("#selectOption").val();
	var div2 = $("#div2");
	$.ajax({
		url: "statement",
		type: "GET",
		data: {
			accountId: accno,
			option: selectedOption,
			type: type
		},
		success: function(data) {
			div2.html(data);
		},
		error: function(xhr, status, error) {
			console.log("Error: " + error);
		}
	});
}