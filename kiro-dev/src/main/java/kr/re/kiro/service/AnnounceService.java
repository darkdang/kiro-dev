package kr.re.kiro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.model.Announce;
import kr.re.kiro.repository.AnnounceRepository;
import kr.re.kiro.repository.QNARepository;

@Service
@Transactional
public class AnnounceService {

	@Autowired
	private AnnounceRepository announceRepository;
	
	private Logger log = LoggerFactory.getLogger(AnnounceService.class);
	
	public void delete(Integer id) {
		log.debug("delete()");
		announceRepository.deleteById(id);
	}

	public Announce findById(Integer id) {
		log.debug("findById()");
		return announceRepository.getOne(id);
	}
	
	public Announce findByAnnounceNo(Integer announceNo) {
		log.debug("findByAnnounceNo()");
		return announceRepository.findByAnnounceNo(announceNo);
	}
	
	public Object listAll() {
		log.debug("listAll()..");
		return null;
	}
	
	public void regist(Object object) {
		log.debug("regist()..");
	}
	
	public Object read(int id) {
		log.debug("read()..");
		return null;
	}
	
	public void modify(Object object) {
		log.debug("modify()..");
	}

}
