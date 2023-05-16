package tn.iit.projectjee.model;

public class Model {
	private String nom="";
	private String prenom="";
	private String login="";
	private String pwd="";
	public Model() {}
	public Model(String nom, String prenom, String login, String pwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Model)) {
			return false;

		} else {
			return this.login.equals(((Model) obj).login) && this.pwd.equals(((Model) obj).pwd);
		}
	}
}
