package kr.re.kiro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.repository.ResearchRepository;

@Service
@Transactional
public class ResearchService {

	@Autowired
	private ResearchRepository researchRepository;
	
	private Logger log = LoggerFactory.getLogger(ResearchService.class);
	
}
