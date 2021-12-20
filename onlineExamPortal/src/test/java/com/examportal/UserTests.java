package com.examportal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.examportal.entities.UserEntity;
import com.examportal.repositories.UserDAO;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserDAO userDao;

	@Test
	void testCreateUser() {
		UserEntity user = new UserEntity();
		user.setUserEmailId("sahu@.com");
		user.setUserName("purur");
		user.setUserPsw("shotam");
		UserEntity savedUser = userDao.save(user);

		UserEntity existUser = entityManager.find(UserEntity.class, savedUser.getUserEmailId());

		assertThat(user.getUserEmailId()).isEqualTo(existUser.getUserEmailId());

	}
}
