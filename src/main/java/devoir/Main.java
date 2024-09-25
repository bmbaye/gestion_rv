package devoir;

import java.util.Scanner;

import devoir.core.Factory.FactoryRespo;
import devoir.datas.entities.Medecin;
import devoir.service.MedecinService;
import devoir.service.RvService;
import devoir.service.impl.MedecinServiceImpl;
import devoir.service.impl.RvServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MedecinService medService = new MedecinServiceImpl(FactoryRespo.getMedRepositoryInstance());

        RvService rvService = new RvServiceImpl(FactoryRespo.getRvRepositoryInstance());

        int choix =0;
        do {
            System.out.println("1.Enregistrer medecin");
            System.out.println("2.Enregistrer Rv");
            System.out.println("3.Lister RV");
            System.out.println("4.Quitter");
            switch (choix) {
                case 1->{
                    scan.nextLine();
                    System.out.println("le nom:");
                    String nom = scan.nextLine();
                    System.out.println("le prenom:");
                    String prenom = scan.nextLine();

                    Medecin med = new Medecin(0, nom, prenom);
                     medService.create(med);
                }
                case 2->{
                    scan.nextLine();
                    System.out.println("");
                }
            
                default ->{
                    break;
                }
            }
        } while (choix <4);
    }
}