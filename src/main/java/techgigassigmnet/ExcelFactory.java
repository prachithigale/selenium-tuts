package techgigassigmnet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelFactory {
	public  static FileInputStream fis;
	public  static File f;

	public  static XSSFWorkbook wb;
	public  static XSSFSheet sh;
	public  static XSSFRow row = null;
	public  static XSSFCell cell = null;
	//static String path="D:\\selenium_jar\\autoscript\\login.xlsx";

	public static Object[][] getTableArray(String path,int index){   

		{
			System.out.println("Excel build up started  "+ path +" "+index);

			String[][] tabArray = null;
			try {
				f=new File(path);
				
				fis =new FileInputStream(f);
				
				 wb=new XSSFWorkbook(fis);
			
				sh=wb.getSheetAt(index);;
				int totalRows = sh.getPhysicalNumberOfRows();
				
				int totalcols=sh.getRow(0).getPhysicalNumberOfCells();
				System.out.println("row>>  "+totalRows+"  col>> "+totalcols);  
				tabArray=new String[totalRows][totalcols];

				for (int i=0;i<totalRows;i++) {           	   


					for (int j=0;j<totalcols;j++){
						 
						tabArray[i][j]=getCellData(i,j);
						System.out.println(tabArray[i][j]); 

					}

				}
				System.out.println("Excel tabArray"+tabArray);
				return(tabArray);


			} catch (Exception e) {
				System.out.println("Exception in reading excel");
				e.printStackTrace();
				return(tabArray);
			}


		}
	}

	public  static  String getCellData(int RowNum, int ColNum) throws Exception {
		try{	
			row = sh.getRow(RowNum);
			cell = row.getCell(ColNum);
			System.out.println("cell>>> "+cell);
			if(cell.getCellTypeEnum() == CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
			{
				String cellValue  = String.valueOf(cell.getNumericCellValue());

				return cellValue;
			}else if(cell.getCellTypeEnum() == CellType.BLANK)
			{
				return "";
			}
			else
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row "+RowNum+" or column "+ColNum +" does not exist  in Excel";
		}
	}

}	


