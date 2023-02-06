package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.City;
import com.entity.Master;
import com.form.Test2Class;
import com.repository.CityRepository;
import com.repository.MasterRepository;

/**
 * list.html用のコントローラー
 */
@Controller
public class ListController {

	// Masterテーブル用リポジトリ
	@Autowired
	private MasterRepository masterRep;

	// 画面名
	private static final String PAGE_NAME = "list";

	// アクセスURL定義(アクセスURL:http://localhost:8080/list)
	@GetMapping("/list")
	public String disp(@Validated @ModelAttribute Master master, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "/list";
		}
		// ここでユーザー情報を登録する
		// 登録処理は省略
		return "/list";
	}

	/*
	 * List<Master> master = masterRep.findAll(); // モデル設定
	 * model.addAttribute("lists", master); // 画面遷移
	 * 
	 * return PAGE_NAME;
	 */
}
