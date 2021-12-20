package com.examportal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.examportal.entities.UserEntity;
import com.examportal.repositories.UserDAO;

@SpringBootTest
class OnlineExamPortalApplicationTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserDAO userDao;
	@Test
	void contextLoads() {
		UserEntity user = new UserEntity();
		user.setUserEmailId("tom@.com");
		user.setUserName("TomJerry");
		user.setUserPsw("motupatlu");
		UserEntity savedUser = userDao.save(user);

		UserEntity existUser = entityManager.find(UserEntity.class, savedUser.getUserEmailId());

		assertThat(user.getUserEmailId()).isEqualTo(existUser.getUserEmailId());

	}

}
