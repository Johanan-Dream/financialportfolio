package javaproject.portfolio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



import javaproject.portfolio.DTO.Pmember;
import javaproject.portfolio.domain.PortfolioMain;
import javaproject.portfolio.util.DBManager;
import util.StringUtil;

public class PmemberDAO {
	DBManager dbManager=DBManager.getInstance();
	PortfolioMain portfolioMain;
	
	public PmemberDAO(PortfolioMain portfolioMain) {
		this.portfolioMain=portfolioMain;
	}
	
	//회원등록
	public int regist(Pmember pmember) {
		int result=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		con=dbManager.getConnection();
		
		String sql="insert into pmember(pmember_idx, id, pass, name, phone, email)";
		sql+=" values(seq_pmember.nextval, ?, ?, ?, ?, ?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, pmember.getId());
			pstmt.setString(2, StringUtil.getConvertedPassword(pmember.getPass()));
			pstmt.setString(3, pmember.getName());
			pstmt.setInt(4, pmember.getPhone());
			pstmt.setString(5, pmember.getEmail());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(pstmt);
		}
		return result;
	}
	
	//로그인 확인 
	public List loginCheck(Pmember pmember) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dbManager.getConnection();
		String sql="select * from pmember where id=? and pass=?";
		ArrayList list=new ArrayList();
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, pmember.getId());
			pstmt.setString(2, StringUtil.getConvertedPassword(pmember.getPass()));
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(rs);
				portfolioMain.loginFlag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(pstmt, rs);
		}
		return list;
	}
}
