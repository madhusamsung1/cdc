package com.TestScenarios;

import java.io.FileInputStream;

import org.testng.annotations.Test;

import com.Utilities.StaticVariables;

import jxl.Sheet;
import jxl.Workbook;

public class readfromloop_M extends StaticVariables{
  @Test
	  
	  public void readExcel() throws Exception{
			String FilePath = "/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/testdata/loop_M.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// TO get the access to the sheet
			Sheet sh = wb.getSheet("Sheet1");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();

			for (int row = 0; row < totalNoOfRows; row++) {

				for (int col = 0; col < totalNoOfCols; col++) {
					System.out.print(sh.getCell(col, row).getContents() + "\t");
				}
				System.out.println();
			}
		}

		//public static void main(String args[]) throws Exception {
			//ReadExcelFile DT = new ReadExcelFile();
			//DT.readExcel();
  }


