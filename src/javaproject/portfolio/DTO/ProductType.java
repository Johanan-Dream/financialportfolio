package javaproject.portfolio.DTO;

public class ProductType {
	private int producttype_idx;
	private BankName bankName;
	private String product_type;
	
	public int getProducttype_idx() {
		return producttype_idx;
	}
	public void setProducttype_idx(int producttype_idx) {
		this.producttype_idx = producttype_idx;
	}
	public BankName getBankName() {
		return bankName;
	}
	public void setBankName(BankName bankName) {
		this.bankName = bankName;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	
}
