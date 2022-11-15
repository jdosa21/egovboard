package main.service;

public interface MemberService {

	// 저장 처리
	public String insertMember(MemberVO vo) throws Exception;

	// 아아디 중복 체크
	public int selectIdCheck(String userid) throws Exception;
}
