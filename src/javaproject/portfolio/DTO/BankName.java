package javaproject.portfolio.DTO;

public class BankName {
	private BankType bankType;
	private int bankname_idx;
	private String bank_name;
	
	public BankType getBankType() {
		return bankType;
	}
	public void setBankType(BankType bankType) {
		this.bankType = bankType;
	}
	public int getBankname_idx() {
		return bankname_idx;
	}
	public void setBankname_idx(int bankname_idx) {
		this.bankname_idx = bankname_idx;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	
	
}
