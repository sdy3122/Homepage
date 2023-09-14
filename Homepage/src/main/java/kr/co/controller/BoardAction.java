package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.BoardDAO;
import kr.co.board.BoardVO;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. 필터,리스너 아직 사용안함 ->인코딩 처리
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		// 2. output
		ActionForward forward = new ActionForward();
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(req.getParameter("bid")));
		vo = dao.selectOne(vo);
		if (vo == null) {
			System.out.println("로그 : BoardAction: 없는데이터를 출력하려함");
			forward.setPath("/main.do");
			forward.setRedirect(true);
		} else {
			req.setAttribute("dyoung", vo);
			forward.setPath("/board.jsp");
			forward.setRedirect(false);
		}
		return forward;
	}

}
