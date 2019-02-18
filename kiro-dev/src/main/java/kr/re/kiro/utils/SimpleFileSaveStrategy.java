package kr.re.kiro.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFileSaveStrategy implements FileSaveStrategy {

	private Logger logger = LoggerFactory.getLogger(SimpleFileSaveStrategy.class);

	public static final int DEFAULT_MAX_FILES_PROPERTY = 100;

	private File rootDirectory;
	private int maxFiles = DEFAULT_MAX_FILES_PROPERTY;
	private volatile boolean exactlyMatched;
	private Lock lock = new ReentrantLock();

	public SimpleFileSaveStrategy(String rootDir, int maxFiles) {
		this.maxFiles = maxFiles;
		this.rootDirectory = new File(rootDir);
	}

	public SimpleFileSaveStrategy(File rootDir, int maxFiles) {
		this.maxFiles = maxFiles;
		this.rootDirectory = rootDir;
	}

	public void setMaxFiles(int maxFiles) {
		this.maxFiles = maxFiles;
	}

	public void setExactlyMatched(boolean exactlyMatched) {
		this.exactlyMatched = exactlyMatched;
	}

	public void setRootDirectory(File rootDirectory) throws IOException {
		FileUtils.forceMkdir(rootDirectory);
		this.rootDirectory = rootDirectory;
	}

	public File getRootDirectory() {
		return rootDirectory;
	}

	public File createNewFile() throws IOException {
		logger.trace("enter createNewFile()");
		return createNewFile(UUID.randomUUID().toString());
	}

	public File createNewFile(String name) throws IOException {
		logger.trace("enter createNewFile(String)");
		Date today = new Date(System.currentTimeMillis());
		String date = new SimpleDateFormat("yyyy/MM/dd").format(today);

		if (exactlyMatched) {
			lock.lock();
		}
		try {
			File baseDirectory = new File(rootDirectory, date.substring(0, 7));
			if (!baseDirectory.exists())
				baseDirectory.mkdirs();
			final String day = date.substring(8);

			File[] baseFiles = baseDirectory.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.startsWith(day);
				}
			});
			int index = (baseFiles.length - 2);
			File targetDirectory = new File(baseDirectory, day + ((index > -1) ? ("-" + index) : ""));
			if (!targetDirectory.exists())
				targetDirectory.mkdirs();

			if (targetDirectory.list().length >= maxFiles) {
				targetDirectory = new File(baseDirectory, day + "-" + (index + 1));
				if (!targetDirectory.exists())
					targetDirectory.mkdirs();
			}

			File newFile = new File(targetDirectory, name);
			return newFile;
		} finally {
			if (exactlyMatched) {
				lock.unlock();
			}
		}
	}
}
