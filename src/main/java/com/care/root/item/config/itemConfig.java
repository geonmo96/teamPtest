package com.care.root.item.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	@RequestMapping("item")
public class itemConfig {
	@RequestMapping("itemview")
	public String itemView(String itemnum) {
		return "/item/itemview?itemnum="+itemnum;
}
	@RequestMapping("itemlist")
	public String ItemListView() {
		return "/item/list";
	}
}
