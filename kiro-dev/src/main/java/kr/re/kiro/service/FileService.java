package kr.re.kiro.service;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.re.kiro.config.Properties;
import kr.re.kiro.repository.FileRepository;
import kr.re.kiro.utils.SimpleFileSaveStrategy;

@Service
@Transactional
public class FileService {

	@Autowired
	private FileRepository fileRepository;

	private Logger log = LoggerFactory.getLogger(FileService.class);

	public List<kr.re.kiro.model.File> findByNoticeId(Integer noticeId) {
		log.debug("findByNoticeId()..");
		return fileRepository.findByNoticeId(noticeId);
	}
	
	public List<kr.re.kiro.model.File> findByAnnounceId(Integer announceId) {
		log.debug("findByAnnounceId()..");
		return fileRepository.findByAnnounceId(announceId);
	}
	
	public List<kr.re.kiro.model.File> findByResearchId(Integer researchId) {
		log.debug("findByResearchId()..");
		return fileRepository.findByResearchId(researchId);
	}

	public kr.re.kiro.model.File insert(kr.re.kiro.model.File file) {
		log.debug("insert()..");
		return fileRepository.save(file);
	}

	public void update(kr.re.kiro.model.File file) {
		log.debug("update()..");
		fileRepository.save(file);
	}

	public List<kr.re.kiro.model.File> delete(Integer noticeId) {
		log.debug("delete()..");
		List<kr.re.kiro.model.File> files = fileRepository.findByNoticeId(noticeId);
//		fileRepository.deleteByNoticeId(noticeId);
		return files;
	}

	public File getBaseDirectory() {
		return new File(Properties.FILE_ROOTDIR);
	}

	public int getFileCountPerDirectory() {
		int count =  SimpleFileSaveStrategy.DEFAULT_MAX_FILES_PROPERTY; //default
		return count;
	}

	public File createFile(String fileName) throws IOException {
		return createFile((String) null, fileName);
	}

	private File createFile(String parentDir, String fileName) throws IOException {
		if (fileName == null) {
			fileName = UUID.randomUUID().toString();
		}
		File parent;
		if (parentDir != null) {
			parent = new File(getBaseDirectory(), parentDir);
		} else {
			parent = getBaseDirectory();
		}
		return createFile(parent, fileName);
	}

	private File createFile(File parent, String fileName) throws IOException {
		SimpleFileSaveStrategy simpleFileSaveStrategy = new SimpleFileSaveStrategy(parent, getFileCountPerDirectory());
		File newFile = simpleFileSaveStrategy.createNewFile(fileName);
		if(newFile.exists()) {
			FileUtils.forceDelete(newFile);
		}
		return newFile;
	}
}
