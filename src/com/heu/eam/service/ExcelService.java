package com.heu.eam.service;

import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;

import com.heu.eam.dao.pojo.Irp;




public interface ExcelService {

	 public  List<Irp> importEmployeeByPoi(InputStream fis,String updateId);
	 public  String getCellValue(HSSFCell cell);
}
