package com.heu.eam.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.heu.eam.dao.pojo.Person;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.PersonService;
import com.heu.eam.service.impl.PersonServiceImpl;
import com.heu.eam.utils.SessionUtil;
import com.heu.eam.utils.UploadUtils;

/**
 * Servlet implementation class PersonAction
 */
@WebServlet("/person")
public class PersonAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private PersonService personService = new PersonServiceImpl();

	public String addPerson(HttpServletRequest request,
			HttpServletResponse response) throws DaoException {

		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String realname = request.getParameter("realname");
		String nat = request.getParameter("nat");
		String borndate = request.getParameter("borndate");
		String hiredate = request.getParameter("hiredate");
		String deptid = request.getParameter("deptid");
		String cardid = request.getParameter("cardid");
		String address = request.getParameter("address");
		String natpl = request.getParameter("natpl");
		String mail = request.getParameter("mail");
		String pos = request.getParameter("pos");
		String state = request.getParameter("state");
	
		String createId = request.getParameter("createId");
		String createtime = request.getParameter("createtime");
		String updateId = request.getParameter("updateId");
		String updatetime = request.getParameter("updatetime");
		String version = request.getParameter("version");

		Person p = new Person();
		String createid = SessionUtil.getId(request, response);
		p.setUsername(username);
		p.setSex(sex);
		p.setTel(tel);
		p.setRealname(realname);
		p.setNat(natpl);
		p.setBorndate(borndate);
		p.setHiredate(hiredate);
		p.setDeptid(Integer.parseInt(deptid));
		p.setCardid(cardid);
		p.setAddress(address);
		p.setNatpl(natpl);
		p.setMail(mail);
		p.setPos(pos);
		p.setState("0");
		p.setDel("0");
		p.setNat(nat);
		p.setCreateId(Integer.parseInt(createid));

		personService.save(p);

		return "/InterFace/PersonFrame/addPerson.jsp";

	}

	public String deletePerson(HttpServletRequest request,
			HttpServletResponse response) {

		String id = request.getParameter("id");
		Person p = new Person();
		p.setId(Integer.parseInt(id));
		Integer[] sss = { Integer.parseInt(id) };
		int updateid =1;//(Integer) request.getSession().getAttribute("userid");
		try {
			personService.delete(sss, Person.class,updateid);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/InterFace/PersonFrame/selectPerson.jsp";
	}

	public String updatePerson(HttpServletRequest request,
			HttpServletResponse response) throws DaoException,
			ServiceBusinessException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String realname = request.getParameter("realname");
		String nat = request.getParameter("nat");
		String borndate = request.getParameter("borndate");
		String hiredate = request.getParameter("hiredate");
		String deptid = request.getParameter("deptid");
		String cardid = request.getParameter("cardid");
		String address = request.getParameter("address");
		String natpl = request.getParameter("natpl");
		String mail = request.getParameter("mail");
		String pos = request.getParameter("pos");
		String state = request.getParameter("state");
		String del = request.getParameter("del");
		String createId = request.getParameter("createId");
		String createtime = request.getParameter("createtime");
		String updateId = request.getParameter("updateId");
		String updatetime = request.getParameter("updatetime");
		String version = request.getParameter("version");
		request.setAttribute("version", version);
		String updateid = (String) request.getSession().getAttribute("userid");
		Map<String, String> map = new HashMap<String, String>();		
		String createid = SessionUtil.getId(request, response);
		request.setAttribute("createId", createid);
		if (sex.isEmpty() && pos.isEmpty() && mail.isEmpty()
				&& natpl.isEmpty() && address.isEmpty() && cardid.isEmpty()
				&& deptid.isEmpty() && hiredate.isEmpty() && nat.isEmpty()
				&& username.isEmpty() && tel.isEmpty() 
				&& realname.isEmpty() && borndate.isEmpty()) {
			map = null;
		} else {
			if (!sex.isEmpty()) {
				map.put("sex", sex);
			}
			if (!username.isEmpty()) {
				map.put("username", username);
			}
			if (!tel.isEmpty()) {
				map.put("tel", tel);
			}
		    if (!realname.isEmpty()) {
				map.put("realname", realname);
		    }
		    if (!borndate.isEmpty()) {
				map.put("borndate", borndate);
		    }
			if (!hiredate.isEmpty()) {
				map.put("hiredate", hiredate);
			}
			if (!deptid.isEmpty()) {
				map.put("deptid", deptid);
			}
			if (!cardid.isEmpty()) {
				map.put("cardid", cardid);
			}
			if (!address.isEmpty()) {
				map.put("address", address);
			}
			if (!nat.isEmpty()) {
				map.put("nat", nat);
			}
			if (!natpl.isEmpty()) {
			    map.put("natpl", natpl);
			}
		}
		

		personService.update(map, SessionUtil.getId(request, response), Person.class, version, id);		
		return "/InterFace/PersonFrame/selectPerson.jsp";
	}

	public String selectPerson(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException,
			DaoException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String realname = request.getParameter("realname");
		String nat = request.getParameter("nat");
		String borndate = request.getParameter("borndate");
		String hiredate = request.getParameter("hiredate");
		String deptid = request.getParameter("deptid");
		String cardid = request.getParameter("cardid");
		String address = request.getParameter("address");
		String natpl = request.getParameter("natpl");
		String mail = request.getParameter("mail");
		String pos = request.getParameter("pos");
		String state = request.getParameter("state");
		String del = request.getParameter("del");
		String createId = request.getParameter("createId");
		String createtime = request.getParameter("createtime");
		String updateId = request.getParameter("updateId");
		String updatetime = request.getParameter("updatetime");
		String version = request.getParameter("version");
	Map<String, String> map = new HashMap<String, String>();
	List<Map<String, Object>> result = null;
	if (sex.isEmpty() && pos.isEmpty() && deptid.isEmpty() 
			&& username.isEmpty() && realname.isEmpty()) {
		map = null;
	} else {
		if (!sex.isEmpty()) {
			map.put("sex", sex);
		}
		if (!username.isEmpty()) {
			map.put("username", username);
		}
	    if (!realname.isEmpty()) {
			map.put("realname", realname);
	    }
		if (!deptid.isEmpty()) {
			map.put("deptid", deptid);
		}
		if (!pos.isEmpty()) {
			map.put("deptid", deptid);
		}
	}
		result = personService.findBy(map, Person.class);
        request.setAttribute("person", result);
        System.out.println(result.size());
        return "/InterFace/PersonFrame/selectPerson.jsp";

	}
	public void jumpToUpdate (HttpServletRequest req,
			HttpServletResponse res)
			{
		  String id = req.getParameter("id");
		  Map<String, Object> person = null;
		try {
			person = personService.findById(Integer.parseInt(id),Person.class);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    
		  req.setAttribute("person", person);
		    req.setAttribute("isUpdate", "true");
		    try {
				req.getRequestDispatcher("/InterFace/PersonFrame/updatePerson.jsp").forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	



	private static final String UPLOAD_DIRECTORY = "upId";

	// 上传配置
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	
	
	public static final String APP_ID = "9890900";
	public static final String API_KEY = "M0pfEZOruEjA0AQUvPt0ZjB0";
	public static final String SECRET_KEY = "0lgELynRlRmSE1oHRm32w9kmKBNiwybx";
	 
	public String addform(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
       String checkPath=null;
		String savePath = this.getServletContext().getRealPath("\\upId\\");
		System.out.println(savePath);
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> parseRequest = upload.parseRequest(request);
			for (FileItem fi : parseRequest) {
				if (fi.isFormField()) {

				} else {
					String name = fi.getName();// 绝对路径
					String fileName = UploadUtils.getRealName(name);
					InputStream inputStream = fi.getInputStream();
					checkPath = savePath + "\\" + fileName;
					System.out.println(checkPath);
					FileOutputStream fileOutputStream = new FileOutputStream(
							new File(checkPath));
					IOUtils.copy(inputStream, fileOutputStream);
					fileOutputStream.close();
					inputStream.close();
					fi.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
		// 初始化一个OcrClient
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setConnectionTimeoutInMillis(60000);
		HashMap<String, String> prorertieMap = new HashMap<String, String>();
		// 调用身份证识别接口
		//String idFilePath = "checkPath";
		JSONObject idcardRes = client.idcard(checkPath, true, prorertieMap);
		System.out.println(checkPath);
		/*System.out.println(idcardRes.toString(2));*/
		JSONObject test = (JSONObject) (idcardRes.get("words_result"));
		String str = ((JSONObject) (test.get("姓名"))).getString("words");
		System.out.println(str);
		String str1 = ((JSONObject) (test.get("性别"))).getString("words");
		System.out.println(str1);
		String str2 = ((JSONObject) (test.get("民族"))).getString("words");
		System.out.println(str2);
		String str3 = ((JSONObject) (test.get("住址"))).getString("words");
		System.out.println(str3);
		String str4 = ((JSONObject) (test.get("公民身份号码"))).getString("words");
		System.out.println(str4);
		String str5 = ((JSONObject) (test.get("出生"))).getString("words");
		System.out.println(str5);

		request.setAttribute("realname", str);
		request.setAttribute("sex", str1);
		request.setAttribute("nat", str2);
		request.setAttribute("address", str3);
		request.setAttribute("cardid", str4);
		request.setAttribute("borndate", str5);
		
		
		 Map<String, String> idMap = new HashMap<String, String>();
		 idMap.put("realname", str);
		 idMap.put("sex", str1);
	     idMap.put("nat", str2);
		 idMap.put("address", str3);
		 idMap.put("cardid", str4);
		 idMap.put("borndate", str5);
		 request.setAttribute("Idtest", idMap);
		 return  "/InterFace/PersonFrame/addPerson.jsp";
		
	}

	// 检测是否为多媒体上传
	/*
	 * if (!ServletFileUpload.isMultipartContent(request)) { // 如果不是则停止
	 * PrintWriter writer; try { writer = response.getWriter();
	 * writer.println("Error: 表单必须包含 enctype=multipart/form-data");
	 * writer.flush(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * return; }
	 * 
	 * // 配置上传参数 DiskFileItemFactory factory = new DiskFileItemFactory(); //
	 * 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中 factory.setSizeThreshold(MEMORY_THRESHOLD);
	 * // 设置临时存储目录 factory.setRepository(new
	 * File(System.getProperty("java.io.tmpdir")));
	 * 
	 * ServletFileUpload upload = new ServletFileUpload(factory);
	 * 
	 * // 设置最大文件上传值 upload.setFileSizeMax(MAX_FILE_SIZE);
	 * 
	 * // 设置最大请求值 (包含文件和表单数据) upload.setSizeMax(MAX_REQUEST_SIZE);
	 * 
	 * // 中文处理 upload.setHeaderEncoding("UTF-8");
	 * 
	 * // 构造临时路径来存储上传的文件 // 这个路径相对当前应用的目录 String uploadPath =
	 * getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
	 * System.out.println("$"+uploadPath);
	 * 
	 * 
	 * // 如果目录不存在则创建 File uploadDir = new File(uploadPath); if
	 * (!uploadDir.exists()) { uploadDir.mkdir(); }
	 * 
	 * try { // 解析请求的内容提取文件数据 List<FileItem> formItems =
	 * upload.parseRequest(request);
	 * 
	 * if (formItems != null && formItems.size() > 0) { // 迭代表单数据 for (FileItem
	 * item : formItems) { // 处理不在表单中的字段 if (!item.isFormField()) { String
	 * fileName = item.getName(); System.out.println("++"+fileName); String
	 * filePath = uploadPath + File.separator + fileName; FileOutputStream
	 * fileOutputStream=new FileOutputStream(new File("outPath\\"+fileName));
	 * FileInputStream fileInputStream=new FileInputStream(new File(filePath));
	 * 
	 * //File storeFile = new File(filePath);
	 * 
	 * // 在控制台输出文件的上传路径 System.out.println("yoyoy="+filePath); // 保存文件到硬盘
	 * item.write(storeFile); /// PersonService ps = new PersonServiceImpl();
	 * Person p = ps.Idcheck(filePath); System.out.println(p);
	 * request.setAttribute("idinfor", p); ExcelService se = new
	 * ExcelServiceImpl(); InputStream fs = new FileInputStream(storeFile);
	 * System.out.println("-----"+SessionUtil.getId(request, response));
	 * se.importEmployeeByPoi(fs,SessionUtil.getId(request, response));
	 * request.setAttribute("message", "文件上传成功!"); } } } } catch (Exception ex)
	 * { request.setAttribute("message", "错误信息: " + ex.getMessage()); } // 跳转到
	 * message.jsp try { getServletContext().getRequestDispatcher(
	 * "/InterFace/PersonFrame/idmessage.jsp").forward( request, response); }
	 * catch (ServletException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } //return
	 * "/InterFace/PersonFrame/addPerson.jsp"; }
	 */

	/*protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是则停止
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return;
		}

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// 中文处理
		upload.setHeaderEncoding("UTF-8");

		// 构造临时路径来存储上传的文件
		// 这个路径相对当前应用的目录
		String uploadPath = getServletContext().getRealPath("./")
				+ File.separator + UPLOAD_DIRECTORY;

		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// 解析请求的内容提取文件数据
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator
								+ fileName;
						File storeFile = new File(filePath);

						// 在控制台输出文件的上传路径
						System.out.println(filePath);
						// 保存文件到硬盘
						item.write(storeFile);
						// /
						PersonService ps = new PersonServiceImpl();
						Person p = ps.Idcheck(filePath);
						System.out.println("act=" + p);
						request.setAttribute("idinfor", p);
						//
						request.setAttribute("message", "文件上传成功!");
					}
				}
			}
		} catch (Exception ex) {
			request.setAttribute("message", "错误信息: " + ex.getMessage());
		}
		// 跳转到 message.jsp
		getServletContext().getRequestDispatcher(
				"/InterFace/PersonFrame/idmessage.jsp").forward(request,
				response);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
*/
	/*public String upId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String savePath = this.getServletContext().getRealPath("\\upId\\");
		System.out.println(savePath);
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> parseRequest = upload.parseRequest(req);
			for (FileItem fi : parseRequest) {
				if (fi.isFormField()) {

				} else {
					String name = fi.getName();// 绝对路径
					String fileName = UploadUtils.getRealName(name);
					InputStream inputStream = fi.getInputStream();
					checkPath = savePath + "\\" + fileName;
					System.out.println(checkPath);
					FileOutputStream fileOutputStream = new FileOutputStream(
							new File(checkPath));
					IOUtils.copy(inputStream, fileOutputStream);
					fileOutputStream.close();
					inputStream.close();
					fi.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/InterFace/PersonFrame/addPerson.jsp";
	}*/
	
}
