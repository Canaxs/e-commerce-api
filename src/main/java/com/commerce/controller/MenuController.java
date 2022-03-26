package com.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.dto.MenuDto;
import com.commerce.model.Menu;
import com.commerce.service.MenuService;

@RestController
@RequestMapping("/api/1.0/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@PostMapping
	private Menu createMenu(@RequestBody MenuDto menuDto) {
		return menuService.createMenu(menuDto);
	}
	
	@DeleteMapping
	private Menu deleteMenu(@RequestBody MenuDto menuDto) {
		return menuService.deleteMenu(menuDto);
	}
	
	@PutMapping("/{id}")
	private Menu updateMenu(@PathVariable long id,@RequestBody MenuDto menuDto) {
		return menuService.updateMenu(id,menuDto);
	}
	
	@GetMapping
	private List<Menu> getListMenu() {
		return menuService.getListMenu();
	}

}
