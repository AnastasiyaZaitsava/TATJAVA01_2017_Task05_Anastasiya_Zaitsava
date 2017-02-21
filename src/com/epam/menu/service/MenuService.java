package com.epam.menu.service;

import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import com.epam.menu.bean.Food;
import com.epam.menu.dao.DomMenuDAO;
import com.epam.menu.dao.SaxMenuDAO;
import com.epam.menu.dao.StaxMenuDAO;

public class MenuService  {
	
	public MenuService(){}
	
	public List<Food> getMenu() throws SAXException, IOException, XMLStreamException{
	//	SaxMenuDAO menuDAO = new SaxMenuDAO();
	//	StaxMenuDAO menuDAO = new StaxMenuDAO();
		DomMenuDAO menuDAO = new DomMenuDAO();
		List<Food> menu = menuDAO.getMenu();
	return menu;
	}
}

