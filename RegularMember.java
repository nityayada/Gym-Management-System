/* Creating the Subclass: RegularMember
 * RegularMember inherits from the parentclass GymMember
 * It follow the Hierarchical Inheritance
   */
public class RegularMember extends GymMember {
    
    //Creating the private attributes 
    private final int attendanceLimit; // final keyowrd is used to make this variable unchangeable 
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //creating this class constuctor with parameters
    public RegularMember(int id, String name, String location, String phone,
    String email, String gender, String DOB, String membershipStartDate,
    String referralSource) {
        // calling the superclass constructor
        super( id, name, location, phone, email, gender, DOB,
        membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.attendanceLimit = 30;
        this.plan = "basic";
        this.price = 6500.0;
        this.removalReason = "";
    }
    
    //Creating the accessor method(getter) for the all corresponding attridutes 
    public int getAttendanceLimit() {
        return attendanceLimit;
    }
    public boolean getIsEligibleForUpgrade() { 
        return isEligibleForUpgrade;
    }
    public String getRemovalReason() {
        return removalReason;
    }
    public String getReferralSource() {
        return referralSource;
    }
    public String getPlan() {
        return plan;
    }
    public double getPrice() {
        return price;
    }
    
    //Implementing and overriding the abstract method of parentclass markAttendance
    @Override
    public void markAttendance() {
        if(this.activeStatus) { //this check acitveStatus before marking attendance and only mark the attendance if the member is active 
            this.attendance++; 
            this.loyaltyPoints += 5;
            if(getAttendance() >= attendanceLimit) {
                isEligibleForUpgrade = true;
            }
        }
    }
    
    //Creating the method to getPlanPrice
    public double getPlanPrice(String plan) {
        switch(plan.toLowerCase()) {
            case "basic": 
                return 6500.0;
            case "standard": 
                return 12500.0;
            case "deluxe": 
                return 18500.0;
            default: 
                return -1; //if it passed the invaild plan
        }
    }
    
    //Creating the upgradePlan method 
    public String upgradePlan(String plan) {
        if(this.isEligibleForUpgrade) {
            double price = getPlanPrice(plan);
            //return if the user input invalid plan 
            if(price == -1) {
                return "Invaild plan. Please choose a vaild plan.";
            }
            //return if the plan is same 
            else if(plan.equalsIgnoreCase(this.plan)) { 
                return "Member is already on this Plan.";
            }
            else {
                this.plan = plan;
                this.price = price;
                return "Plan upgraded to " + plan + " with price Rs."+ price;
            }
        }
        else {
            return "Member is not eligible for upgrade."; //If the member is invalid with requirement for the upgrade 
        }
    }
    
    //Creating the revertRegualarMember method
    public void revertRegularMember(String removalReason) {
        //Calling the superclass method resetMember
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500.0;
        this.removalReason = removalReason;
    }
    
    //Creating the display method which implements the parent class
    @Override
    public void display() {
        //Calling the display method of the parent class 
        super.display();
        System.out.println("Plan: "+ plan);
        System.out.println("Price: Rs."+ price);
        if(!removalReason.isEmpty()) { //if the removalReason is not empty then print the removalReason
            System.out.println("Removal Reason: "+ removalReason);
        }
        System.out.println("===================================\n");
    }
}