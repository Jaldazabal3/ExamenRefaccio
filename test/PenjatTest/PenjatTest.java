/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PenjatTest;

import java.util.Arrays;
import java.util.Collection;
import javaapplication7.Penjat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe que testeja diverses funcionalitats de la classe penjat
 * @author jaldazabal
 * @version 1.0
 */
@RunWith(value=Parameterized.class)
public class PenjatTest {
    
    @Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
            {"A",'A',true,"Molt b\u00e9!!! Torna a intentar-ho"},
            {"3",'3',false,"Aquesta lletra no es troba dins de la paraula."},
            {"l",'l',true,"Molt b\u00e9!!! Torna a intentar-ho"},
            {"m",'m',true,"Molt b\u00e9!!! Torna a intentar-ho"},
            {"}",'}',false,"Aquesta lletra no es troba dins de la paraula."},
            {"z",'z',true,"Aquesta lletra no es troba dins de la paraula."}
        });
    }
    private String llegit;
    private char lletra;
    private boolean valid;
    private String resultatBusqueda;
    public PenjatTest(String llegit ,char lletra,boolean valid, String resultatBusqueda) {
        this.llegit=llegit;
        this.lletra=lletra;
        this.valid=valid;
        this.resultatBusqueda=resultatBusqueda;
    }
    Penjat penjat;
    
    @Before
    public void before(){
        penjat=new Penjat();
        penjat.setParaula("Molecula");
        penjat.creaArray();
        penjat.setCount(0);
        penjat.setEncerts(0);
        System.out.println(penjat.getEncerts());
    }
    
    @Test
    public void validaLletresTest(){
        
        assertEquals(valid,penjat.validaLletres(llegit.toUpperCase()));
    }
    
    @Test
    public void buscaParaulaTest(){
        assertEquals(resultatBusqueda, penjat.buscaParaula(lletra));
    }
    
}
