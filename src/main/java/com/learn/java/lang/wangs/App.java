package com.learn.java.lang.wangs;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.learn.java.lang.wangs.util.excel.ExcelUtil;
import com.learn.java.lang.wangs.util.excel.ExcelUtil_Dul;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
        System.out.println("Hello World!");

        ExcelUtil.showResult(ExcelUtil.getExcelData("D:/excel/基础.xlsx", 3, 6, 2), //
                ExcelUtil.getExcelData("D:/excel/test.xlsx", 3, 2, 2));

        ExcelUtil_Dul.showResult(ExcelUtil_Dul.getExcelData("D:/excel/基础.xlsx", 3, 6, 2), //
                ExcelUtil_Dul.getExcelData("D:/excel/test.xlsx", 3, 2, 2));
    }
}
