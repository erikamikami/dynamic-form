package com.example.repository.operation;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import org.springframework.stereotype.Component;

import com.ninja_squad.dbsetup.operation.Operation;

/**
 * Userテーブルのオペレーション
 * 
 * @author mikami
 *
 */

public class UserOperation {
	
	/** レコード3件登録 **/
	public static final Operation USER_INSERT = insertInto("users")
			.columns("name", "email")
			.values("佐藤太郎", "test1@test.com")
			.values("高橋花子", "test2@test.com")
			.values("山田一郎", "test3@test.com")
			.build();
	
	/** 全レコード 削除 **/
	public static final Operation USER_DELETE = deleteAllFrom("users");

}
