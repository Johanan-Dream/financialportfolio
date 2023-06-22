package javaproject.portfolio.DTO;

public class FinanceProducts {
	private BankName bankName;
	private int financeproducts_idx;
	private String type;
	private String name;
	private int jlimit;
	private int period;
	private String irtype;
	private double default_ir;
	private double max_ir;
	private int max_amount;
	
	public BankName getBankName() {
		return bankName;
	}
	public void setBankName(BankName bankName) {
		this.bankName = bankName;
	}
	public int getFinanceproducts_idx() {
		return financeproducts_idx;
	}
	public void setFinanceproducts_idx(int financeproducts_idx) {
		this.financeproducts_idx = financeproducts_idx;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJlimit() {
		return jlimit;
	}
	public void setJlimit(int jlimit) {
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
