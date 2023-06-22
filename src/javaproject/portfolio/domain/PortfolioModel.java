package javaproject.portfolio.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import javaproject.portfolio.DTO.PortFolio;

public class PortfolioModel extends AbstractTableModel{

	String[] colunmName= {"은행이름", "상품 이름", "원금 합계", "세후 이자"};
	List<PortFolio> list=new ArrayList<PortFolio>();//테이블에 출력은 위의 컬럼만 하지만 각종 계산을 위해 정보를 다 가지고 옴.
	PortfolioPage portfolioPage;
	
	public PortfolioModel(PortfolioPage portfolioPage) {
		this.portfolioPage=portfolioPage;
	}
	public int getRowCount() {
		return list.size();
	}

	public int getColumnCount() {
		return colunmName.length;
	}

	public Object getValueAt(int row, int col) {
		PortFolio portFolio=list.get(row);
		String value=null;
		switch(col) {
		case 0: value=portFolio.getBank_name();break;
		case 1: value=portFolio.getProduct_name();break;
		case 2: value=Integer.toString(portFolio.getTotalAmount()); break;
		case 3: value=Integer.toString(portFolio.getIrat()); break;
		}
		return value;
	}
	
	public String getColumnName(int col) {
		return colunmName[col];
	}

}
