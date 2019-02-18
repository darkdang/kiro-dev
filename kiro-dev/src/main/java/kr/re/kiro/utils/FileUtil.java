package kr.re.kiro.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static void moveFile(File srcFile, File destFile) throws IOException {
		moveFile(srcFile, destFile, true);
	}

    public static void moveFile(File srcFile, File destFile, boolean overwrite) throws IOException {

    	if(srcFile == null)
            throw new NullPointerException("Source must not be null");
        if(destFile == null)
            throw new NullPointerException("Destination must not be null");
        if(!srcFile.exists())
            throw new FileNotFoundException((new StringBuilder()).append("Source '").append(srcFile).append("' does not exist").toString());
        if(srcFile.isDirectory())
            throw new IOException((new StringBuilder()).append("Source '").append(srcFile).append("' is a directory").toString());
        if(!overwrite && destFile.exists())
            throw new FileExistsException((new StringBuilder()).append("Destination '").append(destFile).append("' already exists").toString());

        if(destFile.isDirectory())
            throw new IOException((new StringBuilder()).append("Destination '").append(destFile).append("' is a directory").toString());
        boolean rename = srcFile.renameTo(destFile);
        if(!rename) {
            FileUtils.copyFile(srcFile, destFile);
            if(!srcFile.delete()) {
                FileUtils.deleteQuietly(destFile);
                throw new IOException((new StringBuilder()).append("Failed to delete original file '").append(srcFile).append("' after copy to '").append(destFile).append("'").toString());
            }
        }
    }

	public static void copyFile(File srcFile, File destFile) throws IOException {
		copyFile(srcFile, destFile, true);
	}


    public static void copyFile(File srcFile, File destFile, boolean overwrite) throws IOException {

    	if(srcFile == null)
            throw new NullPointerException("Source must not be null");
        if(destFile == null)
            throw new NullPointerException("Destination must not be null");
        if(!srcFile.exists())
            throw new FileNotFoundException((new StringBuilder()).append("Source '").append(srcFile).append("' does not exist").toString());
        if(srcFile.isDirectory())
            throw new IOException((new StringBuilder()).append("Source '").append(srcFile).append("' is a directory").toString());
        if(!overwrite && destFile.exists())
            throw new FileExistsException((new StringBuilder()).append("Destination '").append(destFile).append("' already exists").toString());

        if(destFile.isDirectory())
            throw new IOException((new StringBuilder()).append("Destination '").append(destFile).append("' is a directory").toString());
        boolean rename = srcFile.renameTo(destFile);
        if(!rename) {
            FileUtils.copyFile(srcFile, destFile);
        }
    }

    public static void moveFileToDirectory(File srcFile, File destDir, boolean createDestDir)
        throws IOException {
        if(srcFile == null)
            throw new NullPointerException("Source must not be null");
        if(destDir == null)
            throw new NullPointerException("Destination directory must not be null");
        if(!destDir.exists() && createDestDir)
            destDir.mkdirs();
        if(!destDir.exists())
            throw new FileNotFoundException((new StringBuilder()).append("Destination directory '").append(destDir).append("' does not exist [createDestDir=").append(createDestDir).append("]").toString());
        if(!destDir.isDirectory()){
            throw new IOException((new StringBuilder()).append("Destination '").append(destDir).append("' is not a directory").toString());
        } else {
            moveFile(srcFile, new File(destDir, srcFile.getName()));
            return;
        }
    }
}