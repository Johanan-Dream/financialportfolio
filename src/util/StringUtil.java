package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
	//넘겨받은 숫자가 1자리수이면, 앞에 0붙이기
	//누군가가 이 메서드를 호출하면, 처리결과를 반환받는다.
	public static String getNumString(int num) {//static으로 되어있기 때문에 new할 필요없음
		
		String str=null;
		if(num<10) {//한자리수
			str="0"+num;// 05
		}else {//두자리수
			str=Integer.toString(num);//wrapper 적용
		}
		return str;
	}
	
	//확장자 추출하여 반환받기
	public static String getExtend(String filename) {
		//String filename="a.aa.png";//split은 .이 여러개일때 사용할 수 없음
		
		//int lastIndex=filename.lastIndexOf(".");
		int lastIndex=filename.lastIndexOf(".");
		System.out.println(lastIndex);
		return filename.substring(lastIndex+1, filename.length());
	}
	

	
	//비밀번호 암호화
	//자바의 보안과 관련된 기능을 지원하는 api 모여있는 패키지가 java.security이다.
	public static String getConvertedPassword(String pass) {
		StringBuffer hexString=null;
		//암호화객체
		
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			byte[] hash=digest.digest(pass.getBytes("UTF-8"));//digest(암호화 대상), 잘게 쪼개기
			//String hexString="";//String 불변이다!!! 따라서 그 값이 변경될 수 없다.
			//String은 상수여서 한번 올라가면 변경이 안됨(final)
			//새로운 객체가 계속 생성됨 
			//따라서 String객체는 반복문 횟수가 클때는 절대 누적식을 사용해서는 안된다!
			//해결책 ) 변경가능한 문자열 객체를 지원하는 StringBuffer, StringBuilder등을 활용하자
			
			hexString=new StringBuffer();//String이 아님
			for(int i=0;i<hash.length;i++) {
				String hex=Integer.toHexString(0xff& hash[i]);
				
				//자리수 옮겨서 16진수로 만드는것 :0xff& hash[i]
				//->16진수를 다시 문자로 : Integer.toHexString(0xff& hash[i]);
				System.out.println(hex);
				//hex중 한자리 수가 존재함->앞에 0을 붙여서 두글자로 만들어주자
				if(hex.length()==1) {
					//hex="0"+hex;
					hexString.append("0");
				}
				//hexString+=hex;
				hexString.append(hex);//hexString에 hex를 추가하면 우리가 생각했던 누적된 값이 나옴
			}
			//System.out.println(hexString.toString());//확실하게 스트링화 시켜줌
			//System.out.println(hexString.length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}
	
	/*public static void main(String[] args) { 
		String result=getConvertedPassword("minzino");
		System.out.println(result.length());
	}*/
	 
}
