/* Creating the Subclass: PremiumMember
 * PremiumMember inherits from the parentclass GymMember
 * It follow the Hierarchical Inheritance
   */
public class PremiumMember extends GymMember {
    
    //Creating this class attridutes
    private final double premiumCharge; // final keyowrd is used to make this variable unchangeable 
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //Creating this class constructor 
    PremiumMember(int id, String name, String location, String phone,
    String email, String gender, String DOB, String membershipStartDate, 
    String personalTrainer) {
        // calling the superclass constructor
        super( id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000.0;
        this.paidAmount = 0.0;
        this.isFullPayment = false;
        this.discountAmount = 0.0;
        this.personalTrainer = personalTrainer;
    }
 
    //Creating the accessor method(getter) for this class attridutes
    public double getPremiumCharge() {
        return premiumCharge;
    }
    public String getPersonalTrainer() {
        return personalTrainer;
    }
    public boolean getIsFullPayment() {  
        return isFullPayment;
    }
    public double getPaidAmount() {
        return paidAmount;
    }
    public double getDiscountAmount() {
        return discountAmount;
    }
    
    //Implementing and overriding the abstract method of parentclass markAttendance
    @Override
    public void markAttendance() {
        if(this.activeStatus) { //this check acitveStatus before marking attendance
            this.attendance++;
            this.loyaltyPoints += 10; //premium get more loyalty points
        }
    }
    
    //creating the payDueAmount method 
    public String payDueAmount(double paidAmount) {
        //check if payment is already complete
        if(this.isFullPayment) {
            return "Payment is already completed. No further payment is required. ";
        }
        //check if payment exceeds the premium charge then
        else if(this.paidAmount + paidAmount > premiumCharge ) {
            return "Payment exceeds the premium price. Please pay the correct amount. ";
        }
        else {
            //update paidAmount
            this.paidAmount += paidAmount;
            //check if the full payment is made
            if(this.paidAmount == premiumCharge) {
                this.isFullPayment = true;
                return "Payment sucessful. Payment is now complete. ";
            }
            //if no then calculating the remaining amount
            else {
                double remainingAmount = premiumCharge - this.paidAmount;
                return "Payment successful. Remainig amount to be paid: Rs." + remainingAmount;
            }
        }
    }
    
    //Creating th calculateDiscount method 
    public void calculateDiscount() {
        if(this.isFullPayment ) {
            this.discountAmount = 0.10 * premiumCharge; 
            //10% discount applied in premium charge if the fullpayment is done only 
            System.out.println("Discount calculated: Rs." + discountAmount);
        }
        else {
            System.out.println("No discount available. Full payment required. ");
        }
    }
    
    //Creating revertPremiumMember method
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
    }
    
    //Creating the display method which implements and overriding the parent class
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full payment status: " + 
        (isFullPayment ? "Fully Paid" : "Not Paid"));
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: Rs." + remainingAmount);
        if(isFullPayment) {
            System.out.println("Discount Amount: Rs." + discountAmount);
        }
        System.out.println("===================================\n");
    }
}


