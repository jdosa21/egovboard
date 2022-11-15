package main.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.MemberService;
import main.service.MemberVO;

@Controller
public class MemberController {

	@Resource(name="memberService")
	public MemberService memberService;
	// 회원 등록 화면
	@RequestMapping("/memberWrite.do")
	public String memberWrite() throws Exception {
		
		return "member/memberWrite";
	}
	
	// 회원 정보 저장
	@RequestMapping("/memberWriteSave.do")
	@ResponseBody
	public String insertMember(MemberVO vo) throws Exception {
		
		String msg = ""; // jquery에 보낼 데이터
		String result = memberService.insertMember(vo);
		
		// 저장성공시
		if(result == null) {
			msg = "ok";
		}
		
		return msg; // jquery -> data변수에 전달
	}
	
	@RequestMapping("/idCheck.do")
	@ResponseBody
	public String selectMemberIdCheck(String userid) throws Exception {
		
		String msg = "";
		int count = memberService.selectIdCheck(userid);
		
		if(count == 0) { // 중복이 없다
			msg = "ok";
		}
		return msg;
	}
}
