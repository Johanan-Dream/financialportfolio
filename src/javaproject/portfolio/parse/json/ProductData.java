package javaproject.portfolio.parse.json;

import javaproject.portfolio.DTO.ProductType;

public class ProductData {
	private String bank_name;//은행이름
	private String product_name;//상품이름
	private String jlimit;//가입제한
	private String name;
	private String period;
	private String irtype;
	private String default_ir;
	private String max_ir;
	private int max_amount;
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getJlimit() {
		return jlimit;
	}
	public void setJlimit(String jlimit) {
		this.jlimit = jlimit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getIrtype() {
		return irtype;
	}
	public void setIrtype(String irtype) {
		this.irtype = irtype;
	}
	public String getDefault_ir() {
		return default_ir;
	}
	public void setDefault_ir(String default_ir) {
		this.default_ir = default_ir;
	}
	public String getMax_ir() {
		return max_ir;
	}
	public void setMax_ir(String max_ir) {
		this.max_ir = max_ir;
	}
	public int getMax_amount() {
		return max_amount;
	}
	public void setMax_amount(int max_amount) {
		this.max_amount = max_amount;
	}
	
	
	
	
}
