package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

//DAO => SQL ID값 세팅
//ID값은 절대 중복되면 안된다. 고유하게 설정 보통 클래스이름과 메소드이름
@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO {

	// 데이터 저장
	public String InsertDept(DeptVO vo) {
		return (String) insert("deptDAO.InsertDept",vo);
	}

	// 리스트 출력
	public List<?> SelectDeptList(DeptVO vo) {
		// TODO Auto-generated method stub
		return list("deptDAO.SelectDeptList",vo); // (아이디값,vo)
	}

	
	// 상세 페이지
	public DeptVO selectDeptDetail(int deptno) {
	
		return (DeptVO) select("deptDAO.selectDeptDetail", deptno);
	}

	
	// 삭제 처리
	public int deleteDept(int deptno) {
		
		return (int) delete("deptDAO.deleteDept", deptno);
	}

	// 수정 처리
	public int updateDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return (int) update("deptDAO.updateDept", vo);
	}

}
