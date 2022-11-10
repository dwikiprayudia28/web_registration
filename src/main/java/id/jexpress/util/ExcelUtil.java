package id.jexpress.util;

import id.jexpress.dto.AttendanceList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static void generateExcelAttn(List<AttendanceList> listObj, String fileLocation, HttpServletResponse response) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dnow = new Date();
		String strDate = sdfDate.format(dnow);
        String fileName  = fileLocation + "Attendance-" + strDate + ".xlsx";
        
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Set header in excel
		XSSFSheet excelHeader = workbook.createSheet("Attendance List");
		excelHeader.setDefaultColumnWidth((short) 20);
		
		
		// create style for header cells
//		DateFormat dfHHmm = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		DateFormat dfHH = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		CellStyle styleBasic = workbook.createCellStyle();
		CellStyle styleDecimal = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		styleBasic.setFillForegroundColor(HSSFColor.BLUE.index);
		styleBasic.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleDecimal.setFillForegroundColor(HSSFColor.BLUE.index);
		styleDecimal.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		styleBasic.setFont(font);
		styleDecimal.setFont(font);
		styleDecimal.setDataFormat(workbook.createDataFormat().getFormat("0.00"));

		// Input
		XSSFRow excelSheet = excelHeader.createRow(0);

		int i = 0;

//		excelSheet.createCell(i).setCellValue("No");
//		excelSheet.getCell(i).setCellStyle(styleBasic);

//		excelSheet.createCell(i).setCellValue("Attn ID");
//		excelSheet.getCell(i).setCellStyle(styleBasic);
//		excelHeader.setColumnWidth(i, 2500);

		excelSheet.createCell(i).setCellValue("NIK");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("NIK Ext");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("User Office");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Company");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Job Position");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Department");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("User Name");
		excelSheet.getCell(i).setCellStyle(styleBasic);

		excelSheet.createCell(++i).setCellValue("In");
		excelSheet.getCell(i).setCellStyle(styleBasic);

		excelSheet.createCell(++i).setCellValue("Arrive Zname");
		excelSheet.getCell(i).setCellStyle(styleBasic);

		excelSheet.createCell(++i).setCellValue("Arrive Office");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Arrive Approval");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Arrive Approved By");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Arrive Approved By (NIK)");
		excelSheet.getCell(i).setCellStyle(styleBasic);

		excelSheet.createCell(++i).setCellValue("Out");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Depart Zname");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Depart Office");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Depart Approval");
		excelSheet.getCell(i).setCellStyle(styleBasic);

		excelSheet.createCell(++i).setCellValue("Depart Approved By");
		excelSheet.getCell(i).setCellStyle(styleBasic);
		
		excelSheet.createCell(++i).setCellValue("Depart Approved By (NIK)");
		excelSheet.getCell(i).setCellStyle(styleBasic);

		//Merged Cell
		//excelHeader.addMergedRegion(new CellRangeAddress(1,1,1,4));

		int record = 1;
//		int no = 0;

		try {
			for (AttendanceList attn : listObj) {

				int j = 0;
				XSSFRow excelRow = excelHeader.createRow(record++);
//				excelRow.createCell(j++).setCellValue(++no);
//				excelRow.createCell(j++).setCellValue(attn.getId());
				excelRow.createCell(j++).setCellValue(attn.getUserNik() != null ? attn.getUserNik().toString() : "");
				excelRow.createCell(j++).setCellValue(attn.getUserNikExt());
				excelRow.createCell(j++).setCellValue(attn.getUserOfficeName());
				excelRow.createCell(j++).setCellValue(attn.getUserCompanyName());
				excelRow.createCell(j++).setCellValue(attn.getUserJobPositionName());
				excelRow.createCell(j++).setCellValue(attn.getUserDepartmentName());
				excelRow.createCell(j++).setCellValue(attn.getUserName());
				excelRow.createCell(j++).setCellValue(attn.getArriveTime() != null ? dfHH.format(attn.getArriveTime()) : "");
				excelRow.createCell(j++).setCellValue(attn.getArriveZName());
				excelRow.createCell(j++).setCellValue(attn.getArriveOfficeName());
				excelRow.createCell(j++).setCellValue(attn.getArriveApprovalName());
				excelRow.createCell(j++).setCellValue(attn.getArriveUserAprove());
				excelRow.createCell(j++).setCellValue(attn.getArriveUserNikAprove() != null ? attn.getArriveUserNikAprove().toString() : "");
				excelRow.createCell(j++).setCellValue(attn.getDepartTime() != null ? dfHH.format(attn.getDepartTime()) : "");
				excelRow.createCell(j++).setCellValue(attn.getDepartZName());
				excelRow.createCell(j++).setCellValue(attn.getDepartOfficeName());
				excelRow.createCell(j++).setCellValue(attn.getDepartApprovalName());
				excelRow.createCell(j++).setCellValue(attn.getDepartUserAprove());
				excelRow.createCell(j++).setCellValue(attn.getDepartUserNikAprove() != null ? attn.getDepartUserNikAprove().toString() : "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
			System.out.println("Excel Document written succesfully");
			
			File fileToDownload = new File(fileName);
  	        InputStream in = new FileInputStream(fileToDownload);
  	
  	        // Gets MIME type of the file
  	        String mimeType = new MimetypesFileTypeMap().getContentType(fileName);
  	
  	        if (mimeType == null) {
  	            // Set to binary type if MIME mapping not found
  	            mimeType = "application/octet-stream";
  	        }
  	        
  	        // Modifies response
  	        response.setContentType(mimeType);
  	        response.setContentLength((int) fileToDownload.length());
  	
  	        // Forces download
  	        String headerKey = "Content-Disposition";
  	        String headerValue = String.format("attachment; filename=\"%s\"", fileToDownload.getName());
  	        response.setHeader(headerKey, headerValue);
  	
  	        // obtains response's output stream
  	        OutputStream outStream = response.getOutputStream();
  	
  	        byte[] buffer = new byte[4096];
  	        int bytesRead = -1;
  	
  	        while ((bytesRead = in.read(buffer)) != -1) {
  	            outStream.write(buffer, 0, bytesRead);
  	        }
  	        in.close();
  	        outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

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
			
			/*Checking merged cell*/
//			if(mySheet.getNumMergedRegions() > 0){
//				Vector vec = new Vector(1);
//				vec.add("Merged Cell Detected");
//				return vec;
//			}

			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
//				while (cellIter.hasNext()) {
				for(int i=0; i<myRow.getLastCellNum(); i++) {
					
//					HSSFCell myCell = (HSSFCell) cellIter.next();
					
					HSSFCell myCell = myRow.getCell(i, Row.CREATE_NULL_AS_BLANK);
					
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
//			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			/** Create a workbook using the File System **/
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);

			/** Get the first sheet from workbook **/
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			/** We now need something to iterate through the cells. **/
			Iterator rowIter = mySheet.rowIterator();
			
			for (int i = 0; i < mySheet.getNumMergedRegions(); i++){
			    CellRangeAddress mergedRegion = mySheet.getMergedRegion(i);
			}
			
			/*Checking merged cell*/
//			if(mySheet.getNumMergedRegions() > 0){
//				Vector vec = new Vector(1);
//				vec.add("Merged Cell Detected");
//				return vec;
//			}

			while (rowIter.hasNext()) {
				XSSFRow myRow = (XSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
				
//				for(int i=0; i<myRow.getLastCellNum(); i++) {
//					XSSFCell cell; 
//					cell = myRow.getCell(i, Row.CREATE_NULL_AS_BLANK);
//					System.out.print(cell.toString()+" - ");
//				}
//				System.out.println();
				
//				while (cellIter.hasNext()) {
				for(int i=0; i<myRow.getLastCellNum(); i++) {
					
//					XSSFCell myCell = (XSSFCell) cellIter.next();
					
					XSSFCell myCell = myRow.getCell(i, Row.CREATE_NULL_AS_BLANK);
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
