package kr.co.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.BoardDAO;
import kr.co.board.BoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		forward.setPath("/index.jsp");
		forward.setRedirect(false);
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> datas = dao.selectAll();
		req.setAttribute("dyoung", datas);
		return forward;
	}
}