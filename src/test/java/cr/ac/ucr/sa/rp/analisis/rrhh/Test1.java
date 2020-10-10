package cr.ac.ucr.sa.rp.analisis.rrhh;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cr.ac.ucr.sa.rp.analisis.rrhh.data.CategoriaData;
import cr.ac.ucr.sa.rp.analisis.rrhh.domain.Categoria;
@SpringBootTest
class Test1 {
	@Autowired
	private CategoriaData categoriaData;
	
	@Test
	void test() {
		List<Categoria> lista = categoriaData.findAll();
		for (Categoria categoria : lista) {
			System.out.println(categoria.getDescripcion());
		}
	}

}
