package egovframework.example.sample.service;

import java.util.List;

public interface DeptService {
	
	// 데이터 저장
	public String InsertDept(DeptVO vo) throws Exception;
	
	// 데이터 리스트 가져오기
	public List<?> SelectDeptList(DeptVO vo) throws Exception;
	
	// 상세 페이지 값 가져오기
	// DeptVO: 리턴타입, selectDeptDetail: 메소드 ,(int deptno): sql로 전달시킬 요소
	// 리턴타입이 위 2개와 다르게 DeptVO
	// 부서번호를 매개변수로 설정
	public DeptVO selectDeptDetail(int deptno) throws Exception; 
	
	// 리턴 타입을 int로 하는 이유는 sql에서 삭제처리의 결과로 받기 때문에 int로
	public int deleteDept(int deptno) throws Exception;
	
	// 개수가 넘어오기 때문에 리턴타입은 int
	public int updateDept(DeptVO vo) throws Exception;
}
