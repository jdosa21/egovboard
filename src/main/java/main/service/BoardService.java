package main.service;

import java.util.List;

public interface BoardService {

	// 글 저장 처리
	public String insertBoard(BoardVO vo) throws Exception;
	
	// 글 목록 리스트 출력 처리
	public List<?> selectBoardList(BoardVO vo) throws Exception;
	
	// Total 개수 출력
	public int selectBoardTotal(BoardVO vo) throws Exception;

	// 상세화면 이동
	public BoardVO selectBoardDetail(int unq) throws Exception;
	
	// 조회수
	public int updateBoardHits(int unq) throws Exception;

	// 수정 처리
	public int updateBoard(BoardVO vo) throws Exception;
	
	// 암호 확인
	public int selectBoardPass(BoardVO vo) throws Exception;
	
	// 삭제 처리
	public int deleteBoard(BoardVO vo) throws Exception;
}
