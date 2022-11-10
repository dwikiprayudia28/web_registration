package id.jexpress.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static Vector readExcelFileXls(String fileName) throws IOException {
		/**
		 * --Define a Vector --Holds Vectors Of Cells
		 */
		Vector cellVectorHolder = new Vector();

		try {
			/** Creating Input Stream **/
			// InputStream myInput= ReadExcelFile.class.getResourceAsStream(
			// fileName );
			File file = new File(fileName);
			FileInputStream myInput = new FileInputStream(file);

			/** Create a POIFSFileSystem object **/
			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			/** Create a workbook using the File System **/
			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			/** Get the first sheet from workbook **/
			HSSFSheet mySheet = myWorkBook.getSheetAt(0);

			/** We now need something to iterate through the cells. **/
			Iterator rowIter = mySheet.rowIterator();

			/* Checking merged cell */
			// if(mySheet.getNumMergedRegions() > 0){
			// Vector vec = new Vector(1);
			// vec.add("Merged Cell Detected");
			// return vec;
			// }

			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
				// while (cellIter.hasNext()) {
				for (int i = 0; i < myRow.getLastCellNum(); i++) {

					// HSSFCell myCell = (HSSFCell) cellIter.next();

					HSSFCell myCell = myRow
							.getCell(i, Row.CREATE_NULL_AS_BLANK);

					if (myCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						if (DateUtil.isCellDateFormatted(myCell)) {
							// System.out.println(myCell.getDateCellValue());
						} else {
							myCell.setCellType(Cell.CELL_TYPE_STRING);
							String numberAsString = myCell.getStringCellValue();
							// System.out.println("cell type -- number"+numberAsString);

							try {
								double cellValue = Double
										.parseDouble(numberAsString);

							} catch (NumberFormatException e) {
								double cellValue = 0; // Handle unexpected
														// values

							}
						}

					} else if (myCell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
						// System.out.println("Formula is " +
						// myCell.getCellFormula());
						// if (DateUtil.isCellDateFormatted(myCell)) {
						// SimpleDateFormat sdf = new
						// SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
						// String myDate =
						// sdf.format(myCell.getDateCellValue());
						// Date awbDate = sdf.parse(myDate);
						// System.out.println(myCell.getDateCellValue());
						// System.out.println(awbDate);
						// } else
						if (myCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							if (DateUtil.isCellDateFormatted(myCell)) {
								// System.out.println(myCell.getDateCellValue());
							} else {
								myCell.setCellType(Cell.CELL_TYPE_STRING);
								String numberAsString = myCell
										.getStringCellValue();
								// System.out.println("cell type -- number"+numberAsString);

								try {
									double cellValue = Double
											.parseDouble(numberAsString);

								} catch (NumberFormatException e) {
									double cellValue = 0; // Handle unexpected
															// values

								}
							}
						} else {
							myCell.setCellType(Cell.CELL_TYPE_STRING);
							String numberAsString = myCell.getStringCellValue();
							// System.out.println("cell type -- number"+numberAsString);

							try {
								double cellValue = Double
										.parseDouble(numberAsString);

							} catch (NumberFormatException e) {
								double cellValue = 0; // Handle unexpected
														// values

							}
						}
						// switch(myCell.getCachedFormulaResultType()) {
						// case Cell.CELL_TYPE_NUMERIC:
						// System.out.println("Last evaluated as: " +
						// myCell.getNumericCellValue());
						// break;
						// case Cell.CELL_TYPE_STRING:
						// System.out.println("Last evaluated as \"" +
						// myCell.getRichStringCellValue() + "\"");
						// break;
						// }
					}

					cellStoreVector.addElement(myCell);
				}
				// System.out.println(cellStoreVector);
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static Vector readExcelFileXlsx(String fileName) throws IOException {
		/**
		 * --Define a Vector --Holds Vectors Of Cells
		 */
		Vector cellVectorHolder = new Vector();

		try {
			/** Creating Input Stream **/
			// InputStream myInput= ReadExcelFile.class.getResourceAsStream(
			// fileName );
			File file = new File(fileName);
			FileInputStream myInput = new FileInputStream(file);

			/** Create a POIFSFileSystem object **/
			// POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			/** Create a workbook using the File System **/
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);

			/** Get the first sheet from workbook **/
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			/** We now need something to iterate through the cells. **/
			Iterator rowIter = mySheet.rowIterator();

			for (int i = 0; i < mySheet.getNumMergedRegions(); i++) {
				CellRangeAddress mergedRegion = mySheet.getMergedRegion(i);
			}

			/* Checking merged cell */
			// if(mySheet.getNumMergedRegions() > 0){
			// Vector vec = new Vector(1);
			// vec.add("Merged Cell Detected");
			// return vec;
			// }

			while (rowIter.hasNext()) {
				XSSFRow myRow = (XSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();

				// for(int i=0; i<myRow.getLastCellNum(); i++) {
				// XSSFCell cell;
				// cell = myRow.getCell(i, Row.CREATE_NULL_AS_BLANK);
				// System.out.print(cell.toString()+" - ");
				// }
				// System.out.println();

				// while (cellIter.hasNext()) {
				for (int i = 0; i < myRow.getLastCellNum(); i++) {

					// XSSFCell myCell = (XSSFCell) cellIter.next();

					XSSFCell myCell = myRow
							.getCell(i, Row.CREATE_NULL_AS_BLANK);
					if (myCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
						if (DateUtil.isCellDateFormatted(myCell)) {
							// System.out.println(myCell.getDateCellValue());
						} else {
							myCell.setCellType(Cell.CELL_TYPE_STRING);
							String numberAsString = myCell.getStringCellValue();
							// System.out.println("cell type -- number"+numberAsString);

							try {
								double cellValue = Double
										.parseDouble(numberAsString);

							} catch (NumberFormatException e) {
								double cellValue = 0; // Handle unexpected
														// values

							}
						}

					} else if (myCell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
						// System.out.println("Formula is " +
						// myCell.getCellFormula());
						// if (DateUtil.isCellDateFormatted(myCell)) {
						// SimpleDateFormat sdf = new
						// SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
						// String myDate =
						// sdf.format(myCell.getDateCellValue());
						// Date awbDate = sdf.parse(myDate);
						// System.out.println(myCell.getDateCellValue());
						// System.out.println(awbDate);
						// } else
						if (myCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
							if (DateUtil.isCellDateFormatted(myCell)) {
								// System.out.println(myCell.getDateCellValue());
							} else {
								myCell.setCellType(Cell.CELL_TYPE_STRING);
								String numberAsString = myCell
										.getStringCellValue();
								// System.out.println("cell type -- number"+numberAsString);

								try {
									double cellValue = Double
											.parseDouble(numberAsString);

								} catch (NumberFormatException e) {
									double cellValue = 0; // Handle unexpected
															// values

								}
							}
						} else {
							myCell.setCellType(Cell.CELL_TYPE_STRING);
							String numberAsString = myCell.getStringCellValue();
							// System.out.println("cell type -- number"+numberAsString);

							try {
								double cellValue = Double
										.parseDouble(numberAsString);

							} catch (NumberFormatException e) {
								double cellValue = 0; // Handle unexpected
														// values

							}
						}
						// switch(myCell.getCachedFormulaResultType()) {
						// case Cell.CELL_TYPE_NUMERIC:
						// System.out.println("Last evaluated as: " +
						// myCell.getNumericCellValue());
						// break;
						// case Cell.CELL_TYPE_STRING:
						// System.out.println("Last evaluated as \"" +
						// myCell.getRichStringCellValue() + "\"");
						// break;
						// }
					}

					cellStoreVector.addElement(myCell);
				}
				// System.out.println(cellStoreVector);
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

}
