package javaproject.portfolio.parse.json;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

//JTable이 데이터를 출력할때 참고할 모델 객체 정의
public class DataParseModel extends AbstractTableModel{
	//파싱한 결과로 대체해야하지만, 최초에 프로그램 가동될때 JTable이 인식할 예정이므로,
	//처음엔 비어있는 movieList를 만들자. 사이즈는 0으로
	//최조 프로그램 가동과 함께 null이면 JTable이 참고를 못하므로, 에러 방지용으로 
	//인스턴스 생성해둠
	
	ArrayList<ProductData> productList=new ArrayList<ProductData>();
	String[] column= {"bank_name", "product_name", "jlimit", "period", "irtype", "default_ir", "max_ir", "maxAmount"};
	

	public int getRowCount() {//레코드수(층수)
		return productList.size();
	}

	public int getColumnCount() {//호수
		return column.length;
	}
	
	public String getColumnName(int col) {
		return column[col];
	}
	
	public Object getValueAt(int row, int col) {

		ProductData product=productList.get(row);
		String value=null;
		
		switch(col) {
			case 0:value=product.getBank_name();break;
			case 1:value=product.getProduct_name();break;
			case 2:value=product.getJlimit();break;
			case 3:value=product.getPeriod();break;
			case 4:value=product.getIrtype();break;
			case 5:value=product.getDefault_ir();break;
			case 6:value=product.getMax_ir();break;
			case 7:value=Integer.toString(product.getMax_amount());break;
		}
		return value;
	}
}
