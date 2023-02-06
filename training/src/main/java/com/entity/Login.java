package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ログイン情報クラス
 */
@Entity
@Table(name = "login")
public class Login{
	
	//ID
	@Id
	@Column
	private int id;
	// メールアドレス
	@Column
	private String mail;
	// パスワード
	@Column
	private String pass;
	
	//setter,getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}