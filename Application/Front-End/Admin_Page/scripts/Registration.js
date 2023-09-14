// Get the form and success message elements
const registrationForm = document.getElementById("registration-form");
const registrationSuccess = document.getElementById("registration-success");

// Event listener for form submission
registrationForm.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    // Get form data
    const username = document.getElementById("username").value.trim();
    const firstName = document.getElementById("firstName").value.trim();
    const lastName = document.getElementById("lastName").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;

    // Validation checks
    if (!validateUsername(username) || !validateName(firstName) || !validateName(lastName) || !validateEmail(email) || !validatePassword(password)) {
        return false; // Validation failed, prevent form submission
    }

    // Display success message, hide the form, and show "Log In Now" button
    registrationForm.style.display = "none";
    registrationSuccess.style.display = "block";

    // Create "Log In Now" button
    const loginButton = document.createElement("button");
    loginButton.textContent = "Log In Now";
    loginButton.id = "login-button";
    loginButton.addEventListener("click", function () {
        
        window.location.href = "login.html";
    });

    registrationSuccess.appendChild(loginButton);
});

// Validation functions
function validateUsername(username) {
    // Username must be at least 5 characters long
    if (username.length < 5) {
        alert("Username must be at least 5 characters long.");
        return false;
    }
    return true;
}

function validateName(name) {
    // Name must not be empty
    if (name === "") {
        alert("Name cannot be empty.");
        return false;
    }
    return true;
}

function validateEmail(email) {
    // Email validation pattern (basic pattern for demonstration)
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }
    return true;
}

function validatePassword(password) {
    // Password must be at least 8 characters long
    if (password.length < 8) {
        alert("Password must be at least 8 characters long.");
        return false;
    }
    return true;
}
