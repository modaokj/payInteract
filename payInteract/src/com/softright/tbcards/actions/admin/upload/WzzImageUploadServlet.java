package com.softright.tbcards.actions.admin.upload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.annotations.Expose;
import com.handwin.db.DataService;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import com.softright.tbcards.Constants;
import com.softright.tbcards.PassportNew;

public class WzzImageUploadServlet extends HttpServlet {
	Logger log = Logger.getLogger(WzzImageUploadServlet.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PassportNew ppt=PassportNew.fromString(request.getParameter(Constants.PASSPORT_COOKIE_NAME));
		UploadImgResult result = new UploadImgResult();
		result.setCode(200);
		if(ppt==null){
			result.setState("error");
			response.getOutputStream().print(result.getJson());
			result.setInfo("没有权限操作啊");
			return;
		}
		
		DataService dao = null;
		try{
//			HashMap<String, Object> updata = Parser(request);
//			dao = new DataService(String.valueOf(ppt.getPartitionId()));
//			TaobaoUser s = (TaobaoUser) dao.locate(TaobaoUser.class, ppt.getId());
//			//
//			PictureCategoryGetResponse pictureCategoryGetResponse=BoFactory.getTaobaoApiBo().getPicCategory(s.getSessionKey());
//			Long picture_category_id=null;
//			if (pictureCategoryGetResponse != null && pictureCategoryGetResponse.getErrorCode() == null) {
//    			List<PictureCategory> picList=pictureCategoryGetResponse.getPictureCategories();
//    			if(picList!=null&&picList.size()>0){
//    				PictureCategory pictureCategory=picList.get(0);
//	        		picture_category_id=pictureCategory.getPictureCategoryId();
//    			}else{
//    				PictureCategoryAddResponse creatgrob=BoFactory.getTaobaoApiBo().addPicCategory(s.getSessionKey());
//    				if (creatgrob != null && creatgrob.getErrorCode() == null) {
//    		    		PictureCategory pictureCategory=creatgrob.getPictureCategory();
//    		    		picture_category_id=pictureCategory.getPictureCategoryId();
//    		    	}else{
//    		    		log.error("taobaoId:"+ppt.getId()+" 创建图片空间分类失败  "+pictureCategoryGetResponse.getErrorCode()+pictureCategoryGetResponse.getMsg()+pictureCategoryGetResponse.getParams());
//    					result.setState("error");
//    					result.setCode(-2);
//    					result.setInfo("创建图片空间分类失败");
//    		    	}
//        		}
//    		}else{
//    			log.error("taobaoId:"+ppt.getId()+"查询图片空间分类失败"+pictureCategoryGetResponse.getErrorCode()+pictureCategoryGetResponse.getMsg()+pictureCategoryGetResponse.getParams());
//    			result.setState("error");
//    			result.setCode(-1);
//    			result.setInfo("查询图片空间分类失败");
//    		}
//			 if(picture_category_id!=null){
//		        //上传图片到分类下
//		        PictureUploadResponse upimgret= BoFactory.getTaobaoApiBo().uploadPicture(s.getSessionKey(), (byte[])updata.get("filebyte"), (String)updata.get("oldfilename"), picture_category_id);
//		        if (upimgret != null && upimgret.getErrorCode() == null) {
//		        	Picture picture=upimgret.getPicture();
//		        	if(picture!=null){
//		        		result.setUrl(picture.getPicturePath());
//		    			result.setState("SUCCESS");
//		        	}else {
//		        		log.error("taobaoId:"+ppt.getId()+"图片上传没有返回结果"+upimgret.getErrorCode()+upimgret.getMsg()+upimgret.getSubMsg()+upimgret.getParams());
//		        		result.setState("error");
//		    			result.setCode(-5);
//		    			result.setInfo("图片上传没有返回结果");
//					}
//		        }else{
//		        	log.error("taobaoId:"+ppt.getId()+"图片上传失败"+upimgret.getErrorCode()+upimgret.getMsg()+upimgret.getSubMsg()+upimgret.getParams());
//		        	result.setState("error");
//	    			result.setCode(-4);
//	    			result.setInfo("图片上传失败");
//	        	}
//			}else{
//				log.error("taobaoId:"+ppt.getId()+"图片上传失败,因为没有拿到分组ID");
//    			result.setState("error");
//    			result.setCode(-3);
//    			result.setInfo("图片上传失败,因为没有拿到分组ID");
//			}
//			response.setContentType("text/xml;UTF-8");
//			OutputStream out = response.getOutputStream();
//			out.write(result.getJson().getBytes("UTF-8"));  
//			log.info("上传文件成功");
		}catch(Exception e){
			e.printStackTrace();
			if(dao!=null){
				dao.rollBack();
			}
			result.setState("error");
			response.getOutputStream().print(result.getJson());
			log.error("上传文件错误：",e);
		}finally{
			if(dao!=null){
				dao.close();
			}
		}
		
	}
	public static final HashMap<String, Object> Parser(HttpServletRequest req)
			throws IOException {
		HashMap <String , Object> pars = new HashMap<String, Object>();
		MultipartParser parser = new MultipartParser(req, 2 * 1024 * 1024, false,false, "UTF-8");

		Part _part = null;

		while ((_part = parser.readNextPart()) != null) {
			if (_part.isFile()) {
				FilePart fpart = (FilePart) _part;

				String fileName = fpart.getFileName();
				if (fileName != null) {
					pars.put("oldfilename", fileName);
					pars.put("filebyte", input2byte(fpart.getInputStream()));
				}
			}
		}
		return pars;
	}

	public static final byte[] input2byte(InputStream inStream)
			throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}
	
	public class UploadImgResult {
		@Expose
		private String state;
		@Expose
		private int error;
		@Expose
		private int code;//-1 查询分组失败 -2 创建分组失败 -3 无法获取分组号进行上传 -4 上传图片失败 -5 图片上传没有返回结果
		@Expose
		private String info;
		@Expose
		private String url;
		
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getError() {
			return error;
		}
		public void setError(int error) {
			this.error = error;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getJson() {
			return "{'state':'" + state + "', 'error':'" + error + "', 'info':'" + info
					+ "', 'code':'" + code + "', 'url':'" + url + "'}";
		}
		
	}
}
