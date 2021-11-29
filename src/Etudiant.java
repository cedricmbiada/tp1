

public class Etudiant {
    public String matricule;
    public String nom;
    public char genre;
    public String datedenaissance;
    public double moyenne;

    public Etudiant(String Matricule, String nom, String genre, String datenaissance, double moyenne) {
        this.matricule = Matricule.toUpperCase();// "20R2313";
        this.nom = nom;// "fosso";
        this.genre = genre.toUpperCase().charAt(0);// "Masculin";
        this.datedenaissance = datenaissance;// "09/12/2001";
        this.moyenne = moyenne;// 19;
    }

    public void afficher() {
        System.out.print("Nom:" + this.nom);
        System.out.println("");
        System.out.print("Maricule:" + this.matricule);
        System.out.println("");
        System.out.print("Genre:" + this.genre);
        System.out.println("");
        System.out.print("Moyenne:" + this.moyenne);
        System.out.println("");
        System.out.print("Date de Naissance:" + this.datedenaissance);
        System.out.println("");
    }

    public long calculerAge() {
        String[] annee = this.datedenaissance.split("/");
        return 2021 - (Long.parseLong(String.valueOf(annee[2])));
    }

    public double bonifier(int bonus) {
        return bonus += this.moyenne;
    }
}


