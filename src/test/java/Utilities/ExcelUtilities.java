package Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtilities {
        
        public static FileInputStream fi;
        public static FileOutputStream fo;
        public static XSSFWorkbook wb;
        public static XSSFSheet ws;
        public static XSSFRow row;
        public static XSSFCell cell;
        public static int row_count(String XlFile,String XlSheet) throws IOException
        {
                fi = new FileInputStream(XlFile);
                wb = new XSSFWorkbook(fi);
                ws = wb.getSheet(XlSheet);
                int rowcount=ws.getLastRowNum();
                wb.close();
                fi.close();
                return rowcount;        
        }
        
        public static int cell_count(String XlFile,String XlSheet, int row_num) throws IOException
        {
                fi = new FileInputStream(XlFile);
                wb = new XSSFWorkbook(fi);
                ws = wb.getSheet(XlSheet);
                row = ws.getRow(row_num);
                int cell_count = row.getLastCellNum();
                wb.close();
                fi.close();
                return cell_count;
        }
        
        public static String get_cell_data(String XlFile,String XlSheet, int row_num, int cell_num) throws IOException
        {
                fi = new FileInputStream(XlFile);
                wb = new XSSFWorkbook(fi);
                ws = wb.getSheet(XlSheet);
                row = ws.getRow(row_num);
                cell = row.getCell(cell_num);
                String data;
                try
                {
                data = cell.toString();
                }
                catch(Exception e)
                {
                        data = " ";
                }
                return data;
        }
        
        public static void set_cell_data(String XlFile,String XlSheet, int row_num, int cell_num, String data) throws IOException
        {
                fi=new FileInputStream(XlFile);
                wb=new XSSFWorkbook(fi);
                ws=wb.getSheet(XlSheet);
                row=ws.getRow(row_num);
                cell=row.createCell(cell_num);
                cell.setCellValue(data);
                fo=new FileOutputStream(XlFile);
                wb.write(fo);                
                wb.close();
                fi.close();
                fo.close();                        
        }
}

