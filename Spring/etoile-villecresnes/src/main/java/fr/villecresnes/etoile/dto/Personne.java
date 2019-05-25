package fr.villecresnes.etoile.dto;

public class Personne {

	private int id_personne;
	private String nom;
	private String prenom;
	private String tel;
	private String rue;
	private String codePostal;
	private String ville;
	private String email;
	private String tel_pere;
	private String tel_mere;
	private String date_naissance;
	private int num_licence;
	
	
	public Personne() {
		super();
		
	}


	public Personne(int id_personne, String nom, String prenom, String tel, String rue, String codePostal, String ville,
			String email, String tel_pere, String tel_mere, String date_naissance, int num_licence) {
		super();
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.tel_pere = tel_pere;
		this.tel_mere = tel_mere;
		this.date_naissance = date_naissance;
		this.num_licence = num_licence;
	}


	public int getId_personne() {
		return id_personne;
	}


	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel_pere() {
		return tel_pere;
	}


	public void setTel_pere(String tel_pere) {
		this.tel_pere = tel_pere;
	}


	public String getTel_mere() {
		return tel_mere;
	}


	public void setTel_mere(String tel_mere) {
		this.tel_mere = tel_mere;
	}


	public String getDate_naissance() {
		return date_naissance;
	}


	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}


	public int getNum_licence() {
		return num_licence;
	}


	public void setNum_licence(int num_licence) {
		this.num_licence = num_licence;
	}
	
	
	
	
	
	
}
