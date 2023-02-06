package com.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Master;
import com.form.Test2Class;
import com.repository.MasterRepository;
import com.util.Common;
import com.util.Const;

import antlr.collections.List;

/*createmaster.htmlのコントローラー*/
@Controller
public class CreateMasterController {

	// Masterテーブル用リポジトリ
	@Autowired
	private MasterRepository masterRep;

	// 画面名
	private static final String PAGE_NAME = "createmaster";

	// 新規登録画面
	@GetMapping("/createmaster")
	public String disp(Model model) {
		// インスタンス
		Master mas = new Master();
		// モデル設定
		model.addAttribute("Master", mas);
		return PAGE_NAME;
	}
	@PostMapping("/input_master")
	// トランザクション
	@Transactional

	public String input(HttpServletRequest req, Model model,
			// クラスとして受け取る
			Master master, Common common) {
		ArrayList<String> errorList = new ArrayList<String>();
		// 技術名が空白の時に画面にエラーメッセージを出す処理
		if(Common.isEmpty(master.getName())) {
			errorList.add("技術名を入力してください");
		}
		// パスワードが空白の時に画面にエラーメッセージを出す処理
		if (Common.isEmpty(master.getOption_1())) {
			// エラーリストに追加
			errorList.add("オプションを入力してください");
		}

		// エラーリストが存在している時の制御
		if (0 < errorList.size()) {
			model.addAttribute(Const.ERROR_MSG, errorList);
			model.addAttribute("Master", master);
			return PAGE_NAME;
		} else {
			// saveメソッド
			masterRep.save(master);
		}

		// モデル
		model.addAttribute("Master", master);
		// 画面遷移
		return "redirect:list";
	}
}
