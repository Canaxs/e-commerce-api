package com.commerce.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.commerce.dto.MenuDto;
import com.commerce.model.panel.Menu;
import com.commerce.repository.MenuJpaRepository;
import com.commerce.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	MenuJpaRepository menuJpaRepository;
	
	ModelMapper modelMapper;

	public MenuServiceImpl(MenuJpaRepository menuJpaRepository,ModelMapper modelMapper) {
		super();
		this.menuJpaRepository = menuJpaRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Menu createMenu(MenuDto menuDto) {
		Menu menu = modelMapper.map(menuDto, Menu.class);
		return menuJpaRepository.save(menu);
	}

	@Override
	public Menu deleteMenu(MenuDto menuDto) {
		Menu menu = menuJpaRepository.findBymenuName(menuDto.getMenuName());
		System.out.println(menu);
		try {
			menuJpaRepository.delete(menu);
		}
		catch(Error e) {
			
		}
		return menu;
	}

	@Override
	public Menu updateMenu(long id,MenuDto menuDto) {
		Menu menu = menuJpaRepository.getById(id);
		System.out.println(menu);
		try {
			menu.setMenuName(menuDto.getMenuName());
			menuJpaRepository.save(menu);
		}
		catch(Error e) {
			
		}
		
		return menu;
	}

	@Override
	public List<Menu> getListMenu() {
		List<Menu> menu = menuJpaRepository.findAll();
		return menu;
	}

}
