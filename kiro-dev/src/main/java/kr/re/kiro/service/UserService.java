package kr.re.kiro.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.model.User;
import kr.re.kiro.repository.UserRepository;

/**
 * <pre>
 * kr.re.kiro.service
 * UserService.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private Logger log = LoggerFactory.getLogger(UserService.class);

	public User insert(User user) {
		log.debug("insert()..");
		return userRepository.save(user);
	}

	public User update(User user) {
		log.debug("update()..");
		return userRepository.save(user);
	}

	public User findById(String loginId) {
		log.debug("findByLoginId()..");
		return userRepository.findByLoginId(loginId);
	}

	public List<User> getUsers() {
		log.debug("getUsers()..");
		return userRepository.findAll();
	}

	public void delete(String loginId) {
		log.debug("delete()..");
		userRepository.deleteByLoginId(loginId);
	}
}
