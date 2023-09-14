package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 요청처리로직 (==메서드)은
//반드시 req,res를 가져야한다! ==강제성
//->추상메서드 => 인터페이스
public interface Action {
	public abstract ActionForward execute(HttpServletRequest req,HttpServletResponse res)throws Exception;
	//로직(==메서드)은 input,output이 중요!
	/*
	 * +++output+++
	 * 1.-어디로갈지(페이지정보)
	 * 2.-어떻게갈지(forward,sendRedirect)
	 * 어디로|어뗗게 == 객체화 ->ActionForward ex)VO,DTO
	 */
}
