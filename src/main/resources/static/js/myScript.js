// Fetch project list on page load
window.onload = function() {
	fetchProjects();
};

// Fetch projects from API
function fetchProjects() {
	fetch('http://172.16.40.130:8090/api/projects')
		.then(response => response.json())
		.then(data => {
			const projectSelect = document.getElementById('projectSelect');
			projectSelect.innerHTML = '<option value="">Select a Project</option>'; // Clear existing options
			data.forEach(project => {
				const option = document.createElement('option');
				option.value = project.id;
				option.text = project.name;
				projectSelect.appendChild(option);
			});
		})
		.catch(error => {
			console.error('Error fetching projects:', error);
			alert('Failed to load projects. Please try again later.');
		});
}

// Fetch Mantis IDs based on selected project
function fetchMantisIds() {
	const projectId = document.getElementById('projectSelect').value;
	const mantisIdSelect = document.getElementById('mantisIdSelect');
	mantisIdSelect.disabled = true; // Disable until Mantis IDs are fetched
	mantisIdSelect.innerHTML = '<option value="">Select a Mantis ID</option>'; //

	if (projectId) {
		fetch(`http://172.16.40.130:8090/api/mantis/${projectId}`)
			.then(response => response.json())
			.then(data => {
				data.forEach(mantis => {
					const option = document.createElement('option');
					option.value = mantis.mantisId;
					option.text = mantis.mantisId;
					mantisIdSelect.appendChild(option);
				});
				mantisIdSelect.disabled = false; 
			})
			.catch(error => {
				console.error('Error fetching Mantis IDs:', error);
				alert('Failed to load Mantis IDs. Please try again later.');
			});
	}
}

// Clear form fields
function clearFields() {
	document.getElementById('projectSelect').value = '';
	document.getElementById('mantisIdSelect').innerHTML = '<option value="">Select a Mantis ID</option>';
	document.getElementById('mantisIdSelect').disabled = true;
	document.getElementById('reasonInput').value = '';
	document.getElementById('runQueryBox').value = '';
	document.getElementById('resultDisplay').innerHTML = '{}';
}

// Post query to API
function runQuery() {
	const mantisId = document.getElementById('mantisIdSelect').value;
	const reason = document.getElementById('reasonInput').value;
	const runQuery = document.getElementById('runQueryBox').value;

	if (mantisId && reason && runQuery) {
		const payload = {
			mantisId: mantisId,
			reason: reason,
			runQuery: runQuery
		};

		fetch('http://172.16.40.130:8090/api/mantis-integration/postMantisIntegration', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(payload)
		})
			.then(response => response.text())
			.then(data => {
				document.getElementById('resultDisplay').innerHTML = `{ "result": "${data}" }`;
			})
			.catch(error => {
				console.error('Error posting query:', error);
				alert('Failed to submit query. Please try again.');
			});
	} else {
		alert('Please fill in all fields.');
	}
}