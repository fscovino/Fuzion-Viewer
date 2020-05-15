package fv.Views;


import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 * Give format to cells on JTables when they meet certain characteristics
 * @author Francisco
 */
public class CellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col){
    super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, col );
        
        // Render Date cells to display format "MM-dd-yyyy"
        if(value instanceof Date){
             String strDate = new SimpleDateFormat("MM-dd-yyyy").format((Date)value);
             this.setText(strDate);
        }
        
        // Render Price cells to dislpay format "$ #,###.##"
        if (value instanceof Double){

            String strPrice = new DecimalFormat("$ #,###.##").format((double)value);
            // Add 2 decimals zeros to whole numbers
            if (!strPrice.contains(".")){
                strPrice += ".00";
            }
            this.setText(strPrice);
        }
        
        // Center Align Columns
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
 
        return this;
    }
}
