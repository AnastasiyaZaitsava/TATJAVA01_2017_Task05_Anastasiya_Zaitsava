package com.epam.menu.bean;

import java.util.ArrayList;

public class Food {
		private int id;
		private String name; 
		private ArrayList<String> description;
		private String portion;
		private ArrayList<Integer> price;  
		
		public Food(){
			description = new ArrayList<String>();
			price = new ArrayList<Integer>();
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<Integer> getPrice() {
			return price;
		}
		
		public int getPrice(int index) {
			return price.get(index);
		}

		public void setPrice(int price) {
			this.price.add(price);
		}

		public void setPrice(ArrayList<Integer> price) {
			this.price = price;
		}
		
		public ArrayList<String> getDescription() {
			return description;
		}
		
		public String getDescription(int index) {
			return description.get(index);
		}

		public void setDescription(String description) {
			this.description.add(description);
		}

		public void setDescription(ArrayList<String> description) {
			this.description = description;
		}
		
		public String getPortion() {
			return portion;
		}

		public void setPortion(String portion) {
			this.portion = portion;
		}

}
