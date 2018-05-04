package cn.sdhqtj.hjt.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel工具类
 */
public class ExcelTool {
	
	/**
	 * 根据Excel模板文件生成Excel文件
	 * @param inurl Excel模板文件路径
	 * @param outurl 生成的Excel文件路径
	 * @param datas 要写入Excel文件的数据
	 */
	public void WriteExcel(String inurl,String outurl,Object[][] datas) throws IOException {
		// 读取Excel模板文件
		FileInputStream inputStream = new FileInputStream(new File(inurl));
		//读取工作簿
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);  
		//读取工作表  
        XSSFSheet sheet = workBook.getSheetAt(0);
		
        XSSFRow row;
        XSSFCell cell;
        for(int i = 0; i < datas.length; i++) {
            row = sheet.createRow(i+1);//创建表格行
            for(int j = 0; j < datas[i].length; j++) {
                cell = row.createCell(j);//根据表格行创建单元格
                cell.setCellValue(String.valueOf(datas[i][j]));
            }
        }
        workBook.write(new FileOutputStream(outurl));
        
        inputStream.close();//关闭工作簿  
        workBook.close(); 
	}
}
