package com.epam.menu.dao;

import java.util.List;

import com.epam.menu.bean.Food;
import com.epam.menu.dao.exception.DAOException;

public interface MenuDAO {
	
	public List<Food> getMenu() throws DAOException;
}
