import java.util.Scanner;
// Objectif : Lire 3 valeurs réelles et afficher la moyenne des 2 plus grandes.
public class Exercice3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.printf("C'est l'heure du bulletin !");

        Scanner sc = new Scanner(System.in);

        System.out.printf("\n T'as combien de moyenne en math ? \n ---> ");

        //val reel :
        float noteMath = sc.nextFloat();

        System.out.printf("\n T'as combien de moyenne en Français ? \n ---> ");

        //val reel :
        float noteFR = sc.nextFloat();


        System.out.printf("\n T'as combien de moyenne en Anglais ? \n ---> ");

        //val reel :
        float noteEN = sc.nextFloat();

        System.out.printf("Allons calculer ta moyenne ...\n ");
        Thread.sleep(500);
        System.out.printf("...");
        Thread.sleep(500);
        System.out.printf("...");
        Thread.sleep(500);
        System.out.printf("...");

        float somme = (noteEN + noteFR + noteMath)/3;

        System.out.printf("\n Moyenne générale :...\n " + somme);
















    }
}
