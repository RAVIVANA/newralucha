document.addEventListener('DOMContentLoaded', function() {
	var dateTimeField = document.getElementById('dateTime');
	var currentDate = new Date();
	var dateString = currentDate.toLocaleDateString();
	var timeString = currentDate.toLocaleTimeString();
	dateTimeField.value = dateString + ' ' + timeString;
});