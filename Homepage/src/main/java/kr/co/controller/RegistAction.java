package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.member.MemberDAO;
import kr.co.member.MemberVO;

public class RegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		String mid = req.getParameter("registID");
		String mpw = req.getParameter("registPW");
		String irum = req.getParameter("irum");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMname(irum);
		if (dao.insert(vo)) {
			System.out.println("로그: 회원가입성공");
		} else {
			System.out.println("로그: 회원가입실패");
			HttpSession session = req.getSession();
			session.setAttribute("fail", true);
		}
		forward.setPath("/main.do");
		forward.setRedirect(true);
		return forward;
	}

}
