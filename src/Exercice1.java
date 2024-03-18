import java.util.Scanner;
// Objectid Exercie1 : Lire deux entiers afficher leur somme.
public class Exercice1 {
    public static void main(String[] args)
    {
        System.out.printf("Tape un nombre chef \n");

        //La classse Scanner sert à lire des valeurs sur System.in = clavier
        Scanner sc = new Scanner(System.in);


        // pour lire un int :
        int a = sc.nextInt();

        System.out.printf("Tape-en encore un chef \n");

        int b = sc.nextInt();

        // pour lire un double :
        //double d = sc.nextDouble();

        // out, tout simplement, pour lire une String:
        //String s = sc.next();

        System.out.printf("Merci mon gars, \n et maintenant voici les chifres tapés! \n ------>  "+ a + "\n & \n" + "-----------> " + b);






    }
}
