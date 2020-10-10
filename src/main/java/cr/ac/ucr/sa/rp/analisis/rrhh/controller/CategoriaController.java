package cr.ac.ucr.sa.rp.analisis.rrhh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.sa.rp.analisis.rrhh.data.CategoriaData;
import cr.ac.ucr.sa.rp.analisis.rrhh.domain.Categoria;


@RestController
@RequestMapping(value="/api/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*") 
public class CategoriaController {
	@Autowired
	private CategoriaData categoriaData;
	
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> categorias = categoriaData.findAll();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}
	

}
