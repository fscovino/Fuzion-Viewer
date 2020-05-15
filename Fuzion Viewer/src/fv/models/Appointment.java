package fv.models;

import fv.controllers.Controller;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.commons.csv.CSVRecord;

public class Appointment {
    
    // Class Members
    // Index: Position on JTable. Column: Position on Excel.
    private final int CLAIM_ID_INDEX = 0;
    private final int CLAIM_ID_COLUMN = 48;
    private final String CLAIM_ID_TITLE = "Claim ID";
    
    private final int CLAIM_STATUS_INDEX = 1;
    private final int CLAIM_STATUS_COLUMN = 49;
    private final String CLAIM_STATUS_TITLE = "Claim Status";
    
    private final int PATIENT_NAME_INDEX = 2;
    private final int PATIENT_NAME_COLUMN = 1;
    private final String PATIENT_NAME_TITLE = "Patient Name";
    
    private final int APPOINTMENT_TYPE_INDEX = 3;
    private final int APPOINTMENT_TYPE_COLUMN = 8;
    private final String APPOINTMENT_TYPE_TITLE = "Appointment Type";
    
    private final int APPT_STATUS_INDEX = 4;
    private final int APPT_STATUS_COLUMN = 10;
    private final String APPT_STATUS_TITLE = "Appt. Status";
    
    private final int SERVICE_INDEX = 5;
    private final int SERVICE_COLUMN = 2;
    private final String SERVICE_TITLE = "Service";
    
    private final int APPT_DATE_INDEX = 6;
    private final int APPT_DATE_COLUMN = 3;
    private final String APPT_DATE_TITLE = "Appt. Date";
    
    private final int START_TIME_INDEX = 7;
    private final int START_TIME_COLUMN = 4;
    private final String START_TIME_TITLE = "Start Time";
    
    private final int END_TIME_INDEX = 8;
    private final int END_TIME_COLUMN = 5;
    private final String END_TIME_TITLE = "End Time";
    
    private final int DURATION_INDEX = 9;
    private final int DURATION_COLUMN = 6;
    private final String DURATION_TITLE = "Duration";
    
    private final int UNITS_INDEX = 10;
    private final int UNITS_COLUMN = 40;
    private final String UNITS_TITLE = "Units";
    
    private final int MINUTES_QTY_INDEX = 11;
    private final int MINUTES_QTY_COLUMN = 41;
    private final String MINUTES_QTY_TITLE = "Minutes / Qty";
    
    private final int CODES_INDEX = 12;
    private final int CODES_COLUMN = 39;
    private final String CODES_TITLE = "Codes";
    
    private final int PLACE_SERVICE_INDEX = 13;
    private final int PLACE_SERVICE_COLUMN = 21;
    private final String PLACE_SERVICE_TITLE = "Place of Service";
    
    private final int PRIMARY_PAYER_INDEX = 14;
    private final int PRIMARY_PAYER_COLUMN = 44;
    private final String PRIMARY_PAYER_TITLE = "Primary Payer";
    
    private final int THERAPIST_NAME_INDEX = 15;
    private final int THERAPIST_NAME_COLUMN = 13;
    private final String THERAPIST_NAME_TITLE = "Therapist Name";
    
    // Data coming from Insurances Rates Table
    private final int CHARGES_INDEX = 16;
    private final String CHARGES_TITLE = "Charges";
    private final int TABLE_INS_RATE_CODE = 0;
    private final int TABLE_INS_RATE_PAYER = 1;
    private final int TABLE_INS_RATE_LOCATION= 2;
    private final int TABLE_INS_RATE_MODIFIER = 3;
    private final int TABLE_INS_RATE_TYPE = 4;
    private final int TABLE_INS_RATE_RATE = 5;
    
    // Data coming from Therapists Rates Table
    private final int THERAPIST_CHARGES_INDEX = 17;
    private final String THERAPIST_CHARGES_TITLE = "Therapist Charge";
    private final int TABLE_THERAPIST_RATE_NAME = 0;
    private final int TABLE_THERAPIST_RATE_MODIFIER = 1;
    private final int TABLE_THERAPIST_RATE_CODE = 2;
    private final int TABLE_THERAPIST_RATE_OFFICE = 3;
    private final int TABLE_THERAPIST_RATE_SCHOOL = 4;
    private final int TABLE_THERAPIST_RATE_HOME = 5;
    private final int TABLE_THERAPIST_RATE_PRIVATE = 6;
    
    // Data coming from Appoinments Report
    private final int PAT_PORTION_INDEX = 18;
    private final int PAT_PORTION_COLUMN = 51;
    private final String PAT_PORTION_TITLE = "Pat. Portion";
    
    // Data coming from Transactions Report
    private final int PAT_PAID_AMNT_INDEX = 19;
    private final String PAT_PAID_AMNT_TITLE = "Pat. Paid";
    private final int TABLE_TRANSACTIONS_DATE = 0;
    private final int TABLE_TRANSACTIONS_PATIENT = 3;
    private final int TABLE_TRANSACTIONS_AMOUNT = 6;
    private final int TABLE_TRANSACTIONS_REF = 13;

    private final int PAT_PAID_DATE_INDEX = 20;
    private final String PAT_PAID_DATE_TITLE = "Pat. Date Paid";
    
    // Data coming from Claims Report
    private final int INS_PORTION_INDEX = 21;
    private final String INS_PORTION_TITLE = "Ins. Portion";
    
    // Data coming from Adjudications Report
    private final int INS_PAID_AMNT_INDEX = 22;
    private final String INS_PAID_AMNT_TITLE = "Ins. Paid";
    private final int TABLE_ADJUDICATIONS_PATNAME = 5;
    private final int TABLE_ADJUDICATIONS_APPDATE = 2;
    private final int TABLE_ADJUDICATIONS_THENAME = 0;
    private final int TABLE_ADJUDICATIONS_PAYDATE = 9;
    private final int TABLE_ADJUDICATIONS_AMOUNT = 12;
    
    private final int INS_PAID_DATE_INDEX = 23;
    private final String INS_PAID_DATE_TITLE = "Ins. Date Paid";
    
    private final int INS_RECEIVABLE_INDEX = 24;
    private final String INS_RECEIVABLE_TITLE = "Ins. Receivable";
    
    private final int PAT_RECEIVABLE_INDEX = 25;
    private final String PAT_RECEIVABLE_TITLE = "Pat. Receivable";
    
    private final int GROSS_PROFIT_INDEX = 26;
    private final String GROSS_PROFIT_TITLE = "Gross Profit";
    
    private final int PROFIT_PERC_INDEX = 27;
    private final String PROFIT_PERC_TITLE = "Profit %";
    
    // Member Variables
    private Controller controller;
    private List<CSVRecord> therapistsRatesList;
    private List<CSVRecord> insurancesRatesList;
    private List<CSVRecord> adjudicationsList;
    private List<CSVRecord> transactionsList;
    
    
    private Date appointmentDate;
    private String patientName;
    private String primaryPayer;
    private String therapistName;
    private String code;
    private int duration;
    private int units;
    private double charges;
    private String modifier;
    private String location;
    private String appStatus;
    private Double patientPortion;
    private Double patPaid;
    private Date patPaidDate;
    private Double insurancePortion;
    private Double insurancePaid;
    private Date insPaidDate;
    
    
    // Calculation Methods
    
    //Load All ArrayLists from csv files
    private void loadAllLists(){
        therapistsRatesList = controller.getTherapistsRatesCSV();
        insurancesRatesList = controller.getInsurancesRatesCSV();
        adjudicationsList = controller.getAdjudicationsCSV();
        transactionsList = controller.getTransactionsCSV();
    }
    
    private double getCharges() {
        // appStatus, code, insurance, location, (modifier), therapist, duration, units
        charges = 0.0;
        
        // Get the modifier of the current therapist
        for (CSVRecord t : therapistsRatesList){
            if (therapistName.equals(t.get(TABLE_THERAPIST_RATE_NAME))){
                modifier = t.get(TABLE_THERAPIST_RATE_MODIFIER);
                break;
            }
        }
        
        // Get rate for a Checked In Patient
        if (appStatus.equals("Checked In")){
            for (CSVRecord ins : insurancesRatesList){
                if (code.equals(ins.get(TABLE_INS_RATE_CODE)) && primaryPayer.equalsIgnoreCase(ins.get(TABLE_INS_RATE_PAYER)) && 
                        location.equalsIgnoreCase(ins.get(TABLE_INS_RATE_LOCATION)) && modifier.equalsIgnoreCase(ins.get(TABLE_INS_RATE_MODIFIER))) {
                    
                    if (!ins.get(TABLE_INS_RATE_RATE).isEmpty()){
                        double rate = Double.parseDouble(ins.get(TABLE_INS_RATE_RATE));
                        // Calcualte price for a 1hr (60 min) visit
                        if (ins.get(TABLE_INS_RATE_TYPE).equalsIgnoreCase("Visit")){
                            charges = rate;
                            return charges;
                        } else if (ins.get(TABLE_INS_RATE_TYPE).equalsIgnoreCase("Unit")){
                            // Calculate price for a per units based
                            charges = units * rate;
                            return charges;
                        }
                    } else {
                        return charges;
                    }
                }
            } 
        }

        return charges;
    }

    private double getTherapistCharges() {
        // therapist, code, appStatus
        
        // Get rate for Checked In Patient
        if (appStatus.equals("Checked In")){
            for (CSVRecord t : therapistsRatesList){
                if (therapistName.equalsIgnoreCase(t.get(TABLE_THERAPIST_RATE_NAME)) && code.equalsIgnoreCase(t.get(TABLE_THERAPIST_RATE_CODE))){
                    switch (location){
                        case "11: Office":
                            return t.get(TABLE_THERAPIST_RATE_OFFICE).isEmpty() ? 0.0 : (duration * Double.parseDouble(t.get(TABLE_THERAPIST_RATE_OFFICE))/60);
                        case "03: School":
                            return t.get(TABLE_THERAPIST_RATE_SCHOOL).isEmpty() ? 0.0 : (duration * Double.parseDouble(t.get(TABLE_THERAPIST_RATE_SCHOOL))/60);
                        case "12: Patient's Home":
                            return t.get(TABLE_THERAPIST_RATE_HOME).isEmpty() ? 0.0 : (duration * Double.parseDouble(t.get(TABLE_THERAPIST_RATE_HOME))/60);
                        case "Private Pay":
                            return t.get(TABLE_THERAPIST_RATE_PRIVATE).isEmpty() ? 0.0 : (duration * Double.parseDouble(t.get(TABLE_THERAPIST_RATE_PRIVATE))/60);
                    }
                }
            }
        } else if (appStatus.equals("No Show")){
            for (CSVRecord t : therapistsRatesList){
                if (therapistName.equalsIgnoreCase(t.get(TABLE_THERAPIST_RATE_NAME)) && "No Show".equalsIgnoreCase(t.get(TABLE_THERAPIST_RATE_CODE))){
                    return t.get(TABLE_THERAPIST_RATE_OFFICE).isEmpty() ? 0.0 : Double.parseDouble(t.get(TABLE_THERAPIST_RATE_OFFICE));
                }
            }
        }
        
        return 0.00;
    }
    
    private double getInsPortion(){
        
        if (charges == 0.0) {
            insurancePortion = 0.0;
        } else {
            if (patientPortion == null || patientPortion == 0.0) {
                insurancePortion = charges;
            } else {
                insurancePortion = charges - patientPortion;
            }
        }
        return insurancePortion;
    }
    
    private double getInsPaid(){
        // Needed: patientName, appDate, therapistName
        insurancePaid = 0.00;
        insPaidDate = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        if (appStatus.equals("Checked In") && !primaryPayer.equalsIgnoreCase("Private Pay")){
            try {
                for (CSVRecord adj : adjudicationsList){
                    if (adj.getRecordNumber() != 1) {
                        if (appointmentDate.compareTo(sdf.parse(adj.get(TABLE_ADJUDICATIONS_APPDATE))) == 0 && patientName.equalsIgnoreCase(adj.get(TABLE_ADJUDICATIONS_PATNAME).trim()) && 
                            therapistName.equalsIgnoreCase(adj.get(TABLE_ADJUDICATIONS_THENAME))) {
                            // Assign the value of ins paid date to member variable
                            insPaidDate = sdf.parse(adj.get(TABLE_ADJUDICATIONS_PAYDATE));
                            
                            String rawAmount = adj.get(TABLE_ADJUDICATIONS_AMOUNT);
                            double amount = 0.0;
                            
                            if (rawAmount.contains("$0.0") || rawAmount.isEmpty()){
                                amount = 0.0;
                            } else {
                                // Get negative numbers
                                if (rawAmount.contains("(") || rawAmount.contains("-")){
                                    amount = Double.parseDouble(rawAmount.trim().substring(2)) *-1;
                                } else if (rawAmount.contains("$")){
                                    amount = Double.parseDouble(rawAmount.trim().substring(1));
                                }
                            }
                            
                            insurancePaid = amount;
                            return amount;
                        }
                    }
                }
            } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "<Appointment>getInsPaid():\n" + ex.getMessage(), "ParseException", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return 0.00;
    }
    
    private Date getInsPaidDate(){
        return insPaidDate;
    }
    
    private double getPatPortion(String portion){
        
        if (portion.contains("$0.0") || portion.isEmpty()){
            patientPortion = 0.0;
        } else {
            if (portion.contains("$")){
                patientPortion = Double.parseDouble(portion.trim().substring(1));
            } 
        }
        
        return patientPortion;
    }
    
    private double getPatPaid(){
        // Needed: patientName, appDate, therapistName
        patPaid = 0.0;
        patPaidDate = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        if (appStatus.equals("Checked In")){
            try {
                for (CSVRecord tnx : transactionsList){
                    if (tnx.getRecordNumber() != 1) {
                        if (appointmentDate.compareTo(sdf.parse(tnx.get(TABLE_TRANSACTIONS_DATE))) == 0 && patientName.equalsIgnoreCase(tnx.get(TABLE_TRANSACTIONS_PATIENT).trim())) {
                            if (tnx.get(TABLE_TRANSACTIONS_AMOUNT).contains("$0.0") || tnx.get(TABLE_TRANSACTIONS_AMOUNT).isEmpty()){
                                patPaid = 0.0;
                            } else {
                                if (tnx.get(TABLE_TRANSACTIONS_AMOUNT).contains("$")){
                                    patPaid = Double.parseDouble(tnx.get(TABLE_TRANSACTIONS_AMOUNT).trim().substring(1));
                                    patPaidDate = sdf.parse(tnx.get(TABLE_TRANSACTIONS_DATE));
                                } 
                            } 
                        }
                    }
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "<Appointment>getPatPaid():\n" + ex.getMessage(), "ParseException", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        return patPaid;
    }
    
    private Date getPatPaidDate(){
        return patPaidDate;
    }
    
    private double getInsReceivable(){
        return insurancePaid - insurancePortion;
    }
    
    private double getPatReceivable(){
        return patPaid - patientPortion;
    }

    private double getGrossProfit() {
        return getCharges() - getTherapistCharges();
    }

    private double getGrossPercentage() {
        
        if (getCharges() == 0 || getTherapistCharges() == 0){
            return 0.0;
        }  
        return ((getCharges() - getTherapistCharges()) * 100) / getCharges();
    }
    
    // Layout Methods
    
    // Return the array with the column header's names for JTable
    private String[] getColumnHeaders(){
        String[] headers = new String[]{
            CLAIM_ID_TITLE, CLAIM_STATUS_TITLE, PATIENT_NAME_TITLE, APPOINTMENT_TYPE_TITLE, APPT_STATUS_TITLE, SERVICE_TITLE, APPT_DATE_TITLE,
            START_TIME_TITLE, END_TIME_TITLE, DURATION_TITLE, UNITS_TITLE, MINUTES_QTY_TITLE, CODES_TITLE, PLACE_SERVICE_TITLE, PRIMARY_PAYER_TITLE,
            THERAPIST_NAME_TITLE, CHARGES_TITLE, THERAPIST_CHARGES_TITLE, PAT_PORTION_TITLE, PAT_PAID_AMNT_TITLE, PAT_PAID_DATE_TITLE,
            INS_PORTION_TITLE, INS_PAID_AMNT_TITLE, INS_PAID_DATE_TITLE, INS_RECEIVABLE_TITLE, PAT_RECEIVABLE_TITLE, GROSS_PROFIT_TITLE, PROFIT_PERC_TITLE
        };
        return headers;
    }
    
    // Process the Fuzion CSV Appointment and return the data object for JTable
    private Object[][] getRowData(){
        
        List<CSVRecord> records;
        Object[][] data;
        // Get the CSV data from fuzion exported file
        records = controller.getAppointmentsCSV();
        // Remove first row with column headers
        records.remove(0);
        // Create a Format Date parser
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        int r = records.size();
        data = new Object[r][28];
        // Populate the columns of the data object
        int row = 0;
        for (CSVRecord record : records) {
            
            for (int j = 0; j < 28; j++){
                
                switch (j){
                    case CLAIM_ID_INDEX:
                        data[row][j] = record.get(CLAIM_ID_COLUMN);
                        break;
                    case CLAIM_STATUS_INDEX:
                        data[row][j] = record.get(CLAIM_STATUS_COLUMN);
                        break;
                    case PATIENT_NAME_INDEX:
                        patientName = record.get(PATIENT_NAME_COLUMN);
                        data[row][j] = patientName;
                        break;
                    case APPOINTMENT_TYPE_INDEX:
                        data[row][j] = record.get(APPOINTMENT_TYPE_COLUMN);
                        break;
                    case APPT_STATUS_INDEX:
                        appStatus = record.get(APPT_STATUS_COLUMN);
                        data[row][j] = appStatus;
                        break;
                    case SERVICE_INDEX:
                        data[row][j] = record.get(SERVICE_COLUMN);
                        break;
                    case APPT_DATE_INDEX:
                        try {
                            appointmentDate = sdf.parse(record.get(APPT_DATE_COLUMN));
                            data[row][j] = appointmentDate;
                        } catch (ParseException e) {
                            // Leaver cell blank
                        }
                        break;
                    case START_TIME_INDEX:
                        data[row][j] = record.get(START_TIME_COLUMN);
                        break;
                    case END_TIME_INDEX:
                        data[row][j] = record.get(END_TIME_COLUMN);
                        break;
                    case DURATION_INDEX:
                        try {
                            duration = Integer.parseInt(record.get(DURATION_COLUMN).trim());
                            data[row][j] = duration;
                        } catch (NumberFormatException e) {
                            // Leaver cell blank
                        }
                        break;
                    case UNITS_INDEX:
                        try {
                            units = Integer.parseInt(record.get(UNITS_COLUMN).trim());
                            data[row][j] = units;
                        } catch (NumberFormatException e) {
                            // Leaver cell blank
                        }
                        break;
                    case MINUTES_QTY_INDEX:
                        try {
                            data[row][j] = Integer.parseInt(record.get(MINUTES_QTY_COLUMN).trim());
                        } catch (NumberFormatException e) {
                            // Leaver cell blank
                        }
                        break;
                    case CODES_INDEX:
                        code = record.get(CODES_COLUMN);
                        data[row][j] = code;
                        break;
                    case PLACE_SERVICE_INDEX:
                        location = record.get(PLACE_SERVICE_COLUMN);
                        data[row][j] = location;
                        break;
                    case PRIMARY_PAYER_INDEX:
                        primaryPayer = record.get(PRIMARY_PAYER_COLUMN);
                        data[row][j] = primaryPayer;
                        break;
                    case THERAPIST_NAME_INDEX:
                        therapistName = record.get(THERAPIST_NAME_COLUMN);
                        data[row][j] = therapistName;
                        break;
                    case CHARGES_INDEX:
                        data[row][j] = getCharges();
                        break;
                    case THERAPIST_CHARGES_INDEX:
                        data[row][j] = getTherapistCharges();
                        break;
                    case PAT_PORTION_INDEX:
                        data[row][j] = getPatPortion(record.get(PAT_PORTION_COLUMN));
                        break;
                    case PAT_PAID_AMNT_INDEX:
                        data[row][j] = getPatPaid();
                        break;
                    case PAT_PAID_DATE_INDEX:
                        data[row][j] = getPatPaidDate();
                        break;
                    case INS_PORTION_INDEX:
                        data[row][j] = getInsPortion();
                        break;
                    case INS_PAID_AMNT_INDEX:
                        data[row][j] = getInsPaid();
                        break;
                    case INS_PAID_DATE_INDEX:
                        data[row][j] = getInsPaidDate();
                        break;
                    case INS_RECEIVABLE_INDEX:
                        data[row][j] = getInsReceivable();
                        break;
                    case PAT_RECEIVABLE_INDEX:
                        data[row][j] = getPatReceivable();
                        break;
                    case GROSS_PROFIT_INDEX:
                        data[row][j] = getGrossProfit();
                        break;
                    case PROFIT_PERC_INDEX:
                        data[row][j] = getGrossPercentage();
                }
            }
            row += 1;
        }
        return data;
    }
    
    // Create the Appointment Table Model
    public DefaultTableModel getTableModel(Controller controller) throws ParseException{
        this.controller = controller;
        // Load all External Tables
        loadAllLists();
        // Create elements of the JTable
        String[] headers = getColumnHeaders();
        Object[][] data = getRowData();
        DefaultTableModel model = new DefaultTableModel(data, headers);
        
        return model;
    }
    
    // Create the Totals Table Model for Appointments
    public TableModel getTotalsTableModel(JTable table){
        String[] headers = new String[]{"Appointments", "Checked In", "No Show", "Canceled", "Units", "Appointment Charges",
                                        "Therapist Charges", "Ins. Receivable", "Pat. Receivable", "Gross Profit", "Profit %"};
        Object[][] data = new Object[1][11];
        
        int visits;
        int checkedIn = 0;
        int noShow = 0;
        int canceled = 0;
        int unitSum = 0;
        double chargesSum = 0.00;
        double therapistChargesSum = 0.00;
        double insReceivableSum = 0.00;
        double patReceivableSum = 0.00;
        double profitSum = 0.00;
        
        // Get Totals for Selected Rows
        if (table.getSelectedRowCount() > 1){
            // Get total number of visits
            visits = table.getSelectedRowCount();
            // Get total Checked In
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                if (table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), APPT_STATUS_INDEX).equals("Checked In")){
                    checkedIn += 1;
                }
            }
            // Get total No Show
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                if (table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), APPT_STATUS_INDEX).equals("No Show")){
                    noShow += 1;
                }
            }
            // Get total Canceled
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                if (table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), APPT_STATUS_INDEX).equals("Canceled")){
                    canceled += 1;
                }
            }
            // Get total Units
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                unitSum += Integer.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), UNITS_INDEX).toString());
            }
            // Get total Charges
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                chargesSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), CHARGES_INDEX).toString());
            }
            // Get total Therapist Charges
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                therapistChargesSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), THERAPIST_CHARGES_INDEX).toString());
            }
            // Get total Insurance Receivable
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                insReceivableSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), INS_RECEIVABLE_INDEX).toString());
            }
            // Get total Patient Receivable
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                patReceivableSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), PAT_RECEIVABLE_INDEX).toString());
            }
            // Get total Profit
            for (int i = 0; i < table.getSelectedRowCount(); i++){
                profitSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[i]), GROSS_PROFIT_INDEX).toString());
            }
            
        }else{
            // Get Totals for All Rows
            // Get total number of visists
            visits = table.getRowCount();
            // Get total Checked In
            for (int i = 0; i < table.getRowCount(); i++){
                if (table.getModel().getValueAt(table.convertRowIndexToModel(i), APPT_STATUS_INDEX).equals("Checked In")){
                    checkedIn += 1;
                }
            }
            // Get total No Show
            for (int i = 0; i < table.getRowCount(); i++){
                if (table.getModel().getValueAt(table.convertRowIndexToModel(i), APPT_STATUS_INDEX).equals("No Show")){
                    noShow += 1;
                }
            }
            // Get total Canceled
            for (int i = 0; i < table.getRowCount(); i++){
                if (table.getModel().getValueAt(table.convertRowIndexToModel(i), APPT_STATUS_INDEX).equals("Canceled")){
                    canceled += 1;
                }
            }
            // Get total Units
            for (int i = 0; i < table.getRowCount(); i++){
                unitSum += Integer.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(i), UNITS_INDEX).toString());
            }
            // Get total Charges
            for (int i = 0; i < table.getRowCount(); i++){
                chargesSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(i), CHARGES_INDEX).toString());
            }
            // Get total Therapist Charges
            for (int i = 0; i < table.getRowCount(); i++){
                therapistChargesSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(i), THERAPIST_CHARGES_INDEX).toString());
            }
            // Get total Insurance Receivable
            for (int i = 0; i < table.getRowCount(); i++){
                insReceivableSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(i), INS_RECEIVABLE_INDEX).toString());
            }
            // Get total Patient Receivable
            for (int i = 0; i < table.getRowCount(); i++){
                patReceivableSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(i), PAT_RECEIVABLE_INDEX).toString());
            }
            // Get total Profit
            for (int i = 0; i < table.getRowCount(); i++){
                profitSum += Double.valueOf(table.getModel().getValueAt(table.convertRowIndexToModel(i), GROSS_PROFIT_INDEX).toString());
            }
        }
        
        data[0][0] = visits;
        data[0][1] = checkedIn;
        data[0][2] = noShow;
        data[0][3] = canceled;
        data[0][4] = unitSum;
        data[0][5] = chargesSum;
        data[0][6] = therapistChargesSum;
        data[0][7] = insReceivableSum;
        data[0][8] = patReceivableSum;
        data[0][9] = profitSum;
        data[0][10] = ((chargesSum - therapistChargesSum) * 100) / chargesSum;
        
        DefaultTableModel tModel = new DefaultTableModel(data, headers);
        
        return tModel;
    }
    
    public ArrayList<List<String>> exportSelectedData(JTable table){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        DecimalFormat ndf = new DecimalFormat("#,###.##");
        
        ArrayList<List<String>> list = new ArrayList<>();
        ArrayList<String> row;
        
        // Create the Headers
        row = new ArrayList<>();
        for (int c = 0; c < table.getColumnCount(); c++){
            
            switch(c){
                case CLAIM_ID_INDEX:
                    row.add(CLAIM_ID_TITLE);
                    break;
                case CLAIM_STATUS_INDEX:
                    row.add(CLAIM_STATUS_TITLE);
                    break;
                case PATIENT_NAME_INDEX:
                    row.add(PATIENT_NAME_TITLE);
                    break;
                case APPOINTMENT_TYPE_INDEX:
                    row.add(APPOINTMENT_TYPE_TITLE);
                    break;
                case APPT_STATUS_INDEX:
                    row.add(APPT_STATUS_TITLE);
                    break;
                case SERVICE_INDEX:
                    row.add(SERVICE_TITLE);
                    break;
                case APPT_DATE_INDEX:
                    row.add(APPT_DATE_TITLE);
                    break;
                case START_TIME_INDEX:
                    row.add(START_TIME_TITLE);
                    break;
                case END_TIME_INDEX:
                    row.add(END_TIME_TITLE);
                    break;
                case DURATION_INDEX:
                    row.add(DURATION_TITLE);
                    break;
                case UNITS_INDEX:
                    row.add(UNITS_TITLE);
                    break;
                case MINUTES_QTY_INDEX:
                    row.add(MINUTES_QTY_TITLE);
                    break;
                case CODES_INDEX:
                    row.add(CODES_TITLE);
                    break;
                case PLACE_SERVICE_INDEX:
                    row.add(PLACE_SERVICE_TITLE);
                    break;
                case PRIMARY_PAYER_INDEX:
                    row.add(PRIMARY_PAYER_TITLE);
                    break;
                case THERAPIST_NAME_INDEX:
                    row.add(THERAPIST_NAME_TITLE);
                    break;
                case CHARGES_INDEX:
                    row.add(CHARGES_TITLE);
                    break;
                case THERAPIST_CHARGES_INDEX:
                    row.add(THERAPIST_CHARGES_TITLE);
                    break;
                case PAT_PORTION_INDEX:
                    row.add(PAT_PORTION_TITLE);
                    break;
                case PAT_PAID_AMNT_INDEX:
                    row.add(PAT_PAID_AMNT_TITLE);
                    break;
                case PAT_PAID_DATE_INDEX:
                    row.add(PAT_PAID_DATE_TITLE);
                    break;
                case INS_PORTION_INDEX:
                    row.add(INS_PORTION_TITLE);
                    break;
                case INS_PAID_AMNT_INDEX:
                    row.add(INS_PAID_AMNT_TITLE);
                    break;
                case INS_PAID_DATE_INDEX:
                    row.add(INS_PAID_DATE_TITLE);
                    break;
                case INS_RECEIVABLE_INDEX:
                    row.add(INS_RECEIVABLE_TITLE);
                    break;
                case PAT_RECEIVABLE_INDEX:
                    row.add(PAT_RECEIVABLE_TITLE);
                    break;
                case GROSS_PROFIT_INDEX:
                    row.add(GROSS_PROFIT_TITLE);
                    break;
                case PROFIT_PERC_INDEX:
                    row.add(PROFIT_PERC_TITLE);
            }
        }
        list.add(row);
        
        // Export Data Only for Selected Rows
        if (table.getSelectedRowCount() > 1){
            for (int r = 0; r < table.getSelectedRowCount(); r++){
                row = new ArrayList<>();
                for (int c = 0; c < table.getColumnCount(); c++){
                    // Avoid null fields
                    if (table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c) == null) {
                        row.add("");
                    // Format Date Fields
                    }else if(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c) instanceof Date){
                        row.add(sdf.format(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c)));
                    // Format Dollar Fields
                    }else if (table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c) instanceof Double){
                        row.add(ndf.format(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c)));
                    // Remove comma "," from Name Fields
                    }else if(c == 2 || c == 14 || c == 15){
                        row.add(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c).toString().replaceAll(",", ""));
                    }else {
                        row.add(table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRows()[r]), c).toString());
                    }
                }
                list.add(row);
            }
            
        // Export All Data from table
        } else {
            
            for (int r = 0; r < table.getRowCount(); r++){
                row = new ArrayList<>();
                for (int c = 0; c < table.getColumnCount(); c++){
                    // Avoid null fields
                    if (table.getModel().getValueAt(table.convertRowIndexToModel(r), c) == null) {
                        row.add("");
                    // Format Date Fields
                    }else if(table.getModel().getValueAt(table.convertRowIndexToModel(r), c) instanceof Date){
                        row.add(sdf.format(table.getModel().getValueAt(table.convertRowIndexToModel(r), c)));
                    // Format Dollar Fields
                    }else if (table.getModel().getValueAt(table.convertRowIndexToModel(r), c) instanceof Double){
                        row.add(ndf.format(table.getModel().getValueAt(table.convertRowIndexToModel(r), c)));
                    // Remove comma "," from Name Fields
                    }else if(c == 2 || c == 14 || c == 15){
                        row.add(table.getModel().getValueAt(table.convertRowIndexToModel(r), c).toString().replaceAll(",", ""));
                    }else {
                        row.add(table.getModel().getValueAt(table.convertRowIndexToModel(r), c).toString());
                    }
                }
                list.add(row);
            }
        }

        return list;
    }
    
}
