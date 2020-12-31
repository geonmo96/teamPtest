package com.care.root.item.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.file.service.FileDTO;
import com.care.root.file.service.FileServiceImpl;

@Controller
	@RequestMapping("item")
public class itemConfig {
	@Autowired FileServiceImpl fsvi;
	@RequestMapping("itemview")
	public String itemView(@RequestParam String itemnum,Model model) {
		
		int itemn = Integer.parseInt(itemnum);
		FileDTO fdto =  fsvi.itemview(itemn);
		model.addAttribute("fdto",fdto);
		
		return "item/itemview";
}
	@RequestMapping("list")
	public String ItemListView(Model model ) {

		
		int allnum = fsvi.fileList();
		model.addAttribute("allnum",allnum);
		ArrayList<String> alllist = fsvi.fileallnum();
		model.addAttribute("alllist",alllist);
		return "item/list";
	}
	@RequestMapping("result")
	public String resultview() {
		return "item/itemview";
	}
	@RequestMapping("catelist")
	public String catelistView(Model model, @RequestParam String cate) {

		int allnum = fsvi.fileList();
		model.addAttribute("allnum",allnum);
		ArrayList<String> catealllist = fsvi.categorylist(cate);
		model.addAttribute("alllist",catealllist);
		return "item/list";
		
	}

}
