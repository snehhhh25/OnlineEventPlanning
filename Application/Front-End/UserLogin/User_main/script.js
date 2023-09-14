// JavaScript code to handle user interactions

// Function to load content into the "content" section
function loadContent(content) {
    document.getElementById("content").innerHTML = content;
}

// Event listener for the navigation links
document.getElementById("viewProfileLink").addEventListener("click", function() {
    // Load the vendor profile data when "View Profile" is clicked
    const dummyProfileData = `
    <div class="container">
      <header>User Details</header>
      <form action="#" class="form">
        <div class="input-box">
          <label>Full Name</label>
          <input type="text" placeholder="John Doe" readonly />
        </div>

        <div class="input-box">
          <label>User Id</label>
          <input type="text" placeholder="VD123456" readonly />
        </div>
        <div class="input-box address">
          <label>Address</label>
          <input type="text" placeholder="123 Main St" readonly />
          <input type="text" placeholder="Apt 456" readonly />
          <div class="column">
            <div class="select-box">
              <select disabled>
                <option hidden>Country</option>
                <option selected>America</option>
                <option>Japan</option>
                <option>India</option>
                <option>Nepal</option>
              </select>
            </div>
            <input type="text" placeholder="New York" readonly />
          </div>
          <div class="column">
            <input type="text" placeholder="NY" readonly />
            <input type="number" placeholder="12345" readonly />
          </div>
        </div>
        <div class="input-box">
          <label>Email Address</label>
          <input type="text" placeholder="john@example.com" readonly />
        </div>

        <div class="column">
          <div class="input-box">
            <label>Contact Number</label>
            <input type="number" placeholder="123-456-7890" readonly />
          </div>
          <div class="input-box">
            <label>Birth Date</label>
            <input type="date" placeholder="1990-01-01" readonly />
          </div>
        </div>

        <div>
          <br>
        </div>
        <div class="input-box">
          <label>Selected Package</label>
          <input type="text" placeholder="Premium" readonly />
        </div>

        <button disabled>Submit</button>
      </form>
    </div>
`;

    loadContent(dummyProfileData);
});


// Event listeners for other navigation links
document.getElementById("changePasswordLink").addEventListener("click", function() {
    // Load the change password form when "Change Password" is clicked
    const changePasswordForm = `
        <!-- Change password form HTML (you can add this part) -->
    `;
    loadContent(changePasswordForm);
});

document.getElementById("sendPlanRequestLink").addEventListener("click", function() {
    // Display "Plan Request Sent Successfully" message
    const planRequestSentMessage = `<h2>Plan Request Sent Successfully...!!!We Will Get Back To You Shortly.</h2>`;
    loadContent(planRequestSentMessage);
});

document.getElementById("viewQuotationsLink").addEventListener("click", function() {
    // Load the view quotations table when "View Quotations" is clicked
    const quotationsTable = `
        <!-- View quotations table HTML (you can add this part) -->
    `;
    loadContent(quotationsTable);
});
