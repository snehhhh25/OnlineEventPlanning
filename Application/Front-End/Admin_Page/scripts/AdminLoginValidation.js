// Dummy user data (replace with your actual data)
const dummyUsers = [
    { username: "admin", password: "password123" },
    { username: "user1", password: "123456" }
];

// Function to validate the login form
function validateLoginForm() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Check if the username and password match any dummy user data
    const user = dummyUsers.find(user => user.username === username && user.password === password);

    if (user) {
        // Successful login, navigate to the home page 
        window.location.href = "admin_main_page.html";
        return false; // Prevent form submission
    } else {
        // Display an error message on the admin page and stay on the same page
        const errorMessage = document.getElementById("error-message");
        errorMessage.textContent = "Invalid username or password";
        return false; // Prevent form submission
    }
}
