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
 * Research.java
 * 연구성과
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Entity
@Table(name="kiro_research")
public class Research {

	@Id
	@Column(name = "id", length = 11, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "research_no", length = 8)
	private Integer researchNo;
	
	@Column(name = "research_hits", length = 16)
	private Integer researchHits;
	
	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "subject", length = 256)
	private String subject;
	
	@Column(name = "contents", length = 15000)
	private String contents;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "research_id")
	public List<File> files = new ArrayList<File>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getResearchNo() {
		return researchNo;
	}

	public void setResearchNo(Integer researchNo) {
		this.researchNo = researchNo;
	}

	public Integer getResearchHits() {
		return researchHits;
	}

	public void setResearchHits(Integer researchHits) {
		this.researchHits = researchHits;
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
		return "Research [id=" + id + ""
				+ ", researchNo=" + researchNo + ""
				+ ", researchHits=" + researchHits + ""
				+ ", createdOn=" + createdOn + ""
				+ ", subject=" + subject + ""
				+ ", contents=" + contents + "]";
	}

}
