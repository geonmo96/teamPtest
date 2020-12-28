package com.care.root.item.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	@RequestMapping("item")
public class itemConfig {
	@RequestMapping("itemview")
	public String itemView() {
		return "item/itemview";
}
	@RequestMapping("itemlist")
	public String ItemListView() {
		return "item/list";
	}
}
