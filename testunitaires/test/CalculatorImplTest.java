package OCR.testunitaires.test;

import OCR.testunitaires.main.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImplTest {

    @Test
    public void multiply() {
    }

    @Test
//    @Test(expected = ArithmeticException.class)
    public void divide() {
        System.out.println("--- divide ---");
        CalculatorImpl unCaclul = new CalculatorImpl();
        int a, b, attendu, result;
        String libelle, cas;

        a = 10;
        b = 2;
        attendu = 5;
        cas = "a et b positifs : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");
//        if (result != attendu) {
//            fail("a et b positifs : " + a + "/" + b + "=" + attendu + " ; résultat obtenu : " + result);
//        }

        a = 10;
        b = -2;
        attendu = -5;
        cas = "a positif, b négatif : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = -12;
        b = 4;
        attendu = -3;
        cas = "a négatif, b positif : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = -12;
        b = -4;
        attendu = 3;
        cas = "a et b négatifs : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 10;
        b = 4;
        attendu = 3;
        cas = "a et b positifs, résultat arrondi sup : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 12;
        b = 20;
        attendu = 1;
        cas = "a et b positifs, b > a, arrondi sup : ";
        libelle = "a et b positifs, b > a, arrondi sup : " + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 12;
        b = 12;
        attendu = 1;
        cas = "a = b : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 0;
        b = 12;
        attendu = 0;
        cas = "a = 0 : ";
        libelle = cas + a + "/" + b;
        result = unCaclul.divide(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");
    }

    @Test(expected = ArithmeticException.class)
    public void divideZero() {
        System.out.println("--- Divide par zero ---");
        CalculatorImpl unCaclul = new CalculatorImpl();
        int a = 666;
        int b = 0;
        int attendu = 0;
        int result = unCaclul.divide(a, b);

    }

    @Test
    public void add() {
        System.out.println("--- add ---");
        CalculatorImpl unCaclul = new CalculatorImpl();
        int a, b, attendu, result;
        String cas, libelle;

        a = 5;
        b = 2;
        attendu = 7;
        cas = "a et b positifs : ";
        libelle = cas + a + "+" + b;
        result = unCaclul.add(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 0;
        b = 2;
        attendu = 2;
        cas = "a nul et b positif : ";
        libelle = cas + a + "+" + b;
        result = unCaclul.add(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 2;
        b = 0;
        attendu = 2;
        cas = "a positif et b nul : ";
        libelle = cas + a + "+" + b;
        result = unCaclul.add(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = -1;
        b = 5;
        attendu = 4;
        cas = "a négatif  et b positif : ";
        libelle = cas + a + "+" + b;
        result = unCaclul.add(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = 2;
        b = -6;
        attendu = -4;
        cas = "a positif  et b négatif : ";
        libelle = cas + a + "+" + b;
        result = unCaclul.add(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

        a = -6;
        b = -2;
        attendu = -8;
        cas = "a et b négatifs : ";
        libelle = cas + a + "+" + b;
        result = unCaclul.add(a, b);
        assertEquals(libelle, attendu, result);
        System.out.println(cas + "OK");

    }

    @Test
    public void substract() {
    }

}