package kr.co.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.common.JDBCUtil;

public class BoardDAO {
	public Connection conn;
	public PreparedStatement pstmt;
	
	static final String insert = "insert into board(writer,content) values(?,?)";
	static final String update = "update board set writer=?,content=? where bid=?";
	static final String delete = "delete from board where bid=?";
	static final String selectOne = "select bid,writer,content,regdate from board where bid=?";
	static final String selectAll = "select bid,writer,content,regdate from board";
	
	public boolean insert(BoardVO vo) {
		conn = JDBCUtil.connect();
		
		try {
			pstmt  = conn.prepareStatement(insert);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	public boolean update(BoardVO vo) {
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	public BoardVO selectOne(BoardVO vo) {
		BoardVO data = null;
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(selectOne);
			pstmt.setInt(1, vo.getBid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setRegdate(rs.getString("regdate"));
				data.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return data;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;	
	}
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setBid(rs.getInt("bid"));
				data.setContent(rs.getString("content"));
				data.setRegdate(rs.getString("regdate"));
				data.setWriter(rs.getString("writer"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return datas;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
	
	public boolean delete(BoardVO vo) {
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
		
	}
}
