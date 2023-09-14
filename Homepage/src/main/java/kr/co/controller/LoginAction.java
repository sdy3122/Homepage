package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.member.MemberDAO;
import kr.co.member.MemberVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		String mid = req.getParameter("memberId");
		String mpw = req.getParameter("memberPw");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo = dao.selectOne(vo);
		if (vo == null) {
			System.out.println("로그: 로그인실패");
		} else {
			HttpSession session = req.getSession(false);
			session.invalidate();
			session = req.getSession();
			session.setAttribute("data", vo);
			session.setAttribute("check", true);
		}
		forward.setPath("/main.do");
		forward.setRedirect(true);
		return forward;
	}

}
