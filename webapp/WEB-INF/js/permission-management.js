const selectUserRole = document.getElementById('userRole');
const clerkCheckboxGroup = document.getElementById('clerkCheckboxGroup');
const bankOfficerCheckboxGroup = document.getElementById('bankOfficerCheckboxGroup');
const accountProcessingOfficerCheckboxGroup = document.getElementById('accountProcessingOfficerCheckboxGroup');

selectUserRole.addEventListener('change', function() {
	// Hide all checkbox groups by default
	hideAllCheckboxGroups();

	// Show the checkbox group based on the selected option
	switch (this.value) {
		case 'clerk':
			clerkCheckboxGroup.style.display = 'block';
			break;
		case 'bankOfficer':
			bankOfficerCheckboxGroup.style.display = 'block';
			break;
		case 'accountProcessingOfficer':
			accountProcessingOfficerCheckboxGroup.style.display = 'block';
			break;
		default:
			// No option selected, hide all checkbox groups
			hideAllCheckboxGroups();
			break;
	}
});

function hideAllCheckboxGroups() {
	clerkCheckboxGroup.style.display = 'none';
	bankOfficerCheckboxGroup.style.display = 'none';
	accountProcessingOfficerCheckboxGroup.style.display = 'none';
}

function resetForm() {
	selectUserRole.value = '';
	hideAllCheckboxGroups();
}