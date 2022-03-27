package com.commerce.service;

import java.util.List;

import com.commerce.dto.MenuDto;
import com.commerce.model.panel.Menu;

public interface MenuService {

	Menu createMenu(MenuDto menuDto);

	Menu deleteMenu(MenuDto menuDto);

	Menu updateMenu(long id,MenuDto menuDto);

	List<Menu> getListMenu();

}
