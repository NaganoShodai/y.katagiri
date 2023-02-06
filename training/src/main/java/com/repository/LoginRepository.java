package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Login;

/**
 * Loginテーブル用リポジトリ
 */
@Repository
public interface LoginRepository extends JpaRepository< Login, Integer>{
	
}