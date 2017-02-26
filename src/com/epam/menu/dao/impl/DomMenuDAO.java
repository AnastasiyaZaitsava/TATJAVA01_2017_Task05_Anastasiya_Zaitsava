package com.epam.menu.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.NodeList; 
import org.xml.sax.SAXException;

import com.epam.menu.bean.Food;
import com.epam.menu.dao.MenuDAO;
import com.epam.menu.dao.exception.DAOException; 


public class DomMenuDAO implements MenuDAO{
	
	public DomMenuDAO(){}
	
	public List<Food> getMenu() throws DAOException {


		DOMParser parser = new DOMParser(); 
		try {
			parser.parse("Menu.xml");
		} catch (SAXException | IOException e) {
			throw new DAOException(e.getMessage());
		}
		Document document = parser.getDocument(); 
		Element root = document.getDocumentElement(); 
		List<Food> menu = new ArrayList<Food>();
		NodeList foodNodes = root.getElementsByTagName("food"); 
		Food food = null;
		ArrayList<Element> childs;
		Element name;
		Element portion;
		
		for (int i = 0; i < foodNodes.getLength(); i++) { 
			food = new Food();
			Element foodElement = (Element) foodNodes.item(i);
			food.setId(Integer.parseInt(foodElement.getAttribute("ID")));
			name = getChild(foodElement, "name").get(0);
			food.setName(name.getTextContent().trim());
			childs = getChild(foodElement, "description");
			if (childs != null){
				for(Element child: childs){
					food.setDescription(child.getTextContent().trim());
				}
			}
			portion = getChild(foodElement, "portion").get(0);
			food.setPortion(portion.getTextContent().trim());
			childs = getChild(foodElement, "price");
			if (childs != null){
				String price;
				for(Element child: childs){
					price = child.getTextContent().trim();
					food.setPrice(Integer.parseInt(price));
				}
			}
			menu.add(food);
		}
		return menu;
	}
	
	private static ArrayList<Element> getChild(Element element, String childName){ 
		NodeList nlist = element.getElementsByTagName(childName);
		ArrayList<Element> child = new ArrayList<Element>();
		if(nlist.getLength() == 0)
			return null;
		else{
			for(int i=0; i<nlist.getLength(); i++){
				child.add((Element) nlist.item(i));
			}
			return child;
		}
	}
}

