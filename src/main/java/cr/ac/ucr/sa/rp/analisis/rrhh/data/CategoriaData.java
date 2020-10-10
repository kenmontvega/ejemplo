package cr.ac.ucr.sa.rp.analisis.rrhh.data;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.sa.rp.analisis.rrhh.domain.Categoria;


@Repository
public class CategoriaData {
private DataSource dataSource;
private JdbcTemplate jdbcTemplate;
@Autowired
public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}
//@Autowired
	//private DataSource dataSource;
	/*@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	 /*public NewsCategory findById(int searchNewsCategoryId) throws SQLException {
		  
		  String sqlSelect = "select news_category_id,name from news_category where news_category_id= "+searchNewsCategoryId+";";
		  Connection conn=dataSource.getConnection();
		  NewsCategory newsCategory = new NewsCategory(); 
		  Statement state=conn.createStatement();
		  ResultSet rs=state.executeQuery(sqlSelect);
		  while (rs.next()) {
		    int idNewsCategory = rs.getInt("news_category_id");
		    String name=rs.getString("name");
		    
		    newsCategory.setNewsCategoryId(idNewsCategory);
		    newsCategory.setNewsCategoryName(name);   
		  }
		  conn.close();
		  return newsCategory;
		 }*/
	 
	 public List<Categoria> findAll() {
			String sqlSelect = "SELECT id_categoria, descripcion FROM categoria_test";
			List<Categoria> categorias = new LinkedList<>();
			jdbcTemplate.query(sqlSelect, new Object[]{}, (rs, row) ->
			new Categoria(rs.getInt("id_categoria"),
					rs.getString("descripcion"))).forEach(entry -> categorias.add(entry));
			return categorias;
		}
}
