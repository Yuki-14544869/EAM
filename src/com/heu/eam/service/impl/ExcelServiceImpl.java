package com.heu.eam.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.heu.eam.dao.IrpDao;
import com.heu.eam.dao.impl.IrpDaoImpl;
import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.ExcelService;
import com.heu.eam.utils.SessionUtil;

public class ExcelServiceImpl implements ExcelService {

	@Override
	public List<Irp> importEmployeeByPoi(InputStream fis,String updateId) {
		 List<Irp> infos = new ArrayList<Irp>();   
		 Irp irp = null;   
	           
	        try {   
	            //创建Excel工作薄   
	            HSSFWorkbook hwb = new HSSFWorkbook(fis);   
	            //得到第一个工作表   
	            HSSFSheet sheet = hwb.getSheetAt(0);   
	            HSSFRow row = null;   
	            //日期格式化   
	            //DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");   
	            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数   
	            for(int i = 0; i < hwb.getNumberOfSheets(); i++) {   
	                sheet = hwb.getSheetAt(i);   
	                //遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数  
	                for(int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {   
	                    row = sheet.getRow(j);   
	                    irp = new Irp();   
	                       
	                    /*此方法规定Excel文件中的数据必须为文本格式，所以在解析数据的时候未进行判断 
	                    //方法1：Excel解析出来的数字为double类型，要转化为Long类型必须做相应的处理(一开始用的方法，比较笨。) 
	                    //先把解析出来的double类型转化为String类型，然后截取String类型'.'以前的字符串，最后把字符串转化为Long类型。 
	                    String orgId = row.getCell(0).toString(); 
	                    String orgId1 = orgId.substring(0, orgId.indexOf('.')); */ 
	                    //方法2：其实double类型可以通过(long)Double这样直接转化为Long类型。 
	                    if(row.getCell(0)!=null){
	                    	String orgId = row.getCell(0).toString(); 
	 	                    String orgId1 = orgId.substring(0, orgId.indexOf('.'));
	                    	irp.setCode(Integer.parseInt(orgId1));
	                    }
	                    
	                    if(row.getCell(1)!=null){
	                        irp.setPath(row.getCell(1).getStringCellValue()); 
	                    }
	           
	                    if(row.getCell(2)!=null){
	                    	irp.setName(row.getCell(2).getStringCellValue()); 
	                    }
	                    
	                    if(row.getCell(3)!=null){
	                    	String orgId = row.getCell(3).toString(); 
	 	                    String orgId1 = orgId.substring(0, orgId.indexOf('.'));
	                    	irp.setPid(Integer.parseInt(orgId1)); 
	                    }
	                   
	                    if(row.getCell(4)!=null){
	                    	irp.setCname(row.getCell(4).getStringCellValue()); 
	                    }
	                    
	                    if(row.getCell(5)!=null){
	                    	irp.setDetal(row.getCell(5).getStringCellValue());
	                    }
	                    
	                    if(row.getCell(6)!=null){
	                    	String orgId = row.getCell(6).toString(); 
	 	                    String orgId1 = orgId.substring(0, orgId.indexOf('.'));
	                    	irp.setState(orgId1);
	                    }
	                    irp.setCreateId(Integer.parseInt(updateId));
	                    
	                       
	                    //此方法调用getCellValue(HSSFCell cell)对解析出来的数据进行判断，并做相应的处理  
//	                    ExcelServiceImpl esi = new ExcelServiceImpl();
//	                    if(Irp.getCellValue(row.getCell(0)) != null && !"".equals(Irp.getCellValue(row.getCell(0)))) {   
//	                    	irp.setOrgId(Long.valueOf(Irp.getCellValue(row.getCell(0))));   
//	                    }   
//	                    irp.setEmployeeNumber(Irp.getCellValue(row.getCell(1)));   
//	                    irp.setFullName(Irp.getCellValue(row.getCell(2)));   
//	                    irp.setSex(Irp.getCellValue(row.getCell(3)));   
//	                    if(Irp.getCellValue(row.getCell(4)) != null && !"".equals(Irp.getCellValue(row.getCell(4)))) {   
//	                        try {   
//	                        	irp.setDateOfBirth(ft.parse(Irp.getCellValue(row.getCell(4))));   
//	                        } catch (ParseException e) {   
//	                            e.printStackTrace();   
//	                        }   
//	                        irp.setTownOfBirth(Irp.getCellValue(row.getCell(5)));   
//	                    }   
//	                    irp.setNationalIdentifier(Irp.getCellValue(row.getCell(6)));   
	                    infos.add(irp);   
	                }   
	                IrpDao ip = new IrpDaoImpl();
	                for(Irp irpp :infos){
	                	ip.save(irpp);
	                }
	            }   
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        } catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
	        return infos;  
	}

	public  String getCellValue(HSSFCell cell){  
		 String value = null;  
	        //简单的查检列类型  
	        switch(cell.getCellType())  
	        {  
	            case HSSFCell.CELL_TYPE_STRING://字符串  
	                value = cell.getRichStringCellValue().getString();  
	                break;  
	            case HSSFCell.CELL_TYPE_NUMERIC://数字  
	                long dd = (long)cell.getNumericCellValue();  
	                value = dd+"";  
	                break;  
	            case HSSFCell.CELL_TYPE_BLANK:  
	                value = "";  
	                break;     
	            case HSSFCell.CELL_TYPE_FORMULA:  
	                value = String.valueOf(cell.getCellFormula());  
	                break;  
	            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值  
	                value = String.valueOf(cell.getBooleanCellValue());  
	                break;  
	            case HSSFCell.CELL_TYPE_ERROR:  
	                value = String.valueOf(cell.getErrorCellValue());  
	                break;  
	            default:  
	                break;  
	        }  
	        return value;  
	    }  
//	public static void main(String[] args) {
//		ExcelService es = new ExcelServiceImpl();
//		File f = new File("C:/Users/new/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/EAM/./uploadexcel/lht.xls");
//	    InputStream in;
//		try {
//			in = new FileInputStream(f);
//			es.importEmployeeByPoi(in);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
