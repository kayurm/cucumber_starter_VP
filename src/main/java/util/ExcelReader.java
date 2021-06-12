package util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    private final static Logger LOG = LogManager.getLogger(ExcelReader.class);

    public static List<List<String>> getSheetData(String filePath, String sheetName) {
        LOG.info(String.format("Reading the spreadsheet '%s' at '%s')",sheetName,filePath));
        XSSFSheet sheet;
        XSSFWorkbook workbook;
        List<List<String>> outerList;

        try {
            workbook = readWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
            outerList = prepareSheetData(sheet);
            workbook.close();
        } catch (InvalidFormatException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return outerList;
    }

    public static List<LinkedHashMap<String, String>> getSheetDataAsMap(List<List<String>> data){
        LOG.info("Forming map from the list, with the first row (header) as keys");
        List<String> keys = data.get(0);
        List<LinkedHashMap<String, String>> result = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            LinkedHashMap<String, String> innerListMap = new LinkedHashMap<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                innerListMap.put(keys.get(j),data.get(i).get(j));
            }
            result.add(innerListMap);
        }
        return result;
    }

    private static XSSFWorkbook readWorkbook(String filePath) throws InvalidFormatException, IOException {
        return new XSSFWorkbook(new File(filePath));
    }

    private static List<List<String>> prepareSheetData(XSSFSheet sheet) {
        List<List<String>> outerList = new LinkedList<>();
        prepareOuterList(sheet, outerList);
        return Collections.unmodifiableList(outerList);
    }

    private static void prepareOuterList(XSSFSheet sheet, List<List<String>> outerList) {
        LOG.info("Preparing excel list");
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            List<String> innerList = new LinkedList<>();
            XSSFRow xssfRow = sheet.getRow(i);

            for (int j = xssfRow.getFirstCellNum(); j < xssfRow.getLastCellNum(); j++) {
                prepareInnerList(innerList, xssfRow, j);
            }
            outerList.add(Collections.unmodifiableList(innerList));
        }
    }

    private static void prepareInnerList(List<String> innerList, XSSFRow xssfRow, int j) {
        switch (xssfRow.getCell(j).getCellType()) {

            case BLANK:
                innerList.add("");
                break;

            case STRING:
                innerList.add(xssfRow.getCell(j).getStringCellValue());
                break;

            case NUMERIC:
                innerList.add(xssfRow.getCell(j).getNumericCellValue() + "");
                break;

            case BOOLEAN:
                innerList.add(xssfRow.getCell(j).getBooleanCellValue() + "");
                break;

            default:
                throw new IllegalArgumentException("Cannot read the column : " + j);
        }
    }

    @Ignore("for debugging")
    @Test
    public void testExcel(){
        List<List<String>> dataList = ExcelReader.getSheetData("src/test/resources/testdata/userData.xlsx", "happyPath");
        System.out.println(dataList);
        List<LinkedHashMap<String, String>> resultMap = getSheetDataAsMap(dataList);
        resultMap.forEach(System.out::println);
    }
}
