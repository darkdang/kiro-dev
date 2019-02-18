package kr.re.kiro.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <pre>
 * kr.re.kiro.model
 * Announce.java
 * 입창공고
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Entity
@Table(name="kiro_announce")
public class Announce {

	@Id
	@Column(name = "id", length = 11, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "announce_no", length = 8)
	private Integer announceNo;
	
	@Column(name = "announce_hits", length = 16)
	private Integer announceHits;
	
	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "deadline", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	
	@Column(name = "subject", length = 256)
	private String subject;
	
	@Column(name = "contents", length = 15000)
	private String contents;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "announce_id")
	public List<File> files = new ArrayList<File>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnnounceNo() {
		return announceNo;
	}

	public void setAnnounceNo(Integer announceNo) {
		this.announceNo = announceNo;
	}

	public Integer getAnnounceHits() {
		return announceHits;
	}

	public void setAnnounceHits(Integer announceHits) {
		this.announceHits = announceHits;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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
		return "Announce [id=" + id + ""
				+ ", announceNo=" + announceNo + ""
				+ ", announceHits=" + announceHits + ""
				+ ", createdOn=" + createdOn + ""
				+ ", deadline=" + deadline + ""
				+ ", subject=" + subject + ""
				+ ", contents=" + contents + "]";
	}
	
	
}
