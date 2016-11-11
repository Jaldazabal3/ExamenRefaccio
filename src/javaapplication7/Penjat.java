
package javaapplication7;

import java.util.Random;
import static javaapplication7.JavaApplication7.penjat;

/**
 *
 * @author jaldazabal
 * @version 1.0
 */
public class Penjat {
   //COMENTARI VOSTRE
    //Declaració del conjunt de paraules que poden sortir en l'aplicació del penjat
    private final String[] paraules = {"ATOM", "MOLECULA", "BIO", "PERL"};
    
    private String paraula;
    private char[] lletres;
    private int count;
    private int encerts;
    
    /**
     * Constructor
     */
    public Penjat() {
    }
    
    
    
    /**
     * getter de paraula
     * @return un string que es la paraula a endivinar
     */
    public String getParaula() {
        return paraula;
    }
    
    public int getCount() {
        return count;
    }
    
    public char[] getLletres() {
        return lletres;
    }

    public void setParaula(String paraula) {
        this.paraula = paraula;
    }

    public int getEncerts() {
        return encerts;
    }
    
    public void setEncerts(int encerts) {
        this.encerts = encerts;
    }

    public void setCount(int count) {
        this.count = count;
    }
    /**
     * s'encarrega de triar la paraula que s'endevinarà d'entre l'arraylist de paraules
     */
    public void iniciaPenjat(){
        //COMENTARI VOSTRE
        //generació del aleatori que permetrà escollir la paraula d'entre les declarades anteriorment
        Random rnd = new Random();
        int endevina = (int) (rnd.nextDouble() * penjat.paraules.length);
        //COMENTARI VOSTRE
        //es tria la paraula a endivinar amb el random executat anteriorment
        this.paraula = paraules[endevina];
    }
    /**
     * crea l'array amb el simbol '_' que es mostrara
     */
    public void creaArray(){
        //Creo l'array de caràcters que mostraran les encertades
        this.lletres = new char[this.paraula.length()];
        for (int i = 0; i < paraula.length(); i++) {
            this.lletres[i] = '_';
        }
    }
    /**
     * Valida la lletra introduida per l'usuari
     * @param llegit caracter triat per l'usuari
     * @return true si la lletra es valida, false si no
     */
    public boolean validaLletres(String llegit){
        return llegit.matches("[ABCDEFGHIJKLMN\u00d1OPQRSTUVWXYZ ]");
    }
    /**
     * busca la lletra a la paraula a endivinar, retorna informacio sobre si s'ha trobat o no
     * @param c caracter a buscar en la paraula
     * @return string que diu si ha encertat o fallat amb la lletra, mostrant els intents restants en cas que hagi fallat
     */
    public String buscaParaula(char c){
        //COMENTARI VOSTRE
        //indexOf es una funció de string que retorna la primera posició
        //del string on troba la lletra buscada
        int pos = penjat.getParaula().indexOf(c);
        //COMENTARI VOSTRE
        /*indexOf retorna -1 si no troba el càracter, per tant, aquest if
        és en cas de que no trobi la lletra. s'incrementa el count, que és
        un contador d'intents*/
        if (pos == -1) {
            this.count++;
            return "Aquesta lletra no es troba dins de la paraula.";
            
        } else {
            //COMENTARI VOSTRE
            //bucle on es subtitueix el caracter '_' per la lletra encertada
            for (int i = 0; i < lletres.length; i++) {
                if (paraula.charAt(i) == c) {
                    lletres[i] = c;
                    encerts += 1;
                }
                
            }
            return "Molt b\u00e9!!! Torna a intentar-ho";
            
        }
    }  
}
