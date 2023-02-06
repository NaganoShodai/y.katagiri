package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *　test3.html用のコントローラー
 */
@Controller
public class Test3Controller {

	// 画面名
	private static final String PAGE_NAME = "test3";
	
	// アクセスURL定義(アクセスURL:http://localhost:8080/test3)
	@RequestMapping("/test3")
	public String disp(Model model) {
		
		// モデル設定
		model.addAttribute("test", "テスト3");
		// 画面遷移
		return PAGE_NAME;
}

	
	// POST:リクエストURLにパラメータが付与されない
	@PostMapping("/input_2")
	public String input1(HttpServletRequest req, Model model) {
		
		// 入力値
		String input1 = req.getParameter("input_2");
		// モデル設定
		req.setAttribute("disp_2", input1);
		// 画面遷移
		return PAGE_NAME;
	}

	// GET:リクエストURLにパラメータが付与される
	@GetMapping("/input_3")
	public String input2(HttpServletRequest req, Model model,
						// 入力値
						@RequestParam("input_3") String input2) {
		// モデル設定
		req.setAttribute("disp_3", input2);
		// 画面遷移
		return PAGE_NAME;
	}
}