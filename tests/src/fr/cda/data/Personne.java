package fr.cda.data;

public class Personne {
    private String nom;
    private String prenom;
    private Integer age;
    private Integer nbrAccident;
    private Permis permis;
    private Fidelite fidelite;

    public Personne(String nom, String prenom, int age, int nbrAccident) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nbrAccident = nbrAccident;
    }

    public Permis getPermis() {
        return permis;
    }

    public void setPermis(Permis permis) {
        this.permis = permis;
    }

    public Fidelite getFidelite() {
        return fidelite;
    }

    public void setFidelite(Fidelite fidelite) {
        this.fidelite = fidelite;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNbrAccident() {
        return nbrAccident;
    }

    public void setNbrAccident(Integer nbrAccident) {
        this.nbrAccident = nbrAccident;
    }
}
