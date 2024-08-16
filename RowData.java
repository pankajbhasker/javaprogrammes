import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class RowData {
    private String serviceCode;
    private String originLoc;
    private String terminalId;
    private String dayOfWeek;

    public RowData(String serviceCode, String originLoc, String terminalId, String dayOfWeek) {
        this.serviceCode = serviceCode;
        this.originLoc = originLoc;
        this.terminalId = terminalId;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "RowData{" +
                "serviceCode='" + serviceCode + '\'' +
                ", originLoc='" + originLoc + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }

    // Getters and setters can be added here if needed
}

public class ExcelReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\YourUsername\\Downloads\\yourfile.xlsx"; // Specify the file path here
        String oriServiceCode = "123";
        String oriOriginLoc = "LocationA";
        String oriTerminalId = "TID001";
        String oriDayOfWeek = "Monday";
        
        List<RowData> rowsData = readExcelFile(filePath, oriServiceCode, oriOriginLoc, oriTerminalId, oriDayOfWeek);
        for (RowData row : rowsData) {
            System.out.println(row);
        }
    }

    public static List<RowData> readExcelFile(String filePath, String oriServiceCode, String oriOriginLoc, String oriTerminalId, String oriDayOfWeek) {
        List<RowData> rowsData = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Reading the first sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from 1 to skip header row
                Row row = sheet.getRow(i);
                if (row != null) {
                    String serviceCode = getCellValue(row.getCell(0));
                    String originLoc = getCellValue(row.getCell(1));
                    String terminalId = getCellValue(row.getCell(2));
                    String dayOfWeek = getCellValue(row.getCell(3));

                    if (serviceCode.equals(oriServiceCode) && origin
