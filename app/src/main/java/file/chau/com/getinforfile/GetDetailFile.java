package file.chau.com.getinforfile;

import java.io.File;
import java.util.Date;

/**
 * Created by HoVanLy on 5/30/2016.
 */
public class GetDetailFile {
    private File file;
    private String file_path;
    private String fileName;
    private long size;
    private String fileType;
    private Date created;
    private Date modified;

    public GetDetailFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void configFile() {
        file_path =file.getPath();
        size = file.length() / 1024;
        created = new Date(file.lastModified());
        int index = file.getName().indexOf('.');
        fileName = file.getName().substring(0, index);
        fileType = file.getName().substring(index+1);

    }
}
