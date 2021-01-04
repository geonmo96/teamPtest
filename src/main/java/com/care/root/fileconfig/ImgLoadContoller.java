package com.care.root.fileconfig;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.file.service.FileDTO;

@Controller
public class ImgLoadContoller {
	@Autowired FileDTO fdto;
	@RequestMapping("img")
	public void getImage(HttpServletRequest req, HttpSession session, HttpServletResponse res, @RequestParam HashMap<String, String> map) throws Exception {
		int filenum = fdto.getItemNum();
		String filenum2 = Integer.toString(filenum);
		String realFile = "C:\\Users\\heamok\\Desktop\\hm\\workproject\\teamProject\\src\\main\\webapp\\resources\\images";
		
		
		String fileNm = filenum2;
		String ext = ".jpg";

		BufferedOutputStream out = null;
		InputStream in = null;

		try {
			res.setContentType("image/" + ext);
			res.setHeader("Content-Disposition", "inline;filename=" + fileNm);
			File file = new File(realFile);
			if(file.exists()){
				in = new FileInputStream(file);
				out = new BufferedOutputStream(res.getOutputStream());
				int len;
				byte[] buf = new byte[1024];
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			}
		} catch (Exception e) {
			
		} finally {
			if(out != null){ out.flush(); }
			if(out != null){ out.close(); }
			if(in != null){ in.close(); }
		}
	}
}
