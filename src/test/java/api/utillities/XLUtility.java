package api.utillities;


import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;

public class XLUtility {

    String path;

    public XLUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int cellCount = sheet.getRow(rowNum).getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);

        String data;
        try {
            data = cell.toString();
        } catch (Exception e) {
            data = "";
        }

        workbook.close();
        fis.close();
        return data;
    }
}

