package com.epam.menu.view;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException; 

import com.epam.menu.bean.Food;
import com.epam.menu.service.MenuService;

public class View {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

	MenuService menuService = new MenuService();
	List<Food> menu = menuService.getMenu();
	
	for (Food food : menu) { 
		System.out.println(food.getName());
		for(String descr: food.getDescription()){
			System.out.println(descr);
		}
		System.out.println(food.getPortion());
		for(int price: food.getPrice()){
			System.out.println(price);
		}
		System.out.println("");
	}
}
}
