// Dummy user data (replace with your actual data)
const dummyUsers = [
    { username: "vendor1", password: "password1" },
    { username: "vendor2", password: "password2" }
];

// Function to validate the login form
function validateLoginForm() {
    const username = document.getElementById("vendorID").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.getElementById("error-message");

    // Check if username and password are not empty
    if (username.trim() === "" || password.trim() === "") {
        errorMessage.textContent = "Username and password cannot be empty.";
        return false; // Prevent form submission
    }

    // Check if the username and password match any dummy user data
    const user = dummyUsers.find(user => user.username === username && user.password === password);

    if (user) {
        
        window.location.href = "Vendor_MainPage.html";
        return false; // Prevent form submission
    } else {
        errorMessage.textContent = "Invalid username or password";
        return false; // Prevent form submission
    }
}
