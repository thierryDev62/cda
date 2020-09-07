public class Produits {
    private String nom;
    private double prixAuKilo;
    private double poids;
    private double total;
    private double totalPoids;

    public double getTotalProduit() {
        return totalProduit;
    }

    public void setTotalProduit(double totalProduit) {
        this.totalProduit = totalProduit;
    }

    private double totalProduit;

    public Produits(String nom, double prixAuKilo, double poids, double total, double totalPoids, double totalProduit) {
        this.nom = nom;
        this.prixAuKilo = prixAuKilo;
        this.poids = poids;
        this.total = total;
        this.totalPoids = totalPoids;
        this.totalProduit = totalProduit;
    }

    public double calcul(double prixAuKilo, float poids) {
        double total = prixAuKilo * poids;
        return total;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixAuKilo() {
        return prixAuKilo;
    }

    public double getPoids() {
        return poids;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrixAuKilo(double prixAuKilo) {
        this.prixAuKilo = prixAuKilo;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPoids() {
        return totalPoids;
    }

    public void setTotalPoids(double totalPoids) {
        this.totalPoids = totalPoids;
    }
}
