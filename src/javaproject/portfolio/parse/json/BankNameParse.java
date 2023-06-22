package javaproject.portfolio.parse.json;
/* Java 1.8 샘플 코드 */

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;

public class BankNameParse {
	public String getData() throws IOException {

		String serviceKey = "VK1Qr19S0F0QtmqBemocasas7lzEKkcmC%2FmnMeT4POjGi752YJOgyBn7ILgdzJwBb2De6Tf8WTgr7Xk8VBcG9g%3D%3D";

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/6430000/goodRestaService1/getGoodResta1"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey + ""); /* Service Key */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		
		return sb.toString();
}
	public static void main(String[] args) throws IOException {
		BankNameParse fb=new BankNameParse();
		String data=fb.getData();
		//json문자열을 대상으로 파싱해서 원하는 결과 가공하기
		
		JSONParser jsonParser=new JSONParser();
		try {
			JSONObject json=(JSONObject)jsonParser.parse(data);
			JSONArray array=(JSONArray)json.get("body");
			System.out.println("검색된 맛집의 수는"+array.size());
			
			for(int i=0;i<array.size();i++) {
				JSONObject  obj=(JSONObject)array.get(i);
				String name=(String)obj.get("BSSH_NM");
				System.out.println(name);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}