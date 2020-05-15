package fv.dao;

import fv.models.Settings;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

public class DAO {

    private final Settings settings;
    private String DBMS = "";
    private String dbUrl = "";
   
    // Constructor
    public DAO() throws IOException{
        this.settings = new Settings();
        setDatabaseParameters();
    }
    
    // Get .csv File with the database type and location
    private void setDatabaseParameters(){
        
        try (Reader reader = new FileReader("../Fuzion Viewer/Resources/Database/dbloc.csv")) {
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            
            for (CSVRecord record : records){
                DBMS = record.get(0);
                dbUrl = record.get(1);
            }
            
            reader.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>setDatabaseParameters():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
            System.exit(1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>setDatabaseParameters():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
            System.exit(1);
        }
    }
    
    // Get Application Settings from database
    public Settings retrieveApplicationSettings() throws SQLException{
        
        String sql = "SELECT * FROM settings";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getDbConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                settings.setAppointmentFile(rs.getString("appointments_file"));
                settings.setAdjudicationsFile(rs.getString("adjudications_file"));
                settings.setTransactionsFile(rs.getString("transactions_file"));
                settings.setReportsPath(rs.getString("reports_path"));
                settings.setIsTherapistHireDate(rs.getBoolean("trp_hire_date"));
                settings.setTherapistHireDays(rs.getInt("trp_hire_date_days"));
                settings.setIsTherapistProfLicense(rs.getBoolean("trp_prof_lic"));
                settings.setTherapistProfLicenseDays(rs.getInt("trp_prof_lic_days"));
                settings.setIsTherapistDriverLic(rs.getBoolean("trp_driver_lic"));
                settings.setTherapistDriverLicDays(rs.getInt("trp_driver_lic_days"));
                settings.setIsTherapistW4W9(rs.getBoolean("trp_w4w9"));
                settings.setTherapistW4W9Days(rs.getInt("trp_w4w9_days"));
                settings.setIsTherapistPhysicalExam(rs.getBoolean("trp_physical_exam"));
                settings.setTherapistPhysicalExamDays(rs.getInt("trp_physical_exam_days"));
                settings.setIsPatientBirthday(rs.getBoolean("pat_birthday"));
                settings.setPatientBirthdayDays(rs.getInt("pat_birthday_days"));
                settings.setIsPatientInsExp(rs.getBoolean("pat_ins_exp"));
                settings.setPatientInsExpDays(rs.getInt("pat_ins_exp_days"));
            }
            
            stmt.close();
            rs.close();
            conn.close();
            
            return settings;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getApplicationSettings():\n" + ex.getMessage(), "SQLException", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return null;
    }
    
    // Save Application Settings to database
    public int updateApplicationSettings(Settings settings) throws SQLException{
        
        String sql = "UPDATE settings SET"
                + " appointments_file=?,"
                + " adjudications_file=?,"
                + " transactions_file=?,"
                + " reports_path=?,"
                + " trp_hire_date=?,"
                + " trp_hire_date_days=?,"
                + " trp_prof_lic=?,"
                + " trp_prof_lic_days=?,"
                + " trp_driver_lic=?,"
                + " trp_driver_lic_days=?,"
                + " trp_w4w9=?,"
                + " trp_w4w9_days=?,"
                + " trp_physical_exam=?,"
                + " trp_physical_exam_days=?,"
                + " pat_birthday=?,"
                + " pat_birthday_days=?,"
                + " pat_ins_exp=?,"
                + " pat_ins_exp_days=?"
                + " WHERE id=?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getDbConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, settings.getAppointmentFile());
            pstmt.setString(2, settings.getAdjudicationsFile());
            pstmt.setString(3, settings.getTransactionsFile());
            pstmt.setString(4, settings.getReportsPath());
            pstmt.setBoolean(5, settings.isTherapistHireDate());
            pstmt.setInt(6, settings.getTherapistHireDays());
            pstmt.setBoolean(7, settings.isTherapistProfLicense());
            pstmt.setInt(8, settings.getTherapistProfLicenseDays());
            pstmt.setBoolean(9, settings.isTherapistDriverLic());
            pstmt.setInt(10, settings.getTherapistDriverLicDays());
            pstmt.setBoolean(11, settings.isTherapistW4W9());
            pstmt.setInt(12, settings.getTherapistW4W9Days());
            pstmt.setBoolean(13, settings.isTherapistPhysicalExam());
            pstmt.setInt(14, settings.getTherapistPhysicalExamDays());
            pstmt.setBoolean(15, settings.isPatientBirthday());
            pstmt.setInt(16, settings.getPatientBirthdayDays());
            pstmt.setBoolean(17, settings.isPatientInsExp());
            pstmt.setInt(18, settings.getPatientInsExpDays());
            pstmt.setInt(19, 1);
            
            int result = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
            return result;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>updateApplicationSettings():\n" + ex.getMessage(), "SQLException", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }
    
    // Get a Database Connection
    private Connection getDbConnection(){
        
        String dbms;
        String url;
        String user = "";
        String password = "";
        String database = "";
        Connection dbConn = null;
        
        // Conecction for SQLite
        if (DBMS.equalsIgnoreCase("sqlite")){
            dbms = "jdbc:sqlite:";
            url = dbUrl;
            database = dbms + url;
        } 
        
        // Conecction for MySQL
        if (DBMS.equalsIgnoreCase("mysql")) {
            dbms = "jdbc:mysql:";
            url = dbUrl;
            user = "root";
            password = "root";
            database = dbms + url;
        }
        
        try {
            if (DBMS.equalsIgnoreCase("sqlite")){
                dbConn = DriverManager.getConnection(database);
            }
            
            if (DBMS.equalsIgnoreCase("mysql")){
                dbConn = DriverManager.getConnection(database, user, password);
            }
            
            return dbConn;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getDbConnection():\n" + ex.getMessage(), "Database Connection Failure", JOptionPane.INFORMATION_MESSAGE);
            System.exit(1);
        } 
        
        return null;
    }
    
    
    // Load Fuzion Exported Appointment CSV File. @Return CSVRecord
    public List<CSVRecord> getFusionAppointmentsFromCSV(){
        
        try (Reader reader = new FileReader(settings.getAppointmentFile())) {
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            
            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getFuzionAppointment():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getFuzionAppointment():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return null;
    }
    
    
    // Load Insurance Adjudications csv File. @Return CSVRecord
    public List<CSVRecord> getFusionAdjudicationsFromCSV(){
        
        try (Reader reader = new FileReader(settings.getAdjudicationsFile())){
            CSVParser records = CSVFormat.DEFAULT.parse(reader);

            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getInsurancesAdjudicationsFromCSV():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getInsurancesAdjudicationsFromCSV():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    // Load Patients Transactions csv File. @Return CSVRecord
    public List<CSVRecord> getFusionTransactionsFromCSV(){
        
        try (Reader reader = new FileReader(settings.getTransactionsFile())){
            CSVParser records = CSVFormat.DEFAULT.parse(reader);

            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getPatientsTransactionsFromCSV():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getPatientsTransactionsFromCSV():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

    
    // Export list to .csv file
    public int exportToCSV(ArrayList<List<String>> list, String fileName){
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        Date now = new Date();
        
        int success = 0;
        
        try (FileWriter csvWriter = new FileWriter(fileName + "_" + sdf.format(now) + ".csv")){
            
            for (List<String> row : list){
                csvWriter.append(String.join(",", row));
                csvWriter.append("\n");
            }
            
            success = 1;
            csvWriter.close();
            return success;
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>exportToCSV():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return success;
    }
    
    
    // Load Therapist Rates csv File. @Return CSVRecord
    public List<CSVRecord> getTherapistsRatesFromCSV(){
        
        try {
            Reader reader = new FileReader("../Fuzion Viewer/Fusion/Therapists_Rates.csv");
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getTherapistsRatesFromExcel():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getTherapistsRatesFromExcel():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    // Load Insurance Rates csv File. @Return CSVRecord
    public List<CSVRecord> getInsurancesRatesFromCSV(){
        
        try {
            Reader reader = new FileReader("../Fuzion Viewer/Fusion/Insurances_Rates.csv");
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getInsurancesRatesFromExcel():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getInsurancesRatesFromExcel():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
}
