package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.BoardDAO;
import kr.co.board.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		System.out.println(req.getParameter("bid"));
		System.out.println(req.getParameter("writer"));
		System.out.println(req.getParameter("content"));
		int bid = Integer.parseInt(req.getParameter("bid"));
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setBid(bid);
		vo.setWriter(writer);
		vo.setContent(content);
		if (dao.update(vo)) {
			forward = new ActionForward();
			forward.setPath("/board.do");
			forward.setRedirect(true);
		} else {
			throw new Exception("게시글 변경에서 에러발생!");
		}
		return forward;
	}

}