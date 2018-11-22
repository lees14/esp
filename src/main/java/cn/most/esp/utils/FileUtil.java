package cn.most.esp.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	/**
	 * 上传文件
	 * 
	 * @param file
	 *            要上传的文件
	 * @param fileName
	 *            要上传的文件名(如果为""或null,保存名为file文件名)
	 * @param path
	 *            文件保存位置
	 * @return
	 */
	public static boolean Upload(MultipartFile file, String fileName, String path) {
		try {
			String realFileName = file.getOriginalFilename();
			// 创建文件夹
			File dirPath = new File(path);
			/*if(!dirPath.getParentFile().exists()) { //判断父文件夹是否存在
				dirPath.getParentFile().mkdir();
			}*/
			if (!dirPath.exists()) {
				/** mkdir  创建单层文件夹
				 *  mkdirs 创建多层文件夹
				 */ 
				if(!dirPath.mkdirs()) {
					System.err.println("创建文件夹失败！");
					return false;
				}
			}
			File uploadFile = null;
			if (fileName.equals("") || fileName == null) {
				uploadFile = new File(path + realFileName);
			} else {
				if (fileName.split("\\.").length > 1) {
					uploadFile = new File(path + fileName);
				} else {
					uploadFile = new File(path + fileName + "." + realFileName.split("\\.")[1]);
				}
			}
			FileCopyUtils.copy(file.getBytes(), uploadFile);
			if (uploadFile.exists()) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param filePath
	 *            要上传的文件
	 * @param fileName
	 *            要上传的文件名(如果为""或null,保存名为file文件名)
	 * @param path
	 *            文件保存位置
	 * @return
	 */
	public static boolean Upload(String filePath, String fileName, String path) {
		try {
			File file = new File(filePath);
			String realFileName = file.getName();
			// 创建文件
			File dirPath = new File(path);
			if (!dirPath.exists()) {
				dirPath.mkdirs();
			}
			File uploadFile = null;
			if (fileName.equals("") || fileName == null) {
				uploadFile = new File(path + realFileName);
			} else {
				uploadFile = new File(path + fileName);
			}
			FileCopyUtils.copy(file, uploadFile);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * 读取文件夹下所有文件
	 * 
	 * @param fath
	 *            文件夹路径
	 * @return
	 */
	public static List<String> loadFiles(String fath) {
		List<String> files = new ArrayList<String>();
		File file = new File(fath);
		if (file.exists()) {
			File[] fs = file.listFiles();
			String fname = null;
			for (File f : fs) {
				fname = f.getName();
				if (f.isFile()) {
					files.add(fname);
				}
			}
		}
		return files;
	}

	/**
	 * 下载指定文件
	 * 
	 * @param downfath
	 *            文件全称
	 * @param fileName
	 *            文件名称
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	public static void downLoad(String downfath, String fileName, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			try {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
			} catch (Exception e) {
				e.printStackTrace();
			}// firefox浏览器}
		} else {
			try {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}// IE浏览器
		}

		try {
			long fileLength = new File(downfath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downfath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}

	}
}

