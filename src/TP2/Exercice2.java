package TP2;

import java.util.Scanner;

//Lire une chaîne de caractères, et changer toutes les lettres minuscules en lettres majuscules,
// et afficher la chaîne de caractères obtenue. Vous ne pouvez pas utiliser
// une fonction toute prête. Là encore, utilisez une boucle pour parcourir la chaine.
public class Exercice2 {
    public static void main(String args[]){

        //La classse Scanner sert à lire des valeurs sur System.in = clavier
        System.out.println("Bienvenue dans palindrome Incorporation, dit nous un mot et on te montre si c'est un palindrome ! \n");
        Scanner sc = new Scanner(System.in);

        String palindrome = sc.next();
        System.out.println("T'as dit  \n" + palindrome + " ... voila le contraire ! : ");

        for (int i = palindrome.length() - 1; i >= 0; i--) {
            System.out.print(palindrome.charAt(i));
        }

        System.out.println("Alors ? Palindrome ou pas ? ");





    }
}
