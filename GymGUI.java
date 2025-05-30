 /*This GymGUI */

//importing the packages 
import java.util.ArrayList; //importing the ArrayLists class from the java.util package 
import javax.swing.JFrame; //importing the JFrame class from the util javax.swing package 
import javax.swing.JPanel; //importing the JPanel class from the util javax.swing package
import javax.swing.JLabel; //importing the Jlabel class from the util javax.swing package
import javax.swing.JTextField; //importing the JTextField class from the util javax.swing package
import javax.swing.JComboBox; //importing the JComboBox class from the util javax.swing package
import javax.swing.JRadioButton; //importing the JRadioButton class from the util javax.swing package
import javax.swing.ButtonGroup; //importing the ButtonGroup class from the util javax.swing package
import javax.swing.JButton; // importing the JButton class from sswing javax.swing package
import javax.swing.BorderFactory; //importing the BorderFactory class from the util javax.swing package
import javax.swing.JScrollPane; // Adding for scrollable main panel
import java.awt.Color; //importing the Color class from the util java.awt package
import java.awt.Dimension; // Adding for setting preferred size 
import javax.swing.JTextArea; //importing the jTextarea 
import java.awt.event.ActionListener; //importing actionListener 
import java.awt.event.ActionEvent; //importing actionEvent
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

public class GymGUI implements ActionListener {
    // Instance variables 
    private ArrayList<GymMember> obj;
    private JFrame frame;

    // Components for regularPanel
    private JLabel regularTitleLabel, idLabelReg, nameLabelReg, locationLabelReg, 
        phoneLabelReg, emailLabelReg, genderLabelReg,
        dobLabelReg, membershipStartDateLabelReg, referralSourceLabelReg,
        removalReasonLabelReg, planLabelReg, 
        regularPriceLabelReg;
    private JTextField idTfReg, nameTfReg, locationTfReg, phoneTfReg, emailTfReg,
        referralSourceTfReg, removalReasonTfReg, trainerNameTfReg, 
        regularPriceTfReg;
    private JRadioButton maleRadioReg, femaleRadioReg, otherRadioReg;
    private ButtonGroup genderGroupReg;
    private JComboBox<String> dobYearComboBoxReg, dobMonthComboBoxReg, dobDayComboBoxReg,
        msYearComboBoxReg, msMonthComboBoxReg, msDayComboBoxReg, planComboBoxReg;
    private JPanel personalPanelReg, memberPanelReg, planPaymentPanelReg, regularPanel;

    // Components for premiumPanel 
    private JLabel premiumTitleLabel, idLabelPrem, nameLabelPrem,       
        locationLabelPrem, phoneLabelPrem, emailLabelPrem, genderLabelPrem,
        dobLabelPrem, membershipStartDateLabelPrem, paidAmountLabelPrem,
        removalReasonLabelPrem, trainerNameLabelPrem,premiumPriceLabelPrem, discountAmountLabelPrem;
    private JTextField idTfPrem, nameTfPrem, locationTfPrem, phoneTfPrem, emailTfPrem, 
        paidAmountTfPrem, trainerNameTfPrem, premiumPriceTfPrem, discountAmountTfPrem;
    private JRadioButton maleRadioPrem, femaleRadioPrem, otherRadioPrem;
    private ButtonGroup genderGroupPrem;
    private JComboBox<String> dobYearComboBoxPrem, dobMonthComboBoxPrem, dobDayComboBoxPrem,
        msYearComboBoxPrem, msMonthComboBoxPrem, msDayComboBoxPrem;
    private JPanel personalPanelPrem, memberPanelPrem, planPaymentPanelPrem, premiumPanel;

    //Creating the JTabbedPane for switching from the regular member and premium member 
    private JTabbedPane tabbedPane; // New JTabbedPane
    // button for the regular 
    private JButton addRegularBtnReg, activateBtnReg, deactivateBtnReg, 
        markAttendanceBtnReg, revertRegularBtnReg, displayBtnReg, 
    clearBtnReg, upgradePlanBtnReg, saveToFileBtnReg,readFromFileBtnReg; ;
    // button for the Premium
    private JButton addPremiumBtnPrem, activateBtnPrem, deactivateBtnPrem, 
        markAttendanceBtnPrem, revertPremiumBtnPrem, displayBtnPrem, 
        clearBtnPrem,calculateDiscountBtnPrem, payDueAmountBtnPrem,
        saveToFileBtnPrem, readFromFileBtnPrem;
    private JPanel displayPanel;
    private JTextArea displayAreaTA;
    private JScrollPane displayScrollPane;
    private File f;

    // Constructor
    public GymGUI() {
        // Initialize the ArrayList
        obj = new ArrayList<GymMember>();

        // Create the JFrame
        frame = new JFrame("Gym Management System");
        f = new File("MemberDetails.txt");

        // Create JTabbedPane
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 530, 760); // Position and size for the tabbed pane

        /*----------------- Regular Panel  ----------------------*/
        regularPanel = new JPanel();
        regularPanel.setLayout(null);
        regularPanel.setPreferredSize(new Dimension(450, 1000)); // Large enough for scrolling

        // Personal Information Panel (Regular)
        personalPanelReg = new JPanel();
        personalPanelReg.setLayout(null);
        personalPanelReg.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Personal Information"));
        personalPanelReg.setBounds(20, 60, 450, 270);

        // Membership Details Panel (Regular)
        memberPanelReg = new JPanel();
        memberPanelReg.setLayout(null);
        memberPanelReg.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Membership Details"));
        memberPanelReg.setBounds(20, 340, 450, 140);

        // Plan & Payment Panel (Regular)
        planPaymentPanelReg = new JPanel();
        planPaymentPanelReg.setLayout(null);
        planPaymentPanelReg.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Plan & Payment"));
        planPaymentPanelReg.setBounds(20, 490, 450, 145);

        //Regular title bar 
        regularTitleLabel = new JLabel("Regular Member");
        regularTitleLabel.setBounds(140, 5, 200, 50);
        regularTitleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
        regularPanel.add(regularTitleLabel);

        // Add all Regular components 
        // ID (Regular)
        idLabelReg = new JLabel("ID:");
        idLabelReg.setBounds(20, 20, 100, 30);
        personalPanelReg.add(idLabelReg);
        idTfReg = new JTextField();
        idTfReg.setBounds(160, 20, 270, 35);
        personalPanelReg.add(idTfReg);

        // Name (Regular)
        nameLabelReg = new JLabel("Name:");
        nameLabelReg.setBounds(20, 55, 100, 30);
        personalPanelReg.add(nameLabelReg);
        nameTfReg = new JTextField();
        nameTfReg.setBounds(160, 55, 270, 35);
        personalPanelReg.add(nameTfReg);

        // Location (Regular)
        locationLabelReg = new JLabel("Location:");
        locationLabelReg.setBounds(20, 90, 100, 30);
        personalPanelReg.add(locationLabelReg);
        locationTfReg = new JTextField();
        locationTfReg.setBounds(160, 90, 270, 35);
        personalPanelReg.add(locationTfReg);

        // Phone (Regular)
        phoneLabelReg = new JLabel("Phone:");
        phoneLabelReg.setBounds(20, 125, 100, 30);
        personalPanelReg.add(phoneLabelReg);
        phoneTfReg = new JTextField();
        phoneTfReg.setBounds(160, 125, 270, 35);
        personalPanelReg.add(phoneTfReg);

        // Email (Regular)
        emailLabelReg = new JLabel("Email:");
        emailLabelReg.setBounds(20, 160, 100, 30);
        personalPanelReg.add(emailLabelReg);
        emailTfReg = new JTextField();
        emailTfReg.setBounds(160, 160, 270, 35);
        personalPanelReg.add(emailTfReg);

        // Gender (Regular)
        genderLabelReg = new JLabel("Gender:");
        genderLabelReg.setBounds(20, 195, 100, 30);
        personalPanelReg.add(genderLabelReg);
        maleRadioReg = new JRadioButton("Male");
        maleRadioReg.setBounds(160, 195, 70, 30);
        personalPanelReg.add(maleRadioReg);
        femaleRadioReg = new JRadioButton("Female");
        femaleRadioReg.setBounds(240, 195, 90, 30);
        personalPanelReg.add(femaleRadioReg);
        otherRadioReg = new JRadioButton("Other");
        otherRadioReg.setBounds(340, 195, 90, 30);
        personalPanelReg.add(otherRadioReg);

        genderGroupReg = new ButtonGroup();
        genderGroupReg.add(maleRadioReg);
        genderGroupReg.add(femaleRadioReg);
        genderGroupReg.add(otherRadioReg);

        // DOB (Regular)
        dobLabelReg = new JLabel("DOB:");
        dobLabelReg.setBounds(20, 225, 100, 30);
        personalPanelReg.add(dobLabelReg);
        String[] monthDOBReg = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        dobMonthComboBoxReg = new JComboBox<>(monthDOBReg);
        dobMonthComboBoxReg.setBounds(160, 225, 80, 35);
        personalPanelReg.add(dobMonthComboBoxReg);
        String[] dayDOBReg = new String[31];
        for (int i = 1; i <= dayDOBReg.length; i++) {
            dayDOBReg[i - 1] = String.valueOf(i);
        }
        dobDayComboBoxReg = new JComboBox<>(dayDOBReg);
        dobDayComboBoxReg.setBounds(250, 225, 70, 35);
        personalPanelReg.add(dobDayComboBoxReg);
        String[] yearDOBReg = new String[76];
        for (int i = 0; i < yearDOBReg.length; i++) {
            yearDOBReg[i] = String.valueOf(1950 + i);
        }
        dobYearComboBoxReg = new JComboBox<>(yearDOBReg);
        dobYearComboBoxReg.setBounds(325, 225, 90, 35);
        personalPanelReg.add(dobYearComboBoxReg);

        // Membership Start Date (Regular)
        membershipStartDateLabelReg = new JLabel("Membership Start Date:");
        membershipStartDateLabelReg.setBounds(20, 20, 150, 35);
        memberPanelReg.add(membershipStartDateLabelReg);
        msMonthComboBoxReg = new JComboBox<>(monthDOBReg);
        msMonthComboBoxReg.setBounds(180, 20, 80, 35);
        memberPanelReg.add(msMonthComboBoxReg);
        msDayComboBoxReg = new JComboBox<>(dayDOBReg);
        msDayComboBoxReg.setBounds(270, 20, 70, 35);
        memberPanelReg.add(msDayComboBoxReg);
        msYearComboBoxReg = new JComboBox<>(yearDOBReg);
        msYearComboBoxReg.setBounds(345, 20, 90, 30);
        memberPanelReg.add(msYearComboBoxReg);

        // Referral Source (Regular)
        referralSourceLabelReg = new JLabel("Referral Source:");
        referralSourceLabelReg.setBounds(20, 55, 100, 30);
        memberPanelReg.add(referralSourceLabelReg);
        referralSourceTfReg = new JTextField();
        referralSourceTfReg.setBounds(160, 55, 270, 35);
        memberPanelReg.add(referralSourceTfReg);

        // Removal Reason (Regular)
        removalReasonLabelReg = new JLabel("Removal Reason:");
        removalReasonLabelReg.setBounds(20, 90, 130, 30);
        memberPanelReg.add(removalReasonLabelReg);
        removalReasonTfReg = new JTextField();
        removalReasonTfReg.setBounds(160, 90, 270, 35);
        memberPanelReg.add(removalReasonTfReg);

        // Plan (Regular)
        planLabelReg = new JLabel("Plan:");
        planLabelReg.setBounds(20, 20, 100, 30);
        planPaymentPanelReg.add(planLabelReg);
        String[] plan = {"Basic", "Standard", "Deluxe"};
        planComboBoxReg = new JComboBox<>(plan);
        planComboBoxReg.setBounds(160, 20, 110, 35);
        planPaymentPanelReg.add(planComboBoxReg);

        // Regular Price (Regular)
        regularPriceLabelReg = new JLabel("Regular Price:");
        regularPriceLabelReg.setBounds(20, 55, 100, 30);
        planPaymentPanelReg.add(regularPriceLabelReg);
        regularPriceTfReg = new JTextField("6500.0");
        regularPriceTfReg.setEditable(false);
        regularPriceTfReg.setBackground(Color.LIGHT_GRAY);
        regularPriceTfReg.setBounds(160, 55, 270, 35);
        planPaymentPanelReg.add(regularPriceTfReg);

        // Buttons (Regular)
        //add regular member button
        addRegularBtnReg = new JButton("Add Regular Member");
        addRegularBtnReg.setBounds(50, 675, 170, 40);
        regularPanel.add(addRegularBtnReg);
        //activate regular member button
        activateBtnReg = new JButton("Activate Membership");
        activateBtnReg.setBounds(240, 675, 170, 40);
        regularPanel.add(activateBtnReg);
        //deactivate regular member button
        deactivateBtnReg = new JButton("Deactivate Membership");
        deactivateBtnReg.setBounds(50, 725, 170, 40);
        regularPanel.add(deactivateBtnReg);
        //mark attendance regular member button
        markAttendanceBtnReg = new JButton("Mark Attendance");
        markAttendanceBtnReg.setBounds(240, 725, 170, 40);
        regularPanel.add(markAttendanceBtnReg);
        //revert regular member button
        revertRegularBtnReg = new JButton("Revert Regular Member");
        revertRegularBtnReg.setBounds(50, 775, 170, 40);
        regularPanel.add(revertRegularBtnReg);
        //displau member button
        displayBtnReg = new JButton("Display Members");
        displayBtnReg.setBounds(240, 775, 170, 40);
        regularPanel.add(displayBtnReg);
        //save to file button
        saveToFileBtnReg = new JButton("Save to File");
        saveToFileBtnReg.setBounds(50, 825, 170, 40);
        regularPanel.add(saveToFileBtnReg);
        //read from file 
        readFromFileBtnReg = new JButton("Read from File");
        readFromFileBtnReg.setBounds(240, 825, 170, 40);
        regularPanel.add(readFromFileBtnReg);
        //upgrade plan
        upgradePlanBtnReg = new JButton("Upgrade Plan");
        upgradePlanBtnReg.setBounds(50, 875, 170, 40);
        regularPanel.add(upgradePlanBtnReg);
        //clear button
        clearBtnReg = new JButton("Clear");
        clearBtnReg.setBounds(240, 875, 170, 40);
        regularPanel.add(clearBtnReg);

        // Add sub-panels to regularPanel
        regularPanel.add(personalPanelReg);
        regularPanel.add(memberPanelReg);
        regularPanel.add(planPaymentPanelReg);

        /* Register listeners (Regular)
         * .addActionListener(this); -> this help assgined the regular member button
         * to the acttionListener to handle the button clicked to the j comboBox and 
         * radiobutton also and in this "this" refers to the instance of GymMember
         */
        addRegularBtnReg.addActionListener(this);
        activateBtnReg.addActionListener(this);
        deactivateBtnReg.addActionListener(this);
        markAttendanceBtnReg.addActionListener(this);
        revertRegularBtnReg.addActionListener(this);
        displayBtnReg.addActionListener(this);
        saveToFileBtnReg.addActionListener(this);
        readFromFileBtnReg.addActionListener(this);
        upgradePlanBtnReg.addActionListener(this);
        clearBtnReg.addActionListener(this);

        /* ------------------ Premium Panel  -------------------*/
        premiumPanel = new JPanel();
        premiumPanel.setLayout(null);
        premiumPanel.setPreferredSize(new Dimension(450, 1000));

        // Personal Information Panel (Premium)
        personalPanelPrem = new JPanel();
        personalPanelPrem.setLayout(null);
        personalPanelPrem.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Personal Information"));
        personalPanelPrem.setBounds(20, 60, 450, 270);

        // Membership Details Panel (Premium)
        memberPanelPrem = new JPanel();
        memberPanelPrem.setLayout(null);
        memberPanelPrem.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Membership Details"));
        memberPanelPrem.setBounds(20, 340, 450, 140);

        // Plan & Payment Panel (Premium)
        planPaymentPanelPrem = new JPanel();
        planPaymentPanelPrem.setLayout(null);
        planPaymentPanelPrem.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), "Plan & Payment"));
        planPaymentPanelPrem.setBounds(20, 490, 450, 140);

        //Title of the premium 
        premiumTitleLabel = new JLabel("Premium Member");
        premiumTitleLabel.setBounds(140, 5, 240, 50);
        premiumTitleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 28));
        premiumPanel.add(premiumTitleLabel);

        // Add all Premium components (unchanged from your original code)
        // ID (Premium)
        idLabelPrem = new JLabel("ID:");
        idLabelPrem.setBounds(20, 20, 100, 30);
        personalPanelPrem.add(idLabelPrem);
        idTfPrem = new JTextField();
        idTfPrem.setBounds(160, 20, 270, 35);
        personalPanelPrem.add(idTfPrem);

        // Name (Premium)
        nameLabelPrem = new JLabel("Name:");
        nameLabelPrem.setBounds(20, 55, 100, 30);
        personalPanelPrem.add(nameLabelPrem);
        nameTfPrem = new JTextField();
        nameTfPrem.setBounds(160, 55, 270, 35);
        personalPanelPrem.add(nameTfPrem);

        // Location (Premium)
        locationLabelPrem = new JLabel("Location:");
        locationLabelPrem.setBounds(20, 90, 100, 30);
        personalPanelPrem.add(locationLabelPrem);
        locationTfPrem = new JTextField();
        locationTfPrem.setBounds(160, 90, 270, 35);
        personalPanelPrem.add(locationTfPrem);

        // Phone (Premium)
        phoneLabelPrem = new JLabel("Phone:");
        phoneLabelPrem.setBounds(20, 125, 100, 30);
        personalPanelPrem.add(phoneLabelPrem);
        phoneTfPrem = new JTextField();
        phoneTfPrem.setBounds(160, 125, 270, 35);
        personalPanelPrem.add(phoneTfPrem);

        // Email (Premium)
        emailLabelPrem = new JLabel("Email:");
        emailLabelPrem.setBounds(20, 160, 100, 30);
        personalPanelPrem.add(emailLabelPrem);
        emailTfPrem = new JTextField();
        emailTfPrem.setBounds(160, 160, 270, 35);
        personalPanelPrem.add(emailTfPrem);

        // Gender (Premium)
        genderLabelPrem = new JLabel("Gender:");
        genderLabelPrem.setBounds(20, 195, 100, 30);
        personalPanelPrem.add(genderLabelPrem);
        maleRadioPrem = new JRadioButton("Male");
        maleRadioPrem.setBounds(160, 195, 70, 30);
        personalPanelPrem.add(maleRadioPrem);
        femaleRadioPrem = new JRadioButton("Female");
        femaleRadioPrem.setBounds(240, 195, 90, 30);
        personalPanelPrem.add(femaleRadioPrem);
        otherRadioPrem = new JRadioButton("Other");
        otherRadioPrem.setBounds(340, 195, 90, 30);
        personalPanelPrem.add(otherRadioPrem);
        genderGroupPrem = new ButtonGroup();
        genderGroupPrem.add(maleRadioPrem);
        genderGroupPrem.add(femaleRadioPrem);
        genderGroupPrem.add(otherRadioPrem);

        // DOB (Premium)
        dobLabelPrem = new JLabel("DOB:");
        dobLabelPrem.setBounds(20, 225, 100, 30);
        personalPanelPrem.add(dobLabelPrem);
        String[] monthDOBPrem = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        dobMonthComboBoxPrem = new JComboBox<>(monthDOBPrem);
        dobMonthComboBoxPrem.setBounds(160, 225, 80, 35);
        personalPanelPrem.add(dobMonthComboBoxPrem);
        String[] dayDOBPrem = new String[31];
        for (int i = 1; i <= dayDOBPrem.length; i++) {
            dayDOBPrem[i - 1] = String.valueOf(i);
        }
        dobDayComboBoxPrem = new JComboBox<>(dayDOBPrem);
        dobDayComboBoxPrem.setBounds(250, 225, 70, 35);
        personalPanelPrem.add(dobDayComboBoxPrem);
        String[] yearDOBPrem = new String[76]; //setting the size of the array
        for (int i = 0; i < yearDOBPrem.length; i++) {
            yearDOBPrem[i] = String.valueOf(1950 + i);
        }
        dobYearComboBoxPrem = new JComboBox<>(yearDOBPrem);
        dobYearComboBoxPrem.setBounds(325, 225, 90, 35);
        personalPanelPrem.add(dobYearComboBoxPrem);

        // Membership Start Date (Premium)
        membershipStartDateLabelPrem = new JLabel("Membership Start Date:");
        membershipStartDateLabelPrem.setBounds(20, 20, 150, 35);
        memberPanelPrem.add(membershipStartDateLabelPrem);
        msMonthComboBoxPrem = new JComboBox<>(monthDOBPrem);
        msMonthComboBoxPrem.setBounds(180, 20, 80, 35);
        memberPanelPrem.add(msMonthComboBoxPrem);
        msDayComboBoxPrem = new JComboBox<>(dayDOBPrem);
        msDayComboBoxPrem.setBounds(270, 20, 70, 35);
        memberPanelPrem.add(msDayComboBoxPrem);
        msYearComboBoxPrem = new JComboBox<>(yearDOBPrem);
        msYearComboBoxPrem.setBounds(345, 20, 90, 30);
        memberPanelPrem.add(msYearComboBoxPrem);

        // Trainer's Name (Premium)
        trainerNameLabelPrem = new JLabel("Trainer's Name:");
        trainerNameLabelPrem.setBounds(20, 55, 100, 35);
        memberPanelPrem.add(trainerNameLabelPrem);
        trainerNameTfPrem = new JTextField();
        trainerNameTfPrem.setBounds(160, 55, 270, 35);
        memberPanelPrem.add(trainerNameTfPrem);

        // Premium Price (Premium)
        premiumPriceLabelPrem = new JLabel("Premium Price:");
        premiumPriceLabelPrem.setBounds(20, 20, 100, 30);
        planPaymentPanelPrem.add(premiumPriceLabelPrem);
        premiumPriceTfPrem = new JTextField("50000.0");
        premiumPriceTfPrem.setEditable(false);
        premiumPriceTfPrem.setBackground(Color.LIGHT_GRAY);
        premiumPriceTfPrem.setBounds(160, 20, 270, 35);
        planPaymentPanelPrem.add(premiumPriceTfPrem);

        // Discount Amount (Premium)
        discountAmountLabelPrem = new JLabel("Discount Amount:");
        discountAmountLabelPrem.setBounds(20, 55, 120, 30);
        planPaymentPanelPrem.add(discountAmountLabelPrem);
        discountAmountTfPrem = new JTextField("0.0");
        discountAmountTfPrem.setEditable(false);
        discountAmountTfPrem.setBackground(Color.LIGHT_GRAY);
        discountAmountTfPrem.setBounds(160, 55, 270, 35);
        planPaymentPanelPrem.add(discountAmountTfPrem);

        // Paid Amount (Premium)
        paidAmountLabelPrem = new JLabel("Paid Amount:");
        paidAmountLabelPrem.setBounds(20, 90, 100, 30);
        planPaymentPanelPrem.add(paidAmountLabelPrem);
        paidAmountTfPrem = new JTextField();
        paidAmountTfPrem.setBounds(160, 90, 270, 35);
        planPaymentPanelPrem.add(paidAmountTfPrem);

        // Buttons (Premium)
        //Add premium button
        addPremiumBtnPrem = new JButton("Add Premium Member");
        addPremiumBtnPrem.setBounds(50, 670, 170, 40);
        premiumPanel.add(addPremiumBtnPrem);
        //Activate remium member
        activateBtnPrem = new JButton("Activate Membership");
        activateBtnPrem.setBounds(240, 670, 170, 40);
        premiumPanel.add(activateBtnPrem);
        //Deactivate premium member button
        deactivateBtnPrem = new JButton("Deactivate Membership");
        deactivateBtnPrem.setBounds(50, 720, 170, 40);
        premiumPanel.add(deactivateBtnPrem);
        //Mark attendance button
        markAttendanceBtnPrem = new JButton("Mark Attendance");
        markAttendanceBtnPrem.setBounds(240, 720, 170, 40);
        premiumPanel.add(markAttendanceBtnPrem);
        //Revert premium member
        revertPremiumBtnPrem = new JButton("Revert Premium Member");
        revertPremiumBtnPrem.setBounds(50, 770, 170, 40);
        premiumPanel.add(revertPremiumBtnPrem);
        //Display member
        displayBtnPrem = new JButton("Display Members");
        displayBtnPrem.setBounds(240, 770, 170, 40);
        premiumPanel.add(displayBtnPrem);
        //calculate discount member
        calculateDiscountBtnPrem = new JButton("Calculate Discount");
        calculateDiscountBtnPrem.setBounds(50, 820, 170, 40);
        premiumPanel.add(calculateDiscountBtnPrem);
        //Pay Due Amount member
        payDueAmountBtnPrem = new JButton("Pay Due Amount");
        payDueAmountBtnPrem.setBounds(240, 820, 170, 40);
        premiumPanel.add(payDueAmountBtnPrem);
        //Pay Due Amount member
        saveToFileBtnPrem = new JButton("Save to File");
        saveToFileBtnPrem.setBounds(50, 870, 170, 40);
        premiumPanel.add(saveToFileBtnPrem);
        //Pay Due Amount member
        readFromFileBtnPrem = new JButton("Read from File");
        readFromFileBtnPrem.setBounds(240, 870, 170, 40);
        premiumPanel.add(readFromFileBtnPrem);
        //clear button
        clearBtnPrem = new JButton("Clear");
        clearBtnPrem.setBounds(145, 920, 170, 40);
        premiumPanel.add(clearBtnPrem);

        // Add sub-panels to premiumPanel
        premiumPanel.add(personalPanelPrem);
        premiumPanel.add(memberPanelPrem);
        premiumPanel.add(planPaymentPanelPrem);

        /* Register listeners (Premium)
         * .addActionListener(this); -> this help assgined the Premium member button
         * to the acttionListener to handle the button clicked to the j comboBox and 
         * radiobutton also and in this "this" refers to the instance of GymMember
         */
        planComboBoxReg.addActionListener(this);
        addPremiumBtnPrem.addActionListener(this);
        activateBtnPrem.addActionListener(this);
        deactivateBtnPrem.addActionListener(this);
        markAttendanceBtnPrem.addActionListener(this);
        revertPremiumBtnPrem.addActionListener(this);
        displayBtnPrem.addActionListener(this);
        payDueAmountBtnPrem.addActionListener(this);
        calculateDiscountBtnPrem.addActionListener(this);
        saveToFileBtnPrem.addActionListener(this);
        readFromFileBtnPrem.addActionListener(this);
        clearBtnPrem.addActionListener(this);

        // Adding panels to JTabbedPane with scroll panes
        tabbedPane.addTab("Regular", new JScrollPane(regularPanel));
        tabbedPane.addTab("Premium", new JScrollPane(premiumPanel));

        /* ------------- Display Panel Setup  ------------*/
        displayPanel = new JPanel();
        displayPanel.setLayout(null);
        displayPanel.setBounds(540, 5, 420, 755);
        displayPanel.setBorder(BorderFactory.createTitledBorder("Member Details"));
        displayAreaTA = new JTextArea();
        displayAreaTA.setEditable(false);
        displayAreaTA.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane displayScrollPane = new JScrollPane(displayAreaTA);
        displayPanel.add(displayScrollPane);
        displayScrollPane.setBounds(10, 20, 400, 725);

        // Add components to frame
        frame.add(tabbedPane);
        frame.add(displayPanel);

        // Frame setup
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(970, 800); //Adjusting size to fit the tabbed pane and display
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);//it will center the window on the screen 

    }

    /*
     * Handles action events triggered by various components in the GUI.
     * This method is called when an action is performed like button click and combo box selection).
     * 
     * ActionEvent ae The ActionEvent object containing details about the event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Handle regular member plan selection
        if (ae.getSource() == planComboBoxReg) {
            String selectedPlan = (String)planComboBoxReg.getSelectedItem();
            if(selectedPlan == "Basic"){
                regularPriceTfReg.setText("6500.0");
            }
            else if(selectedPlan == "Standard"){
                regularPriceTfReg.setText("12500.0");
            }
            else {
                regularPriceTfReg.setText("18500.0");
            }
        }
        else if (ae.getSource() == addRegularBtnReg) {
            addRegularMember();
        } 
        else if (ae.getSource() == activateBtnReg) {
            activateMembershipReg();
        }
        else if (ae.getSource() == deactivateBtnReg) {
            deactivateMembershipReg();
        }
        else if (ae.getSource() == markAttendanceBtnReg) {
            markAttendanceReg();
        } 
        else if (ae.getSource() == revertRegularBtnReg) {
            revertRegularMember();
        } 
        else if (ae.getSource() == displayBtnReg) {
            displayMembers();
        }
        else if (ae.getSource() == clearBtnReg) {
            clearReg();
        } 
        else if (ae.getSource() == saveToFileBtnReg) {
            saveToFile();
        }
        else if (ae.getSource() == readFromFileBtnReg) {
            readFromFile();
        }
        else if(ae.getSource() == upgradePlanBtnReg) {
            upgradePlan();
        }
        // Handle Premium member plan selection
        else if (ae.getSource() == addPremiumBtnPrem) {
            addPremiumMember();
        } 
        else if (ae.getSource() == activateBtnPrem) {
            activateMembershipPrem();
        }
        else if (ae.getSource() == deactivateBtnPrem) {
            deactivateMembershipPrem();
        }
        else if (ae.getSource() == markAttendanceBtnPrem) {
            markAttendancePrem();
        } 
        else if (ae.getSource() == revertPremiumBtnPrem) {
            revertPremiumMember();
        } 
        else if (ae.getSource() == displayBtnPrem) {
            displayMembers();
        } 
        else if (ae.getSource() == clearBtnPrem) { 
            clearPrem();
        }
        else if (ae.getSource() == calculateDiscountBtnPrem) {
            calculateDiscountPremium();
        }
        else if (ae.getSource() == payDueAmountBtnPrem) {
            payDueAmountPremium();
        }
        else if (ae.getSource() == saveToFileBtnPrem) {
            saveToFile();
        }
        else if (ae.getSource() == readFromFileBtnPrem) {
            readFromFile();
        }
    }

    //creating the addRegularMember method 
    private void addRegularMember() {
        // Exception handling for adding a regular member
        try {
            //Checking if any text field is empty
            if (idTfReg.getText().isEmpty() || nameTfReg.getText().isEmpty() || 
            locationTfReg.getText().isEmpty() || phoneTfReg.getText().isEmpty() || 
            emailTfReg.getText().isEmpty() || referralSourceTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if any field is empty
            }
            //Converting the string to integer value in ID from the text field which may throw NumberFormatException if non-numeric
            int id = Integer.parseInt(idTfReg.getText());

            // If the ID is a duplicate, show an error to the user and stop execution
            if(!obj.isEmpty()){
                if (isDuplicateId(id)) {
                    JOptionPane.showMessageDialog(frame, "Member ID already exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return; // added for clarity to exit early
                }
            }

            // collecting member details from text fields
            String name = nameTfReg.getText();
            String location = locationTfReg.getText();
            String phone = phoneTfReg.getText();
            String email = emailTfReg.getText();
            // for the phone number validation
            try {
                // Check if phone number contains only digits and has exactly 10 characters
                Long.parseLong(phone); // This will throw NumberFormatException if not numeric
                if (phone.length() != 10) {
                    JOptionPane.showMessageDialog(frame, "Phone number must be exactly 10 digits!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Phone number must contain only digits!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // determining gender based on selected radio button
            String gender = "";
            if (maleRadioReg.isSelected()) {
                gender = "Male";
            } 
            else if (femaleRadioReg.isSelected()) {
                gender = "Female";
            } 
            else if (otherRadioReg.isSelected()) {
                gender = "Other";
            }

            //date of birth from combo box selections in (YYYY-MM-DD format)
            String dob = dobYearComboBoxReg.getSelectedItem() + "-" +
                dobMonthComboBoxReg.getSelectedItem() + "-" +
                dobDayComboBoxReg.getSelectedItem();

            //membership start date from combo box selections in (YYYY-MM-DD format)
            String membershipStartDate = msYearComboBoxReg.getSelectedItem() + "-" +
                msMonthComboBoxReg.getSelectedItem() + "-" +
                msDayComboBoxReg.getSelectedItem();

            // referral source from text field
            String referralSource = referralSourceTfReg.getText();

            // Create a new RegularMember object with all collected data
            RegularMember member = new RegularMember(id, name, location, phone,
                    email, gender, dob, membershipStartDate,
                    referralSource);
            // Adding the member to the ArrayList 
            obj.add(member);

            // Update the display area with confirmation in display area 
            displayAreaTA.append("Added Regular Member: " + name + "(ID: " + id + ")\n");

            // Showing  success message to the user when the regular message is added
            JOptionPane.showMessageDialog(frame, "Regular member added successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        }
        /* NumberFormatException is thrown during the conversion of the string into an integer
         * This handles when the user inputs a non-numeric value and shows an error
         */
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating the addPremoumMember method 
    private void addPremiumMember(){
        //Exception handling for the addPremiumMember
        try{
            //Checking if any text field is empty
            if (idTfPrem.getText().isEmpty() || nameTfPrem.getText().isEmpty() || 
            locationTfPrem.getText().isEmpty() || phoneTfPrem.getText().isEmpty() || 
            emailTfPrem.getText().isEmpty() || trainerNameTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if any field is empty
            }
            //Converting the string to integer value in ID from the text field which may throw NumberFormatException if non-numeric
            int id = Integer.parseInt(idTfPrem.getText());

            // If the ID is a duplicate, show an error to the user and stop execution
            if(!obj.isEmpty()){
                if (isDuplicateId(id)) {
                    JOptionPane.showMessageDialog(frame, "Member ID already exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return; // added for clarity to exit early
                }
            }

            // collecting member details from text fields
            String name = nameTfPrem.getText();
            String location = locationTfPrem.getText();
            String phone = phoneTfPrem.getText();
            String email = emailTfPrem.getText();

            // for the phone number validation
            try {
                // Check if phone number contains only digits and has exactly 10 characters
                Long.parseLong(phone); // This will throw NumberFormatException if not numeric
                if (phone.length() != 10) {
                    JOptionPane.showMessageDialog(frame, "Phone number must be exactly 10 digits!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Phone number must contain only digits!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // determining gender based on selected radio button
            String gender = "";
            if (maleRadioPrem.isSelected()) {
                gender = "Male";
            } 
            else if (femaleRadioPrem.isSelected()) {
                gender = "Female";
            } 
            else if (otherRadioPrem.isSelected()) {
                gender = "Other";
            }

            //date of birth from combo box selections in (YYYY-MM-DD format)
            String dob = dobYearComboBoxPrem.getSelectedItem() + "-" +
                dobMonthComboBoxPrem.getSelectedItem() + "-" +
                dobDayComboBoxPrem.getSelectedItem();

            //membership start date from combo box selections in (YYYY-MM-DD format)
            String membershipStartDate = msYearComboBoxPrem.getSelectedItem() + "-" +
                msMonthComboBoxPrem.getSelectedItem() + "-" +
                msDayComboBoxPrem.getSelectedItem();

            // referral source from text field
            String trainerName = trainerNameTfPrem.getText();

            double paidAmount = Double.parseDouble(paidAmountTfPrem.getText());
            if(paidAmount < 0 || paidAmount > 50000){
                JOptionPane.showMessageDialog(frame, "Please enter the valid Premium Price", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new RegularMember object with all collected data
            PremiumMember member = new PremiumMember(id, name, location, phone,
                    email, gender, dob, membershipStartDate,
                    trainerName);
            member.payDueAmount(paidAmount);

            // Adding the member to the ArrayList 
            obj.add(member);

            // Update the display area with confirmation in display area 
            displayAreaTA.append("Added Premium Member: " + name + "(ID: " + id + ")\n");

            // Showing  success message to the user when the regular message is added
            JOptionPane.showMessageDialog(frame, "Premium member added successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        }
        /* NumberFormatException is thrown during the conversion of the string into an integer
         * This handles when the user inputs a non-numeric value and shows an error
         */
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    //activating the regular member
    private void activateMembershipReg() {
        try {
            // Check if the ID text field is empty
            if (idTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members to compare
            }

            // Converting the string to an integer value from the text field
            int id = Integer.parseInt(idTfReg.getText());

            // Find the member by ID
            GymMember member = findMemberById(id);

            if (member != null) {
                if(member.getActiveStatus() == false){
                    // Activate the membership
                    member.activateMembership();

                    // Update the display area with confirmation
                    displayAreaTA.append("Activated membership for ID: " + id + "\n");

                    // Show success message to the user
                    JOptionPane.showMessageDialog(frame, "Membership activated successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Membership has already activated!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } 
            else {
                // Show error message if the member is not found
                JOptionPane.showMessageDialog(frame, "Member not found!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Handle invalid numeric input for ID
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID!", "Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Handle any other unexpected errors
            JOptionPane.showMessageDialog(frame, "Error activating membership: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //activating the premium member
    private void activateMembershipPrem() {
        try {
            // Check if the ID text field is empty
            if (idTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            // Converting the string to integer value from the text field
            int id = Integer.parseInt(idTfPrem.getText());

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members to compare
            }

            GymMember member = findMemberById(id);

            if (member != null) {
                if(member.getActiveStatus() == false){
                    member.activateMembership();
                    displayAreaTA.append("Activated membership for ID: " + id + "\n");
                    JOptionPane.showMessageDialog(frame, "Membership activated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(frame, " Membership has already activated!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } 
            else {
                JOptionPane.showMessageDialog(frame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID!", "Error",
                JOptionPane.ERROR_MESSAGE);
        } 
    }

    //Deactivating the regular member
    private void deactivateMembershipReg() {
        try {
            // Check if the ID text field is empty
            if (idTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            // Converting the string to integer value from the text field
            int id = Integer.parseInt(idTfReg.getText());

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members to compare
            }

            GymMember member = findMemberById(id);

            if (member != null) {
                if(member.getActiveStatus() == true){
                    member.deactivateMembership();
                    displayAreaTA.append("Deactivated membership for ID: " + id + "\n");
                    JOptionPane.showMessageDialog(frame, "Membership deactivated successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Membership already deactivated!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID!", "Error",
                JOptionPane.ERROR_MESSAGE);
        } 
    }

    //Deactivating the premium member
    private void deactivateMembershipPrem() {
        try {
            // Check if the ID text field is empty
            if (idTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            // Converting the string to integer value from the text field
            int id = Integer.parseInt(idTfPrem.getText());

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members to compare
            }

            GymMember member = findMemberById(id);

            if (member != null) {
                if(member.getActiveStatus() == true){
                    member.deactivateMembership();
                    displayAreaTA.append("Deactivated membership for ID: " + id + "\n");
                    JOptionPane.showMessageDialog(frame, "Membership deactivated successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Membership already deactivated!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } 
            else {
                JOptionPane.showMessageDialog(frame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID!", "Error",
                JOptionPane.ERROR_MESSAGE);
        } 
    }

    //creating the markAttendance method for the regular member 
    private void markAttendanceReg() {
        try {
            // Check if the ID text field is empty
            if (idTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }
            int id = Integer.parseInt(idTfReg.getText());
            GymMember member = findMemberById(id);

            //If the id exist is the arraylist then only proceed to next part
            if (member != null) {
                //If the member if acitve then only it markattendance 
                if (member.getActiveStatus() == true) {
                    member.markAttendance();
                    displayAreaTA.append("Marked attendance for ID: " + id + " (Total: " + member.getAttendance() + ")\n");
                    JOptionPane.showMessageDialog(frame, "Attendance marked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                // else it will display the member is not acitve 
                else {
                    JOptionPane.showMessageDialog(frame, "Member is not active!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            //If the member dont exist then it will print the member not found
            else {
                JOptionPane.showMessageDialog(frame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating the markAttendance method for the Premium member 
    private void markAttendancePrem() {
        try {
            // Check if the ID text field is empty
            if (idTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }
            int id = Integer.parseInt(idTfPrem.getText());
            GymMember member = findMemberById(id);

            //If the id exist is the arraylist then only proceed to next part
            if (member != null) {
                //If the member if acitve then only it markattendance of the member
                if (member.getActiveStatus() == true) {
                    member.markAttendance();
                    displayAreaTA.append("Marked attendance for ID: " + id + " (Total: " + member.getAttendance() + ")\n");
                    JOptionPane.showMessageDialog(frame, "Attendance marked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                // else it will display the member is not acitve 
                else {
                    JOptionPane.showMessageDialog(frame, "Member is not active!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            //If the member dont exist then it will print the member not found
            else {
                JOptionPane.showMessageDialog(frame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating the revertMember method for the regular class
    private void revertRegularMember() {
        try {
            // Check if the ID text field is empty
            if (idTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            int id = Integer.parseInt(idTfReg.getText());
            if (removalReasonTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Removal Reason!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }
            String removalReason = removalReasonTfReg.getText();

            for (GymMember member : obj) {
                /*The member.getID() == id -> it used to compare the entered Id with member's
                 * member instanceof RegularMember -> this ensures the member is of regularMember by passing the boolean value 
                 */
                if (member.getId() == id && member instanceof RegularMember) {
                    /*it will cast the GymMember to regularMember and calls revertRegularMember method 
                     * which is also called the downcasting 
                     */
                    ((RegularMember) member).revertRegularMember(removalReason);
                    displayAreaTA.append("Reverted Regular Member ID: " + id + "\n");
                    JOptionPane.showMessageDialog(frame, "Regular member reverted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(frame, "Regular member not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating the revertMember method for the regular class
    private void revertPremiumMember() {
        try {
            // Check if the ID text field is empty
            if (idTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            int id = Integer.parseInt(idTfPrem.getText());

            //Loop through the ArrayList which contain the regular and Premium member
            for (GymMember member : obj) {
                /*The member.getID() == id -> it used to compare the entered Id with member's
                 * member instanceof RegularMember -> this ensures the member is of regularMember
                 */
                if (member.getId() == id && member instanceof PremiumMember) {
                    //it cast the GymMember to Premium and calls revertRegularMember method
                    ((PremiumMember) member).revertPremiumMember();
                    displayAreaTA.append("Reverted Premium Member ID: " + id + "\n");
                    JOptionPane.showMessageDialog(frame, "Premium member reverted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(frame, "Premium member not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*Display method help to display the details of the regular 
     * and premium member in the Display panel
     */
    private void displayMembers() {
        displayAreaTA.setText(""); // Clear previous content

        // Check if there are no members
        if (obj.isEmpty()) {
            displayAreaTA.setText("No members to display.");
            return;
        }

        // If members exist, display them
        for (GymMember member : obj) {
            displayAreaTA.append("===================================\n");

            // Check member type
            if (member instanceof RegularMember) {
                displayAreaTA.append("Regular Member Details:\n");
            } else if (member instanceof PremiumMember) {
                displayAreaTA.append("Premium Member Details:\n");
            }

            // Construct member details using string concatenation (+)
            String details = 
                "ID: " + member.getId() + "\n" +
                "Name: " + member.getName() + "\n" +
                "Location: " + member.getLocation() + "\n" +
                "Phone: " + member.getPhone() + "\n" +
                "Email: " + member.getEmail() + "\n" +
                "Gender: " + member.getGender() + "\n" +
                "DOB: " + member.getDOB() + "\n" +
                "Membership Start Date: " + member.getMembershipStartDate() + "\n" +
                "Attendance: " + member.getAttendance() + "\n" +
                "Loyalty Points: " + member.getLoyaltyPoints() + "\n" +
                "Active Status: " + (member.getActiveStatus() ? "Active" : "Not Active") + "\n";

            // Append additional details based on member type
            //Additional datail for the Regular member
            //instanceof passes the boolean value if memberId is regular then it passes the true 
            if (member instanceof RegularMember)
            {
                RegularMember rm = (RegularMember) member;
                /*This convert the member variable of the GymMember to the regularMember varibale
                 * this allow regular member specfic method
                 */
                details += 
                "Plan: " + rm.getPlan() + "\n" +
                "Price: " + rm.getPrice() + "\n";
                if (!rm.getRemovalReason().isEmpty()) {
                    details += "Removal Reason: " + rm.getRemovalReason() + "\n";
                }
                rm.display();
                //Additional datail for the Premium member    
            } 
            else if (member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member;
                /*This convert the member variable of the GymMember to the premiumMember varibale
                 * this allow premium member specfic method
                 */
                details += 
                "Personal Trainer: " + pm.getPersonalTrainer() + "\n" +
                "Paid Amount: " + pm.getPaidAmount() + "\n" +
                "Full Payment Status: " + (pm.getIsFullPayment() ? "Fully Paid" : "Not Paid") + "\n" +
                "Remaining Amount: " + (pm.getPremiumCharge() - pm.getPaidAmount()) + "\n";
                if (pm.getIsFullPayment()) {
                    pm.calculateDiscount();
                    details += "Discount Amount: " + pm.getDiscountAmount() + "\n";
                }
                pm.display();
            }

            displayAreaTA.append(details);
            displayAreaTA.append("===================================\n\n");
        }
    }

    //Creating the pay due amount method 
    private void payDueAmountPremium() {
        try {
            // Check if the ID text field is empty
            if (idTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }
            // Check if the paid amount field is empty
            if (paidAmountTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Paid Amount!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the paid amount field is empty
            }

            int id = Integer.parseInt(idTfPrem.getText());
            double paidAmount = Double.parseDouble(paidAmountTfPrem.getText());

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members
            }

            GymMember member = findMemberById(id);

            if (member != null && member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member; //Downacasting
                String result = pm.payDueAmount(paidAmount);
                displayAreaTA.append("Payment for ID: " + id + ": " + result + "\n");
                JOptionPane.showMessageDialog(frame, result, "Payment Status",
                    JOptionPane.INFORMATION_MESSAGE);
                // Update the discount amount field if payment is complete
                if (pm.getIsFullPayment()) {
                    discountAmountTfPrem.setText(String.valueOf(pm.getDiscountAmount()));
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Premium member not found!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID and Paid Amount!", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating the calculateDiscount method for the Premium member
    private void calculateDiscountPremium() {
        try{
            // Check if the ID text field is empty
            if (idTfPrem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if the ID field is empty
            }

            int id = Integer.parseInt(idTfPrem.getText());

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members
            }

            GymMember member = findMemberById(id);

            if (member != null && member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member;
                double prevDiscount = pm.getDiscountAmount();
                pm.calculateDiscount();
                double newDiscount = pm.getDiscountAmount();
                discountAmountTfPrem.setText(String.valueOf(newDiscount));
                if (newDiscount > prevDiscount) {
                    displayAreaTA.append("Discount calculated for ID: " + id + ": Rs." + newDiscount + "\n");
                    JOptionPane.showMessageDialog(frame, "Discount calculated: Rs." + newDiscount, "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                } else if(prevDiscount != 0){
                    JOptionPane.showMessageDialog(frame, "Discount is already calculated ", "Infromation",
                        JOptionPane.INFORMATION_MESSAGE);

                }
                else {
                    displayAreaTA.append("No discount available for ID: " + id + ": Full payment required.\n");
                    JOptionPane.showMessageDialog(frame, "No discount available. Full payment required.", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Premium member not found!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating the upgrad plan for the regular memeber
    private void upgradePlan() {
        try {
            // Check if ID field is empty
            if (idTfReg.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(idTfReg.getText());

            // Check if the ArrayList is empty
            if (obj.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members exist in the system!", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return; // Exit early if there are no members
            }
            GymMember member = findMemberById(id);

            if (member != null && member instanceof RegularMember) {
                RegularMember regularMember = (RegularMember) member;

                // Check if member is active
                if (!regularMember.getActiveStatus()) {
                    JOptionPane.showMessageDialog(frame, "Member is not active! Cannot upgrade plan.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String currentPlan = regularMember.getPlan();
                // Get selected plan from combo box
                String selectedPlan = (String) planComboBoxReg.getSelectedItem();
                if (currentPlan.equalsIgnoreCase(selectedPlan)) {
                    JOptionPane.showMessageDialog(frame, "Member is already on the " + selectedPlan + " plan!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String result = regularMember.upgradePlan(selectedPlan.toLowerCase());
                double newPrice = regularMember.getPrice();

                // Update display and show message
                displayAreaTA.append("Plan upgrade for ID: " + id + " to \n" + result +"\n");
                JOptionPane.showMessageDialog(frame, result, "Upgrade Status",
                    JOptionPane.INFORMATION_MESSAGE);

                // Update the price display
                regularPriceTfReg.setText(String.valueOf(regularMember.getPrice()));
            } else {
                JOptionPane.showMessageDialog(frame, "Regular member not found!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid ID number!", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // saveToFile
    private void saveToFile() {
        BufferedWriter writer = null;
        try {
            /*BufferedWriter can’t write to a file on its own—it 
             * needs a Writer like FileWriter to provide the file connection. 
             * here, FileWriter handles the file access,
             * while BufferedWriter optimizes the writing process. 
               */
            writer = new BufferedWriter(new FileWriter(f));
            
            // Write formatted header
            writer.write(String.format("%-5s %-20s %-20s %-15s %-23s %-17s %-10s %-9s %-8s %-13s %-13s %-13s %-13s %-13s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", 
                    "Plan", "Price", "Attendance", "Loyalty Points", "Active Status", 
                    "Full Payment", "Discount Amount", "Net Amount Paid"));

            /* Write separator line
             * java.util.Collections.nCopies(215, "-"): it create the list containing the 215 of the 
             * string"-" and join help to make into the single string
               */
            writer.write(String.join("", java.util.Collections.nCopies(215, "-")) + "\n");

            if (obj.isEmpty()) {
                writer.write("No members to save.");
                JOptionPane.showMessageDialog(frame, "No members to save!", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Write member details with proper formatting
            for (GymMember member : obj) {
                if (member instanceof RegularMember) {
                    RegularMember rm = (RegularMember) member;
                    writer.write(String.format("%-5d %-20s %-20s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-15s %-15s %-15s %-15.2f\n",
                            rm.getId(), 
                            rm.getName(), 
                            rm.getLocation(), 
                            rm.getPhone(), 
                            rm.getEmail(),
                            rm.getMembershipStartDate(), 
                            rm.getPlan(), 
                            rm.getPrice(), 
                            rm.getAttendance(),
                            rm.getLoyaltyPoints(), 
                            rm.getActiveStatus() ? "Active" : "Inactive",
                            "N/A", 
                            "N/A", 
                            rm.getPlanPrice(rm.getPlan())));
                } else if (member instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) member;
                    writer.write(String.format("%-5d %-20s %-20s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-15s %-15s %-15.2f %-15.2f\n",
                            pm.getId(), 
                            pm.getName(), 
                            pm.getLocation(), 
                            pm.getPhone(), 
                            pm.getEmail(),
                            pm.getMembershipStartDate(), 
                            "Premium", 
                            pm.getPremiumCharge(), 
                            pm.getAttendance(),
                            pm.getLoyaltyPoints(), 
                            pm.getActiveStatus() ? "Active" : "Inactive",
                            pm.getIsFullPayment() ? "Yes" : "No", 
                            pm.getDiscountAmount(), 
                            pm.getPaidAmount()));
                }
            }

            displayAreaTA.append("Member details saved to MemberDetails.txt\n");
            JOptionPane.showMessageDialog(frame, "Member details saved successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving to file: " + e.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error closing file: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // readFromFile() method
    private void readFromFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(f)); 
            /*BufferedReader does not have the capability to directly 
             * open or read from a file so we use other FileReader
            */ 

            // Clear display area
            displayAreaTA.setText("");
            displayAreaTA.append("=============================================================\n");
            displayAreaTA.append("                      MEMBER DETAILS                         \n");
            displayAreaTA.append("=============================================================\n\n");

            String line;
            boolean isHeader = true;
            boolean hasMembers = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("-")) {
                    continue; // Skip empty lines or separator lines
                }

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split by multiple spaces (2 or more)
                String[] data = line.trim().split("\\s{2,}"); 
                /*trim help to remove the white spacejavac
                 * split("\\s{2,}")-> it help to split the string where there is two
                 *  or more consecutive whitespace character and convert into the list
                   */

                // If splitting by multiple spaces didn't work well, try splitting by single space
                if (data.length < 10) {
                    data = line.trim().split("\\s+");
                }

                if (data.length >= 10) { // Minimum required fields
                    hasMembers = true;

                    // Create formatted output
                    String formattedOutput = String.format(
                            "ID: %s\nName: %s\nLocation: %s\nPhone: %s\nEmail: %s\n" +
                            "Membership Date: %s\nPlan: %s\nPrice: %s\nAttendance: %s\n" +
                            "Loyalty Points: %s\nStatus: %s\n",
                            safeGet(data, 0), safeGet(data, 1), safeGet(data, 2), safeGet(data, 3),
                            safeGet(data, 4), safeGet(data, 5), safeGet(data, 6), safeGet(data, 7),
                            safeGet(data, 8), safeGet(data, 9), safeGet(data, 10)
                        );

                    // Add premium-specific fields if available
                    if (data.length > 11 && data[6].equalsIgnoreCase("Premium")) {
                        formattedOutput += String.format(
                            "Full Payment: %s\nDiscount Amount: %s\nPaid Amount: %s\n",
                            safeGet(data, 11), safeGet(data, 12), safeGet(data, 13)
                        );
                    }

                    displayAreaTA.append(formattedOutput);
                    displayAreaTA.append("-------------------------------------------------------------\n");
                }
            }

            if (!hasMembers) {
                displayAreaTA.append("No members found in the file.\n");
                displayAreaTA.append("-------------------------------------------------------------\n");
                JOptionPane.showMessageDialog(frame, "No members to display. Please add members first.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Member details read from the file successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "File not found! Please save data first.", "Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error reading file: " + e.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error closing file: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Helper method for the readFromFile method  to safely get array elements
    private String safeGet(String[] array, int index) {
        if (index < array.length) {
            return array[index].trim();
        } else {
            return "N/A";
        } 
        /* this simply give the N/A where there nothing like regular
         * member don't have the disocunt amount in that place it helps to give the N/a 
         * and also help to remove any white sapce from the letter  
        */
    }

    /*this method is used to find the given user id duplicate or not 
     */
    private boolean isDuplicateId(int id) {
        for (GymMember member : obj) {
            if (member.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /*this method is used to find the given user id is exist in the arraylist or no 
     */
    private GymMember findMemberById(int id) {
        //For each loop
        for (GymMember member : obj) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    //Creating the method for the clear text field of the regular member
    private void clearReg() {
        idTfReg.setText("");
        nameTfReg.setText("");
        locationTfReg.setText("");
        phoneTfReg.setText("");
        emailTfReg.setText("");
        femaleRadioReg.setSelected(false);
        maleRadioReg.setSelected(false);
        otherRadioReg.setSelected(false);
        genderGroupReg.clearSelection();
        dobYearComboBoxReg.setSelectedIndex(0);
        dobMonthComboBoxReg.setSelectedIndex(0);
        dobDayComboBoxReg.setSelectedIndex(0);
        msYearComboBoxReg.setSelectedIndex(0);
        msMonthComboBoxReg.setSelectedIndex(0);
        msDayComboBoxReg.setSelectedIndex(0);
        referralSourceTfReg.setText("");
        removalReasonTfReg.setText("");
        planComboBoxReg.setSelectedIndex(0);
    }

    //Creating the method for the clear text field of the premium member
    private void clearPrem() {
        idTfPrem.setText("");
        nameTfPrem.setText("");
        locationTfPrem.setText("");
        phoneTfPrem.setText("");
        emailTfPrem.setText("");
        femaleRadioPrem.setSelected(false);
        maleRadioPrem.setSelected(false);
        otherRadioPrem.setSelected(false);
        genderGroupPrem.clearSelection();
        dobYearComboBoxPrem.setSelectedIndex(0);
        dobMonthComboBoxPrem.setSelectedIndex(0);
        dobDayComboBoxPrem.setSelectedIndex(0);
        msYearComboBoxPrem.setSelectedIndex(0);
        msMonthComboBoxPrem.setSelectedIndex(0);
        msDayComboBoxPrem.setSelectedIndex(0);
        trainerNameTfPrem.setText("");
        discountAmountTfPrem.setText("0.0");
        paidAmountTfPrem.setText("");
    }

    // Main method
    public static void main(String[] args) {
        //Calling thr GymGUI constructor 
        new GymGUI();
    }

}
