package com.epam.menu.service;


import java.util.ArrayList;
import java.util.List;
import com.epam.menu.bean.Food;
import com.epam.menu.dao.exception.DAOException;
import com.epam.menu.dao.impl.DomMenuDAO;
import com.epam.menu.service.exception.ServiceException;

public class MenuService  {
	
	public MenuService(){}
	
	public List<Food> getMenu() throws ServiceException {
	//	SaxMenuDAO menuDAO = new SaxMenuDAO();
	//	StaxMenuDAO menuDAO = new StaxMenuDAO();
		DomMenuDAO menuDAO = new DomMenuDAO();
		List<Food> menu = new ArrayList<Food>();
		try {
			menu = menuDAO.getMenu();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException();
		}
	return menu;
	}
}

