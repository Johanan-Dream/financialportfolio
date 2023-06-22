package javaproject.portfolio.DTO;

public class PortFolio {
	private String bank_name;
	private String product_type;
	private String product_name;
	private int period;
	private int totalAmount;
	private int ibtd;
	private int taxAmount;
	private int atra;
	private int irat;
	
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getIbtd() {
		return ibtd;
	}
	public void setIbtd(int ibtd) {
		this.ibtd = ibtd;
	}
	public int getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(int taxAmount) {
		this.taxAmount = taxAmount;
	}
	public int getAtra() {
		return atra;
	}
	public void setAtra(int atra) {
		this.atra = atra;
	}
	public int getIrat() {
		return irat;
	}
	public void setIrat(int irat) {
		this.irat = irat;
	}
	
	
}
