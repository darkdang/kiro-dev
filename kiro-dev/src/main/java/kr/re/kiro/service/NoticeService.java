package kr.re.kiro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.repository.NoticeRepository;

@Service
@Transactional
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	private Logger log = LoggerFactory.getLogger(NoticeService.class);
	
}
