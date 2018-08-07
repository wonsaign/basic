package com.learn.java.lang.wangs.util.excel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtil {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		showResult(getExcelData("D:/excel/基础.xlsx",3,6,2), getExcelData("D:/excel/test.xlsx",3,2,2));
		
	}
	
	
	public static void showResult(Map<String, Object[]> sourceData , Map<String, Object[]> targetData){
		int sourceDataLength = 0;
		for (String s : sourceData.keySet()) {
			sourceDataLength = sourceData.get(s).length;
			break;
		}
		int targetDataLength = 0;
		for (String k : targetData.keySet()) {
			targetDataLength = targetData.get(k).length;
			break;
		}
		int combineLength = sourceDataLength + targetDataLength;
		
		print(combineMap(targetData,sourceData,combineLength),combineLength);
		
	}
	
	private static void print(Map<String, Object[]> combine , int combineLength) {
		for (String k : combine.keySet()) {
			for (int i = 0; i < combineLength ; i++) {
				System.out.print(combine.get(k)[i]+"\t");
			}
			System.out.println("--end---");
		}
	}
	/**
	 * 
	 * @param path 文件路径
	 * @param pageNum sheet页
	 * @param objSizie 当前sheet页最大列数
	 * @param keyLocal 匹配的关键字
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 *int CELL_TYPE_NUMERIC = 0; //CellType.NUMERIC.getCode();
	 *int CELL_TYPE_STRING = 1; //CellType.STRING.getCode();
	 *int CELL_TYPE_FORMULA = 2; //CellType.FORMULA.getCode();
	 *int CELL_TYPE_BLANK = 3; //CellType.BLANK.getCode();
	 *int CELL_TYPE_BOOLEAN = 4; //CellType.BOOLEAN.getCode();
	 *int CELL_TYPE_ERROR = 5; //CellType.ERROR.getCode();
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static Map<String,Object[]>  getExcelData(String path,int pageNum , int objSizie //
		,int keyLocal )throws EncryptedDocumentException, InvalidFormatException, IOException {
		File source = new File(path);
		Map<String,Object[]> result = new LinkedHashMap<>();
		Workbook book = WorkbookFactory.create(source);
		// 读取sheet内容
		int currentPage = pageNum -1 ;
		Iterator<Row> rowIterator = book.getSheetAt(currentPage).iterator();
		int rowNum = 0;
		int colNum = 0;
		 while (rowIterator != null && rowIterator.hasNext()) {
			 Row row = rowIterator.next();
			 rowNum++;
			 if (rowNum > 1) {
				 Object objs[] = new Object[objSizie];
				 String key = "";
				 Iterator<Cell> cellIterator = row.cellIterator();
				 int point = 0;
				 while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					colNum = colNum + 1;
					Object value ;
					switch(cell.getCellType()) {
					case 0 :
						value = String.valueOf((int) cell.getNumericCellValue());
						objs[point++] = value;
						break;
					case 1 :
						value = cell.getStringCellValue().trim();
						if(point == (keyLocal - 1)) {
							key = (String) value;
						}
						objs[point++] = value;
						break;
					case 2 :
						break;
					case 3 :
						break;
					case 4 :
						break;
					case 5 :
						break;
					default:
						break;
					}
				 }		
				 result.put(key, objs);
			 }
		 }
		return result;
	}
	
	// FIXME: 算法有问题，尚未修改，多层循环，
	@SuppressWarnings("null")
	private static Map<String, Object[]> combineMap(Map<String, Object[]> target , Map<String, Object[]> source , int objSize) {
		Map<String, Object[]> result = new LinkedHashMap<String, Object[]>() ;
		
		for (String t_name : target.keySet()) {
			Object[] obj_result = new Object[objSize];
			
			Object[] obj_target = target.get(t_name);
			Object[] obj_source= source.get(t_name);
			if(obj_source != null) {
				//Object[] s_o= s.get(t_name);
				int i = 0;
				for (; i < obj_target.length; i++) {
					obj_result[i] = obj_target[i];
				}
				for (int j = 0; j < obj_source.length; j++) {
					obj_result[i+j] = obj_source[j];
				}
			} else {
			//	Object[] t_o= t.get(t_name);
				for (int i = 0; i < obj_target.length; i++) {
					obj_result[i] = obj_target[i];
				}
			}
			result.put(t_name, obj_result);
		}
		return result;
	}

}
