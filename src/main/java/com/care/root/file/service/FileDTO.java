package com.care.root.file.service;

import java.io.File;

import org.springframework.stereotype.Repository;

@Repository
public class FileDTO {

		private int itemNum;
		private String itemName;
		private String makerName;
		private String brandName;
		private String makeRegion;
		private int kg;
		private String itemRegion;
		private String itemValue;
		private int categorynum;
		private int itemprice;
		private int kgpic;
		
		public int getKgpic() {
			return kgpic;
		}
		public void setKgpic(int kgpic) {
			this.kgpic = kgpic;
		}
		public int getCategorynum() {
			return categorynum;
		}
		public void setCategorynum(int categorynum) {
			this.categorynum = categorynum;
		}
		public int getItemprice() {
			return itemprice;
		}
		public void setItemprice(int itemprice) {
			this.itemprice = itemprice;
		}
		public int getItemNum() {
			return itemNum;
		}
		public void setItemNum(int itemNum) {
			this.itemNum = itemNum;
		}
		
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getMakerName() {
			return makerName;
		}
		public void setMakerName(String makerName) {
			this.makerName = makerName;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		public String getMakeRegion() {
			return makeRegion;
		}
		public void setMakeRegion(String makeRegion) {
			this.makeRegion = makeRegion;
		}
		public int getKg() {
			return kg;
		}
		public void setKg(int kg) {
			this.kg = kg;
		}
		public String getItemRegion() {
			return itemRegion;
		}
		public void setItemRegion(String itemRegion) {
			this.itemRegion = itemRegion;
		}
		public String getItemValue() {
			return itemValue;
		}
		public void setItemValue(String itemValue) {
			this.itemValue = itemValue;
		}
}
