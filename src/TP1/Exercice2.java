import java.util.Scanner;
// Lire une somme en Dollars, un taux de change des Dollars en Euros, et afficher la somme convertie en Euros.
public class Exercice2 {
    public static void main(String[] args) throws InterruptedException{
        System.out.printf("Merci pour le gâteau, c'etait super bon ! Chef c'est combien la somme en dollars ? \n-> ");

        Scanner sc = new Scanner(System.in);
        //pour lire un double :
        double d = sc.nextDouble();

        System.out.printf("OK Ca roule.. \n C'est combien le taux de conversion déja ? EN Dollar/Euro ? \n");
        double taux = sc.nextDouble();

        double somme = d * taux;

        System.out.printf(" Bah vasy ça fait " + somme + " € chef \n \n je te règle ça par carte ! \n");
        Thread.sleep(500);
        System.out.printf("...");
        Thread.sleep(1500);
        System.out.printf("Paiement en cours...");
        Thread.sleep(1000);
        System.out.printf("...");
        Thread.sleep(1000);
        System.out.printf("\n Paiement accepté!");






    }
}


//public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Demander à l'utilisateur de saisir la somme en dollars
//        System.out.print("Entrez la somme en dollars : ");
//        double sommeEnDollars = scanner.nextDouble();
//
//        // Demander à l'utilisateur de saisir le taux de change des dollars en euros
//        System.out.print("Entrez le taux de change des dollars en euros : ");
//        double tauxDeChange = scanner.nextDouble();
//
//        // Calculer la somme convertie en euros
//        double sommeEnEuros = sommeEnDollars * tauxDeChange;
//
//        // Afficher le résultat
//        System.out.println("La somme convertie en euros est : " + sommeEnEuros + " euros");
//
//        // Fermer le scanner
//        scanner.close();