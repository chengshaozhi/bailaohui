package com.junyang.util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.junyang.constants.Constants;

public class FileUploadUtil {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-", "");
        return id;
	}
	
	public static Map<String, MultipartFile> getFilesByUniapp(HttpServletRequest request){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
	    commonsMultipartResolver.setDefaultEncoding("utf-8");
		if (commonsMultipartResolver.isMultipart(request)){
	        MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest) request;
	        Map<String, MultipartFile> map = mulReq.getFileMap();
	        return map;
	    }else {
			return null;
		}
	}
	
	public static Map<String, String> upload(MultipartFile file, String folder) {
		Map<String, String> map = new HashMap<String, String>();
		String url = "";
		String fileName = "";
		if (file != null) {
			if (!file.isEmpty()) {
				BufferedOutputStream stream = null;
				try {
					// 获取文件名
					fileName = file.getOriginalFilename();
					// 获取文件的后缀名
					String suffixName = fileName.substring(fileName.lastIndexOf("."));
					// 给新文件拼上时间毫秒，防止重名
					long nowfileName = System.currentTimeMillis();
					// 设置文件存储路径
					String filePath = Constants.FILETE_HEAD + folder + "/" ;
					File dir = new File(filePath);
					if (!dir.exists()) {
						dir.mkdirs();
					}
					String path = filePath + nowfileName + suffixName;
					File dest = new File(path);
					byte[] bytes = file.getBytes();
					// 文件写入
					stream = new BufferedOutputStream(new FileOutputStream(dest));
					stream.write(bytes);
					stream.close();
					// 封面图
					url = "shuangsuiji/" + folder + "/" + nowfileName + suffixName;
					map.put("code", "200");
					map.put("msg", "操作成功");
					map.put("url", url);
					map.put("path", path);
					map.put("fileName", fileName);
				} catch (Exception e) {
					stream = null;
					e.printStackTrace();
					map.put("code", "500");
					map.put("msg", fileName+"文件上传失败");
				}
			}
		}else {
			map.put("code", "500");
			map.put("msg", "文件不存在");
		}
		return map;
	}
	
	
	
	
}
