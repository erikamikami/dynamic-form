package com.example.repository;

import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.User;
import com.example.repository.operation.UserOperation;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	private static DbSetup dbSetup;

	/**
	 * 実行前に1度、削除と登録を行う
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Operation operation = sequenceOf(UserOperation.USER_DELETE, UserOperation.USER_INSERT);
		dbSetup = new DbSetup(AccessConfig.dest, operation);
		dbSetup.launch();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("ユーザーを1件登録できているか")
	void insertTest() {
		// 期待値（登録するユーザー）
		User expected = new User();
		expected.setName("秋田太郎");
		expected.setEmail("test4@test.com");
		
		// 実行
		User actual = userRepository.insert(expected);
		
		// 比較
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getEmail(), actual.getEmail());
	}

}
