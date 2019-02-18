package kr.re.kiro.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.re.kiro.type.NoticeType;

/**
 * <pre>
 * kr.re.kiro.model
 * Notice.java
 * 공지사항
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Entity
@Table(name = "kiro_notice")
public class Notice {

	@Id
	@Column(name = "id", length = 11, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "notice_no", length = 8)
	private Integer noticeNo;
	
	@Column(name = "notice_hits", length = 16)
	private Integer noticeHits;
	
	@Column(name = "notice_type", length = 16, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private NoticeType noticeType;

	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "subject", length = 256)
	private String subject;
	
	@Column(name = "contents", length = 15000)
	private String contents;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "notice_id")
	public List<File> files = new ArrayList<File>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(Integer noticeNo) {
		this.noticeNo = noticeNo;
	}

	public Integer getNoticeHits() {
		return noticeHits;
	}

	public void setNoticeHits(Integer noticeHits) {
		this.noticeHits = noticeHits;
	}

	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void addFile(File file) {
		files.add(file);
	}

	public List<File> getFiles() {
		return files;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ""
				+ ", noticeNo=" + noticeNo + ""
				+ ", noticeHits=" + noticeHits + ""
				+ ", noticeType=" + noticeType + ", "
				+ "createdOn=" + createdOn + ""
				+ ", subject=" + subject + ""
				+ ", contents=" + contents + "]";
	}
	
	
}
