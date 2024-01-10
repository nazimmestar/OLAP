package models;

public class employes {

    int id ;
    String nom;
    String prenom;
    String function ;
    String situation_f ;
    String diplome ;
    int num_dept ;

    public employes(){
        super();
    }

    public employes(int id , String nom , String prenom , String function , String situation_f , String diplome , int num_dept) {
        this.id = id ;
        this.nom = nom ;
        this.prenom = prenom ;
        this.function = function;
        this.situation_f = situation_f ;
        this.diplome = diplome;
        this.num_dept = num_dept ;
    }

    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFunction() {
		return function;
	}
	
	public void setFunction(String function) {
		this.function = function;
	}
	
	public String getSituation_f() {
		return situation_f;
	}
	
	public void setSituation_f(String situation_f) {
		this.situation_f = situation_f;
	}
	
	public String getDiplome() {
		return diplome;
	}
	
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	
	public int getNum_dept() {
		return num_dept;
	}
	public void setNum_dept(int num_dept) {
		this.num_dept = num_dept;
	}

 

    
}
