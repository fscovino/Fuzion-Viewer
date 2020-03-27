
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Francisco
 */
public class Controller {
    
    private final DAO dao;
    private final ArrayList<String[]> filterAppointmentParametersList;
    
    // Constructor
    public Controller(){
        dao = new DAO();
        filterAppointmentParametersList = new ArrayList<>();
    }
    
    // Connect to DAO and retrieve the Appointments from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getAppointmentExportedData(){
        List<CSVRecord> records;
        records = dao.getFuzionAppointmentsFromCSV();
        return records;
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
    
    //  Filter Appointment table
    public int filterTable(JTable table, String word, int field, Date dateFrom, Date dateTo, int dateIn){
        
        // Create a parameter pair (keyword, field)
        String[] parameter = new String[]{word, String.valueOf(field)};
        
        // Add parameter to the list of parameters
        filterAppointmentParametersList.add(parameter);

        // Create a filter for each parameter on the parameterList and add them to an arrayList
        ArrayList<RowFilter<TableModel, Object>> filtersList = new ArrayList<>();
        RowFilter<TableModel, Object> filter;
        String param;
        int columnIndex;
        for (int i = 0; i < filterAppointmentParametersList.size(); i++){
            param = filterAppointmentParametersList.get(i)[0];
            columnIndex = Integer.valueOf(filterAppointmentParametersList.get(i)[1]);
            filter = RowFilter.regexFilter(param, columnIndex);
            filtersList.add(filter);
        }
        
        // Add filters for date FROM and TO to the arrayList of filters
        int dateColumn = 6;
        switch(dateIn){
            case 0:
                dateColumn = 6;     // Appointment Date
                break;
            case 1:
                dateColumn = 20;    // Date Ins Paid
                break;
            case 2:
                dateColumn = 23;    // Date Pat Paid
        }
        if (dateFrom != null){
            RowFilter<TableModel, Object> filterFrom = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, dateFrom, dateColumn);
            filtersList.add(filterFrom);
        }
        
        if (dateTo != null){
            RowFilter<TableModel, Object> filterTo = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, dateTo, dateColumn);
            filtersList.add(filterTo);
        }
        
        // Create a compound filter list from the array of filters
        RowFilter<TableModel, Object>  compoundFilter = RowFilter.andFilter(filtersList);
        
        // Create a table sorter object
        TableRowSorter<TableModel> sorter = new TableRowSorter<>((DefaultTableModel)table.getModel());
        sorter.setRowFilter(compoundFilter);
        table.setRowSorter(sorter);
        
        // Return the parameters list size to show on btnClear
        return filterAppointmentParametersList.size();
    }
    
    // Clean al parameters from parameterList
    public int clearSearchParamAppointments(){
        filterAppointmentParametersList.clear();
        return filterAppointmentParametersList.size();
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
    
    // Connect to DAO and retrieve the Adjudications from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getAdjudicationsCSV(){
        List<CSVRecord> records;
        records = dao.getInsurancesAdjudicationsFromCSV();
        return records;
    }
    
    // Connect to DAO and retrieve the Transactions from CSV
    // @Return List<CSVRecord>
    public List<CSVRecord> getTransactionsCSV(){
        List<CSVRecord> records;
        records = dao.getPatientsTransactionsFromCSV();
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
