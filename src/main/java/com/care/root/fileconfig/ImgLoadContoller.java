package com.care.root.fileconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImgLoadContoller {
	private final String IMAGE_REPO = "C:\\Users\\heamok\\Desktop\\hm\\workproject\\teamProject\\src\\main\\resources\\img";
	@RequestMapping("imgload")
	public void download(@RequestParam("imageFileName")String imageFileName, HttpServletResponse response) throws IOException {
		OutputStream out = response.getOutputStream();
		String downFile = IMAGE_REPO + "\\"+ imageFileName+".jpg";
		File file = new File(downFile);
		response.addHeader("Content-disposition", "attachment; fileName="+imageFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*1024*10];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer,0,count);
		}
		in.close();out.close();
	}
}