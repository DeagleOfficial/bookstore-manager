import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ManipulateExcelFile extends MainSystem {
	

	public void readExcel() throws BiffException, IOException {
		String FilePath = "C:/Library.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		int col = 0;

		for (int row = 1; row < totalNoOfRows; row++) {

			String bookName = sh.getCell(col, row).getContents();
			String author = sh.getCell((col + 1), row).getContents();
			String genre = sh.getCell((col + 2), row).getContents();
			String publisher = sh.getCell((col + 3), row).getContents();
			String price = sh.getCell((col+4),row).getContents();

			Book book = new Book(bookName, author, genre, publisher, price);

			bookList[row - 1] = book;
		}
	}

	public void deleteRecord(int rowNo) throws BiffException, IOException, WriteException {
		String FilePath = "D:/Library.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		WritableWorkbook copy = Workbook.createWorkbook(new File(FilePath), wb);
		WritableSheet copySheet = copy.getSheet(0);

		copySheet.removeRow(rowNo+1);

		copy.write();
		copy.close();
		wb.close();

	}
	

}