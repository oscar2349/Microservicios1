package com.formacionbdi.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.service.ItemService;

//el ejercicio implemete de dos manera aca solo lo deje de una
//la otra forma es usando rest Template
@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceFeign")//nombre dado en ItemServiceFeing
	private ItemService itemService;
	
	@GetMapping("/listar")//Son las Rutas propias de este servicio
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")// ruta propia de este servicio
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}

}
