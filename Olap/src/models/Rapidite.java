package models;

public class Rapidite {

    String code_client;
    String num_prod;
    String num_emp;
    String num_mois ;
    float retard_debut;
    float retard_fin;
    float nbr_jours_retard;
    float duree_prevue;
    float duree_reel;

    public Rapidite(){
        super();
    }

    public Rapidite(String code_client , String num_prod ,String num_emp , String num_mois , float retard_debut , float retard_fin , float nbr_jours_retard , float duree_prevue ,float duree_reel) 
    {
        this.code_client = code_client ;
        this.num_prod = num_prod;
        this.num_emp = num_emp ;
        this.num_mois = num_mois;
        this.retard_debut = retard_debut ;
        this.retard_fin = retard_fin;
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

    public float getRetard_debut(){
        return retard_debut ;
    }

    public void setRetard_debut(float retard_debut){
        this.retard_debut = retard_debut ;
    }

    public float getRetard_fin(){
        return retard_fin ;
    }

    public void setRetard_fin(int retard_fin){
        this.retard_fin = retard_fin ;
    }
    
    public float getNbr_jours_retard(){
        return nbr_jours_retard ;
    }

    public void setNbr_jours_retard(float nbr_jours_retard){
        this.nbr_jours_retard = nbr_jours_retard ;
    }

    public float getDuree_prevue(){
        return duree_prevue ;
    }

    public void setDuree_prevue(float duree_prevue){
        this.duree_prevue = duree_prevue ;
    }

    public float getDuree_reel(){
        return duree_reel ;
    }

    public void setDuree_reel(float duree_reel){
        this.duree_reel = duree_reel ;
    }
    
    
    
}
