
package javaapplication7;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Jon Aldazabal Esquivel
 */
public class JavaApplication7 {
    public static Penjat penjat=new Penjat();
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        //COMENTARI VOSTRE
        //declaració de variables
        String resposta;
        String llegit = "";
        char c;
        do {
            penjat.iniciaPenjat();
            penjat.creaArray();
            System.out.println("La paraula que has d'encertar t\u00e9 " + penjat.getParaula().length() + " lletres");
            
            //COMENTARI VOSTRE
            //s'inicialitzen els contadors
            penjat.setCount(0);
            penjat.setEncerts(0);
            do {
                //COMENTARI VOSTRE
                /*bucle on es demana una lletra
                a l'usuari, es converteix en majúscula i es compara amb
                totes les de l'abecedari per validarla*/
                do {
                    System.out.println("Si us plau, Escriu una lletra valida");
                    llegit = lector.nextLine().toUpperCase();
                } while (!penjat.validaLletres(llegit) || llegit.isEmpty() || llegit == null);
                //COMENTARI VOSTRE
                //s'agafa el caràcter introduit (primera posició) i es transforma
                //en majúscula
                c = llegit.toUpperCase().charAt(0);
                System.out.println(penjat.buscaParaula(c));
                System.out.println("Et queden " + (10 - penjat.getCount()) + " intents");
                for(char caracters : penjat.getLletres()){
                    System.out.print(caracters + " ");
                }
                //COMENTARI VOSTRE
                //en cas de que els intents arribin a 10, la persona ha perdut
                if (penjat.getCount() == 10) {
                    System.out.println("Has esgotat tots els intents");
                }
                if (penjat.getEncerts() == penjat.getParaula().length()) {
                    System.out.println("Has acabat encertant la paraula. Felicitats!!!!");
                    penjat.setCount(10);
                }
            } while (penjat.getCount() != 10);
            System.out.println("Vols continuar?(S/N)");
            resposta = lector.nextLine().toUpperCase();
        } while (resposta.equals("S"));
    }

}
