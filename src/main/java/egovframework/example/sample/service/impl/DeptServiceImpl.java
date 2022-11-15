package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("deptService") // extends: 재정의 하지 않아도 됨, implements: 부모 클래스 재정의 필요
public class DeptServiceImpl extends EgovAbstractServiceImpl 
                             implements DeptService {
	@Resource(name="deptDAO")
	private DeptDAO deptDAO;
	
	@Override
	public String InsertDept(DeptVO vo) throws Exception {
		// 프로그램 실행되어 컨트롤러에 있는 vo 저장데이터가 전달 되어 DAO로 전달 최종적으로 DAO에서 SQL에게 전달
		return deptDAO.InsertDept(vo);
	}

	@Override // 부모클래스인 DeptService의 메소드를 override하여 재정의
	public List<?> SelectDeptList(DeptVO vo) throws Exception {
		return deptDAO.SelectDeptList(vo); // Service에서 DAO로 연결 // 저장데이터는 아니지만 이후 검색같은 용도로 활용되는 데이터
	    // 자동완성을 통해 DeptDao에 selectdeptlist 메소드를 생성
	}

	@Override
	public DeptVO selectDeptDetail(int deptno) throws Exception {
		
		return deptDAO.selectDeptDetail(deptno);
	}

	@Override
	public int deleteDept(int deptno) throws Exception {
		
		return deptDAO.deleteDept(deptno);
	}

	@Override
	public int updateDept(DeptVO vo) throws Exception {
		
		return deptDAO.updateDept(vo);
	}
	
	
	
}
