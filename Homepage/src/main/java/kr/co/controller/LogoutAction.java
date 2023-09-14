package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = req.getSession(false);
		session.invalidate();
		forward.setPath("/main.do");
		forward.setRedirect(true);
		return forward;
	}

}
