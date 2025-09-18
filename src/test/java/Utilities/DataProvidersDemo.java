package Utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;
public class DataProvidersDemo {
        
        @DataProvider(name="LoginData")
        public String[][] getData() throws IOException
        {
                String path=".//TestData//testdata.xlsx";
                ExcelUtilities xlutil= new ExcelUtilities();
                int totalRows=xlutil.row_count(path, "Sheet1");
                int totalCell=xlutil.cell_count(path, "Sheet1", 1);
                
                String logindata[][]=new String[totalRows][totalCell];
                for(int i=1; i<=totalRows; i++)
                {
                        for(int j=0; j<totalCell; j++)
                        {
                                logindata[i-1][j]=xlutil.get_cell_data(path, "Sheet1", i, j);
                        }
                }
                return logindata;
                
        }
}