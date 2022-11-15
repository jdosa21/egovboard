package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.BoardService;
import main.service.BoardVO;

@Controller
public class BoardController {
	// impl 파일과 controller 파일의 resour는 동일해야한다.
	@Resource(name="boardService") 
	private BoardService boardService;
	
	@RequestMapping("/boardWrite.do")
	public String boardWrite() throws Exception {
		
		return "board/boardWrite";
	}
	
	@RequestMapping("/boardWriteSave.do")
	@ResponseBody
	public String insertBoard(BoardVO vo) throws Exception {
		
		// 정상: result = null
		String result = boardService.insertBoard(vo);
		String msg = "";
		
		if(result == null) {
			msg = "ok";
		} else {
			msg = "fail";
		}
		return msg; // ajax에 data 값 전달
	}
	
	@RequestMapping("/boardList.do")
	public String selectBoardList(BoardVO vo, ModelMap model) throws Exception {
		
		int unit = 5; // 페이징 갯수 처리 현재는 10
		int total = boardService.selectBoardTotal(vo); // 총 데이터 수
		int totalPage = (int)Math.ceil((double)total/unit); // 페이징 처리
		int viewPage = vo.getViewPage();
		
		// 사용자가 viewPage 초과범위를 입력했을 경우 예외처리
		if(viewPage > totalPage || viewPage < 1) {
			viewPage = 1; // 처음으로 초기화
		}
		
		// 1-> 1~10 // 2-> 11~20 // 3 -> 21~30
		// (1-1)*10 + 1 -> 1
		// (2-1)*10 + 1 -> 11
		// (3-1)*10 + 1 -> 21
		int startIndex = (viewPage-1) * unit + 1;
		int endIndex = startIndex + (unit - 1);
		
		// 행 번호
		// total -> 34
		// 1페이지 -> 34번 - 25번 // 2페이지 -> 24번 - 15번 // 3페이지 -> 14번 - 5번 // 4페이지 -> 4번 - 1번
		int startRowNo = total - (viewPage-1)*unit;
		
		
		// vo에 페이징 데이터 태우기 이 데이터는 SQL로 전송된다.
		vo.setStartIndex(startIndex);
		vo.setEndIndex(endIndex);
		
		List<?> list = boardService.selectBoardList(vo);
		
		// jsp에 데이터 전달
		model.addAttribute("resultList", list);
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("rowNumber", startRowNo);
		
		System.out.println("list :" + list); // 콘솔 출력
		
		return "board/boardList";
	}
	
	@RequestMapping("/boardDetail")
	public String selectBoardDetail(BoardVO vo, ModelMap model) throws Exception {
		
		BoardVO boardVO = boardService.selectBoardDetail(vo.getUnq());
		
		// 줄바꿈 대체
		String content = boardVO.getContent(); // \n
		boardVO.setContent(content.replace("\n", "<br>") );
		
		// 조회수
		boardService.updateBoardHits(vo.getUnq());
		
		model.addAttribute("boardVO", boardVO);
		
		return "board/boardDetail";
	}
	
	@RequestMapping("/boardModifyWrite.do")
	public String selectBoardModifyWrite(BoardVO vo, ModelMap model) throws Exception {
		
		BoardVO boardVO = boardService.selectBoardDetail(vo.getUnq());
		
		model.addAttribute("boardVO", boardVO);
		
		return "board/boardModifyWrite";
	}
	
	@RequestMapping("/boardModifySave.do")
	@ResponseBody
	public String updateBoard(BoardVO vo) throws Exception {
		
		int result = 0;
		
		int count = boardService.selectBoardPass(vo); // 패스워드 일치 결과
		
		if(count == 1) { // 패스워드 일치 
			result = boardService.updateBoard(vo); // result = 1
		} else { // 불일치
			result = -1;
		}
		
		return result + ""; // 결과값 타입이 int지만 함수 반환값 string에 맞춰주기 위헤 +""
	}
	
	// 삭제할 때 암호 작성 페이지
	@RequestMapping("/passWrite.do")
	public String passWrite(int unq, ModelMap model) {
		
		model.addAttribute("unq", unq);
		
		return "board/passWrite";
	}
	
	@RequestMapping("/boardDelete.do")
	@ResponseBody
	public String deleteBoard(BoardVO vo) throws Exception {
		
		int result = 0;
		int count = boardService.selectBoardPass(vo);
		
		// 암호일치 => 삭제성공: result=1, 삭제실패: result=0
		if(count == 1) {
			result = boardService.deleteBoard(vo); // result = 1
		} else if (count == 0) {
			result = -1;// 암호 불일치
		} 
		
		return result+"";
	}
	
}
