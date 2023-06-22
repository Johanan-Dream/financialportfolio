package javaproject.portfolio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaproject.portfolio.DTO.BankName;
import javaproject.portfolio.DTO.BankType;
import javaproject.portfolio.DTO.ProductName;
import javaproject.portfolio.DTO.ProductType;
import javaproject.portfolio.domain.PortfolioMain;
import javaproject.portfolio.util.DBManager;

public class ProductNameDAO {
	PortfolioMain portfolioMain;
	DBManager dbManager=DBManager.getInstance();
	
	public ProductNameDAO(PortfolioMain portfolioMain) {
		this.portfolioMain=portfolioMain;
	}
	
	//은행상품리스트 조회
	public List bankSelectAll() {//은행상품
		List<ProductName> list=new ArrayList<ProductName>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dbManager.getConnection();
		StringBuffer sql=new StringBuffer();
		sql.append("select bt.banktype_idx, productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
		sql.append(" from banktype bt, bankname bn, producttype pt , productname pm");
		sql.append(" where bt.banktype_idx=bn.banktype_idx");
		sql.append(" and bn.bankname_idx =pt.bankname_idx");
		sql.append(" and pt.producttype_idx=pm.producttype_idx");
		sql.append(" and bt.banktype_idx=1");//bank 타입이 은행, 저축은행
		sql.append(" order by productname_idx asc");
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			   while(rs.next()) {
		            ProductName productName=new ProductName();
		            ProductType productType=new ProductType();
		            BankName bankName=new BankName();
		            BankType bankType=new BankType();
		            
		            bankName.setBankType(bankType);
		            productType.setBankName(bankName);
		            productName.setProductType(productType);
		            
		            bankType.setBanktype_idx(rs.getInt("banktype_idx"));
		            productName.setProductname_idx(rs.getInt("productname_idx"));
		            bankType.setBank_type(rs.getString("bank_type"));
		            bankName.setBank_name(rs.getString("bank_name"));
		            productType.setProduct_type(rs.getString("product_type"));
		            productName.setName(rs.getString("name"));
		            
		            if(rs.getInt("jlimit")==1) {
		            	productName.setJlimit("제한없음");
		            }else if(rs.getInt("jlimit")==2) {
		            	productName.setJlimit("서민전용");
		            }else {
		            	productName.setJlimit("일부제한");
		            }
		            
		            productName.setPeriod(rs.getInt("period"));
		            productName.setIrtype(rs.getString("irtype"));
		            productName.setDefault_ir(rs.getDouble("default_ir"));
		            productName.setMax_ir(rs.getDouble("max_ir"));
		            productName.setMax_amount(rs.getInt("max_amount"));
		            list.add(productName);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         dbManager.release(pstmt, rs);
		}
		return list;
	}
	
	//은행상품검색-상품타입, 기간, 내용
	public List bankSelect(String ptype, int period, String content) {//은행상품
		List<ProductName> list=new ArrayList<ProductName>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dbManager.getConnection();
		StringBuffer sql=new StringBuffer();
		sql.append("select bt.banktype_idx, productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
		sql.append(" from banktype bt, bankname bn, producttype pt , productname pm");
		sql.append(" where bt.banktype_idx=bn.banktype_idx");
		sql.append(" and bn.bankname_idx =pt.bankname_idx");
		sql.append(" and pt.producttype_idx=pm.producttype_idx");
		sql.append(" and bank_type ='은행'");
		sql.append(" and product_type =?");
		sql.append(" and period=?");
		sql.append(" and (bank_name like '%' || ? || '%' or name like '%' || ? || '%' or irtype like '%' || ? || '%' or default_ir like '%' || ? || '%' or max_ir like '%' || ? || '%' or max_amount like '%' || ? || '%')");
		//or max_ir like '%' || ? || '%' or max_amount like '%' || ? || '%'
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, ptype);
			pstmt.setInt(2, period);
			pstmt.setString(3, content);//bankname
			pstmt.setString(4, content);//name
			//pstmt.setString(5, content);//jlimit
			pstmt.setString(5, content);//irtype
			pstmt.setString(6, content);//default_ir
			pstmt.setString(7, content);//max_ir
			pstmt.setString(8, content);//max_amount
			
			rs=pstmt.executeQuery();
			
			   while(rs.next()) {
		            ProductName productName=new ProductName();
		            ProductType productType=new ProductType();
		            BankName bankName=new BankName();
		            BankType bankType=new BankType();
		            
		            bankName.setBankType(bankType);
		            productType.setBankName(bankName);
		            productName.setProductType(productType);
		            
		            bankType.setBanktype_idx(rs.getInt("banktype_idx"));
		            productName.setProductname_idx(rs.getInt("productname_idx"));
		            bankType.setBank_type(rs.getString("bank_type"));
		            bankName.setBank_name(rs.getString("bank_name"));
		            productType.setProduct_type(rs.getString("product_type"));
		            productName.setName(rs.getString("name"));
		            
		            if(rs.getInt("jlimit")==1) {
		            	productName.setJlimit("제한없음");
		            }else if(rs.getInt("jlimit")==2) {
		            	productName.setJlimit("서민전용");
		            }else {
		            	productName.setJlimit("일부제한");
		            }
		            
		            productName.setPeriod(rs.getInt("period"));
		            productName.setIrtype(rs.getString("irtype"));
		            productName.setDefault_ir(rs.getDouble("default_ir"));
		            productName.setMax_ir(rs.getDouble("max_ir"));
		            
		            productName.setMax_amount(rs.getInt("max_amount"));
		       
		            list.add(productName);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         dbManager.release(pstmt, rs);
		}
		return list;
	}
	
	/*//은행상품검색 상품타입 정렬
		public List bankSelect(String ptype) {//은행상품
			List<ProductName> list=new ArrayList<ProductName>();
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			con=dbManager.getConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select bt.banktype_idx, productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
			sql.append(" from banktype bt, bankname bn, producttype pt , productname pm");
			sql.append(" where bt.banktype_idx=bn.banktype_idx");
			sql.append(" and bn.bankname_idx =pt.bankname_idx");
			sql.append(" and pt.producttype_idx=pm.producttype_idx");
			sql.append(" and bank_type ='은행'");
			sql.append(" and product_type =?");
			sql.append(" order by productname_idx asc");
			
			try {
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ptype);
				
				rs=pstmt.executeQuery();
				
				   while(rs.next()) {
			            ProductName productName=new ProductName();
			            ProductType productType=new ProductType();
			            BankName bankName=new BankName();
			            BankType bankType=new BankType();
			            
			            bankName.setBankType(bankType);
			            productType.setBankName(bankName);
			            productName.setProductType(productType);
			            
			            bankType.setBanktype_idx(rs.getInt("banktype_idx"));
			            productName.setProductname_idx(rs.getInt("productname_idx"));
			            bankType.setBank_type(rs.getString("bank_type"));
			            bankName.setBank_name(rs.getString("bank_name"));
			            productType.setProduct_type(rs.getString("product_type"));
			            productName.setName(rs.getString("name"));
			            
			            if(rs.getInt("jlimit")==1) {
			            	productName.setJlimit("제한없음");
			            }else if(rs.getInt("jlimit")==2) {
			            	productName.setJlimit("서민전용");
			            }else {
			            	productName.setJlimit("일부제한");
			            }
			            
			            productName.setPeriod(rs.getInt("period"));
			            productName.setIrtype(rs.getString("irtype"));
			            productName.setDefault_ir(rs.getDouble("default_ir"));
			            productName.setMax_ir(rs.getDouble("max_ir"));
			            
			            productName.setMax_amount(rs.getInt("max_amount"));
			       
			            list.add(productName);
			         }
			      } catch (SQLException e) {
			         e.printStackTrace();
			      }finally {
			         dbManager.release(pstmt, rs);
			}
			return list;
		}*/
	
	//저축은행 상품 리스트
	public List savingBankSelectAll() {
		List<ProductName> list=new ArrayList<ProductName>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dbManager.getConnection();
		StringBuffer sql=new StringBuffer();
		sql.append("select bt.banktype_idx, productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
		sql.append(" from banktype bt, bankname bn, producttype pt , productname pm");
		sql.append(" where bt.banktype_idx=bn.banktype_idx");
		sql.append(" and bn.bankname_idx =pt.bankname_idx");
		sql.append(" and pt.producttype_idx=pm.producttype_idx");
		sql.append(" and bt.banktype_idx=2");//bank 타입이 은행, 저축은행
		sql.append(" order by productname_idx asc");
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			   while(rs.next()) {
		            ProductName productName=new ProductName();
		            ProductType productType=new ProductType();
		            BankName bankName=new BankName();
		            BankType bankType=new BankType();
		            
		            bankName.setBankType(bankType);
		            productType.setBankName(bankName);
		            productName.setProductType(productType);
		            
		            bankType.setBanktype_idx(rs.getInt("banktype_idx"));
		            productName.setProductname_idx(rs.getInt("productname_idx"));
		            bankType.setBank_type(rs.getString("bank_type"));
		            bankName.setBank_name(rs.getString("bank_name"));
		            productType.setProduct_type(rs.getString("product_type"));
		            productName.setName(rs.getString("name"));
		            if(rs.getInt("jlimit")==1) {
		            	productName.setJlimit("제한없음");
		            }else if(rs.getInt("jlimit")==2) {
		            	productName.setJlimit("서민전용");
		            }else {
		            	productName.setJlimit("일부제한");
		            }
		            productName.setPeriod(rs.getInt("period"));
		            productName.setIrtype(rs.getString("irtype"));
		            productName.setDefault_ir(rs.getDouble("default_ir"));
		            productName.setMax_ir(rs.getDouble("max_ir"));
		            productName.setMax_amount(rs.getInt("max_amount"));
		            list.add(productName);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         dbManager.release(pstmt, rs);
		}
		return list;
	}
	
	//저축은행 상품 검색-상품타입, 기간, 내용
	public List savingBankSelect(String ptype, int period, String content) {
		List<ProductName> list=new ArrayList<ProductName>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dbManager.getConnection();
		StringBuffer sql=new StringBuffer();
		sql.append("select bt.banktype_idx, productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
		sql.append(" from banktype bt, bankname bn, producttype pt , productname pm");
		sql.append(" where bt.banktype_idx=bn.banktype_idx");
		sql.append(" and bn.bankname_idx =pt.bankname_idx");
		sql.append(" and pt.producttype_idx=pm.producttype_idx");
		sql.append(" and bank_type ='저축은행'");
		sql.append(" and product_type =?");
		sql.append(" and period=?");
		sql.append(" and (bank_name like '%' || ? || '%' or name like '%' || ? || '%' or irtype like '%' || ? || '%' or default_ir like '%' || ? || '%' or max_ir like '%' || ? || '%' or max_amount like '%' || ? || '%')");
		//or max_ir like '%' || ? || '%' or max_amount like '%' || ? || '%'
		
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, ptype);
			pstmt.setInt(2, period);
			pstmt.setString(3, content);//bankname
			pstmt.setString(4, content);//name
			//pstmt.setString(5, content);//jlimit
			pstmt.setString(5, content);//irtype
			pstmt.setString(6, content);//default_ir
			pstmt.setString(7, content);//max_ir
			pstmt.setString(8, content);//max_amount
			
			rs=pstmt.executeQuery();
			
			   while(rs.next()) {
		            ProductName productName=new ProductName();
		            ProductType productType=new ProductType();
		            BankName bankName=new BankName();
		            BankType bankType=new BankType();
		            
		            bankName.setBankType(bankType);
		            productType.setBankName(bankName);
		            productName.setProductType(productType);
		            
		            bankType.setBanktype_idx(rs.getInt("banktype_idx"));
		            productName.setProductname_idx(rs.getInt("productname_idx"));
		            bankType.setBank_type(rs.getString("bank_type"));
		            bankName.setBank_name(rs.getString("bank_name"));
		            productType.setProduct_type(rs.getString("product_type"));
		            productName.setName(rs.getString("name"));
		            
		            if(rs.getInt("jlimit")==1) {
		            	productName.setJlimit("제한없음");
		            }else if(rs.getInt("jlimit")==2) {
		            	productName.setJlimit("서민전용");
		            }else {
		            	productName.setJlimit("일부제한");
		            }
		            
		            productName.setPeriod(rs.getInt("period"));
		            productName.setIrtype(rs.getString("irtype"));
		            productName.setDefault_ir(rs.getDouble("default_ir"));
		            productName.setMax_ir(rs.getDouble("max_ir"));
		            productName.setMax_amount(rs.getInt("max_amount"));
		            list.add(productName);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         dbManager.release(pstmt, rs);
		}
		return list;
	}
	
	/*//저축은행 상품 검색-정렬
		public List savingBankSelect(String ptype) {
			List<ProductName> list=new ArrayList<ProductName>();
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			con=dbManager.getConnection();
			StringBuffer sql=new StringBuffer();
			sql.append("select bt.banktype_idx, productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
			sql.append(" from banktype bt, bankname bn, producttype pt , productname pm");
			sql.append(" where bt.banktype_idx=bn.banktype_idx");
			sql.append(" and bn.bankname_idx =pt.bankname_idx");
			sql.append(" and pt.producttype_idx=pm.producttype_idx");
			sql.append(" and bank_type ='저축은행'");
			sql.append(" and product_type =?");
			sql.append(" order by productname_idx asc");

			try {
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ptype);
				
				rs=pstmt.executeQuery();
				
				   while(rs.next()) {
			            ProductName productName=new ProductName();
			            ProductType productType=new ProductType();
			            BankName bankName=new BankName();
			            BankType bankType=new BankType();
			            
			            bankName.setBankType(bankType);
			            productType.setBankName(bankName);
			            productName.setProductType(productType);
			            
			            bankType.setBanktype_idx(rs.getInt("banktype_idx"));
			            productName.setProductname_idx(rs.getInt("productname_idx"));
			            bankType.setBank_type(rs.getString("bank_type"));
			            bankName.setBank_name(rs.getString("bank_name"));
			            productType.setProduct_type(rs.getString("product_type"));
			            productName.setName(rs.getString("name"));
			            
			            if(rs.getInt("jlimit")==1) {
			            	productName.setJlimit("제한없음");
			            }else if(rs.getInt("jlimit")==2) {
			            	productName.setJlimit("서민전용");
			            }else {
			            	productName.setJlimit("일부제한");
			            }
			            
			            productName.setPeriod(rs.getInt("period"));
			            productName.setIrtype(rs.getString("irtype"));
			            productName.setDefault_ir(rs.getDouble("default_ir"));
			            productName.setMax_ir(rs.getDouble("max_ir"));
			            productName.setMax_amount(rs.getInt("max_amount"));
			            list.add(productName);
			         }
			      } catch (SQLException e) {
			         e.printStackTrace();
			      }finally {
			         dbManager.release(pstmt, rs);
			}
			return list;
		}*/	
	//클릭한 상품정보만 가져오기
	public ProductName select(int productname_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductName productName=null;
			
		con=dbManager.getConnection();
		StringBuffer sb=new StringBuffer();
		sb.append("select productname_idx, bank_type, bank_name, product_type, name, jlimit, period, irtype, default_ir, max_ir, max_amount");
		sb.append(" from banktype bt, bankname bn, producttype pt , productname pm");
		sb.append(" where bt.banktype_idx=bn.banktype_idx");
		sb.append(" and bn.bankname_idx =pt.bankname_idx");
		sb.append(" and pt.producttype_idx=pm.producttype_idx");
		sb.append(" and productname_idx=?");
		
		try {
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setInt(1, productname_idx);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				productName=new ProductName();
		        ProductType productType=new ProductType();
		        BankName bankName=new BankName();
		        BankType bankType=new BankType();
		            
		        bankName.setBankType(bankType);
		        productType.setBankName(bankName);
		        productName.setProductType(productType);
		            
		        productName.setProductname_idx(rs.getInt("productname_idx"));
		        bankType.setBank_type(rs.getString("bank_type"));
		        bankName.setBank_name(rs.getString("bank_name"));
		        productType.setProduct_type(rs.getString("product_type"));
		        productName.setName(rs.getString("name"));
	            if(rs.getInt("jlimit")==1) {
	            	productName.setJlimit("제한없음");
	            }else if(rs.getInt("jlimit")==2) {
	            	productName.setJlimit("서민전용");
	            }else {
	            	productName.setJlimit("일부제한");
	            }
		        productName.setPeriod(rs.getInt("period"));
		        productName.setIrtype(rs.getString("irtype"));
		        productName.setDefault_ir(rs.getDouble("default_ir"));
		        productName.setMax_ir(rs.getDouble("max_ir"));
		        productName.setMax_amount(rs.getInt("max_amount"));
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(pstmt);
		}
		return productName;
	}
}
