package com.panda;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;

/**
 * @author panda   84305510@qq.com
 * @date 2019-06-29 18:40
 */
public class readExcel {
    public static void main(String[] args) {
        String fileDir = "/Users/panda/Desktop/Oracle_jmeter/多表对比输入文件.xlsx";
        File file = new File(fileDir);
        HSSFWorkbook workbook = null;
        if (file.exists()) {    //文件存在
            //创建workbook
            try {
                workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.getSheetAt(0);
                //加入Worksheet（不加入sheet时生成的xls文件打开时会报错)
                // HSSFSheet sheet = workbook.getSheetAt(0);
                // sheet=Oraclebook.getSheetAt(1);//到时候这里换上变量
                System.out.println(sheet);
                HSSFRow row = sheet.getRow(0);
                int zerorow = row.getLastCellNum();
                for (int i = 1; i < zerorow; i++) {
                    String databasename = row.getCell(i).getStringCellValue();
                    String[] strArr = databasename.split("\\-");
                    System.out.println(strArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("文件不存在");
        }

    }


}
