package kr.re.kiro.service;

import java.awt.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.repository.QNARepository;

@Service
@Transactional
public class QNAService {
	
	@Autowired
	private QNARepository qnaRepository;
	
	private Logger log = LoggerFactory.getLogger(QNAService.class);

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
