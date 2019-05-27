package com.example.demo;

import java.sql.Types;


import java.util.Date;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;



/*
public interface ArticlesRepository extends CrudRepository<articles, Integer> {
	Iterable<articles>	findAll();
}
*/
//ne s'occupe que de la table Article
@Service
public class ArticlesRepository implements CrudRepository<articles, Integer> {
	
	 private static final String driverClassName = "com.mysql.jdbc.Driver";
	 private static final String url = "jdbc:mysql://localhost/bdassoc";
	 private static final String dbUsername = "root";
	 private static final String dbPassword = "";
	 private static DataSource dataSource;
	 private static final String insertArticleSql =
	 
	  "INSERT INTO article (" +
	 
	 
	  " titre_Article, " +
	 
	  " texte_Article, " +
	 
	  " date_Article, " +
	  
	  " photo_idphoto, " +
	  
	  " idpersonne) " +
	 
	  "VALUES ( ?, ?, ?, ?, ?)";
	 
	
	public ArticlesRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends articles> article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<articles> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public articles findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends articles> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(articles arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<articles> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends articles> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void insertIntoArticle(String titre, String texte, Date date, int id_photo, int id_personne) {
        
        JdbcTemplate template = new JdbcTemplate(dataSource);
         
        // define query arguments
        Object[] params = new Object[] {titre, texte, date, id_photo, id_personne};
         
        // define SQL types of the arguments
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER };
 
        // execute insert query to insert the data
        // return number of row / rows processed by the executed query
        int row = template.update(insertArticleSql, params, types);
        System.out.println(row + " row inserted.");
         
    }
     
    public static DriverManagerDataSource getDataSource() {
 
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
  dataSource.setDriverClassName(driverClassName);
 
  dataSource.setUrl(url);
 
  dataSource.setUsername(dbUsername);
 
  dataSource.setPassword(dbPassword);
 
  return dataSource;
    }
    
	//main Article
	public void storeArticleInDB(articles article) {
		
		//récupérer les informations de l'article séparémment
		// int id_article = article.getId();
		 int auteur = article.getId_personne();
		 int id_photo = article.getId_photo();
		 String texte = article.getTexte();
		 String titre = article.getTitre();
		// Date date = article.getDate(); 
		 Date date = new Date(); 
		 //ajouter un article dans la BD
		// JdbcTemplate.update("INSERT INTO ");
		 
		 dataSource = getDataSource();
         //int id_article, String titre, String texte, Date date, int id_photo, int id_personne
		 insertIntoArticle(titre, texte, date, id_photo, auteur);
		 
		 
	}
}