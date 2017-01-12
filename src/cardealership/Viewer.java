package cardealership;

import association.*;
import car.CARTYPE;
import car.FUELTYPE;
import car.GEARBOXTYPE;
import db.DatabaseOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * This class includes all functions to displayed user interface and some functionalities tightly
 * related to UI. It uses singleton design pattern to make sure there is only one window will be
 * created at one time.
 *
 * @author Yufeng
 * @since 2016-12-23
 * @see JFrame
 * @see DealMaker
 * @see DatabaseOperations
 */
public class Viewer extends JFrame {
    /**
     *
     * @param dealPanel     This is the JPanel contains objects related to selling functionality.
     * @param hstryPanel    This is the JPanel contains objects related to selling history.
     * @param tabbedPane    This is the JPane to switch between dealPanel and hstryPanel.
     * @param newDeal       This is the instance of DealMaker class, contains members and functionalities
     *                      to make a car deal.
     * @param container     This is a Container with BorderLayout to put other JFrame objects.
     */
    private JPanel dealPanel, hstryPanel;
    private JTabbedPane tabbedPane;
    private Listener listener;
    private DealMaker newDeal;
    private Container container;
    /**
     * The following parameters are put in dealPanel.
     *
     * @param creatBot          This is a JButton to create new deal.
     * @param calculateBot      This is a JButton to calculate total price of a customized car.
     * @param cstmrNameLabel    This is a Label to indicate user's name should be entered next.
     * @param priceLabel        This is a Label to indicate the following thing presents price.
     * @param mpgLabel          This is a Label to indicate the following thing presents MPG.
     * @param priceDisplay      This is a Label to display the price of a customized car.
     * @param mpgDisplay        This is a Label to display the car MPG.
     * @param modelNameLabel    This is a Label to indicate the following thing presents the car model.
     * @param fuelTypeLabel     This is a Label to indicate the following thing presents the fuel type
     *                          of a car.
     * @param gearBoxLabel      This is a Label to indicate the following thing presents the gearbox type
     *                          of a car.
     * @param modelNameCB       This is a JComboBox for users to select a model from existing choices.
     * @param fuelTypeCB        This is a JComboBox for users to select a fuel type from existing choices.
     * @param gearBoxCB         This is a JComboBox for users to select a gearbox type from existing chices.
     * @param airConditioning   This is a Label to indicate the following thing presents a choice related to
     *                          air conditioning.
     * @param parkingSensor     This is a Label to indicate the following thing presents a choice related to
     *                          parking sensor.
     * @param digitalRadio      This is a Label to indicate the following thing presents a choice related to
     *                          digital radio.
     * @param alloyWheels       This is a Label to indicate the following thing presents a choice related to
     *                          alloy wheels.
     * @param airConditioningCB This is a JComboBox for users to decide to buy an air conditioning or not.
     * @param parkingSensorCB   This is a JComboBox for users to decide to buy a parking sensor or not.
     * @param digitalRadioCB    This is a JComboBox for users to decide to buy a digital radio or not.
     * @param alloyWheelsCB     This is a JComboBox for users to decide to but alloy wheels or not.
     * @param cstmrNameField    This is a JTextField for users to enter a customer's name.
     * @param showLabel         This is a Label to tell if a deal is created successfully.
     */
//    private modelListener modelListener;//A listener for a JCombo box
    private JButton createBot,calculateBot;
    private Label cstmrNameLabel, priceLabel, mpgLabel;
    private Label priceDisplay, mpgDisplay;
    private Label modelNameLabel, fuelTypeLabel, gearBoxLabel;
    private JComboBox modelNameCB, fuelTypeCB, gearBoxCB;
    private Label airConditioning, parkingSensor, digitalRadio, alloyWheels;
    private JComboBox airConditioningCB, parkingSensorCB, digitalRadioCB, alloyWheelsCB;
    private JTextField cstmrNameField;
    private Label showLabel;
    /**
     * The following objects will be used in hstryPanel.
     *
     * @param cstmrList         This is a JList to display customers of historic deals.
     * @param dealHstryArea     This is a JTextArea to display the deal information of a chosen customer.
     * @param showAll           This is a JButton to click to display the deal information of a chosen customer.
     * @param listScrollPane    This is a JScrollPane for cstmrList.
     * @param areaScrollPane    This is a JScrollPane for dealHstryArea.
     */
    private JList cstmrList;
    private JTextArea dealHstryArea;
    private JButton show;
//    private JButton deleteBot;//This is a button to delete an existing deal.
    private JScrollPane listScrollPane, areaScrollPane;
    /**
     * @param cstmrName This is a String to store a customer's name.
     */
    private String cstmrName;


    /**
     * @param instance This is a Viewer instance for singleton design pattern.
     */
    private static Viewer instance;

    /**
     * This is a static functionality for the program runner to open a window. And only one window will
     * be opend.
     *
     * @param str                       This is a String to get the name of a window.
     * @return                          Returns a Viewer instance.
     * @throws SQLException             An exception that provides information on a database access error
     *                                  or other errors.
     * @throws ClassNotFoundException   Thrown when an application tries to load in a class through its string
     *                                  name.
     */
    public static Viewer getInstance(String str) throws SQLException, ClassNotFoundException {
        Viewer instance = new Viewer(str);
        instance.initWin();
        return instance;
    }

    /**
     * This is the constructor of Viewer class.
     *
     * @param str   This is a String to store the name of the window going to be created.
     */
    private Viewer(String str){
        super(str);
        DatabaseOperations.creatDB();

        listener = new Listener();
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        container = this.getLayeredPane();
        dealPanel = new JPanel();
        hstryPanel = new JPanel();
        createBot = new JButton("Create");
        calculateBot = new JButton("Calculate Price");

        cstmrNameLabel = new Label("Name:");
        cstmrNameField = new JTextField(10);

        priceLabel = new Label("Total cost:");
        priceDisplay = new Label("0");

        mpgLabel = new Label("Miles per gallon(MPG): ");
        mpgDisplay = new Label("0");

        modelNameLabel = new Label("Model:");
        modelNameCB = new JComboBox(CARTYPE.values());
        fuelTypeLabel = new Label("Fuel trype:");
        fuelTypeCB = new JComboBox(FUELTYPE.values());
        gearBoxLabel = new Label("GearBox:");
        gearBoxCB = new JComboBox(GEARBOXTYPE.values());

        String[] isSelected = {"No", "Yes"};
        airConditioning = new Label("Air conditioning:");
        airConditioningCB = new JComboBox(isSelected);
        parkingSensor = new Label("Parking sensor:");
        parkingSensorCB = new JComboBox(isSelected);
        digitalRadio = new Label("Digital radio:");
        digitalRadioCB = new JComboBox(isSelected);
        alloyWheels = new Label("AlloyWheels:");
        alloyWheelsCB = new JComboBox(isSelected);

        showLabel = new Label();
        showLabel.setForeground(Color.red);

        cstmrList = new JList();
        cstmrList.setModel(DatabaseOperations.showAllCstmr());

        listScrollPane = new JScrollPane(cstmrList);
        dealHstryArea = new JTextArea();
        areaScrollPane = new JScrollPane(dealHstryArea);
        show = new JButton("Show Selected");
    }

    /**
     * This is the functionality to initialize the window.
     *
     * @throws SQLException             An exception that provides information on a database access error
     *                                  or other errors.
     * @throws ClassNotFoundException   Thrown when an application tries to load in a class through its string
     *                                  name.
     */
    private void initWin() throws SQLException, ClassNotFoundException {
        this.setBounds(300, 300, 400, 410);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        displayWin();
        this.setVisible(true);
    }

    /**
     * This is the functionality to set details of the window and the behaviour of different actions.
     *
     * @throws SQLException             An exception that provides information on a database access error
     *                                  or other errors.
     * @throws ClassNotFoundException   Thrown when an application tries to load in a class through its string
     *                                  name.
     */
    private void displayWin() throws SQLException, ClassNotFoundException {
        tabbedPane.add(dealPanel, "New deal");
        tabbedPane.add(hstryPanel, "Historical deal");
        container.setLayout(new BorderLayout());
        container.add(tabbedPane, BorderLayout.CENTER);

        /*
        Objects in dealPanel.
         */
        Container container1 = new Container();
        container1.setLayout(new GridLayout(0, 2, 0, 0));

        container1.add(cstmrNameLabel);
        container1.add(cstmrNameField);

        container1.add(modelNameLabel);
        container1.add(modelNameCB);
        container1.add(fuelTypeLabel);
        container1.add(fuelTypeCB);
        container1.add(gearBoxLabel);
        container1.add(gearBoxCB);

        container1.add(airConditioning);
        container1.add(airConditioningCB);
        container1.add(parkingSensor);
        container1.add(parkingSensorCB);
        container1.add(digitalRadio);
        container1.add(digitalRadioCB);
        container1.add(alloyWheels);
        container1.add(alloyWheelsCB);

        container1.add(mpgLabel);
        container1.add(mpgDisplay);
        container1.add(priceLabel);
        container1.add(priceDisplay);
        container1.add(showLabel);
        dealPanel.add(container1);
//        modelNameCB.addItemListener(modelListener);

        Container container2 = new Container();
        container2.setLayout(new FlowLayout());
        container2.add(calculateBot);
        container2.add(createBot);
        dealPanel.add(container2, BorderLayout.NORTH);
        dealPanel.add(container2);
        createBot.addActionListener(listener);
        calculateBot.addActionListener(listener);

        /*
        Objects in hstryPanel.
         */
        cstmrList.setSelectionMode(new DefaultListSelectionModel().SINGLE_SELECTION);
        cstmrList.setVisibleRowCount(9);
        cstmrList.setFixedCellWidth(100);
        dealHstryArea.setColumns(15);
        dealHstryArea.setRows(10);
        dealHstryArea.setLineWrap(true);
        dealHstryArea.setWrapStyleWord(true);
        hstryPanel.add(listScrollPane);
        hstryPanel.add(areaScrollPane);
        hstryPanel.add(show);
        show.addActionListener(listener);
    }

    /**
     * The Listener of createBot, calculaeBot and show.
     */
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            If user click createBot.
             */
            if (e.getSource() == createBot){
                if (cstmrNameField.getText() == ""){
                    /*
                    Check if customer's name is blank.
                     */
                    showLabel.setText("Customer name should not be empty.");
                }
                else {
                    /*
                    Create new deal, display the total car price, and write data
                    into database and update infomation in hstryPanel.
                     */
                    createDeal();
                    mpgDisplay.setText(String.valueOf(newDeal.getMpg()));
                    priceDisplay.setText(newDeal.price());
                    try {
                        DatabaseOperations.recordDB(newDeal);
                        cstmrList.setModel(DatabaseOperations.showAllCstmr());
                        showLabel.setText("Success!");
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            /*
            If users click calculateBot.
             */
            else if (e.getSource() == calculateBot){
                createDeal();
                mpgDisplay.setText(String.valueOf(newDeal.getMpg()));
                priceDisplay.setText(newDeal.price());
            }
            /*
            If users click show.
             */
            else if (e.getSource() == show){
                try {
                    dealHstryArea.setText(DatabaseOperations.readDB(String.valueOf(cstmrList.getSelectedValue())));
                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
//    /**
//     * The listener of a JComboBox.
//     */
//    class modelListener implements ItemListener{
//        @Override
//        public void itemStateChanged(ItemEvent e) {
//            if (!modelNameCB.getSelectedItem().equals("")){
//                modelNameCB = (JComboBox) e.getSource();
//                fuelTypeCB.setEnabled(true);
//                gearBoxCB.setEnabled(true);
//                airConditioningCB.setEnabled(true);
//                parkingSensorCB.setEnabled(true);
//                digitalRadioCB.setEnabled(true);
//                alloyWheelsCB.setEnabled(true);
//            }
//        }
//    }

    /**
     * This is a functionality to create an instance of DealMaker.
     */
    private void createDeal(){
        cstmrName = cstmrNameField.getText();
        newDeal = new DealMaker(cstmrName,
                                CARTYPE.valueOf(String.valueOf(modelNameCB.getSelectedItem())),
                                FUELTYPE.valueOf(String.valueOf(fuelTypeCB.getSelectedItem())),
                                GEARBOXTYPE.valueOf(String.valueOf(gearBoxCB.getSelectedItem())));

        AirConditioning airConditioning = new AirConditioning();
        airConditioning.setState(isAsct(airConditioningCB));
        newDeal.setAssociation(airConditioning);

        ParkingSensors parkingSensors = new ParkingSensors();
        parkingSensors.setState(isAsct(parkingSensorCB));
        newDeal.setAssociation(parkingSensors);

        DigitalRadio digitalRadio = new DigitalRadio();
        digitalRadio.setState(isAsct(digitalRadioCB));
        newDeal.setAssociation(digitalRadio);

        AlloyWheels alloyWheels = new AlloyWheels();
        alloyWheels.setState(isAsct(alloyWheelsCB));
        newDeal.setAssociation(alloyWheels);
    }

    /**
     * This is a functionality to check if the customer has chosen an association or not.
     *
     * @param jComboBox This is the parameter of an instance of a subclass of Association class.
     * @return          Returns true the customer's choice of the current kind of association.
     */
    private boolean isAsct(JComboBox jComboBox){
        if (String.valueOf(jComboBox.getSelectedItem()).equalsIgnoreCase("yes")){
            return true;
        }
        else if (String.valueOf(jComboBox.getSelectedItem()).equalsIgnoreCase("no")) return false;
        return false;
    }
}
