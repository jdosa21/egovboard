package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import egovframework.example.sample.service.CodeVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO; // DAO 상위 추상 클래스

@Repository("codeDAO")
public class CodeDAO extends EgovAbstractDAO {

	public String insertCodes(CodeVO vo) {
		return (String) insert("codeDAO.insertCodes", vo); // (ID값, 실데이터)
	}

	public List<?> selectCodesList(CodeVO vo) {
		// TODO Auto-generated method stub
		return list("codeDAO.selectCodesList", vo);
	}

	public int selectCodesCount(CodeVO vo) {
		// TODO Auto-generated method stub
		return (int) select("codeDAO.selectCodesCount", vo);
	}

	public int deleteCodes(int code) {
		// TODO Auto-generated method stub
		return (int) delete("codeDAO.deleteCodes", code);
	}

	public CodeVO selectCodesDetail(int code) {
		// TODO Auto-generated method stub
		return (CodeVO) select("codeDAO.selectCodesDetail", code);
	}

	public int updateCodes(CodeVO vo) {
		// TODO Auto-generated method stub
		return (int) update("codeDAO.updateCodes", vo);
	}

}
