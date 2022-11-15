package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;

@Controller
public class CodeController {
	
	@Resource(name="codeService")
	private CodeService codeService;
	
	@RequestMapping(value="/codeWrite.do")
	public String codeWrite() {
		
		return "code/codeWrite";
	}
	
	@RequestMapping(value="/codeWriteSave.do")
	public String insertCodes(CodeVO vo) throws Exception {
		
		//String result = null; 초기값은 null
		String result = codeService.insertCodes(vo);
		
		if(result == null) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		// UPDATE, DELETE --> 성공=1 실패=0
		
		return "redirect:/codeList.do";
	}
	
	@RequestMapping(value="/codeList.do")
	public String selectCodesList(CodeVO vo, ModelMap model) throws Exception {
		
		List<?> list = codeService.selectCodesList(vo);
		int total = codeService.selectCodesCount(vo);
		
		model.addAttribute("resultList", list);
		model.addAttribute("resultTotal", total);
		
		return "code/codeList";
	}
	
	@RequestMapping(value="/codeDelete.do")
	public String deleteCodes(int code) throws Exception {
		
		int result = codeService.deleteCodes(code);
		
		return "redirect:/codeList.do";
	}
	
	@RequestMapping(value="/codeModifyWrite.do")
	public String selectCodesDetail(int code, ModelMap model) throws Exception {
		
		CodeVO vo = codeService.selectCodesDetail(code);
		
		model.addAttribute("vo", vo);
		
		return "code/codeModifyWrite";
	}

	@RequestMapping(value="/codeModifySave.do")
	public String updateCodes(CodeVO vo) throws Exception {
		
		codeService.updateCodes(vo);
		
		return "redirect:/codeList.do";
	}
}
