package com.care.root.fileconfig;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.care.root.file.service.FileDTO;
import com.care.root.file.service.FileServiceImpl;




@Controller
@RequestMapping("seller")
public class FileUpload {
	@Autowired FileServiceImpl fsvi;
	@Autowired FileDTO fdto;
	private final String IMAGE_REPO = "C:\\Users\\heamok\\Desktop\\hm\\workproject\\teamProject\\src\\main\\webapp\\resources\\images";
	@RequestMapping("form")
	public String form() {
		return "/seller/seller";

	}
	@RequestMapping("upload")
	public ModelAndView upload(HttpServletRequest req, MultipartHttpServletRequest mul, 
								HttpServletResponse response ) {
		
		
		try {
			mul.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		Enumeration enu = mul.getParameterNames();

			System.out.println(mul.getParameter("category"));
			System.out.println(mul.getParameter("itemName"));
			System.out.println(mul.getParameter("makerName"));
			System.out.println(mul.getParameter("brandName"));
			System.out.println(mul.getParameter("makeRegion"));
			System.out.println(mul.getParameter("kg"));
			System.out.println(mul.getParameter("itemRegion") );
			System.out.println(mul.getParameter("itemValue"));
			System.out.println(mul.getParameter("kgpic"));
			
			String kg2 = mul.getParameter("kg");
			int kg = Integer.parseInt(kg2);
			String category2 = mul.getParameter("categorynum");
			int categorynum = Integer.parseInt(category2);
			String itemprice2 = mul.getParameter("itemprice");
			int itemprice = Integer.parseInt(itemprice2);
			String kgpic2 = mul.getParameter("kgpic");
			int kgpic3 = Integer.parseInt(kgpic2);
			fdto.setItemName(mul.getParameter("itemName"));
			fdto.setMakerName(mul.getParameter("makerName"));
			fdto.setBrandName(mul.getParameter("brandName"));
			fdto.setMakeRegion(mul.getParameter("makeRegion"));
			fdto.setKg(kg);
			fdto.setItemRegion(mul.getParameter("itemRegion"));
			fdto.setItemValue(mul.getParameter("itemValue"));
			fdto.setKgpic(kgpic3);
			fdto.setCategorynum(categorynum);
			fdto.setItemprice(itemprice);
			
		fsvi.updata(fdto);
		
		String itemnum = fsvi.itemresult(mul.getParameter("itemName"));
		System.out.println(itemnum);
		fdto.setItemNum(Integer.parseInt(itemnum));
		List fileList = fileProcess(mul);
		System.out.println(itemnum);
		map.put("fileList", fileList);
		req.setAttribute("fdto", fdto);
		RequestDispatcher rd = req.getRequestDispatcher("/item/result");
        try {
			rd.forward(req, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		ModelAndView mv = new ModelAndView();
		mv.addObject("map",map);
		mv.setViewName("/item/list");
		
		
		return mv;

	}
	private List<String> 
	fileProcess(MultipartHttpServletRequest mul){
				String itemName = fdto.getItemName();
				List<String> fileList = new ArrayList<String>();
				Iterator<String> fileNames = mul.getFileNames();
			//	while(fileNames.hasNext()) {
				String fileName = fileNames.next();
				MultipartFile mFile = mul.getFile(fileName);
				String originFile = fsvi.itemresult(itemName);;
				fileList.add(originFile);
				File file = new File(IMAGE_REPO+"\\"+originFile);
				file.getParentFile().mkdir();
				if(mFile.getSize() != 0) {
					try {
						mFile.transferTo(new File(IMAGE_REPO+"\\"+originFile+".jpg"));
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			//	}
				return fileList;
	}
	
}
