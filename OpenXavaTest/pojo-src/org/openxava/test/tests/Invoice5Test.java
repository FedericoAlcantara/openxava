package org.openxava.test.tests;

import java.text.*;
import java.util.*;

import org.openxava.tests.*;

/**
 * 
 * @author Javier Paniza
 */

public class Invoice5Test extends ModuleTestBase {
	
	public Invoice5Test(String testName) {
		super(testName, "Invoice5");		
	}
	
	
	public void testDateInCroatian() throws Exception { // tmp
		// TMP ME QUED� POR AQU�: EL CASO B�SICO, UN java.util.Date YA FUNCIONA, FALTA:
		// tmp   LocalDate
		// tmp   DATETIME
		// tmp   JS Calencar
		// tmp   JDK 8/11
		setLocale("hr");
		assertValue("date", getToday());
		assertDateInCroatian("20.9.2021", "20.09.2021");
		execute("CRUD.new");
		assertDateInCroatian("1.12.21", "01.12.2021");		
	}

	private void assertDateInCroatian(String dateEntered, String dateFormatted) throws Exception {
		setValue("year", "2021");
		setValue("number", "66"); 
		setValue("date", dateEntered);
		execute("CRUD.save");
		execute("Mode.list");
		assertValueInList(0, "date", dateFormatted);
		execute("List.viewDetail", "row=0");
		assertValue("date", dateFormatted);
		execute("CRUD.delete");
	}
	
	private String getToday() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		return df.format(new Date());
	}


	public void testImportFromExcel() throws Exception {  
		execute("Mode.list");
		assertListRowCount(0);
		assertImportFromExcel("invoices5.xlsx", "2017", "1", "9/25/17", "", "1,258.26", "");  
		assertImportFromExcel("invoices5.xls", "2017", "1", "9/25/17", "", "1,258.26", "DEFAULTER;FOLLOW UP NEEDED"); 
		setLocale("es");
		execute("Mode.list"); 
		assertImportFromExcel("invoices5.xlsx", "2017", "1", "25/09/2017", "", "1.258,26", ""); 
	}
	
	private void assertImportFromExcel(String file, String value0, String value1, String value2, String value3, String value4, String value5) throws Exception { 
		execute("ImportData.importData");
		uploadFile("file", "test-files/" + file); 
		execute("ConfigureImport.configureImport");
		execute("Import.import");
		assertNoErrors(); 
		
		assertListRowCount(1); // We want to test import just one record
		assertValueInList(0, 0, value0);
		assertValueInList(0, 1, value1);
		assertValueInList(0, 2, value2);
		assertValueInList(0, 3, value3);
		assertValueInList(0, 4, value4);
		assertValueInList(0, 5, value5); 
		
		execute("CRUD.deleteRow", "row=0");
		assertListRowCount(0);
	}

		
}
