package kr.re.kiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.re.kiro.model.Announce;

/**
 * <pre>
 * kr.re.kiro.repository
 * AnnounceRepository.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Repository
public interface AnnounceRepository extends JpaRepository<Announce, Integer> {
	
	public Announce findByAnnounceNo(Integer AnnounceNo);

}
