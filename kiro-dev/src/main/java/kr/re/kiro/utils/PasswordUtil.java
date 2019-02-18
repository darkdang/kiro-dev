package kr.re.kiro.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * kr.re.kiro.utils
 * PasswordUtil.java
 * </pre>
 *
 * * 패스워드 정규식 체크
 * [사용방법]
 * PasswordUtil.checkPw(String pw);
 * Return
 * 
 * 0: OK (규칙에 맞음)
 * 1: 입력된 패스워드 null 이거나 없음
 * 2: 입력된 패스워드가 16자 이상임
 * 3: 입력된 패스워드가 2조합인데  10자리 미만임
 * 4: 입력된 패스워드가 3조합인데 8자리 미만임
 * 5: 입력된 패스워드가 2조합 미만임
 * 99: 에러
 * 
 * 
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
public class PasswordUtil {

	public static String checkPw(String pw) {
		
		String strResult = "";
		if(pw == null || pw.equals("")) return "1";
		if(pw.length() > 16) return "2";
		
		try {
			Pattern pAlphabetLow = null;
			Pattern pAlphabetUp = null;
			Pattern pNumber = null;
			Pattern pSpecialChar = null;
			Matcher match;
			int nCharType = 0;
			
			pAlphabetLow = Pattern.compile("[a-z]");
			pAlphabetUp = Pattern.compile("[A-Z]");
			pNumber = Pattern.compile("[0-9]");
			pSpecialChar = Pattern.compile("\\p{Punct}");
			
			match = pAlphabetLow.matcher(pw);
			if(match.find()) nCharType++;
			
			match = pAlphabetUp.matcher(pw);
			if(match.find()) nCharType++;
			
			match = pNumber.matcher(pw);
			if(match.find()) nCharType++;
			
			match = pSpecialChar.matcher(pw);
			if(match.find()) nCharType++;
			
			// 3자리 이상 조합?
			if(nCharType >= 3) {
				if(pw.length() < 8) return "4";
				else strResult = "0";
// 이번엔 2가지 조합은 사용 안함
//			} else if(nCharType == 2) {
//				if(pw.length() < 10) return "3";
//				else strResult = "0";
			} else {
				return "5";
			}
		} catch (Exception e) {
			strResult = "99";
			e.printStackTrace();
		}
		return strResult;
	}
}
