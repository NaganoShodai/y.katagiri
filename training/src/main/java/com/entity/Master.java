package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


@Entity
@Table(name = "master")
//データベースへ登録するデータを格納しておくためのクラス
public class Master {
	//ID
	@Id
	@Column
	private int id;
	//技術名
	@Column
	@Size(max=50, message="技術名は50文字以内で入力してください")
	private String name;
	//オプション
	@Column
	@Size(max=50, message="オプションは50文字以内で入力してください")
	private String option_1;
	
	//setter,getter
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getOption_1() {
		return option_1;
	}
	public Master() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	
	
}
