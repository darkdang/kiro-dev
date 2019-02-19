package kr.re.kiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.re.kiro.model.QNA;

/**
 * <pre>
 * kr.re.kiro.repository
 * QNARepository.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
public interface QNARepository extends JpaRepository<QNA, Integer> {

}
