package com.commerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.dto.UnderMenuDto;
import com.commerce.dto.UnderMenuDtoUpdate;
import com.commerce.model.panel.UnderMenu;
import com.commerce.service.UnderMenuService;

@RestController
@RequestMapping("/api/1.0/undermenu")
public class UnderMenuController {

	@Autowired
	UnderMenuService underMenuService;
	
	@PostMapping
	private UnderMenu createUnderMenu(@RequestBody UnderMenuDto underMenuDto) {
		return underMenuService.createUnderMenu(underMenuDto); 
	}
	
	@DeleteMapping
	private UnderMenu deleteUnderMenu(@RequestBody UnderMenuDto underMenuDto) {
		return underMenuService.deleteUnderMenu(underMenuDto);
	}
	
	@PutMapping
	private UnderMenu updateUnderMenu(@RequestBody UnderMenuDtoUpdate underMenuDto) {
		return underMenuService.updateUnderMenu(underMenuDto);
	}
	
	@GetMapping("/{menuName}")
	private List<UnderMenu> getListMenu(@PathVariable String menuName) {
		return underMenuService.getListMenu(menuName);
	}
	
}
