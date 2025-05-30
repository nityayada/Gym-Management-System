//Programming CourseWork 
/* Creating the Parent abstract Class: GymMember
 * Abstract class is the class which cannot be instantiated
*/
public abstract class GymMember {
    //Creating the attributes of the class with protected access modifier
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //Creating the constructor of this class
    public GymMember(int id, String name, String location, String phone,
    String email, String gender, String DOB, String membershipStartDate)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0; // initalized the attendance to zero
        this.loyaltyPoints = 0.0; // initalized the loyaltyPoints to zero
        this.activeStatus = false;// initalized the activeStatus to false
        
    }
    
    //Creating the accessor method(getter) for the all corresponding attribute
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public String getDOB() {
        return DOB;
    }
    public String getMembershipStartDate() {
        return membershipStartDate;
    }
    public int getAttendance() {
        return attendance;
    }
    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public boolean getActiveStatus() {
        return activeStatus;
    }
    
    //Creating the abstract markAttendance method
    public abstract void markAttendance();
    
    //creating activateMembership method  
    public void activateMembership() {
        this.activeStatus = true;
    }
    
    //creating deactivateMembership method (only if it is acitvate )
    public void deactivateMembership() {
        if(this.activeStatus) //this check the boolean value of the activeStatus 
        { 
            this.activeStatus = false;
        }
    }
    
    //Creating resetMember method 
    public void resetMember(){
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        
    }
    
    //Creating the display method to display the membership details
    public void display() {
        System.out.println("Gym Member Details: ");
        System.out.println("ID: "+ id);
        System.out.println("Name: "+ name);
        System.out.println("Location: "+ location);
        System.out.println("Phone: "+ phone);
        System.out.println("Email: "+ email);
        System.out.println("Gender: "+ gender);
        System.out.println("Date of Birth: "+ DOB);
        System.out.println("Membership Start Date: "+ membershipStartDate);
        System.out.println("Attendance: "+ attendance);
        System.out.println("Loyalty Points: "+ loyaltyPoints);
        //Used of Ternary Operator when active is true then return the active and if the false then return the Not active
        System.out.println("Active Status: "+ (activeStatus ? "Active" : "Not Active"));
        
    }
}