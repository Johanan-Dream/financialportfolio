package javaproject.portfolio.DTO;

public class ProductName {
	private int productname_idx ;
	private ProductType productType;
	private String name;
	private String jlimit;
	private int period;
	private String irtype;
	private double default_ir;
	private double max_ir;
	private int max_amount;
	
	public int getProductname_idx() {
		return productname_idx;
	}
	public void setProductname_idx(int productname_idx) {
		this.productname_idx = productname_idx;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getJlimit() {
		return jlimit;
	}
	public void setJlimit(String jlimit) {
		this.jlimit = jlimit;
	}

	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getIrtype() {
		return irtype;
	}
	public void setIrtype(String irtype) {
		this.irtype = irtype;
	}
	public double getDefault_ir() {
		return default_ir;
	}
	public void setDefault_ir(double default_ir) {
		this.default_ir = default_ir;
	}
	public double getMax_ir() {
		return max_ir;
	}
	public void setMax_ir(double max_ir) {
		this.max_ir = max_ir;
	}
	public int getMax_amount() {
		return max_amount;
	}
	public void setMax_amount(int max_amount) {
		this.max_amount = max_amount;
	}
	
	
	
}
