package com.allianz.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2ExcelTest {

    public static void main(String[] args) throws IOException {


        FileInputStream file=new FileInputStream("src/test/resources/TestData/excel.xlsx");

        XSSFWorkbook book=new XSSFWorkbook(file);

        XSSFSheet sheet= book.getSheet("invalidLoginTest");

        int rowCount=sheet.getPhysicalNumberOfRows();
        int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data=new Object[rowCount-1][cellCount];

        //write a logic to print all cell values one by one
        //add the values to two dim Object[][]

        DataFormatter format=new DataFormatter();
        for(int r=1;r<rowCount;r++)
        {
            for(int c=0;c<cellCount;c++)
            {
                data[r-1][c]=format.formatCellValue(sheet.getRow(r).getCell(c));
            }
        }


        book.close();
        file.close();
    }

}