package com.heu.eam.action;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class Photo
 */
// @WebServlet("/Photo")
public class FaceloginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String APP_ID = "9895384";
	public static final String API_KEY = "VyXNu3jQTV7sHAQDXAT0pdVm";
	public static final String SECRET_KEY = "9rz8A9ppKz9LKME1nWtIB3gdGnUbilsE";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FaceloginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void verifyUser(AipFace client) {
		String path = "test1.jpg";
		HashMap<String, Object> options = new HashMap<String, Object>(1);
		options.put("top_num", 5);
		JSONObject res = client.verifyUser("uid1",
				Arrays.asList("group1", "group2"), path, options);
		System.out.println(res.toString(2));
	}

	boolean f(String s) {
		try {
			Double ss = Double.valueOf(s);
			if (ss > 80)
				return true;
			else
				return false;

		} catch (Exception e) {
			return false;
		}

	}

	public String faceRecognize(AipFace client, String s1, String s2) {
		// 鍙傛暟涓烘湰鍦板浘鐗囪矾寰�
		String imagePath1 = s1;
		String imagePath2 = s2;
		ArrayList<String> pathArray = new ArrayList<String>();
		pathArray.add(imagePath1);
		pathArray.add(imagePath2);
		JSONObject response = client.match(pathArray,
				new HashMap<String, String>());
		System.out.println(response.toString());
		return response.toString();
	}

	public void faceRecognize(AipFace client, String s) {
		// 鍙傛暟涓烘湰鍦板浘鐗囪矾寰�
		String imagePath = s;
		HashMap<String, String> hashmap = new HashMap<String, String>();
		JSONObject response = client.detect(imagePath, hashmap);
		System.out.println(response.toString());

	}

	// base64瀛楃涓茶浆鍖栨垚鍥剧墖
	public static boolean GenerateImage(String imgStr, String imageName) { // 瀵瑰瓧鑺傛暟缁勫瓧绗︿覆杩涜Base64瑙ｇ爜骞剁敓鎴愬浘鐗�
		if (imgStr == null) // 鍥惧儚鏁版嵁涓虹┖
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64瑙ｇ爜
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 璋冩暣寮傚父鏁版嵁
					b[i] += 256;
				}
			}
			// 鐢熸垚jpeg鍥剧墖
			String imgFilePath = imageName;// 鏂扮敓鎴愮殑鍥剧墖
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String img11=request.getRealPath("InterFace");
		System.out.println(img11);
		
		String img2 = "C:/Users/new/Desktop/project/SRC/EAM/WebContent/InterFace/login/group1/";
		String path = "C:/Users/new/Desktop/project/SRC/EAM/WebContent/InterFace/login/group2/"
				+ System.currentTimeMillis() + ".jpg";
		String img1 = path;
		String ID = request.getParameter("ID");
		img2 += ID + ".jpg";
		request.getSession().setAttribute("userid", ID);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String url = request.getParameter("hid");
		if (GenerateImage(url, path)) {
			System.out.println("YES");
		} else
			System.out.println("NO");

		// 璁剧疆APPID/AK/SK

		// 鍒濆鍖栦竴涓狥aceClient
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

		// 鍙�锛氳缃綉缁滆繛鎺ュ弬鏁�
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		faceRecognize(client, img1);
		System.out.println("-------------------------------------");
		faceRecognize(client, img2);
		// 璋冪敤API
		System.out.println("--------------------------------");
		String message = faceRecognize(client, img1, img2);
		System.out.println(message.substring(48, 53));
		message = message.substring(48, 53);
		if (f(message)) {
			Double mes = Double.valueOf(message);
			System.out.println(mes + "YES!!!");
			out.print("<script>alert(\'OK\');</script>");
			response.setHeader("refresh", "2;URL=/EAM/menu");
		} else {
			System.out.println("error!!!!");
			out.print("<script>alert(\' NO\');</script>");
			response.setHeader("refresh", "2;URL=/EAM/menu");
		}

	}

}
