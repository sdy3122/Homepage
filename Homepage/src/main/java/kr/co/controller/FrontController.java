package kr.co.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do") //*.do로 요청하게되면 어노테이션(애너테이션)에 의해 FrontController로 오게됨!!!
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
    	//객체의 생성및 관리를 담당하는 것 == 컨테이너
    	//서블릿 컨테이너==톰캣
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request,HttpServletResponse response) {
		String uri  = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		ActionForward forward = null;
		if(command.equals("/login.do")) {
			System.out.println("로그 : FrontController:로그인요청");
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.do")) {
			System.out.println("로그 : FrontController:로그아웃요청");
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/main.do")) {
			System.out.println("로그 : FrontController:메인페이지요청");
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/regist.do")) {
			System.out.println("로그 : FrontController:회원가입요청");
			try {
				forward = new RegistAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/boardupdate.do")) {
			System.out.println("로그 : FrontController:글변경요청");
			try {
				forward = new BoardUpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else if(command.equals("/board.do")) {
			System.out.println("로그 : FrontController:게시판요청");
			try {
				forward = new BoardAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		else if(command.equals("/insert.do")) {
			System.out.println("로그 : FrontController:글등록요청");
			try {
				forward = new InsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
//		else if(command.equals("/signup.do")) {//signup 회원가입
//			System.out.println("로그 : FrontController:회원가입요청");
//			try {
//				forward = new SignupAction().execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}//signup 회원가입
//		else if(command.equals("/mupdate.do")) {//mupdate 회원정보변경
//			System.out.println("로그 : FrontController:회원정보변경요청");
//			try {
//				forward = new MupdateAction().execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}//mupdate 회원정보변경
//		else if(command.equals("/mypage.do")) {
//			if (request.getSession(false).getAttribute("check") == null || !request.isRequestedSessionIdValid()) {
//				try {
//					forward = new LoginAction().execute(request, response);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			} else {
//				try {
//					System.out.println("로그 : 마이페이지로 이동");
//					forward = new MypageAction().execute(request, response);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		else if(command.equals("/mdelete.do")) {//mdelete 회원삭제=멤버탈퇴
//			System.out.println("로그 : FrontController:회원삭제요청");
//			try {
//				forward = new MdeleteAction().execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}//mdelete 회원삭제=멤버탈퇴
		else {
			System.out.println("잘못된요청!!!");
		}
		
		//RequestDispactcher 리퀘스트디스패쳐
		//:특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스
		//:사용자(브라우저,클라이언트)로부터 들어온 요청을 처리하고,
		//그 처리 결과를 올바른 페이지(==결과를 출력하는 페이지)로 보내는 역할을 수행하는 클래스
		try {                                                            //"main.jsp"
			RequestDispatcher dispatcher =  request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			//.forward(request,response)
			//:제어권을 넘겨서 클라이언트가 응답받을수 있도록하는 메서드
			//:요청의 처리결과로 생성되는 request,response객체를 타겟페이지(인자)로 전달하는 메서드
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
