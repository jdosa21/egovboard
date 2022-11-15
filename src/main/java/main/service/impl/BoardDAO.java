package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import main.service.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO {

	// SQL INSERT 작업처리
	public String insertBoard(BoardVO vo) {
		
		return (String) insert("boardDAO.insertBoard", vo);
	}

	// SQL SELECT LIST 처리
	public List<?> selectBoardList(BoardVO vo) {
		
		return list("boardDAO.selectBoardList", vo);
	}

	public int selectBoardTotal(BoardVO vo) {
		
		return (int) select("boardDAO.selectBoardTotal", vo);
	}

	public BoardVO selectBoardDetail(int unq) {
		
		return (BoardVO) select("boardDAO.selectBoardDetail", unq);
	}

	public int updateBoardHits(int unq) {
		
		return (int) update("boardDAO.updateBoardHits", unq);
	}

	public int updateBoard(BoardVO vo) {
		
		return (int) update("boardDAO.updateBoard", vo);
	}

	public int selectBoardPass(BoardVO vo) {
		
		return (int) select("boardDAO.selectBoardPass", vo);
	}

	public int deleteBoard(BoardVO vo) {
		
		return (int) delete("boardDAO.deleteBoard", vo);
	}

	
}
