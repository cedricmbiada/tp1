

import java.util.*;
import java.util.Date;

public class Gestion_Etudiant {
    public static void main(String[] args) {
        String matricule, name, datedenaissance, genre;
        double moyenne;
        Scanner scan = new Scanner(System.in);
        System.out.print("Quel est l' effectif de la salle? ");
        int n = scan.nextInt();
        scan.nextLine();

        Etudiant[] etudiant = new Etudiant[n];
        double[] tab = new double[n];
        String[] annee = new String[3];
        int[] bonusis = new int[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Entrez :->Nom:");
                name = scan.nextLine();
            } while (name.length() < 3);

            do{
                System.out.print("Entrez :->Genre:");
                genre = scan.nextLine();
            }while((!genre.equals("m")&&!genre.equals("M")) && (!genre.equals("f")&&!genre.equals("F")));

            do {
                System.out.print("Entrez :->Matricule:");
                matricule = scan.nextLine();
            } while (matricule.length() < 7);

            do {
                System.out.print("Entrez :->Date de naissance:jj/mm/aaaa:");
                datedenaissance = scan.nextLine();
                annee = datedenaissance.split("/");
            } while ((datedenaissance.lastIndexOf('/') != 5 && annee[2] == "")&&(Integer.parseInt(String.valueOf(annee[0]))>31&&Integer.parseInt(String.valueOf(annee[0]))<1));

            System.out.print("Entrez :->Moyenne:");
            moyenne = scan.nextDouble();
            tab[i] = moyenne;

            bonusis[i] = scan.nextInt();

            etudiant[i] = new Etudiant(matricule, name, genre, datedenaissance, moyenne);
            scan.nextLine();
            System.out.println("");
        }
        String valeur = new String("oui");
        char Valeur = valeur.charAt(0);
        do {
            System.out.println("1-/Afficher les Etudiants par ordre de Merite");
            System.out.println("2-/Afficher les informations sur le premier étudiant");
            System.out.println("3-/Afficher les informations du dernier étudiant");
            System.out.println("4-/ Réinitialiser la liste de la classe");
            System.out.println("5-/ Sortir du programme");
            System.out.println("");
            int choix;
            System.out.print("Entrez votre choix:");
            choix = scan.nextInt();
            double tmp;
            System.out.println("");
            switch (choix) {
                case 1: {
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 1; j < n; j++) {
                            if (tab[i] < tab[j]) {
                                tmp = tab[i];
                                tab[i] = tab[j];
                                tab[j] = tmp;
                            }
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (tab[i] == etudiant[j].moyenne) {
                                System.out.println("-Etudiant" + (i + 1) + ":");
                                etudiant[j].afficher();
                                System.out.print("Age:" + etudiant[j].calculerAge());
                                System.out.println("");
                                System.out.print("note + bonus:" + etudiant[j].bonifier(bonusis[j]));
                                System.out.println("\n");
                            }
                        }
                    }
                }
                break;
                case 2: {
                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < n; j++) {
                            if (tab[i] == etudiant[j].moyenne) {
                                System.out.println("-Premier Etudiant:");
                                etudiant[j].afficher();
                                System.out.print("Age:" + etudiant[i].calculerAge());
                                System.out.println("");
                                System.out.print("note + bonus:" + etudiant[i].bonifier(bonusis[i]));
                                System.out.println("");
                            }
                        }
                    }
                }
                break;
                case 3: {
                    for (int i = n - 1; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (tab[i] == etudiant[j].moyenne) {
                                System.out.println("-Dernier Etudiant:");
                                etudiant[j].afficher();
                                System.out.print("Age:" + etudiant[i].calculerAge());
                                System.out.println("");
                                System.out.print("note + bonus:" + etudiant[i].bonifier(bonusis[i]));
                                System.out.println("\n");
                                System.out.println("");
                            }
                        }
                    }
                }
                break;
                case 4:
                    for (int i = 0; i < n; i++) {
                        etudiant[i] = null;
                    }
                    break;
                case 5:
                    Valeur = 'n';
                    break;
            }
            System.out.println("");
        } while (Valeur == 'o' || Valeur == 'O');
    }
}


