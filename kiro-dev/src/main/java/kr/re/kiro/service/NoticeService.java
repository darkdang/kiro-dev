package kr.re.kiro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.repository.NoticeRepository;
import kr.re.kiro.repository.QNARepository;

@Service
@Transactional
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	private Logger log = LoggerFactory.getLogger(NoticeService.class);
	
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

	public void delete(int id) {
		log.debug("delete()..");
	}
}
