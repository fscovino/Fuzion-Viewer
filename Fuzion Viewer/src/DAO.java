
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

/**
 *
 * @author Francisco
 */
public class DAO {

    private final String[] listPaths;
   
    // Constructor
    public DAO(){
        this.listPaths = getExternalTablesPath();
    }
    
    // Load Fuzion Exported Appointment CSV File. @Return CSVRecord
    public List<CSVRecord> getFuzionAppointmentsFromCSV(){
        
        try {
            Reader reader = new FileReader(listPaths[0]);
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getFuzionAppointment():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getFuzionAppointment():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    // Load Therapist Rates csv File. @Return CSVRecord
    public List<CSVRecord> getTherapistsRatesFromCSV(){
        
        try {
            Reader reader = new FileReader(listPaths[1]);
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
            Reader reader = new FileReader(listPaths[2]);
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getInsurancesRatesFromExcel():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getInsurancesRatesFromExcel():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    // Load Insurance Adjudications csv File. @Return CSVRecord
    public List<CSVRecord> getInsurancesAdjudicationsFromCSV(){
        
        try {
            Reader reader = new FileReader(listPaths[3]);
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
    public List<CSVRecord> getPatientsTransactionsFromCSV(){
        
        try {
            Reader reader = new FileReader(listPaths[4]);
            CSVParser records = CSVFormat.DEFAULT.parse(reader);
            return records.getRecords();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getPatientsTransactionsFromCSV():\n" + ex.getMessage(), "File Not Found Exception", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>getPatientsTransactionsFromCSV():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }

    // Get the External Fuzion Exported Tables paths from DB
    private static String[] getExternalTablesPath(){
        /**  C:/Users/Francisco  |  C:/Users/fscovino.CMHMIAMI   |  /home/francisco   */
        String[] paths = {
            "C:/Users/Francisco/Dropbox/Workspace/Netbeans/Fuzion Viewer/src/tables/Appointments.csv",
            "C:/Users/Francisco/Dropbox/Workspace/Netbeans/Fuzion Viewer/src/tables/Therapists_Rates.csv",
            "C:/Users/Francisco/Dropbox/Workspace/Netbeans/Fuzion Viewer/src/tables/Insurances_Rates.csv",
            "C:/Users/Francisco/Dropbox/Workspace/Netbeans/Fuzion Viewer/src/tables/Adjudications.csv",
            "C:/Users/Francisco/Dropbox/Workspace/Netbeans/Fuzion Viewer/src/tables/Transactions.csv"
        };
        
        return paths;
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
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "<DAO>exportToCSV():\n" + ex.getMessage(), "IO Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return success;
    }
    
    public void testMethod(){

    }
    
    // Main method for testing pursposes
    public static void main(String args[]){
        DAO dao = new DAO();
        
    }
}
