package com.commerce.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.commerce.dto.UnderMenuDto;
import com.commerce.dto.UnderMenuDtoUpdate;
import com.commerce.model.Menu;
import com.commerce.model.UnderMenu;
import com.commerce.repository.MenuJpaRepository;
import com.commerce.repository.UnderMenuJpaRepository;
import com.commerce.service.UnderMenuService;

@Service
public class UnderMenuServiceImpl implements UnderMenuService{
	
	UnderMenuJpaRepository underMenuJpaRepository;
	
	MenuJpaRepository menuJpaRepository;

	public UnderMenuServiceImpl(UnderMenuJpaRepository underMenuJpaRepository, MenuJpaRepository menuJpaRepository) {
		super();
		this.underMenuJpaRepository = underMenuJpaRepository;
		this.menuJpaRepository = menuJpaRepository;
	}

	@Override
	public UnderMenu createUnderMenu(UnderMenuDto underMenuDto) {
		Menu menu = menuJpaRepository.findBymenuName(underMenuDto.getMenuName());
		UnderMenu underMenu = new UnderMenu();
		try {
			if(menu != null) {
				underMenu.setMenu(menu);
				underMenu.setUnderMenuName(underMenuDto.getUnderMenuName());
				underMenuJpaRepository.save(underMenu);
			}
		}
		catch(Error e) {
			
		}
		return underMenu;
	}

	@Override
	public UnderMenu deleteUnderMenu(UnderMenuDto underMenuDto) {
		Menu menu = menuJpaRepository.findBymenuName(underMenuDto.getMenuName());
		UnderMenu underMenu = underMenuJpaRepository.findByUnderMenuNameAndMenu(underMenuDto.getUnderMenuName(), menu);
		try {
			underMenuJpaRepository.delete(underMenu);
		}
		catch(Error e) {
			
		}
		
		return underMenu;
	}

	@Override
	public UnderMenu updateUnderMenu(UnderMenuDtoUpdate underMenuDto) {
		Menu menu = menuJpaRepository.findBymenuName(underMenuDto.getMenuName());
		UnderMenu underMenu = underMenuJpaRepository.findByUnderMenuNameAndMenu(underMenuDto.getUnderMenuName(), menu);
		try {
			underMenu.setUnderMenuName(underMenuDto.getChangeName());
			underMenuJpaRepository.save(underMenu);
		}
		catch(Error e) {
			
		}
		return underMenu;
	}

	@Override
	public List<UnderMenu> getListMenu(String menuName) {
		Menu menu = menuJpaRepository.findBymenuName(menuName);
		List<UnderMenu> menu2 = underMenuJpaRepository.findAllByMenu(menu);
		return menu2;
	}

}
