package org.spring.controller;

import java.util.List;

import org.spring.domain.BoardVO;
import org.spring.service.BoardService;
import org.spring.service.BoardServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor 
@Log4j
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/list")
	public void listAll(Model model) {
		log.info("전체 회원 목록");
		model.addAttribute("boardList", boardService.listAll());
	}

	@GetMapping("/register")
	public void registerGet() {}
	
	@PostMapping("/register")
	public String regiter(BoardVO board, RedirectAttributes rttr) {
		log.info("board: "+board);
		Integer bno =  boardService.registerKey(board);
		
		rttr.addFlashAttribute("result", bno+"번째 글 등록 완료!");
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Integer bno, Model model) {
		model.addAttribute("vo", boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		int count = boardService.modify(board);
		if(count==1) {
			rttr.addFlashAttribute("result", board.getBno()+"번 글 수정 완료!!");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) {
		int count = boardService.remove(bno);
		if(count==1) {
			rttr.addFlashAttribute("result", bno+"번 글 삭제 완료!!");
		}
		return "redirect:/board/list";
	}

	
}
