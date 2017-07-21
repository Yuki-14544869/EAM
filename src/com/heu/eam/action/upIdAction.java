package com.heu.eam.action;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class upIdAction {public static final String APP_ID = "9890900";
public static final String API_KEY = "M0pfEZOruEjA0AQUvPt0ZjB0";
public static final String SECRET_KEY = "0lgELynRlRmSE1oHRm32w9kmKBNiwybx";

public static void main(String[] args) {
	// 初始化一个OcrClient
	AipOcr client = new AipOcr();

	// 可选：设置网络连接参数
	client.setConnectionTimeoutInMillis(2000);
	client.setConnectionTimeoutInMillis(60000);
     HashMap<String, String> prorertieMap=new HashMap<String, String>();
	// 调用身份证识别接口
	String idFilePath = "d:/a.jpg";
	JSONObject idcardRes = client.idcard(idFilePath, true,prorertieMap);
	System.out.println(idcardRes.toString(2));
	JSONObject test = (JSONObject)(idcardRes.get("words_result"));
	String str = ((JSONObject)(test.get("姓名"))).getString("words");
	System.out.println(str);
	String str1 = ((JSONObject)(test.get("性别"))).getString("words");
	System.out.println(str1);
	String str2 = ((JSONObject)(test.get("民族"))).getString("words");
	System.out.println(str2);
	String str3 = ((JSONObject)(test.get("住址"))).getString("words");
	System.out.println(str3);
	String str4 = ((JSONObject)(test.get("公民身份号码"))).getString("words");
	System.out.println(str4);
	String str5 = ((JSONObject)(test.get("出生"))).getString("words");
	System.out.println(str5);

	Map<String, String> idMap = new HashMap<String, String>();
	idMap.put("name", str);
	idMap.put("sex", str1);
	idMap.put("nat", str2);
	idMap.put("add", str3);
	idMap.put("ID", str4);
	idMap.put("borndate", str5);
	request.setAttribute("Idtest", idMap);
}

}
