package com.epam.menu.dao;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.menu.bean.Food;

public class SaxMenuDAO {
	
	public SaxMenuDAO(){}
	
	public List<Food> getMenu() throws SAXException, IOException{
		XMLReader reader = XMLReaderFactory.createXMLReader(); 
		MenuSaxHandler handler = new MenuSaxHandler(); 
		reader.setContentHandler(handler);
		reader.parse(new InputSource("Menu.xml"));
		
		// включение проверки действительности
		reader.setFeature("http://xml.org/sax/features/validation", true);
		// включение обработки пространств имен
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
			 
		// включение канонизации строк
		reader.setFeature("http://xml.org/sax/features/string-interning",true);
		 
		
		// отключение обработки схем
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		List<Food> menu = handler.getFoodList();
		return menu;
	}
}
