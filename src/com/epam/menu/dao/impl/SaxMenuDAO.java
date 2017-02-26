package com.epam.menu.dao.impl;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.menu.bean.Food;
import com.epam.menu.dao.MenuDAO;
import com.epam.menu.dao.exception.DAOException;

public class SaxMenuDAO implements MenuDAO{
	
	public SaxMenuDAO(){}
	
	public List<Food> getMenu() throws DAOException{
		XMLReader reader;
		MenuSaxHandler handler = new MenuSaxHandler(); 
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("Menu.xml"));
			
			// включение проверки действительности
			reader.setFeature("http://xml.org/sax/features/validation", true);
			// включение обработки пространств имен
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
				 
			// включение канонизации строк
			reader.setFeature("http://xml.org/sax/features/string-interning",true);
			reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException();
		} 
		
		List<Food> menu = handler.getFoodList();
		return menu;
	}
}
