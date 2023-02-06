package com.util;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.entity.Login;
import com.entity.Master;
import com.repository.LoginRepository;
import com.repository.MasterRepository;

//汎用メソッドを扱うクラス
public class Common {
	//空文字判定を行うメソッド
	public static boolean isEmpty(String str) {
		//メソッドの引数によって戻り値を変える
		return str.equals("");
	}
}

