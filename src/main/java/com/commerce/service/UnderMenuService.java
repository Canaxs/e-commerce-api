package com.commerce.service;

import java.util.List;

import com.commerce.dto.UnderMenuDto;
import com.commerce.dto.UnderMenuDtoUpdate;
import com.commerce.model.UnderMenu;

public interface UnderMenuService {

	UnderMenu createUnderMenu(UnderMenuDto underMenuDto);

	UnderMenu deleteUnderMenu(UnderMenuDto underMenuDto);

	UnderMenu updateUnderMenu(UnderMenuDtoUpdate underMenuDto);

	List<UnderMenu> getListMenu(String menuName);

}
