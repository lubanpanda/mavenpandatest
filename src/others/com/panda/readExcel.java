package panda;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author panda   84305510@qq.com
 * @date 2019-06-29 18:40
 */
public class readExcel {
    public static void main(String[] args) {
        String fileDir = "/Users/panda/Desktop/hello.xls";
        File file = new File(fileDir);
        HSSFWorkbook workbook = null;
        if (file.exists()) {    //文件存在
            //创建workbook
            try {
                workbook = new HSSFWorkbook();

                HSSFSheet sheet = workbook.createSheet();
                //加入Worksheet（不加入sheet时生成的xls文件打开时会报错)
                // HSSFSheet sheet = workbook.getSheetAt(0);
                HSSFRow row = sheet.createRow(0);
                row.createCell(0).setCellValue("nishuo");
                OutputStream out = new FileOutputStream(new File(fileDir));
                workbook.write(out);
                out.close();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("文件不存在");
        }

    }


}
