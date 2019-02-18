package kr.re.kiro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.re.kiro.type.ReplyType;
import kr.re.kiro.type.TrueType;

/**
 * <pre>
 * kr.re.kiro.model
 * QNA.java
 * QnA
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@Entity
@Table(name = "kiro_qna")
public class QNA {

	@Id
	@Column(name = "id", length = 11, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "qna_no", length = 8)
	private Integer boardNo;
	
	@Column(name = "qna_hits", length = 16)
	private Integer boardHits;
	
	@Column(name = "qna_re", length = 8, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TrueType trueType;
	
	@Column(name = "reply_type", length = 8, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private ReplyType replyType;

	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "login_id", length = 20, unique = true)
	private String loginId;
	
	@Column(name = "user_name", length = 20)
	private String userName;

	@Column(name = "subject", length = 256)
	private String subject;
	
	@Column(name = "contents", length = 15000)
	private String contents;

}
