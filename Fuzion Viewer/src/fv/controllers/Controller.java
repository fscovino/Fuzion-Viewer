package fv.controllers;

import fv.models.Appointment;
import fv.models.Settings;
import fv.dao.DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.commons.csv.CSVRecord;

public class Controller {
    
    private final DAO dao;
    
    // Constructor
    public Controller() throws IOException{
        dao = new DAO();
    }
    
    // Connect to Database and get Application Settings
    public Settings getApplicationSettings() throws SQLException{
        return dao.retrieveApplicationSettings();
    }
    
    // Connect to database and Save Application Settings
    public int updateApplicationSettings(Settings settings) throws SQLException{
        return dao.updateApplicationSettings(settings);
    }
    
    // Instantiates an Appointment class to create an Appointment Table Model
    // @Return DefaultTableModel
    public DefaultTableModel getAppointmentModel(){
        try {
            Appointment app = new Appointment();
            DefaultTableModel model = app.getTableModel(this);
            return model;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "<Controller>getAppointmentModel():\n" + ex.getMessage(), "ParseException", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    // Instantiates an Appointment class to create an Appointment Totals Table Model
    // @Return TableModel
    public TableModel getAppointmentTotalsModel(JTable table){
        Appointment app = new Appointment();
        TableModel totalsModel = app.getTotalsTableModel(table);
        return totalsModel;
    } 
    
    // Connect to DAO and retrieve the Appointments from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getAppointmentsCSV(){
        List<CSVRecord> records;
        records = dao.getFusionAppointmentsFromCSV();
        return records;
    }
    
    // Connect to DAO and retrieve the Adjudications from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getAdjudicationsCSV(){
        List<CSVRecord> records;
        records = dao.getFusionAdjudicationsFromCSV();
        return records;
    }
    
    // Connect to DAO and retrieve the Transactions from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getTransactionsCSV(){
        List<CSVRecord> records;
        records = dao.getFusionTransactionsFromCSV();
        return records;
    }
    
    // Connect to DAO and retrieve the Therapists Rates from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getTherapistsRatesCSV(){
        List<CSVRecord> records;
        records = dao.getTherapistsRatesFromCSV();
        return records;
    }
    
    // Connect to DAO and retrieve the Insurances Rates from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getInsurancesRatesCSV(){
        List<CSVRecord> records;
        records = dao.getInsurancesRatesFromCSV();
        return records;
    }
    
    // Export Data to CSV
    public int exportDataToCsv(JTable table, String name){
        Appointment app = new Appointment();
        ArrayList<List<String>> list = app.exportSelectedData(table);
        int success = dao.exportToCSV(list, name);
        return success;
    }
}
