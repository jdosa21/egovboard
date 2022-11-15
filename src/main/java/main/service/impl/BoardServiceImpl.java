package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.service.BoardService;
import main.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	// 컨트롤러와의 연결 Resource
	@Resource(name="boardDAO")
	public BoardDAO boardDAO;
	
	// 글 저장 처리
	@Override
	public String insertBoard(BoardVO vo) throws Exception {
		
		return boardDAO.insertBoard(vo);
	}
	
	// 글 목록 리스트 처리
	@Override
	public List<?> selectBoardList(BoardVO vo) throws Exception {
		
		return boardDAO.selectBoardList(vo);
	}

	// 총 데이터 개수 출력
	@Override
	public int selectBoardTotal(BoardVO vo) throws Exception {
		
		return boardDAO.selectBoardTotal(vo);
	}

	// 상세 페이지 이동을 위한 key값 전달
	@Override
	public BoardVO selectBoardDetail(int unq) throws Exception {
		
		return boardDAO.selectBoardDetail(unq);
	}

	// 조회수
	@Override
	public int updateBoardHits(int unq) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.updateBoardHits(unq);
	}

	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		
		return boardDAO.updateBoard(vo);
	}

	@Override
	public int selectBoardPass(BoardVO vo) throws Exception {
		
		return boardDAO.selectBoardPass(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) throws Exception {
		
		return boardDAO.deleteBoard(vo);
	}

}
