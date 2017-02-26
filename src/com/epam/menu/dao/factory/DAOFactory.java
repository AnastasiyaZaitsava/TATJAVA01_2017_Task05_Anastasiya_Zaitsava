package com.epam.menu.dao.factory;

import com.epam.menu.dao.MenuDAO;
import com.epam.menu.dao.impl.DomMenuDAO;
import com.epam.menu.dao.impl.SaxMenuDAO;
import com.epam.menu.dao.impl.StaxMenuDAO;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	
	private final MenuDAO domImpl = new DomMenuDAO();
	private final MenuDAO saxImpl = new SaxMenuDAO();
	private final MenuDAO staxImpl = new StaxMenuDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public MenuDAO getDomDAO(){
		return domImpl;
	}
	
	public MenuDAO getSaxDAO(){
		return saxImpl;
	}
	
	public MenuDAO getStaxDAO(){
		return staxImpl;
	}
}
