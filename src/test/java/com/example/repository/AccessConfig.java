package com.example.repository;

import org.springframework.stereotype.Component;

import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;

/**
 * DBSetupを使用する際にDBと接続するために必要なクラス
 * 接続に必要なDestinationオブジェクトを作成
 * @author mikami
 *
 */

public class AccessConfig {
	
	/** 接続に必要なDestinationオブジェクトを作成 **/
	public static final Destination dest = new DriverManagerDestination(
			"jdbc:postgresql://localhost:5432/dynamic_form-test", 
			"postgres", 
			"postgres"
			);

}
