package javaproject.portfolio.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import javaproject.portfolio.DTO.ProductName;

public class ProductNameModel extends AbstractTableModel {
	List<ProductName> list=new ArrayList<ProductName>();
	String[] columnName= {"순번", "은행이름", "상품종류", "상품이름", "가입제한", "기간", "금리유형", "기본금리", "최고금리", "최고한도"};
	
	public int getRowCount() {
		return list.size();
	}

	public int getColumnCount() {
		return 10;
	}

	public Object getValueAt(int row, int col) {
		ProductName productName=list.get(row);
		String value=null;

	      switch(col) {
	      case 0 : value=Integer.toString(productName.getProductname_idx());break;
	      case 1 : value=productName.getProductType().getBankName().getBank_name();break;
	      case 2 : value=productName.getProductType().getProduct_type();break;
	      case 3 : value=productName.getName();break;
	      case 4 : value=productName.getJlimit();break;
	      case 5 : value=Integer.toString(productName.getPeriod());break;
	      case 6 : value=productName.getIrtype();break;
	      case 7 : value=Double.toString(productName.getDefault_ir());break;
	      case 8 : value=Double.toString(productName.getMax_ir());break;
	      case 9 : value=Integer.toString(productName.getMax_amount());break;
		}
		return value;
	}
	
	public String getColumnName(int col) {
		return columnName[col];
	}
}
