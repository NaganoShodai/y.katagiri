package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Login;
import com.repository.LoginRepository;

/**
 * logintop.html用のコントローラー
 */
@Controller
public class LoginTopController {

	// Masterテーブル用リポジトリ
	@Autowired
	private LoginRepository loginRep;

	// 画面名
	private static final String PAGE_NAME = "logintop";

	// アクセスURL定義(アクセスURL:http://localhost:8080/logintop)
	@PostMapping("/logintop")

	public String disp(HttpServletRequest req, Model model, Login login) {
		
		//メールの入力を受け取る 
		model.addAttribute("mail", login.getMail());
		//パスワードの入力を受け取る
		model.addAttribute("pass", login.getPass());
		return PAGE_NAME;
	}
}
