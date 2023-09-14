const togglePassword = document.querySelector('#togglePassword');
  const password = document.querySelector('#typePasswordX');

  togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye slash icon
    this.classList.toggle('fa-eye-slash');

  

});

document.addEventListener("DOMContentLoaded", function () {
  const usernameInput = document.getElementById("username");
  const passwordInput = document.getElementById("typePasswordX");
  const submitButton = document.getElementById("Submit");

  // Function to validate the username and password
  function validateCredentials() {
      const username = usernameInput.value.trim();
      const password = passwordInput.value.trim();

      if (username === "" || password === "") {
          alert("Username and password are required.");
          return false;
      }

      
      if (username.length < 5) {
          alert("Username must be at least 5 characters long.");
          return false;
      }

      
      if(username === "usernormal123" && password === "password123"){
        alert("Success");
        return true;
      }
      else{
        alert("Invalid Credentials");
        alert("Login Failed, Please enter correct Username or Password");
        return false;
      }
      
  }

  
  submitButton.addEventListener("click", function (event) {
      event.preventDefault(); // Prevent the form from submitting by default

      // Call the validation function
      if (validateCredentials()) {
          alert("Login successful!"); 
          window.location.href = "./User_main/index.html";
          //Link the User Page here
      }
  });
});
