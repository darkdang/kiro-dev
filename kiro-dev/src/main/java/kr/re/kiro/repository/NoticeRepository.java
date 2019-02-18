package kr.re.kiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.re.kiro.model.Notice;

/**
 * <pre>
 * kr.re.kiro.repository
 * NoticeRepository.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
