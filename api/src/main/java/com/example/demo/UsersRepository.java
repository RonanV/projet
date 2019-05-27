package com.example.demo;

import java.sql.Types;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

/*
public interface UsersRepository extends CrudRepository<users, Integer> {

}

*/
@Service
public class UsersRepository implements CrudRepository<users, Integer> {

	private static final String driverClassName = "com.mysql.jdbc.Driver";
	 private static final String url = "jdbc:mysql://localhost/bdassoc";
	 private static final String dbUsername = "root";
	 private static final String dbPassword = "";
	 private static DataSource dataSource;
	 
	 private static final String insertPersonneSql =
			 
			  "INSERT INTO personne (" +
			 
			  " nom_Personne, " +
			 
			  " prenom_Personne, " +
			  " telephone, " +
			 
			  " rue_Personne, " +
			  
			  " codepostal_Personne, " +
			  
			  " ville_Personne, " +
			  " email_Personne, " +
			  " telephonepere, " +
			  " telephonemere, " +
			  " datenaissance_Personne, " +
			  " numlicence) " +
			 
			  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public UsersRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(users arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends users> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<users> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public users findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends users> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends users> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
public void insertIntoPersonne(String nom, String prenom, String telephone, String rue, String codePostal, String ville, String email, String telPere, String telMere, Date dateNaissance, String numlicence) {
        
        JdbcTemplate template = new JdbcTemplate(dataSource);
         
        
        // define query arguments
        Object[] params = new Object[] {nom, prenom, telephone, rue, codePostal, ville, email, telPere, telMere, dateNaissance, numlicence};
         
        // define SQL types of the arguments
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR};
 
        // execute insert query to insert the data
        // return number of row / rows processed by the executed query
        int row = template.update(insertPersonneSql, params, types);
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
	public void storePersonneInDB(users personne) {
		
		//récupérer les informations de la personne séparémment
		String nom = personne.getNom();
		String prenom = personne.getPrenom();
		String telephone = personne.getTelephone();
		String rue = personne.getRue();
		String codePostal = personne.getCodePostal();
		String ville = personne.getVille();
		String email = personne.getEmail();
		String telPere = personne.getTelPere();
		String telMere = personne.getTelMere();
		Date dateNaissance = new Date(); 
		String numlicence = personne.getNumlicence();
		 
		 //ajouter un article dans la BD
		// JdbcTemplate.update("INSERT INTO ");
		 
		 dataSource = getDataSource();
         //int id_article, String titre, String texte, Date date, int id_photo, int id_personne
		 insertIntoPersonne(nom, prenom, telephone, rue, codePostal, ville, email, telPere, telMere, dateNaissance, numlicence);
		 
		 
	}

}