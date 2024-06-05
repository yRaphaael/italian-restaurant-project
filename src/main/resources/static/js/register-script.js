document.addEventListener("DOMContentLoaded", function() {
    const registerBtn = document.querySelector('.register-btn');

    registerBtn.addEventListener('click', function(event) {
        event.preventDefault();

        const name = document.querySelector('.name-input-registration').value;
        const email = document.querySelector('.email-input-registration').value;
        const password = document.querySelector('.password-input-registration').value;

        const user = {
            userName: name,
            userEmail: email,
            userPassword: password
        };

        fetch('http://localhost:8080/user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        .then(response => {
            if (!response.ok) {
                return response.json().then(error => { throw new Error(error.message); });
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            alert('User registered successfully!');
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to register user.');
        });
    });
});
