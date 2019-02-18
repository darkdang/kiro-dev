package kr.re.kiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.re.kiro.model.File;

/**
 * <pre>
 * kr.re.kiro.repository
 * FileRepository.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

	public List<File> findByAnnounceId(Integer announceId);
	
	public List<File> findByNoticeId(Integer noticeId);
	
	public List<File> findByResearchId(Integer researchId);

}