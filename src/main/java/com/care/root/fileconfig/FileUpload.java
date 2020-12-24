package com.care.root.fileconfig;

import java.io.File;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.care.root.file.service.FileDAO;
import com.care.root.file.service.FileDTO;
import com.care.root.file.service.FileServiceImpl;


@Controller
@RequestMapping("seller")
public class FileUpload {
	private final String IMAGE_REPO = "C:\\Users\\heamok\\Desktop\\hm\\image";
	@RequestMapping("form")
	public String form() {
		return "/seller/seller";

	}
	@RequestMapping("upload")
	public ModelAndView upload(MultipartHttpServletRequest mul, 
								HttpServletResponse response ,  @RequestParam final String itemName ,@RequestParam final String makerName,
								@RequestParam final String brandName,@RequestParam final String makeRegion,@RequestParam final int kg,
								@RequestParam final String itemRegion,@RequestParam final String itemValue ) {

		
		try {
			mul.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		FileDTO fdto = new FileDTO();
		Enumeration enu = mul.getParameterNames();
		while(enu.hasMoreElements()) {
			
			FileServiceImpl fsvi = new FileServiceImpl();
			
//			String itemName2 = itemName;
//			String makerName2 = (String)enu.nextElement();
//			String brandName2 = (String)enu.nextElement();
//			String makeRegion2 = (String)enu.nextElement();
//			String kg2 =  (String)enu.nextElement();
//			String itemRegion2 =  (String)enu.nextElement();
//			String itemValue2 =  (String)enu.nextElement();
			System.out.println(itemName );
			System.out.println(makerName );
			System.out.println(brandName );
			System.out.println(makeRegion );
			System.out.println(kg);
			System.out.println(itemRegion );
			System.out.println(itemValue);
			
			fdto.setItemName(itemName);
			fdto.setMakerName(makerName);
			fdto.setBrandName(brandName);
			fdto.setMakeRegion(makeRegion);
			fdto.setKg(kg);
			fdto.setItemRegion(itemRegion);
			fdto.setItemValue(itemValue);
			
			
			
			fsvi.updata(fdto);
			
		}
		
		int itemnum = fdto.getItemNum();
		List fileList = fileProcess(mul);
		map.put("fileList", fileList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.setViewName("../item/itemview?itemnum="+itemnum);
		return mv;
	}
	private List<String> 
	fileProcess(MultipartHttpServletRequest mul){
			List<String> fileList = new ArrayList<String>();
				Iterator<String> fileNames = mul.getFileNames();
				while(fileNames.hasNext()) {
				String fileName = fileNames.next();
				MultipartFile mFile = mul.getFile(fileName);
				String originFile = mFile.getOriginalFilename();
				fileList.add(originFile);
				File file = new File(IMAGE_REPO+"\\"+fileName);
				file.getParentFile().mkdir();
				if(mFile.getSize() != 0) {
					try {
						
						mFile.transferTo(new File(IMAGE_REPO+"\\"+originFile));
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
				}
				return fileList;
	}
	
}
