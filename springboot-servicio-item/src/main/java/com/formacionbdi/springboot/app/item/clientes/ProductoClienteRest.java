package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

//Esta clase crea el CONFIGURA EL CLIENTE por lo cual todo apunta el servicio que se 
//desea comsumir
@FeignClient(name = "servicio-productos")//nombre de servicio del 8001
public interface ProductoClienteRest {
	
	@GetMapping("/listar")//Dirigido al Servicio Productos (8001), no al controller de este microservicio
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")//***el controller de servicio-productos
	public Producto detalle(@PathVariable Long id);

}
