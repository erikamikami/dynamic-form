package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * usersテーブルを操作するリポジトリ
 * @author mikami
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** RowMapper **/
	public static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		
		return user;
	};
	
	/**
	 * userを1件登録します
	 * @param user
	 * @return 登録したuser（自動採番されたidも含む）
	 */
	public User insert(User user) {
		String sql = "INSERT INTO users (name, email) VALUES (:name, :email)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String[] keyColumnNames = {"id"};
		template.update(sql, param, keyHolder, keyColumnNames);
		user.setId(keyHolder.getKey().intValue());
		
		return user;
		
	}

}
