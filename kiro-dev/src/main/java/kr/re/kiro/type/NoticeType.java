package kr.re.kiro.type;

/**
 * <pre>
 * kr.re.kiro.type
 * NoticeType.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
public enum NoticeType {

	NOTICE("공지"),
	COMPETITION("경진대회"),
	RELATED("유관기관"),
	EDUCATION("교육"),
	EVENT("행사"),
	DEADLINE("마감"),
	ETC("기타");
	
	private String notice;

	NoticeType(String notice) {
		this.notice = notice;
	}

	public String getNotice() {
		return notice;
	}
}
