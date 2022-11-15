package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {

	@Resource(name="deptService")
	private DeptService deptService;
	
	// 작성 페이지 요청
	@RequestMapping(value="/deptWrite.do")
	public String deptWrite() {
		
		return "dept/deptWrite";
	}
	
	// 저장 post요청
	@RequestMapping(value="/deptWriteSave.do")
	public String InsertDept(DeptVO vo) throws Exception {
		
		System.out.println(vo.getDeptno());
		System.out.println(vo.getDname());
		System.out.println(vo.getLoc());
		
		String result = deptService.InsertDept(vo);
		
		if(result == null) {
			System.out.println("저장 완료");
		} else {
			System.out.println("저장 실패");
		}
		
		return "redirect:/deptList.do";
	}
	
	// 리스트 형태의 부서 목록 페이지 요청
	@RequestMapping(value="/deptList.do") // Model: 자바의 데이터를 jsp 전달해주는 매개체
	public String selectDeptList(DeptVO vo,ModelMap model) throws Exception{
		
		List<?> list = deptService.SelectDeptList(vo); //<?> 어떠한 자료형 타입도 상관없다
		
		System.out.println(list);
		model.addAttribute("resultList",list); // (변수, 실데이터)
		return "dept/deptList";
	}
	
	// 상세 페이지 요청
	@RequestMapping(value="/deptDetail.do")
	public String selectDeptDetail(int deptno, ModelMap model) throws Exception{
		
		DeptVO vo = deptService.selectDeptDetail(deptno); // sql.xml에서 vo 반환타입이 DeptVO 였으므로 통일해줌
		System.out.println("부서번호: " + vo.getDeptno());
		
		model.addAttribute("deptVO",vo);
		return "dept/deptDetail";
	}
	
	// 삭제 post 요청
	@RequestMapping(value="/deptDelete.do")
	public String deleteDept(int deptno) throws Exception{
		
		int result = deptService.deleteDept(deptno);
		
		if(result == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		return "redirect:/deptList.do";
	}
	
	// 수정버튼을 눌렀을 때 수정페이지 요청
	@RequestMapping(value="/deptModifyWrite.do")
	public String selectDeptModify(int deptno, ModelMap model) throws Exception {
		
		DeptVO vo = deptService.selectDeptDetail(deptno); // 상세 페이지를 띄우기 위한 부서번호 키 값 서비스에서 가져오기
		model.addAttribute("vo", vo); // 뷰 페이지로 vo 전달
		
		return "dept/deptModifyWrite";
	}
	
	// 수정 post 요청
	@RequestMapping(value="/deptModifySave.do")
	public String updateDept(DeptVO vo) throws Exception {
		
		int result = deptService.updateDept(vo);
		
		if(result == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		return "redirect:/deptList.do";
	}
}
