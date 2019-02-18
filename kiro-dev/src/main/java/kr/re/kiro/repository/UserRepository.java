package kr.re.kiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.re.kiro.model.User;

/**
 * <pre>
 * kr.re.kiro.repository
 * UserRepository.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

	@Query
	public User findByLoginId(String loginId);
	
	@Query
	public void deleteByLoginId(String loginId);
}
