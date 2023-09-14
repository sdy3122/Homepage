package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.BoardDAO;
import kr.co.board.BoardVO;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setWriter(req.getParameter("writer"));
		vo.setContent(req.getParameter("content"));
		if (dao.insert(vo)) {
			System.out.println("로그: 게시글등록성공");
		} else {
			forward.setPath("/main.do");
			forward.setRedirect(true);
			throw new Exception("로그: 게시글등록실패");
		}
		forward.setPath("/main.do");
		forward.setRedirect(true);
		return forward;
	}

}
