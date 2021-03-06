package com.epam.menu.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream; 
import java.util.ArrayList; 
import java.util.List;

import javax.xml.stream.XMLInputFactory; 
import javax.xml.stream.XMLStreamConstants; 
import javax.xml.stream.XMLStreamException; 
import javax.xml.stream.XMLStreamReader;

import com.epam.menu.bean.Food;
import com.epam.menu.dao.MenuDAO;
import com.epam.menu.dao.exception.DAOException;



public class StaxMenuDAO implements MenuDAO {


	public StaxMenuDAO(){}
	
	public List<Food> getMenu() throws DAOException { 
		XMLInputFactory inputFactory = XMLInputFactory.newInstance(); 
		InputStream input;
		List<Food> menu = new ArrayList<Food>(); 
		try {
			input = new FileInputStream("Menu.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			Food food = new Food();
			MenuTagName elementName = null; 
			String tag = "";
			while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
				tag = reader.getLocalName().toUpperCase().replace("-", "_");
				elementName = MenuTagName.valueOf(tag);
				switch (elementName) {
				case FOOD:
					food = new Food(); 
					Integer id = Integer.parseInt(reader.getAttributeValue(null, "ID")); 
					food.setId(id);
					break;	
				default:
					break;
				}
				break;
				case XMLStreamConstants.CHARACTERS:
					String text = reader.getText().trim();
					if (text.isEmpty()) {
						break;
					}
				switch (elementName) {
					case NAME:
						food.setName(text);
						break; 
					case PRICE:
						food.setPrice(Integer.parseInt(text));
						break; 
					case DESCRIPTION:
						food.setDescription(text);
						break; 
					case PORTION:
						food.setPortion(text);
						break;
					default:
							break;
					}
				break;
				
				case XMLStreamConstants.END_ELEMENT:
					tag = reader.getLocalName().toUpperCase().replace("-", "_");
					elementName = MenuTagName.valueOf(tag);
					switch (elementName) {
						case FOOD:
							menu.add(food);
						default:
							break;
					
						}
				default:
					break;
			
					}
				}
		} catch (FileNotFoundException | XMLStreamException e) {
			throw new DAOException();
		}
		
	return menu;
	}
}
