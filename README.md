<h1>Gym Management System</h1> 

<h2>Overview</h2>
<p>The Gym Management System is a Java-based desktop application designed to manage gym memberships efficiently. Built using Java Swing for the GUI, it supports both Regular and Premium membership types, offering a user-friendly interface to handle member details, payments, attendance, and plan upgrades. The system follows object-oriented principles, including hierarchical inheritance, to ensure modularity and extensibility.</p>

<h3>Features</h3>
<ul>
<li>Member Management: Add, activate, deactivate, and revert both Regular and Premium members.</li>
<li>Membership Plans: Supports three Regular plans (Basic, Standard, Deluxe) and a Premium plan with a personal trainer and discount eligibility.</li>
<li>Attendance Tracking: Mark attendance for active members, with Regular members earning 5 loyalty points and Premium members earning 10 points per attendance.</li>
<li>Plan Upgrades: Regular members can upgrade plans (Basic to Standard/Deluxe) if they meet attendance requirements (30+ sessions).</li>
<li>Payment Handling: Premium members can make partial or full payments, with a 10% discount applied upon full payment.</li>
<li>Data Persistence: Save member details to a file (MemberDetails.txt) and read them back for display.</li>
<li>Input Validation: Ensures valid inputs for ID, phone number (10 digits), and payment amounts, with error messages for invalid entries.</li>
<li>Tabbed Interface: Separate tabs for Regular and Premium members, with a shared display panel for member details.</li>
<li>Error Handling: Robust exception handling for numeric inputs, duplicate IDs, and file operations.</li>
</ul>

<h3>Project Structure</h3>
<ul>
<li>GymMember.java: Abstract parent class defining common attributes and methods for members.</li>
<li>RegularMember.java: Subclass for Regular members, handling plan-specific logic and upgrades.</li>
<li>PremiumMember.java: Subclass for Premium members, managing payments and discounts.</li>
<li>GymGUI.java: Main GUI class using Java Swing, implementing the user interface and event handling.</li>
</ul>

<h3>How to Run</h3>
<ul>
<li>Ensure Java (JDK 8 or later) is installed.</li>
<li>Compile and run GymGUI.java to launch the application.</li>
<li>Use the GUI to manage members via the Regular or Premium tabs.</li>
<li>Member details are saved to MemberDetails.txt in the project directory.</li>
</ul>

<h3>Technologies Used</h3>
<ul>
<li>Java: Core programming language.</li>
<li>Java Swing: For the graphical user interface.</li>
<li>File I/O: For persistent storage of member data.</li>
</ul>

<h3>Usage</h3>
<ul>
<li>Add Member: Enter details in the respective tab and click "Add Regular Member" or "Add Premium Member."</li>
<li>Manage Membership: Use buttons to activate/deactivate memberships, mark attendance, or revert members.</li>
<li>Premium Payments: Enter payment amounts for Premium members and calculate discounts.</li>
<li>File Operations: Save or read member data to/from MemberDetails.txt.</li>
<li>Plan Upgrades: Select a new plan for Regular members and click "Upgrade Plan" (if eligible).</li>
</ul>

<h3>Future Enhancements</h3>
<ul>
<li>Add database support for scalable storage.</li>
<li>Implement user authentication for admin access.</li>
<li>Enhance reporting with attendance and payment summaries.</li>
</ul>

