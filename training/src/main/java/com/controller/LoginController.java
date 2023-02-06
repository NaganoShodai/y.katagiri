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
import com.util.Common;
import com.util.Const;

/**
 * login.html用のコントローラー
 */
@Controller
public class LoginController {

	// Loginテーブル用リポジトリ
	@Autowired
	private LoginRepository loginRep;

	// 画面名
	private static final String PAGE_NAME = "login";

	// アクセスURL定義(アクセスURL:http://localhost:8080/login)
	@PostMapping("/login1")
	// トランザクション
	@Transactional

	public String login1(HttpServletRequest req, Model model, Login login, Common common) {
		
		// 入力値の必須チェック
		// エラーメッセージを格納するエラーリストの宣言
		ArrayList<String> errorList = new ArrayList<String>();
		// メールアドレスが空白の時に画面にエラーメッセージを出す処理
		if(Common.isEmpty(login.getMail())) {
			errorList.add("メールアドレスを入力してください");
		}
		// パスワードが空白の時に画面にエラーメッセージを出す処理
		if (Common.isEmpty(login.getPass())) {
			// エラーリストに追加
			errorList.add("パスワードを入力してください");
		}
		
		// エラーリストが存在している時の制御
		if (0 < errorList.size()) {
			model.addAttribute(Const.ERROR_MSG, errorList);
			model.addAttribute("Login", login);
			return PAGE_NAME;
		} else {
			// saveメソッドを呼び出す
			loginRep.save(login);
		}
		// モデル
		model.addAttribute("Login", login);
		//入力値が正しい場合、トップ画面へ遷移
		return "/logintop";
	}

	@GetMapping("/login")

	public String login(Model model, Login login) {
		model.addAttribute("Login", login);

		return PAGE_NAME;
	}
	
	@GetMapping("/logintop")

	public String logintop(Model model) {
		
		return PAGE_NAME;
	}
}
