package com.learn.java.lang.wangs.util.excel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtil_Dul {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		showResult(getExcelData("D:/excel/基础.xlsx",3,6,2), getExcelData("D:/excel/test.xlsx",8,2,2));
	}
	
	public static void showResult(Map<String, List<Object[]>> sourceData , Map<String,List<Object[]>> targetData){
		int sourceDataLength = 0;
		for (String s : sourceData.keySet()) {
			sourceDataLength = sourceData.get(s).get(0).length;
			break;
		}
		int targetDataLength = 0;
		for (String k : targetData.keySet()) {
			targetDataLength = targetData.get(k).get(0).length;
			break;
		}
		int combineLength = sourceDataLength + targetDataLength;
		
		print(combineMap(targetData,sourceData,targetDataLength,sourceDataLength),combineLength);
		
	}
	
	private static void print(Map<String, List<Object[]>> combine , int combineLength) {
		for (String k : combine.keySet()) {
			for (Object[] o : combine.get(k)) {
				for (int i = 0; i < combineLength ; i++) {
					System.out.print(o[i]+"\t");
				}
				System.out.println();
			}
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
	public static Map<String,List<Object[]>>  getExcelData(String path,int pageNum , int objSizie //
		,int keyLocal )throws EncryptedDocumentException, InvalidFormatException, IOException {
		File source = new File(path);
		Map<String,List<Object[]>> result = new LinkedHashMap<>();
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
				 // 重复数据添加
				 List<Object[]> objsArray = new LinkedList<>();
				 
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
							// exist array
							if(result.get(key) != null)
								objsArray = result.get(key);
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
				 objsArray.add(objs);
				 result.put(key, objsArray);
			 }
		 }
		return result;
	}
	
	// FIXME: 算法有问题，尚未修改，多层循环，
	@SuppressWarnings("null")
	private static Map<String, List<Object[]>> combineMap(Map<String, List<Object[]>> target , Map<String, List<Object[]>> source , int targetLen , int sourceLen) {
		Map<String, List<Object[]>> result = new LinkedHashMap<String, List<Object[]>>() ;
		
		for (String t_name : target.keySet()) {
			List<Object[]> objectArray = new LinkedList<Object[]>();
			Object[] obj_result = new Object[targetLen+sourceLen];
			
			List<Object[]> obj_target_list = target.get(t_name);
			List<Object[]> obj_source_list= source.get(t_name);
			if(obj_source_list != null) {
				// maybe not one
				for (Object[] obj_target : obj_target_list) {
					int i = 0;
					for (; i < targetLen; i++) {
						obj_result[i] = obj_target[i];
					}
					// must be one
					for (int j = 0; j < sourceLen; j++) {
						obj_result[i+j] = obj_source_list.get(0)[j];
					}
					objectArray.add(obj_result);
				}
			} else {
				for (Object[] obj_target : obj_target_list) {
					for (int i = 0; i < targetLen; i++) {
						obj_result[i] = obj_target[i];
					}
					objectArray.add(obj_result);
				}
			}
			result.put(t_name, objectArray);
		}
		return result;
	}

}
