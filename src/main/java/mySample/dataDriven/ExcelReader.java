package mySample.dataDriven;

import net.thucydides.core.annotations.Step;
import util.ExcelHelper;
import util.PropertyLoader;

import java.util.LinkedHashMap;
import java.util.List;

public class ExcelReader {

    private String dataFilePath;
    private List<LinkedHashMap<String, String>> sheetDataMap;

    @Step
    public void setDataFile(String fileName) {
        dataFilePath = PropertyLoader.loadProperty("testdata_folder") + fileName;
    }

    @Step
    public void readSheetFromDataFile(String sheetName) {
        sheetDataMap = ExcelHelper.getSheetDataAsMap(ExcelHelper.getSheetData(dataFilePath, sheetName));
    }

    @Step
    public List<LinkedHashMap<String, String>> getSheetDataAsMap() {
        return sheetDataMap;
    }
}
