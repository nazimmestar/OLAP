package models;

public class Rapidite_c {

    String code_client;
    String num_prod;
    String num_emp;
    String num_mois ;
    int nbr_jours_retard;
    int duree_prevue;
    int duree_reel;

    public Rapidite_c(){
        super();
    }

    public Rapidite_c(String code_client , String num_prod ,String num_emp , String num_mois , int nbr_jours_retard , int duree_prevue ,int duree_reel) 
    {
        this.code_client = code_client ;
        this.num_prod = num_prod;
        this.num_emp = num_mois ;
        this.num_mois = num_mois;
        this.nbr_jours_retard = nbr_jours_retard;
        this.duree_prevue = duree_prevue ;
        this.duree_reel = duree_reel ;
    }

    public String getCode_client(){
        return code_client ;
    }

    public void setCode_client(String code_client){
        this.code_client = code_client ;
    }

     public String getNum_prod(){
        return num_prod ;
    }

    public void setNum_prod(String num_prod){
        this.num_prod = num_prod ;
    }

    public String getNum_emp(){
        return num_emp ;
    }

    public void setNum_emp(String num_emp){
        this.num_emp = num_emp ;
    }

    public String getNum_mois(){
        return num_mois ;
    }

    public void setNum_mois(String num_mois){
        this.num_mois = num_mois ;
    }

    
    public int getNbr_jours_retard(){
        return nbr_jours_retard ;
    }

    public void setNbr_jours_retard(int nbr_jours_retard){
        this.nbr_jours_retard = nbr_jours_retard ;
    }

    public int getDuree_prevue(){
        return duree_prevue ;
    }

    public void setDuree_prevue(int duree_prevue){
        this.duree_prevue = duree_prevue ;
    }

    public int getDuree_reel(){
        return duree_prevue ;
    }

    public void setDuree_reel(int duree_reel){
        this.duree_reel = duree_reel ;
    }
    
    
    
}
