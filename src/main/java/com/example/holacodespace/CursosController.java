package com.example.holacodespace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.PathVariable;
// imports for use List, Map, String and Object
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Object;

import org.springframework.jdbc.core.JdbcTemplate;

@Controller	
@RequestMapping(path="api/curso") 
public class CursosController {
	@Autowired 
	private CursosRepository cursosRepository;

	@Autowired
  	private JdbcTemplate jdbcTemplate;

	@PostMapping(path="/nuevo/HTTP/1.1") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String nombre
			, @RequestParam Integer creditos) {
		Cursos c = new Cursos();
		c.setNombre(nombre);
		c.setCreditos(creditos);
		cursosRepository.save(c);
		return "Guardado";
	}

	@DeleteMapping(path="/eliminar/HTTP/1.1")
	public @ResponseBody String delUser (@RequestParam Integer id) {
		Cursos c = new Cursos();
		c.setId(id);
		cursosRepository.delete(c);
		return "Eliminado";
	}

	

	@GetMapping(path="/listar/HTTP/1.1")
	public @ResponseBody Iterable<Cursos> getAllUsers() {
		return cursosRepository.findAll();
	}

	//@GetMapping(path="/get/{id}")
	//public @ResponseBody Cursos getOneUser(@PathVariable Integer id) {
	//	return cursosRepository.findById(id).orElse(null);
	//}


	@GetMapping(path="/get/report")
	public @ResponseBody List<Map<String, Object>> getReport() {
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList("SELECT CONCAT(nombre, ' ==> ', id) as mycol FROM cursos");
		return queryResult;
	}


}